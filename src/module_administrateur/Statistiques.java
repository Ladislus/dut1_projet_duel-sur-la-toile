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
import javafx.collections.*;

public class Statistiques extends Application {

    Button bRetour;

    public static void main(String[] args) {
        launch(args);
    }

    public Button getbRetour() {
        return bRetour;
    }

    public BorderPane haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Statistiques");
        bRetour = new Button("< Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));
        return haut;
    }

    public BorderPane entete() {
        BorderPane entete = new BorderPane();
        VBox partiegauche = new VBox(20);
        VBox partiedroite = new VBox(20);

        Label jconnecte = new Label("Joueurs connectés : ");
        Label nbpartiesencours = new Label("Nombre de parties en cours : ");
        Label nbjinscrits = new Label("Nombre de joueurs inscrits : ");
        Label nbpartiestotales = new Label("Nombre de parties totales de la plateforme : ");
        Label recordconnectes = new Label("Record de connectés en même temps : ");
        Label statsjeux = new Label("Statistiques des jeux");
        ObservableList<String> optionsJeux = FXCollections.observableArrayList("Puissance 4", "Mastermind");
        ComboBox cbJeux = new ComboBox(optionsJeux);
        Label nbpartiestotalesjeu = new Label("Nombre de parties totales : ");
        Label meilleurj = new Label("Meilleur joueur : ");
        Label statsperiode = new Label("Statistiques sur une période : ");
        Label nbpartiestotalesjeuperiode = new Label("Nombre de parties totales : ");
        Label meilleurjperiode = new Label("Meilleur joueur : ");
        Label vide = new Label(" ");
        Label meilleurjplateforme = new Label("Meilleurs joueurs de la plateforme");


        partiegauche.getChildren().addAll(jconnecte, nbjinscrits, nbpartiestotales, statsjeux,
          cbJeux, nbpartiestotalesjeu, meilleurj, statsperiode, nbpartiestotalesjeuperiode,
            meilleurjperiode);
        partiedroite.getChildren().addAll(nbpartiesencours, recordconnectes, vide,
          meilleurjplateforme);

        entete.setLeft(partiegauche);
        entete.setRight(partiedroite);
        entete.setPadding(new Insets(20,25,20,25));

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
