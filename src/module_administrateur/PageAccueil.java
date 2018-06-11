package module_administrateur;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PageAccueil extends Application {

    Button bJoueur;

    public static void main(String[] args) {
        launch(args);
    }

    public Button getbJoueur() {
        return bJoueur;
    }

    public VBox bas() {
        VBox bas = new VBox();
        Button rapport = new Button("Lire les rapports des joueurs");
        rapport.setOnAction(new ActionRapport(this));
        rapport.setPrefWidth(600);
        rapport.setPrefHeight(100);
        bas.getChildren().add(rapport);
        bas.setAlignment(Pos.BOTTOM_CENTER);
        bas.setPadding(new Insets(0,0,15,0));
        return bas;
    }

    public VBox gauche() {
        VBox gauche = new VBox();
        bJoueur = new Button("Gérer les utilisateurs");
      //  button.setContentDisplay(ContentDisplay.TOP);
        bJoueur.setPrefWidth(200);
        bJoueur.setPrefHeight(250);
        bJoueur.setOnAction(new ActionUtilisateurs(this));
        gauche.getChildren().addAll(bJoueur);
        gauche.setPadding(new Insets(0,0,0,25));
        return gauche;
    }

    public VBox centre() {
        VBox centre = new VBox();
        Button jeu = new Button("Gérer les jeux");
        Button stat = new Button("Voir les statistiques");
        jeu.setPrefWidth(388);
        jeu.setPrefHeight(117);
        stat.setPrefWidth(388);
        stat.setPrefHeight(117);
        centre.getChildren().addAll(jeu, stat);
        centre.setPadding(new Insets(0,12,0,12));
        centre.setSpacing(16);
        return centre;
    }

    public BorderPane haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Administration");
        Button b = new Button("< Accueil");
        haut.setLeft(l);
        haut.setRight(b);
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));
        return haut;
    }

    public Scene scene() {
        BorderPane b = new BorderPane();
        b.setTop(haut());
        b.setCenter(centre());
        b.setBottom(bas());
        b.setLeft(gauche());
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
