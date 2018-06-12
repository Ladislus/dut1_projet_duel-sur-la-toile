package module_administrateur;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.FileChooser;
import javafx.collections.*;
import java.io.File;

public class ProfilJoueur extends BorderPane {

    public ProfilJoueur() {
        super();
        this.haut();
        this.gauche();
        this.droite();
        this.bas();
    }

    public void haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Profil de ");
        Button bRetour = new Button("< Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        //bRetour.setOnAction(new ActionRetour());
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(0,25,0,25));
        this.setTop(haut);
    }

    public void gauche() {
        GridPane gauche = new GridPane();
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

        gauche.add(pseudo, 1, 40);
        gauche.add(prenom, 1, 45);
        gauche.add(nom, 1, 50);
        gauche.add(email, 1, 55);
        gauche.add(role, 1, 60);

        gauche.add(tpseudo, 2, 40);
        gauche.add(tprenom, 2, 45);
        gauche.add(tnom, 2, 50);
        gauche.add(temail, 2, 55);
        gauche.add(cbrole, 2, 60);

        //gauche.setPadding(new Insets(0,25,0,25));
        gauche.setVgap(1);

        this.setLeft(gauche);
    }

    public void droite() {
        VBox droite = new VBox(15);
        Label stats = new Label("Statistiques");
        Label jeuplusjoue = new Label("Jeu le plus joué : ");
        Label tempsplateforme = new Label("Temps passé sur la plateforme : ");
        Label nbpartiesjouees = new Label("Nombre de parties jouées : ");
        Label nbamis = new Label("Nombre d'amis : ");

        droite.getChildren().addAll(stats, jeuplusjoue, tempsplateforme, nbpartiesjouees, nbamis);
        droite.setPadding(new Insets(0,0,0,25));
        this.setRight(droite);
    }

    public void bas() {
      VBox bas = new VBox(15);
      /*FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Image de profil");
      fileChooser.getExtensionFilters().add(new ExtensionFilter(
        "Image Files", "*.png", "*.jpg", "*.jpeg"));
      File file = fileChooser.showOpenDialog(primaryStage);
      bas.getChildren().add(fileChooser);*/
      Label active = new Label("Active");
      ToggleButton tb1 = new ToggleButton("ON");
      ToggleGroup group = new ToggleGroup();
      tb1.setToggleGroup(group);

      bas.getChildren().add(tb1);

      bas.setPadding(new Insets(0,25,0,0));

      this.setBottom(bas);
    }
}
