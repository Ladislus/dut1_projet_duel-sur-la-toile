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
import java.util.HashMap;
import java.util.List;
import java.lang.Iterable;

public class GererJeu extends BorderPane {

    /** Attributs de GererJeu */
    private PageAccueil pa;
    private ToggleGroup groupe;
    private TextField tfilechoosergauche;
    private TextField tfilechooserdroite;
    private Button bplusdroite;
    private Button bplusgauche;
    private TextField tnom;
    private TextArea tdescription;
    private ComboBox<String> cbmodes;


    /** Constructeur de la page pour gérer les jeux */
    public GererJeu(PageAccueil pa) {
      super();
      this.pa = pa;
      this.groupe = new ToggleGroup();
      this.tfilechoosergauche = new TextField();
      this.tfilechooserdroite = new TextField();
      this.bplusdroite = new Button("+");
      this.bplusgauche = new Button("+");
      this.tnom = new TextField();
      this.tdescription = new TextArea();
      this.haut();
      this.gauche();
      this.centre();
    }

    /** Création de l'entête de la page */
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


    /** Création du label qui affiche "Etat du jeu" */
    public Label creerLabelEtatJeu(){
      Label letatjeu = new Label("Etat du jeu : ");

      return letatjeu;
    }

    /** Création du bouton pour activer un jeu */
    public Button creerBoutonActiverJeu(){
      ActionGererJeuActiver agja = new ActionGererJeuActiver(this);
      Button bactiverjeu = new Button("Activer");
      bactiverjeu.setStyle("-fx-background-color: #009e0f;");
      bactiverjeu.setTextFill(Color.web("white"));
      bactiverjeu.setOnAction(agja);

      return bactiverjeu;
    }

    /** Création du bouton pour désactiver un jeu */
    public Button creerBoutonDesactiverJeu(){
      ActionGererJeuDesactiver agjd = new ActionGererJeuDesactiver(this);
      Button bdesactiverjeu = new Button("Désactiver");
      bdesactiverjeu.setStyle("-fx-background-color: #cf2a27;");
      bdesactiverjeu.setTextFill(Color.web("white"));
      bdesactiverjeu.setOnAction(agjd);

      return bdesactiverjeu;
    }

    /** Création du HBox qui contient le label "Etat du jeu" et les boutons qui activent
    et désactivent un jeu */
    public HBox creerHBoxEtatJeu(){
      HBox hbetatjeu = new HBox(30);
      hbetatjeu.getChildren().addAll(creerLabelEtatJeu(), creerBoutonActiverJeu(),
        creerBoutonDesactiverJeu());

      return hbetatjeu;
    }


    /** Création du bouton qui permet de sauvegarder les modifications */
    public Button creerBoutonSauvegarderModifs(){
      Button bsave = new Button("Sauvegarder");
      ActionSauvegardeModifsJeu asmj = new ActionSauvegardeModifsJeu(this);
      bsave.setOnAction(asmj);
      bsave.setPrefWidth(120);

      return bsave;
    }

    /** Création du HBox qui contient le bouton pour sauvegarder les modifications */
    public HBox creerHBoxSauvegarder(){
      HBox hbsave = new HBox();

      hbsave.getChildren().add(creerBoutonSauvegarderModifs());
      hbsave.setAlignment(Pos.CENTER);

      return hbsave;
    }

    /** Création du textfield qui affiche le lien de l'image choisie à gauche de la vue */
    public TextField creerTextFieldFileChooserGauche(){
      this.tfilechoosergauche.setPromptText("Choisissez une image");

      return this.tfilechoosergauche;
    }

    /** Retourne le textfield à gauche de la vue */
    public TextField getTextFieldFileChooserGauche(){
      return this.tfilechoosergauche;
    }

    /** Création du textfield qui affiche le lien de l'image choisie à droite de la vue */
    public TextField creerTextFieldFileChooserDroite(){
      this.tfilechooserdroite.setPromptText("Choisissez une image");

      return this.tfilechooserdroite;
    }

    /** Retourne le textfield à droite de la vue */
    public TextField getTextFieldFileChooserDroite(){
      return this.tfilechooserdroite;
    }

    /** Retourne le bouton qui permet de choisir une image dans les fichiers à gauche de la vue */
    public Button creerBoutonFileChooserGauche(){
      ActionFileChooser afc = new ActionFileChooser(this);
      bplusgauche.setOnAction(afc);

      return this.bplusgauche;
    }

    /** Retourne le bouton à gauche de la vue */
    public Button getBoutonGauche(){
      return this.bplusgauche;
    }

    /** Création du bouton qui permet de choisir une image dans les fichiers à droite de la vue */
    public Button creerBoutonFileChooserDroite(){
      ActionFileChooser afc = new ActionFileChooser(this);
      this.bplusdroite.setOnAction(afc);

      return this.bplusdroite;
    }


    public Button getBoutonDroite(){
      return this.bplusdroite;
    }


    public HBox creerHBoxFileChooserGauche(){
      HBox hbfilechooser = new HBox(5);
      hbfilechooser.getChildren().addAll(creerTextFieldFileChooserGauche(), creerBoutonFileChooserGauche());

      return hbfilechooser;
    }


    public ComboBox<String> creerComboBoxJeux(){
      ObservableList<String> optionsjeu = FXCollections.observableArrayList(Jeu.recupListeJeux().keySet());
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
      this.cbmodes = new ComboBox<String>(optionsmode);
      this.cbmodes.setPrefWidth(297);

      return this.cbmodes;
    }


    public int getType(){
      if (((String)(this.cbmodes.getValue())).equals("Tour par tour"))
        return 1;
      else{
        if (((String)(this.cbmodes.getValue())).equals("Score le plus élevé par manche"))
          return 2;
        else{
          return 3;
        }
      }
    }


    public VBox creerVBoxDescriptionJeu(){
      VBox vbjeu = new VBox();
      vbjeu.getChildren().addAll(creerComboBoxJeux(), creerHBoxEtatJeu(), creerTextFieldEtatJeu(),
        creerTextAreaRegleJeu(), creerComboBoxModes(), creerHBoxFileChooserGauche(),
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
      this.tnom.setPromptText("Entrez le nom du jeu");

      return this.tnom;
    }


    public String getNom(){
      return this.tnom.getText();
    }


    public TextArea creerTextAreaDescriptionJeu(){
      this.tdescription.setPrefWidth(80);
      this.tdescription.setWrapText(true);
      this.tdescription.setPromptText("Entrez la description du jeu");

      return this.tdescription;
    }


    public String getRegles(){
      return this.tdescription.getText();
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


    public HBox creerHBoxFileChooserDroite(){
      HBox hbfilechooser = new HBox(5);
      hbfilechooser.getChildren().addAll(creerTextFieldFileChooserDroite(), creerBoutonFileChooserDroite());

      return hbfilechooser;
    }


    public VBox creerVBoxAjouterJeu(){
      VBox vbaddjeu = new VBox(15);
      vbaddjeu.getChildren().addAll(creerLabelAjouterJeu(), creerTextFieldNomJeu(),
        creerTextAreaDescriptionJeu(), creerComboBoxModes(), creerHBoxFileChooserDroite(),
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
