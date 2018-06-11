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

    public BorderPane haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Rapport des joueurs");
        bRetour = new Button("< Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));
        return haut;
    }

    public BorderPane entete() {
        BorderPane entete = new BorderPane();
        Label l = new Label("Nombre de rapport non lus : ");
        Button suppr = new Button("Tout supprimer");
        entete.setLeft(l);
        entete.setRight(suppr);
        return entete;
    }

    public VBox corp() {
        VBox vbox = new VBox();
        vbox.getChildren().add(entete());
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
