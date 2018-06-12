package module_administrateur;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VoirRapport extends BorderPane {

    PageAccueil pa;
    Label pseudo;
    Label rapport;

    public VoirRapport(PageAccueil pa) {
        super();
        this.pa = pa;
        this.haut();
        this.corp();
    }

    public void haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Rapport des joueurs");
        Button bRetour = new Button("< Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        l.setFont(Font.font ("Arial", 25));
        bRetour.setOnAction(new ActionRetour(this.pa));
        haut.setPadding(new Insets(20,25,20,25));
        this.setTop(haut);
    }

    public BorderPane entete() {
        BorderPane entete = new BorderPane();
        Label l = new Label("Nombre de rapport non lus : ");
        Button suppr = new Button("Tout supprimer");
        suppr.setStyle("-fx-background-color: #cf2a27;-fx-border-color: black");
        suppr.setTextFill(Color.web("white"));
        suppr.setPrefWidth(150);
        suppr.setPrefHeight(50);
        entete.setLeft(l);
        entete.setRight(suppr);
        l.setPadding(new Insets(15,0,0,0));
        return entete;
    }

    public BorderPane rapportJoueur() {
      BorderPane b = new BorderPane();
      this.pseudo = new Label("Joueur1");
      this.rapport = new Label("J'adore cette plateforme");
      rapport.setPadding(new Insets(0,0,0,10));
      pseudo.setStyle("-fx-font-weight: bold;-fx-underline: true;");
      CheckBox lu = new CheckBox();
      lu.setOnAction(new ActionBoutonRapport(this));
      VBox v = new VBox();
      v.getChildren().addAll(pseudo, rapport);
      b.setLeft(v);
      b.setRight(lu);
      v.setSpacing(10);
      return b;
    }

    public Label getPseudo() {
        return this.pseudo;
    }

    public Label getRapport() {
        return this.rapport;
    }

    public VBox listeRapport() {
      VBox v = new VBox();
      v.getChildren().addAll(rapportJoueur());
      v.setStyle("-fx-border-color: black;");
      v.setPrefHeight(450);
      v.setPadding(new Insets(12,12,12,12));
      v.setSpacing(10);
      return v;
    }

    public void corp() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(0,25,25,25));
        vbox.getChildren().addAll(entete(), listeRapport());
        vbox.setSpacing(15);
        this.setCenter(vbox);
    }
}
