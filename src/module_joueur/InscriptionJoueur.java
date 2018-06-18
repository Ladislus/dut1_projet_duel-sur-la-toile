package module_joueur;

import APIMySQL.ConnexionMySQL;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class InscriptionJoueur extends BorderPane {

  private TextField tfMail;
  private TextField tfPseudo;

  private ToggleGroup tgSex;

  private PasswordField tfPassword;
  private PasswordField tfPasswordConfirm;

  private String title;

  private Stage primaryStage;

  

  public InscriptionJoueur(Stage primaryStage) {

    super();

    this.primaryStage = primaryStage;

    

    this.title = "Acceuil : Inscription";

    this.setTop(creerHaut());
    this.setLeft(creerGauche());
    this.setRight(creeDroite());
    this.setBottom(creerBas()); }

  public VBox creeDroite() {

    VBox candidate = new VBox();

    Label lSex = new Label("Sexe : ");

    tgSex = new ToggleGroup();

    RadioButton rdMan = new RadioButton("Homme");
    rdMan.setToggleGroup(tgSex);
    rdMan.setUserData("M");
    rdMan.setPadding(new Insets(0, 5, 0, 0));
    rdMan.setSelected(true);

    RadioButton rdWoman = new RadioButton("Femme");
    rdWoman.setToggleGroup(tgSex);
    rdWoman.setUserData("F");
    rdWoman.setPadding(new Insets(0, 5, 0, 0));

    RadioButton rdOther = new RadioButton("Autre");
    rdOther.setToggleGroup(tgSex);
    rdOther.setUserData("O");

    HBox hSex = new HBox();
    hSex.getChildren().addAll(rdMan, rdWoman, rdOther);

    Label lMail = new Label("E-mail : ");
    tfMail = new TextField();
    tfMail.setPromptText("Entrez votre email ici");

    Label lPseudo = new Label("Pseudonyme : ");
    tfPseudo = new TextField();
    tfPseudo.setPromptText("Entrez votre pseudo ici");

    Label lPassword = new Label("Mot de passe : ");
    tfPassword = new PasswordField();
    tfPassword.setPromptText("Entrez votre mot de passe ici");

    Label lPasswordConfirm = new Label("Confirmer mot de passe : ");
    tfPasswordConfirm = new PasswordField();
    tfPasswordConfirm.setPromptText("Confirmez votre mot de passe ici");

    Button btConnect = new Button("S'inscrire !");
    btConnect.setOnAction(new ActionInscription(this.primaryStage));

    HBox hBtConnect = new HBox();
    hBtConnect.getChildren().add(btConnect);
    hBtConnect.setAlignment(Pos.BASELINE_CENTER);
    hBtConnect.setPadding(new Insets(15, 0, 0, 0));

    candidate.getChildren().addAll(lMail, tfMail, lPseudo, tfPseudo, lPassword, tfPassword, lPasswordConfirm, tfPasswordConfirm, lSex, hSex, hBtConnect);
    candidate.setPadding(new Insets(20,20,0,0));
    candidate.setSpacing(7);

    return candidate; }

  public VBox creerGauche() {

    VBox candidate = new VBox();

    ImageView imageLogo = new ImageView();
    imageLogo.setImage(VariablesJoueur.LOGO_TEXT);
    imageLogo.setFitWidth(100);
    imageLogo.setPreserveRatio(true);

    Hyperlink hlHelp = new Hyperlink("Besoin d'aide");
    //hlHelp.setOnAction(new ActionHelp());

    ImageView imageHelp = new ImageView();
    imageHelp.setImage(VariablesJoueur.HELP);
    imageHelp.setPreserveRatio(true);
    imageHelp.setFitWidth(20);

    HBox hHelp = new HBox();
    hHelp.getChildren().addAll(hlHelp, imageHelp);
    hHelp.setAlignment(Pos.TOP_CENTER);

    Button btBack = new Button("Retour");
    btBack.setOnAction(new ActionRetourToConnexion(this.primaryStage));
    btBack.setPrefWidth(100);

    candidate.getChildren().addAll(imageLogo, hHelp, btBack);
    candidate.setSpacing(50);
    candidate.setPrefWidth(270);
    candidate.setPadding(new Insets(25,0,0,0));
    candidate.setAlignment(Pos.TOP_CENTER);

    return candidate; }

  public HBox creerHaut() {

    HBox candidate = new HBox();

    Label title = new Label("Inscription");
    title.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    candidate.getChildren().addAll(title);
    candidate.setAlignment(Pos.TOP_CENTER);
    candidate.setPadding(new Insets(7,0,0,0));

    return candidate; }

  public HBox creerBas() {

    HBox candidate = new HBox();

    Label lCopyright = new Label(VariablesJoueur.COPYRIGHT);
    lCopyright.setFont(VariablesJoueur.DEFAULT_TEXT_FONT);

    candidate.getChildren().add(lCopyright);
    candidate.setPadding(new Insets(0,0,5,5));

    return candidate; }

  public TextField getTfMail() { return this.tfMail; }

  public TextField getTfPseudo() { return this.tfPseudo; }

  public ToggleGroup getTgSex() { return this.tgSex; }

  public PasswordField getTfPassword() { return this.tfPassword; }

  public PasswordField getTfPasswordConfirm() {return this.tfPasswordConfirm; }

  public String getTitle() { return this.title; }}
