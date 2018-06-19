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
import APIMySQL.*;

public class ProfilJoueur extends BorderPane {

    private GererJoueur gJoueur;
    private PageAccueil pa;
    private ToggleGroup groupe;
    private Joueur joueur;
    private RadioButton rbactiver;
    private RadioButton rbpasactiver;
    private TextField tfilechooser;

    public ProfilJoueur(PageAccueil pa, GererJoueur gJoueur, Joueur joueur) {
        super();
        this.gJoueur = gJoueur;
        this.joueur = joueur;
        this.pa = pa;
        this.groupe = new ToggleGroup();
        this.tfilechooser = new TextField();
        this.haut();
        this.gauche();
        this.centre();
    }

    public RadioButton getRbactiver() {
        return this.rbactiver;
    }

    public RadioButton getRbpasactiver() {
        return this.rbpasactiver;
    }

    public void haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Profil de "+this.joueur.getPseudo());
        Button bRetour = new Button("< Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        bRetour.setOnAction(new ActionRetour(this.pa, this.gJoueur));
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));
        this.setTop(haut);
    }


    public Label creerLabelPseudo(){
      Label pseudo = new Label("Pseudo : ");
      return pseudo;
    }


    public Label creerLabelPrenom(){
      Label prenom = new Label("Prénom : ");
      return prenom;
    }


    public Label creerLabelNom(){
      Label nom = new Label("Nom : ");
      return nom;
    }


    public Label creerLabelEmail(){
      Label email = new Label("Email : ");
      return email;
    }


    public Label creerLabelRole(){
      Label role = new Label("Rôle : ");
      return role;
    }


    public TextField creerTextFieldPseudo(){
      TextField tpseudo = new TextField();
      return tpseudo;
    }


    public TextField creerTextFieldPrenom(){
      TextField tprenom = new TextField();
      return tprenom;
    }


    public TextField creerTextFieldNom(){
      TextField tnom = new TextField();
      return tnom;
    }


    public TextField creerTextFieldEmail(){
      TextField temail = new TextField();
      return temail;
    }


    public ComboBox<String> creerComboBoxRoles(){
      ObservableList<String> optionsRoles = FXCollections.observableArrayList("Utilisateur", "Administrateur");
      ComboBox<String> cbrole = new ComboBox<String>(optionsRoles);
      cbrole.setPrefWidth(175);
      return cbrole;
    }


    public GridPane creerGridPaneInfos(){
      GridPane gpinfos = new GridPane();
      gpinfos.add(creerLabelPseudo(), 1, 40);
      gpinfos.add(creerLabelPrenom(), 1, 45);
      gpinfos.add(creerLabelNom(), 1, 50);
      gpinfos.add(creerLabelEmail(), 1, 55);
      gpinfos.add(creerLabelRole(), 1, 60);
      gpinfos.add(creerTextFieldPseudo(), 2, 40);
      gpinfos.add(creerTextFieldPrenom(), 2, 45);
      gpinfos.add(creerTextFieldNom(), 2, 50);
      gpinfos.add(creerTextFieldEmail(), 2, 55);
      gpinfos.add(creerComboBoxRoles(), 2, 60);
      gpinfos.setVgap(1);
      return gpinfos;
    }


    public Label creerLabelActiver(){
      Label active = new Label("Activer ?");
      return active;
    }


    public HBox creerRadioBoutonActiverJoueur(){
      this.rbactiver = new RadioButton("Oui");
      this.rbpasactiver = new RadioButton("Non");
      this.rbactiver.setToggleGroup(this.groupe);
      this.rbpasactiver.setToggleGroup(this.groupe);
      HBox hbactiverjoueur = new HBox(20);
      hbactiverjoueur.getChildren().addAll(creerLabelActiver(), rbactiver, rbpasactiver);
      if (Utilisateur.isActivated(this.joueur.getPseudo())) {
          this.rbactiver.setSelected(true);
      }
      else {
          this.rbpasactiver.setSelected(true);
      }
      return hbactiverjoueur;
    }

    public Button creerBoutonSauvegarderModifs(){
      Button bsave = new Button("Sauvegarder");
      bsave.setOnAction(new ActionProfilJoueurSauvegarde(this, this.joueur));
      return bsave;
    }


    public HBox creerHBoxSauvegarderModifs(){
      HBox hbsave = new HBox();
      hbsave.getChildren().add(creerBoutonSauvegarderModifs());
      hbsave.setAlignment(Pos.CENTER);
      return hbsave;
    }


    public Label creerLabelImageProfil(){
      Label limageprofil = new Label("Image de profil");
      return limageprofil;
    }


    public TextField creerTextFieldFileChooser(){
      this.tfilechooser.setPromptText("Choisissez une image");
      return this.tfilechooser;
    }


    public TextField getTextFieldFileChooser(){
      return this.tfilechooser;
    }


    public Button creerBoutonFileChooser(){
      Button bplus = new Button("+");
      ActionFileChooser afc = new ActionFileChooser(this);
      bplus.setOnAction(afc);
      return bplus;
    }


    public HBox creerHBoxFileChooser(){
      HBox hbfilechooser = new HBox(5);
      hbfilechooser.getChildren().addAll(creerTextFieldFileChooser(), creerBoutonFileChooser());
      return hbfilechooser;
    }


    public void gauche() {
      VBox vbgauche = new VBox(18);
      vbgauche.getChildren().addAll(creerGridPaneInfos(), creerLabelImageProfil(),
        creerHBoxFileChooser(), creerRadioBoutonActiverJoueur(), creerHBoxSauvegarderModifs());
      vbgauche.setPadding(new Insets(0,0,0,25));
      this.setLeft(vbgauche);
    }


    public Label creerLabelStats(){
      Label stats = new Label("Statistiques");
      stats.setStyle("-fx-font-weight: bold");
      return stats;
    }


    public Label creerLabelJeuPlusJoue(){
      Label jeuplusjoue = new Label("Jeu le plus joué : ");
      return jeuplusjoue;
    }


    public Label creerLabelTempsPlateforme(){
      Label tempsplateforme = new Label("Temps passé sur la plateforme : ");
      return tempsplateforme;
    }


    public Label creerLabelNbPartiesJouees(){
      Label nbpartiesjouees = new Label("Nombre de parties jouées : ");
      return nbpartiesjouees;
    }


    public Label creerLabelNbAmis(){
      Label nbamis = new Label("Nombre d'amis : ");
      return nbamis;
    }


    public VBox creerVBoxStats(){
      VBox vbstats = new VBox(15);
      vbstats.getChildren().addAll(creerLabelStats(), creerLabelJeuPlusJoue(),
        creerLabelTempsPlateforme(), creerLabelNbPartiesJouees(), creerLabelNbAmis());
      vbstats.setPadding(new Insets(5,10,5,10));
      vbstats.setStyle("-fx-border-color: black;");
      vbstats.setPrefHeight(200);
      return vbstats;
    }


    public PieChart creerPieChart(){
      ObservableList<PieChart.Data> donneesdiagramme = FXCollections.observableArrayList(
        new PieChart.Data("Victoires", 60),
        new PieChart.Data("Défaites", 40));

      PieChart diagramme = new PieChart(donneesdiagramme);
      diagramme.setTitle("Ratio Victoires/Défaites");
      diagramme.setStartAngle(90);
      return diagramme;
    }


    public void centre() {
      VBox vbcentre = new VBox(15);
      vbcentre.getChildren().addAll(creerVBoxStats(), creerPieChart());
      vbcentre.setPadding(new Insets(40,25,20,25));
      this.setCenter(vbcentre);
    }

}
