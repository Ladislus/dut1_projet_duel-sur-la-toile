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

public class VoirRapport extends Application {

    Button bRetour;

    public static void main(String[] args) {
        launch(args);
    }

    public Button getbRetour() {
        return bRetour;
    }

    public BorderPane haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Rapport des joueurs");
        bRetour = new Button("< Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        l.setFont(Font.font ("Arial", 25));
        bRetour.setOnAction(new ActionRetour(this));
        haut.setPadding(new Insets(20,25,20,25));
        return haut;
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
      Label pseudo = new Label("Joueur1");
      Label rapport = new Label("J'adore cette plateforme");
      rapport.setPadding(new Insets(0,0,0,10));
      pseudo.setStyle("-fx-font-weight: bold;-fx-underline: true;");
      CheckBox lu = new CheckBox();
      VBox v = new VBox();
      v.getChildren().addAll(pseudo, rapport);
      b.setLeft(v);
      b.setRight(lu);
      v.setSpacing(10);
      return b;
    }

    public BorderPane rapportJoueur2() {
      BorderPane b = new BorderPane();
      Label pseudo = new Label("Joueur2");
      Label rapport = new Label("Le mastermind marche pas");
      rapport.setPadding(new Insets(0,0,0,10));
      pseudo.setStyle("-fx-font-weight: bold;-fx-underline: true;");
      CheckBox lu = new CheckBox();
      VBox v = new VBox();
      v.getChildren().addAll(pseudo, rapport);
      b.setLeft(v);
      b.setRight(lu);
      v.setSpacing(10);
      return b;
    }

    public VBox listeRapport() {
      VBox v = new VBox();
      v.getChildren().addAll(rapportJoueur(), rapportJoueur2());
      v.setStyle("-fx-border-color: black;");
      v.setPadding(new Insets(12,12,12,12));
      v.setSpacing(10);
      return v;
    }

    public VBox corp() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(0,25,0,25));
        vbox.getChildren().addAll(entete(), listeRapport());
        vbox.setSpacing(15);
        return vbox;
    }

    public Scene scene() {
        BorderPane b = new BorderPane();
        b.setTop(haut());
        b.setCenter(corp());
        return new Scene(b, 650, 450);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Duel sur la toile - Administration");
        primaryStage.setResizable(false);
        primaryStage.setScene(this.scene());
        primaryStage.show();
    }
}
