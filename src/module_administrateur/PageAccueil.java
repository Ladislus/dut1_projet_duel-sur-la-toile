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

    BorderPane bp;

    public static void main(String[] args) {
        launch(args);
    }

    public BorderPane getBp() {
        return this.bp;
    }

    public VBox bas() {
        VBox bas = new VBox();
        Button bRapport = new Button("Lire les rapports des joueurs");
        bRapport.setOnAction(new ActionRapport(this));
        bRapport.setPrefWidth(600);
        bRapport.setPrefHeight(100);
        bas.getChildren().add(bRapport);
        bas.setAlignment(Pos.BOTTOM_CENTER);
        bas.setPadding(new Insets(0,0,15,0));
        return bas;
    }

    public VBox gauche() {
        VBox gauche = new VBox();
        Button bJoueur = new Button("Gérer les utilisateurs");
        bJoueur.setPrefWidth(200);
        bJoueur.setPrefHeight(250);
        bJoueur.setOnAction(new ActionUtilisateurs(this));
        gauche.getChildren().addAll(bJoueur);
        gauche.setPadding(new Insets(0,0,0,25));
        return gauche;
    }

    public VBox centre() {
        VBox centre = new VBox();
        Button bJeu = new Button("Gérer les jeux");
        bJeu.setOnAction(new ActionJeu(this));
        Button bStat = new Button("Voir les statistiques");
        bStat.setOnAction(new ActionStatistiques(this));
        bJeu.setPrefWidth(388);
        bJeu.setPrefHeight(117);
        bStat.setPrefWidth(388);
        bStat.setPrefHeight(117);
        centre.getChildren().addAll(bJeu, bStat);
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
        this.bp = new BorderPane();
        this.bp.setCenter(this.constructB());
        return new Scene(this.bp, 650, 450);
    }

    public BorderPane constructB() {
      BorderPane b = new BorderPane();
      b.setTop(haut());
      b.setCenter(centre());
      b.setBottom(bas());
      b.setLeft(gauche());
      return b;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Duel sur la toile - Administration");
        primaryStage.setResizable(false);
        primaryStage.setScene(this.scene());
        primaryStage.show();
    }
}
