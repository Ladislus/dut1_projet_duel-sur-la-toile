package module_administrateur;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.collections.*;
import java.io.File;
import javafx.scene.chart.*;

public class ProfilJoueur extends BorderPane {

    private GererJoueur gJoueur;
    private PageAccueil pa;


    public ProfilJoueur(PageAccueil pa, GererJoueur gJoueur) {
        super();
        this.gJoueur = gJoueur;
        this.pa = pa;
        this.haut();
        this.gauche();
        this.centre();
    }

    public void haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Profil de ");
        Button bRetour = new Button("< Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        bRetour.setOnAction(new ActionRetour(this.pa, this.gJoueur));
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));
        this.setTop(haut);
    }

    public void gauche() {
      VBox vbgauche = new VBox(18);
      GridPane gpgauche = new GridPane();
      HBox hbactiverjoueur = new HBox(20);
      HBox hbsave = new HBox();
      HBox hbfilechooser = new HBox(5);
      ToggleGroup groupe = new ToggleGroup();
      Label pseudo = new Label("Pseudo : ");
      Label prenom = new Label("Prénom : ");
      Label nom = new Label("Nom : ");
      Label email = new Label("Email : ");
      Label role = new Label("Rôle : ");
      TextField tpseudo = new TextField();
      TextField tprenom = new TextField();
      TextField tnom = new TextField();
      TextField temail = new TextField();
      ObservableList<String> optionsRoles = FXCollections.observableArrayList("Utilisateur", "Administrateur");
      ComboBox cbrole = new ComboBox(optionsRoles);
      cbrole.setPrefWidth(175);
      Label active = new Label("Activer ?");
      RadioButton rbactiver = new RadioButton("Oui");
      RadioButton rbpasactiver = new RadioButton("Non");
      rbactiver.setToggleGroup(groupe);
      rbpasactiver.setToggleGroup(groupe);
      Button bsave = new Button("Sauvegarder");
      Label limageprofil = new Label("Image de profil");
      TextField tfilechooser = new TextField();
      tfilechooser.setPromptText("Choisissez une image");
      tfilechooser.setDisable(true);
      Button bplus = new Button("+");
      ActionFileChooser afc = new ActionFileChooser(this);
      bplus.setOnAction(afc);
      ActionProfilJoueurSauvegarde apjs = new ActionProfilJoueurSauvegarde(this);
      bsave.setOnAction(apjs);


      gpgauche.add(pseudo, 1, 40);
      gpgauche.add(prenom, 1, 45);
      gpgauche.add(nom, 1, 50);
      gpgauche.add(email, 1, 55);
      gpgauche.add(role, 1, 60);

      gpgauche.add(tpseudo, 2, 40);
      gpgauche.add(tprenom, 2, 45);
      gpgauche.add(tnom, 2, 50);
      gpgauche.add(temail, 2, 55);
      gpgauche.add(cbrole, 2, 60);

      gpgauche.setVgap(1);

      hbactiverjoueur.getChildren().addAll(active, rbactiver, rbpasactiver);

      hbfilechooser.getChildren().addAll(tfilechooser, bplus);

      hbsave.getChildren().add(bsave);
      hbsave.setAlignment(Pos.CENTER);
      vbgauche.getChildren().addAll(gpgauche, limageprofil, hbfilechooser,
        hbactiverjoueur, hbsave);

      vbgauche.setPadding(new Insets(0,0,0,25));

      this.setLeft(vbgauche);
    }

    public void centre() {
      VBox vbcentre = new VBox(15);
      VBox vbstats = new VBox(15);
      Label stats = new Label("Statistiques");
      stats.setStyle("-fx-font-weight: bold");
      Label jeuplusjoue = new Label("Jeu le plus joué : ");
      Label tempsplateforme = new Label("Temps passé sur la plateforme : ");
      Label nbpartiesjouees = new Label("Nombre de parties jouées : ");
      Label nbamis = new Label("Nombre d'amis : ");

      ObservableList<PieChart.Data> donneesdiagramme = FXCollections.observableArrayList(
        new PieChart.Data("Victoires", 60),
        new PieChart.Data("Défaites", 40));

      PieChart diagramme = new PieChart(donneesdiagramme);
      diagramme.setTitle("Ratio Victoires/Défaites");
      diagramme.setStartAngle(90);

      vbstats.getChildren().addAll(stats, jeuplusjoue, tempsplateforme, nbpartiesjouees, nbamis);

      vbstats.setPadding(new Insets(5,10,5,10));
      vbstats.setStyle("-fx-border-color: black;");
      vbstats.setPrefHeight(200);

      vbcentre.getChildren().addAll(vbstats, diagramme);

      vbcentre.setPadding(new Insets(40,25,20,25));

      this.setCenter(vbcentre);
    }

}
