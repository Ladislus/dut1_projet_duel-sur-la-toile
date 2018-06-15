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


    public DatePicker creerDatePicker(){
      DatePicker dp = new DatePicker();
      dp.setPrefWidth(120);

      return dp;
    }


    public Label creerLabelDatePicker(){
      Label lau = new Label("au");

      return lau;
    }


    public HBox creerHBoxDatePicker(){
      HBox hbdate = new HBox(15);
      hbdate.getChildren().addAll(creerDatePicker(), creerLabelDatePicker(), creerDatePicker());

      return hbdate;
    }


    public Label creerLabelJoueursConnectes(){
      Label jconnecte = new Label("Joueurs connectés : ");

      return jconnecte;
    }


    public Label creerLabelNbJoueursInscrits(){
      Label nbjinscrits = new Label("Nombre de joueurs inscrits : ");

      return nbjinscrits;
    }


    public Label creerLabelNbPartiesPlateforme(){
      Label nbpartiestotales = new Label("Nombre de parties totales de la plateforme : ");

      return nbpartiestotales;
    }


    public Label creerLabelStatsJeu(){
      Label statsjeux = new Label("Statistiques des jeux");
      statsjeux.setStyle("-fx-font-weight: bold");

      return statsjeux;
    }


    public ComboBox creerComboBoxOptions(){
      ObservableList<String> optionsJeux = FXCollections.observableArrayList("Puissance 4", "Mastermind");
      ComboBox cbJeux = new ComboBox(optionsJeux);
      cbJeux.setPrefWidth(300);

      return cbJeux;
    }


    public Label creerLabelNbPartiesJeu(){
      Label nbpartiestotalesjeu = new Label("Nombre de parties totales : ");

      return nbpartiestotalesjeu;
    }


    public Label creerLabelMeilleurJoueur(){
      Label meilleurj = new Label("Meilleur joueur : ");

      return meilleurj;
    }


    public Label creerLabelStatsPeriode(){
      Label statsperiode = new Label("Statistiques sur une période : ");
      statsperiode.setStyle("-fx-font-weight: bold");

      return statsperiode;
    }


    public Label creerLabelNbPartiesJeuPeriode(){
      Label nbpartiestotalesjeuperiode = new Label("Nombre de parties totales : ");

      return nbpartiestotalesjeuperiode;
    }


    public Label creerLabelMeilleurJoueurPeriode(){
      Label meilleurjperiode = new Label("Meilleur joueur : ");

      return meilleurjperiode;
    }


    public VBox creerVBoxStatsJeux(){
      VBox vbstatsjeux = new VBox(10);
      vbstatsjeux.getChildren().addAll(creerComboBoxOptions(), creerLabelNbPartiesPlateforme(),
        creerLabelMeilleurJoueur(), creerLabelStatsPeriode(), creerHBoxDatePicker(),
          creerLabelNbPartiesJeuPeriode(), creerLabelMeilleurJoueurPeriode());
      vbstatsjeux.setPadding(new Insets(5,10,5,10));
      vbstatsjeux.setStyle("-fx-border-color: black;");
      vbstatsjeux.setPrefHeight(250);

      return vbstatsjeux;
    }


    public void gauche() {
        VBox vbgauche = new VBox(10);
        vbgauche.getChildren().addAll(creerLabelJoueursConnectes(), creerLabelNbJoueursInscrits(),
          creerLabelNbPartiesPlateforme(), creerLabelStatsJeu(), creerVBoxStatsJeux());
        vbgauche.setPadding(new Insets(20,25,20,25));

        this.setLeft(vbgauche);
    }


    public Label creerLabelNbPartiesEnCours(){
      Label nbpartiesencours = new Label("Nombre de parties en cours : ");

      return nbpartiesencours;
    }


    public Label creerLabelRecordConnectes(){
      Label recordconnectes = new Label("Record de connectés : ");

      return recordconnectes;
    }


    public Label creerLabelMeilleursJoueurs(){
      Label meilleurjplateforme = new Label("Meilleurs joueurs de la plateforme");

      return meilleurjplateforme;
    }


    public Label creerLabelVide(){
      Label vide = new Label(" ");

      return vide;
    }


    public Label creerLabelJoueur1(){
      Label lj1 = new Label("Joueur1");

      return lj1;
    }


    public Label creerLabelJoueur2(){
      Label lj2 = new Label("Joueur2");

      return lj2;
    }


    public Label creerLabelRatio1(){
      Label ratioj1 = new Label("75% V/D");

      return ratioj1;
    }


    public Label creerLabelRatio2(){
      Label ratioj2 = new Label("65% V/D");

      return ratioj2;
    }


    public HBox creerHBoxJ1(){
      HBox hbj1 = new HBox(120);
      hbj1.getChildren().addAll(creerLabelJoueur1(), creerLabelRatio1());

      return hbj1;
    }


    public HBox creerHBoxJ2(){
      HBox hbj2 = new HBox(120);
      hbj2.getChildren().addAll(creerLabelJoueur2(), creerLabelRatio2());

      return hbj2;
    }


    public VBox creerVBoxMeilleursJoueurs(){
      VBox vbmeilleurjplateforme = new VBox(10);
      vbmeilleurjplateforme.getChildren().addAll(creerLabelMeilleursJoueurs(), creerHBoxJ1(),
        creerHBoxJ2());
      vbmeilleurjplateforme.setPadding(new Insets(5,10,5,10));
      vbmeilleurjplateforme.setStyle("-fx-border-color: black;");
      vbmeilleurjplateforme.setPrefHeight(250);

      return vbmeilleurjplateforme;
    }


    public void droite() {
      VBox vbdroite = new VBox(10);
      vbdroite.getChildren().addAll(creerLabelNbPartiesEnCours(), creerLabelRecordConnectes(),
        creerLabelVide(), creerLabelVide(), creerVBoxMeilleursJoueurs());
      vbdroite.setPadding(new Insets(20,25,20,25));

      this.setRight(vbdroite);
    }
}
