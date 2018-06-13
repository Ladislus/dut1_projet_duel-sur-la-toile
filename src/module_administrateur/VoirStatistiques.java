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

public class VoirStatistiques extends BorderPane {

    PageAccueil pa;

    public VoirStatistiques(PageAccueil pa) {
        super();
        this.pa = pa;
        this.haut();
        this.gauche();
        this.droite();
    }

    public void haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Statistiques");
        Button bRetour = new Button("< Retour");
        bRetour.setOnAction(new ActionRetour(this.pa));
        haut.setLeft(l);
        haut.setRight(bRetour);
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));
        this.setTop(haut);
    }

    public void gauche() {
        VBox vbgauche = new VBox(10);
        VBox vbstatsjeux = new VBox(10);
        HBox hbdate = new HBox(15);

        Label jconnecte = new Label("Joueurs connectés : ");
        Label nbjinscrits = new Label("Nombre de joueurs inscrits : ");
        Label nbpartiestotales = new Label("Nombre de parties totales de la plateforme : ");
        Label statsjeux = new Label("Statistiques des jeux");
        statsjeux.setStyle("-fx-font-weight: bold");
        ObservableList<String> optionsJeux = FXCollections.observableArrayList("Puissance 4", "Mastermind");
        ComboBox cbJeux = new ComboBox(optionsJeux);
        Label nbpartiestotalesjeu = new Label("Nombre de parties totales : ");
        Label meilleurj = new Label("Meilleur joueur : ");
        Label statsperiode = new Label("Statistiques sur une période : ");
        statsperiode.setStyle("-fx-font-weight: bold");
        Label nbpartiestotalesjeuperiode = new Label("Nombre de parties totales : ");
        Label meilleurjperiode = new Label("Meilleur joueur : ");
        DatePicker dp1 = new DatePicker();
        dp1.setPrefWidth(120);
        Label lau = new Label("au");
        DatePicker dp2 = new DatePicker();
        dp2.setPrefWidth(120);

        hbdate.getChildren().addAll(dp1, lau, dp2);

        vbstatsjeux.getChildren().addAll(cbJeux, nbpartiestotalesjeu, meilleurj, statsperiode,
          hbdate, nbpartiestotalesjeuperiode, meilleurjperiode);
        vbstatsjeux.setPadding(new Insets(5,10,5,10));
        vbstatsjeux.setStyle("-fx-border-color: black;");
        vbstatsjeux.setPrefHeight(250);


        vbgauche.getChildren().addAll(jconnecte, nbjinscrits, nbpartiestotales, statsjeux,
          vbstatsjeux);

        vbgauche.setPadding(new Insets(20,25,20,25));
        this.setLeft(vbgauche);
    }

    public void droite() {
      VBox vbdroite = new VBox(10);
      VBox vbmeilleurjplateforme = new VBox(10);
      HBox hbj1 = new HBox(120);
      HBox hbj2 = new HBox(120);

      Label nbpartiesencours = new Label("Nombre de parties en cours : ");
      Label recordconnectes = new Label("Record de connectés : ");
      Label meilleurjplateforme = new Label("Meilleurs joueurs de la plateforme");
      Label vide = new Label(" ");
      Label vide2 = new Label(" ");
      Label lj1 = new Label("Joueur1");
      Label lj2 = new Label("Joueur2");
      Label ratioj1 = new Label("75% V/D");
      Label ratioj2 = new Label("65% V/D");


      hbj1.getChildren().addAll(lj1, ratioj1);
      hbj2.getChildren().addAll(lj2, ratioj2);

      vbmeilleurjplateforme.getChildren().addAll(meilleurjplateforme, hbj1, hbj2);
      vbmeilleurjplateforme.setPadding(new Insets(5,10,5,10));
      vbmeilleurjplateforme.setStyle("-fx-border-color: black;");
      vbmeilleurjplateforme.setPrefHeight(250);

      vbdroite.getChildren().addAll(nbpartiesencours, recordconnectes, vide, vide2,
        vbmeilleurjplateforme);

      vbdroite.setPadding(new Insets(20,25,20,25));
      this.setRight(vbdroite);

    }
}
