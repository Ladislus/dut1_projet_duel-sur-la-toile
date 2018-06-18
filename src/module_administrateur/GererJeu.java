package module_administrateur;

import APIMySQL.Jeu;
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
import javafx.scene.layout.*;

public class GererJeu extends BorderPane {

    private PageAccueil pa;
    private ToggleGroup groupe;

    public GererJeu(PageAccueil pa) {
      super();
      this.pa = pa;
      this.groupe = new ToggleGroup();
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


    public Label creerLabelEtatJeu(){
      Label letatjeu = new Label("Etat du jeu : ");

      return letatjeu;
    }


    public Button creerBoutonActiverJeu(){
      ActionGererJeuActiver agja = new ActionGererJeuActiver(this);
      Button bactiverjeu = new Button("Activer");
      bactiverjeu.setStyle("-fx-background-color: #009e0f;");
      bactiverjeu.setTextFill(Color.web("white"));
      bactiverjeu.setOnAction(agja);

      return bactiverjeu;
    }


    public Button creerBoutonDesactiverJeu(){
      ActionGererJeuDesactiver agjd = new ActionGererJeuDesactiver(this);
      Button bdesactiverjeu = new Button("Désactiver");
      bdesactiverjeu.setStyle("-fx-background-color: #cf2a27;");
      bdesactiverjeu.setTextFill(Color.web("white"));
      bdesactiverjeu.setOnAction(agjd);

      return bdesactiverjeu;
    }


    public HBox creerHBoxEtatJeu(){
      HBox hbetatjeu = new HBox(30);
      hbetatjeu.getChildren().addAll(creerLabelEtatJeu(), creerBoutonActiverJeu(),
        creerBoutonDesactiverJeu());

      return hbetatjeu;
    }



    public Button creerBoutonSauvegarderModifs(){
      Button bsave = new Button("Sauvegarder");
      ActionSauvegardeModifsJeu asmj = new ActionSauvegardeModifsJeu(this);
      bsave.setOnAction(asmj);
      bsave.setPrefWidth(120);

      return bsave;
    }

    public HBox creerHBoxSauvegarder(){
      HBox hbsave = new HBox();

      hbsave.getChildren().add(creerBoutonSauvegarderModifs());
      hbsave.setAlignment(Pos.CENTER);

      return hbsave;
    }


    public TextField creerTextFieldFileChooser(){
      TextField tfilechooser = new TextField();
      tfilechooser.setPromptText("Choisissez une image");
      tfilechooser.setDisable(true);

      return tfilechooser;
    }


    public Button creerBoutonFileChooser(){
      Button bplus = new Button("+");
      ActionFileChooser afc = new ActionFileChooser(this);
      bplus.setOnAction(afc);

      return bplus;
    }


    public HBox creerHBoxFileChooser(){
      HBox hbfilechooser = new HBox(5);
      hbfilechooser.getChildren().addAll(creerTextFieldFileChooser(), creerBoutonFileChooser());

      return hbfilechooser;
    }


    public ComboBox<String> creerComboBoxJeux(){
      ObservableList<String> optionsjeu = FXCollections.observableArrayList("Puissance 4", "Mastermind");
      ComboBox<String> cbjeux = new ComboBox<String>(optionsjeu);
      cbjeux.setPrefWidth(297);

      return cbjeux;
    }


    public TextField creerTextFieldEtatJeu(){
      TextField tetatjeu = new TextField();
      tetatjeu.setPromptText("Entrez le nom du jeu");

      return tetatjeu;
    }


    public TextArea creerTextAreaRegleJeu(){
      TextArea treglejeu = new TextArea();
      treglejeu.setPromptText("Entrez les règles du jeu");
      treglejeu.setPrefWidth(80);
      treglejeu.setWrapText(true);

      return treglejeu;
    }


    public ComboBox<String> creerComboBoxModes(){
      ObservableList<String> optionsmode = FXCollections.observableArrayList("Tour par tour",
        "Score le plus élevé par manche", "Le plus rapide par manche");
      ComboBox<String> cbmodes = new ComboBox<String>(optionsmode);
      cbmodes.setPrefWidth(297);

      return cbmodes;
    }


    /*public int getType(){
      if (cbmodes.getText() == "Tour par tour")
        return 0;
      else{
        if (cbmodes.getText() == "Score le plus élevé par manche")
          return 1;
        else{
          return 2;
        }
      }
    }*/


    public VBox creerVBoxDescriptionJeu(){
      VBox vbjeu = new VBox();
      vbjeu.getChildren().addAll(creerComboBoxJeux(), creerHBoxEtatJeu(), creerTextFieldEtatJeu(),
        creerTextAreaRegleJeu(), creerComboBoxModes(), creerHBoxFileChooser(),
          creerHBoxSauvegarder());
      vbjeu.setPadding(new Insets(10,15,10,15));
      vbjeu.setStyle("-fx-border-color: black;");
      vbjeu.setPrefHeight(350);
      vbjeu.setSpacing(10);

      return vbjeu;
    }


    public void gauche(){
      VBox gauche = new VBox();

      gauche.getChildren().add(creerVBoxDescriptionJeu());
      gauche.setSpacing(10);
      gauche.setPadding(new Insets(5,5,5,10));

      this.setLeft(gauche);
    }


    public Label creerLabelAjouterJeu(){
      Label laddjeu = new Label("Ajouter un jeu");
      laddjeu.setFont(Font.font ("Arial", 18));

      return laddjeu;
    }


    public TextField creerTextFieldNomJeu(){
      TextField tnom = new TextField();
      tnom.setPromptText("Entrez le nom du jeu");

      return tnom;
    }


    public String getNom(){
      return tnom.getText();
    }


    public TextArea creerTextAreaDescriptionJeu(){
      TextArea tdescription = new TextArea();
      tdescription.setPrefWidth(80);
      tdescription.setWrapText(true);
      tdescription.setPromptText("Entrez la description du jeu");

      return tdescription;
    }


    public String getRegles(){
      return tdescription.getText();
    }


    public Label creerLabelActiverJeu(){
      Label lactiver = new Label("Activer maintenant ?");

      return lactiver;
    }


    public RadioButton creerRadioBoutonActiverJeu(){
      RadioButton rbactiver = new RadioButton("Oui");
      rbactiver.setSelected(true);
      rbactiver.setToggleGroup(this.groupe);

      return rbactiver;
    }


    public RadioButton creerRadioBoutonPasActiverJeu(){
      RadioButton rbpasactiver = new RadioButton("Non");
      rbpasactiver.setToggleGroup(this.groupe);

      return rbpasactiver;
    }


    public HBox creerHBoxRadioBoutonsActivationJeu(){
      HBox hbactiverjeu = new HBox(18);
      hbactiverjeu.getChildren().addAll(creerLabelActiverJeu(), creerRadioBoutonActiverJeu(),
        creerRadioBoutonPasActiverJeu());

      return hbactiverjeu;
    }


    public Button creerBoutonAjouterJeu(){
      ActionAjouterJeu aaj = new ActionAjouterJeu(this);
      Button bajouter = new Button("Ajouter");
      bajouter.setOnAction(aaj);

      return bajouter;
    }


    public HBox creerHBoxBoutonAjouterJeu(){
      HBox hbajouterjeu = new HBox();
      hbajouterjeu.getChildren().add(creerBoutonAjouterJeu());
      hbajouterjeu.setAlignment(Pos.CENTER);

      return hbajouterjeu;
    }


    public VBox creerVBoxAjouterJeu(){
      VBox vbaddjeu = new VBox(15);
      vbaddjeu.getChildren().addAll(creerLabelAjouterJeu(), creerTextFieldNomJeu(),
        creerTextAreaDescriptionJeu(), creerComboBoxModes(), creerHBoxFileChooser(),
          creerHBoxRadioBoutonsActivationJeu(), creerHBoxBoutonAjouterJeu());
      vbaddjeu.setPadding(new Insets(5,10,5,10));
      vbaddjeu.setStyle("-fx-border-color: black;");
      vbaddjeu.setPrefHeight(350);
      vbaddjeu.setSpacing(10);

      return vbaddjeu;
    }



    public void centre(){
      VBox centre = new VBox();
      centre.getChildren().add(creerVBoxAjouterJeu());
      centre.setSpacing(10);
      centre.setPadding(new Insets(5,10,5,5));

      this.setCenter(centre);
    }

}
