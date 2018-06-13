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
      ObservableList<String> optionsjeu = FXCollections.observableArrayList("Puissance 4", "Mastermind");
      ComboBox cbjeux = new ComboBox(optionsjeu);
      Label etatjeu = new Label("Etat du jeu : ");
      TextField tetatjeu = new TextField();
      TextArea treglejeu = new TextArea();
      treglejeu.setPrefWidth(80);
      treglejeu.setWrapText(true);
      ObservableList<String> optionsmode = FXCollections.observableArrayList("Tour par tour",
        "Score le plus élevé par manche", "Le plus rapide par manche");
      ComboBox cbmodes = new ComboBox(optionsmode);
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Open Resource File");
      fileChooser.getExtensionFilters().addAll(
        new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
      Button bsave = new Button("Sauvegarder");

      hbsave.getChildren().add(bsave);
      hbsave.setAlignment(Pos.CENTER);

      vbjeu.getChildren().addAll(cbjeux, etatjeu, tetatjeu, treglejeu, cbmodes, hbsave);
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
      Label laddjeu = new Label("Ajouter un jeu");
      laddjeu.setFont(Font.font ("Arial", 18));
      TextField tnom = new TextField();
      TextArea tdescription = new TextArea();
      tdescription.setPrefWidth(80);
      tdescription.setWrapText(true);
      ObservableList<String> optionstype = FXCollections.observableArrayList("Tour par tour",
        "Score le plus élevé par manche", "Le plus rapide par manche");
      ComboBox cbmodes = new ComboBox(optionstype);
      Label lactiver = new Label("Activer dès maintenant : ");
      Button bajouter = new Button("Ajouter");

      vbaddjeu.getChildren().addAll(laddjeu, tnom, tdescription, cbmodes, lactiver, bajouter);
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
