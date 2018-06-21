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
    private Stage primaryStage;
    private ToggleGroup groupe;
    private TextField tfilechoosergauche;
    private TextField tfilechooserdroite;
    private Button bplusdroite;
    private Button bplusgauche;
    private TextField tnom;
    private TextArea tdescription;
    private ComboBox<String> cbmodes;


    /** Constructeur de la page pour gérer les jeux */
    public GererJeu(Stage primaryStage) {
      super();
      this.primaryStage = primaryStage;
      this.groupe = new ToggleGroup();
      this.tfilechoosergauche = new TextField();
      this.tfilechooserdroite = new TextField();
      this.bplusdroite = new Button("+");
      this.bplusgauche = new Button("+");
      this.tnom = new TextField();
      this.tdescription = new TextArea();
      this.creerGererJeu();
    }

    /** Création de l'entête de la page */
    public BorderPane haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Gestion des jeux");
        Button bRetour = new Button("Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        bRetour.setOnAction(new ActionRetour(this.primaryStage));
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));

        return haut;
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

    /** Retourne le bouton à droite de la vue */
    public Button getBoutonDroite(){
      return this.bplusdroite;
    }

    /** Création du HBox qui contient le textfield et le bouton à gauche de la vue pour gérer les
    images*/
    public HBox creerHBoxFileChooserGauche(){
      HBox hbfilechooser = new HBox(5);
      hbfilechooser.getChildren().addAll(creerTextFieldFileChooserGauche(), creerBoutonFileChooserGauche());

      return hbfilechooser;
    }

    /** Création du ComboBox qui contient le nom des jeux */
    public ComboBox<String> creerComboBoxJeux(){
      ObservableList<String> optionsjeu = FXCollections.observableArrayList(Jeu.recupListeJeux().keySet());
      ComboBox<String> cbjeux = new ComboBox<String>(optionsjeu);
      cbjeux.setPrefWidth(297);

      return cbjeux;
    }

    /** Création du textfield où l'on doit écrire le nom du jeu */
    public TextField creerTextFieldEtatJeu(){
      TextField tetatjeu = new TextField();
      tetatjeu.setPromptText("Entrez l'état du jeu");

      return tetatjeu;
    }

    /** Création du textarea où l'on doit écrire les règles du jeu */
    public TextArea creerTextAreaRegleJeu(){
      TextArea treglejeu = new TextArea();
      treglejeu.setPromptText("Entrez les règles du jeu");
      treglejeu.setPrefWidth(80);
      treglejeu.setWrapText(true);

      return treglejeu;
    }

    /** Création du ComboBox qui contient les différents modes de jeu */
    public ComboBox<String> creerComboBoxModes(){
      ObservableList<String> optionsmode = FXCollections.observableArrayList("Tour par tour",
        "Score le plus élevé par manche", "Le plus rapide par manche");
      this.cbmodes = new ComboBox<String>(optionsmode);
      this.cbmodes.setPrefWidth(297);

      return this.cbmodes;
    }

    /** Retourne le chiffre correspondant au mode de jeu */
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

    /** Création du VBox contenant toute la partie gauche de la vue (les infos pour modifier un jeu) */
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

    /** VBox permettant de créer la partie gauche de la vue */
    public VBox gauche(){
      VBox gauche = new VBox();

      gauche.getChildren().add(creerVBoxDescriptionJeu());
      gauche.setSpacing(10);
      gauche.setPadding(new Insets(5,5,5,10));

      return gauche;
    }

    /** Création du Label qui affiche "Ajouter un jeu" */
    public Label creerLabelAjouterJeu(){
      Label laddjeu = new Label("Ajouter un jeu");
      laddjeu.setFont(Font.font ("Arial", 18));

      return laddjeu;
    }

    /** Création du textfield où l'on doit écrire le nom du jeu */
    public TextField creerTextFieldNomJeu(){
      this.tnom.setPromptText("Entrez le nom du jeu");

      return this.tnom;
    }

    /** Retourne le nom contenu dans le textfield du dessus */
    public String getNom(){
      return this.tnom.getText();
    }

    /** Création du textarea où l'on doit écrire la description du jeu */
    public TextArea creerTextAreaDescriptionJeu(){
      this.tdescription.setPrefWidth(80);
      this.tdescription.setWrapText(true);
      this.tdescription.setPromptText("Entrez la description du jeu");

      return this.tdescription;
    }

    /** Retourne la description du jeu contenu dans le textarea du dessus */
    public String getRegles(){
      return this.tdescription.getText();
    }

    /** Création du Label qui "Activer maintenant ?" */
    public Label creerLabelActiverJeu(){
      Label lactiver = new Label("Activer maintenant ?");

      return lactiver;
    }

    /** Création du RadioButton qui permet d'activer un jeu */
    public RadioButton creerRadioBoutonActiverJeu(){
      RadioButton rbactiver = new RadioButton("Oui");
      rbactiver.setSelected(true);
      rbactiver.setToggleGroup(this.groupe);

      return rbactiver;
    }

    /** Création du RadioButton qui permet de désactiver un jeu */
    public RadioButton creerRadioBoutonPasActiverJeu(){
      RadioButton rbpasactiver = new RadioButton("Non");
      rbpasactiver.setToggleGroup(this.groupe);

      return rbpasactiver;
    }

    /** Création du HBox contenant le label d'activer un jeu et les 2 RadioButton juste au dessus */
    public HBox creerHBoxRadioBoutonsActivationJeu(){
      HBox hbactiverjeu = new HBox(18);
      hbactiverjeu.getChildren().addAll(creerLabelActiverJeu(), creerRadioBoutonActiverJeu(),
        creerRadioBoutonPasActiverJeu());

      return hbactiverjeu;
    }

    /** Création du Button qui permet d'ajouter un jeu */
    public Button creerBoutonAjouterJeu(){
      ActionAjouterJeu aaj = new ActionAjouterJeu(this);
      Button bajouter = new Button("Ajouter");
      bajouter.setOnAction(aaj);

      return bajouter;
    }

    /** Création du HBox contenant le bouton pour ajouter un jeu */
    public HBox creerHBoxBoutonAjouterJeu(){
      HBox hbajouterjeu = new HBox();
      hbajouterjeu.getChildren().add(creerBoutonAjouterJeu());
      hbajouterjeu.setAlignment(Pos.CENTER);

      return hbajouterjeu;
    }

    /** Création du HBox contenant le textfield du chemin de l'image choisie dans les fichiers
    et le bouton qui permet de choisir l'image dans les fichiers pour la partie droite de la vue */
    public HBox creerHBoxFileChooserDroite(){
      HBox hbfilechooser = new HBox(5);
      hbfilechooser.getChildren().addAll(creerTextFieldFileChooserDroite(), creerBoutonFileChooserDroite());

      return hbfilechooser;
    }

    /** Création du VBox contenant toute la partie droite de la vue (les infos pour ajouter un jeu) */
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


    /** VBox permettant d'afficher toute la partie centre/droite de la vue */
    public VBox centre(){
      VBox centre = new VBox();
      centre.getChildren().add(creerVBoxAjouterJeu());
      centre.setSpacing(10);
      centre.setPadding(new Insets(5,10,5,5));

      return centre;
    }

    public void creerGererJeu(){
      this.setTop(haut());
      this.setCenter(centre());
      this.setLeft(gauche());
    }

    /** Rafraichit la page de gérer jeu */
    public void majAffichage() {
        this.creerGererJeu();
    }

}
