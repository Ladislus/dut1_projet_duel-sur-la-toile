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
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.geometry.*;
import javafx.scene.image.ImageView;

public class GererJeu extends BorderPane {

    PageAccueil pa;

    public GererJeu(PageAccueil pa) {
      super();
      this.pa = pa;
      this.haut();
      this.gauche();
      this.centre();
    }

    public void haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Gestion des jeux");
        Button bRetour = new Button("< Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        bRetour.setOnAction(new ActionRetour(this.pa));
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));
        this.setTop(haut);
    }


    public void gauche(){
      VBox gauche = new VBox();
      VBox vbjeu = new VBox();
      HBox hbsave = new HBox();
      HBox hbetatjeu = new HBox(30);
      HBox hbfilechooser = new HBox(5);
      ActionSauvegardeModifsJeu asmj = new ActionSauvegardeModifsJeu(this);
      ObservableList<String> optionsjeu = FXCollections.observableArrayList("Puissance 4", "Mastermind");
      ComboBox cbjeux = new ComboBox(optionsjeu);
      Label etatjeu = new Label("Etat du jeu : ");
      Button bactiverjeu = new Button("Activer");
      Button bdesactiverjeu = new Button("Désactiver");
      TextField tetatjeu = new TextField();
      tetatjeu.setPromptText("Entrez le nom du jeu");
      TextArea treglejeu = new TextArea();
      treglejeu.setPromptText("Entrez les règles du jeu");
      treglejeu.setPrefWidth(80);
      treglejeu.setWrapText(true);
      ObservableList<String> optionsmode = FXCollections.observableArrayList("Tour par tour",
        "Score le plus élevé par manche", "Le plus rapide par manche");
      ComboBox cbmodes = new ComboBox(optionsmode);
      TextField tfilechooser = new TextField();
      tfilechooser.setPromptText("Choisissez une image");
      tfilechooser.setDisable(true);
      Button bplus = new Button("+");
      ActionFileChooser afc = new ActionFileChooser(this);
      bplus.setOnAction(afc);
      Button bsave = new Button("Sauvegarder");
      bsave.setOnAction(asmj);

      hbfilechooser.getChildren().addAll(tfilechooser, bplus);

      hbsave.getChildren().add(bsave);
      hbsave.setAlignment(Pos.CENTER);

      hbetatjeu.getChildren().addAll(etatjeu, bactiverjeu, bdesactiverjeu);

      vbjeu.getChildren().addAll(cbjeux, hbetatjeu, tetatjeu, treglejeu, cbmodes,
        hbfilechooser, hbsave);
      vbjeu.setPadding(new Insets(10,15,10,15));
      vbjeu.setStyle("-fx-border-color: black;");
      vbjeu.setPrefHeight(350);
      vbjeu.setSpacing(10);

      gauche.getChildren().add(vbjeu);
      gauche.setSpacing(10);
      gauche.setPadding(new Insets(5,5,5,10));

      bsave.setPrefWidth(120);

      this.setLeft(gauche);

    }


    public void centre(){
      VBox centre = new VBox();
      VBox vbaddjeu = new VBox(15);
      HBox hbactiverjeu = new HBox(18);
      HBox hbajouterjeu = new HBox();
      HBox hbfilechooser = new HBox(5);
      ToggleGroup groupe = new ToggleGroup();
      ActionAjouterJeu aaj = new ActionAjouterJeu(this);
      Label laddjeu = new Label("Ajouter un jeu");
      laddjeu.setFont(Font.font ("Arial", 18));
      TextField tnom = new TextField();
      tnom.setPromptText("Entrez le nom du jeu");
      TextArea tdescription = new TextArea();
      tdescription.setPrefWidth(80);
      tdescription.setWrapText(true);
      tdescription.setPromptText("Entrez la description du jeu");
      ObservableList<String> optionstype = FXCollections.observableArrayList("Tour par tour",
        "Score le plus élevé par manche", "Le plus rapide par manche");
      ComboBox cbmodes = new ComboBox(optionstype);
      TextField tfilechooser = new TextField();
      tfilechooser.setPromptText("Choisissez une image");
      tfilechooser.setDisable(true);
      Button bplus = new Button("+");
      ActionFileChooser afc = new ActionFileChooser(this);
      bplus.setOnAction(afc);
      Label lactiver = new Label("Activer maintenant ?");
      RadioButton rbactiver = new RadioButton("Oui");
      RadioButton rbpasactiver = new RadioButton("Non");
      Button bajouter = new Button("Ajouter");
      bajouter.setOnAction(aaj);
      rbactiver.setSelected(true);
      rbactiver.setToggleGroup(groupe);
      rbpasactiver.setToggleGroup(groupe);

      hbactiverjeu.getChildren().addAll(lactiver, rbactiver, rbpasactiver);
      hbajouterjeu.getChildren().add(bajouter);
      hbajouterjeu.setAlignment(Pos.CENTER);

      hbfilechooser.getChildren().addAll(tfilechooser, bplus);

      vbaddjeu.getChildren().addAll(laddjeu, tnom, tdescription, cbmodes, hbfilechooser,
        hbactiverjeu, hbajouterjeu);
      vbaddjeu.setPadding(new Insets(5,10,5,10));
      vbaddjeu.setStyle("-fx-border-color: black;");
      vbaddjeu.setPrefHeight(350);
      vbaddjeu.setSpacing(10);

      centre.getChildren().add(vbaddjeu);
      centre.setSpacing(10);
      centre.setPadding(new Insets(5,10,5,5));

      this.setCenter(centre);

    }

}
