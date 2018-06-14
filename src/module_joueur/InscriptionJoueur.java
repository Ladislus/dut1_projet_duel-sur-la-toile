package module_joueur;

import APIMySQL.GestionBD;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class InscriptionJoueur extends BorderPane {

  private TextField tfName;
  private TextField tfFirstName;
  private TextField tfMail;
  private TextField tfPseudo;

  private ToggleGroup tgSex;

  private PasswordField tfPassword;
  private PasswordField tfPasswordConfirm;

  private String title;

  private Stage primaryStage;

  private GestionBD laConnection;

  public InscriptionJoueur(Stage primaryStage, GestionBD laConnection) {

    super();

    this.primaryStage = primaryStage;

    this.laConnection = laConnection;

    this.title = "Acceuil : Inscription";

    this.setTop(creerHaut());
    this.setLeft(creerGauche());
    this.setRight(creeDroite());
    this.setBottom(creerBas()); }

  public VBox creeDroite() {

    VBox candidate = new VBox();

    Label lName = new Label("Nom : ");
    tfName = new TextField();

    Label lFirstName = new Label("Prenom : ");
    tfFirstName = new TextField();

    Label lSex = new Label("Sexe : ");

    tgSex = new ToggleGroup();

    RadioButton rdMan = new RadioButton("Homme");
    rdMan.setToggleGroup(tgSex);

    RadioButton rdWoman = new RadioButton("Femme");
    rdWoman.setToggleGroup(tgSex);

    RadioButton rdOther = new RadioButton("Autre");
    rdOther.setToggleGroup(tgSex);

    HBox hSex = new HBox();
    hSex.getChildren().addAll(rdMan, rdWoman, rdOther);

    Label lMail = new Label("E-mail : ");
    tfMail = new TextField();

    Label lPseudo = new Label("Pseudonyme : ");
    tfPseudo = new TextField();

    Label lPassword = new Label("Mot de passe : ");
    tfPassword = new PasswordField();

    Label lPasswordConfirm = new Label("Confirmer mot de passe : ");
    tfPasswordConfirm = new PasswordField();

    Button btDashBoard = new Button("Accéder a la plateforme !");
    btDashBoard.setOnAction(new ActionInscription(this.primaryStage, this.laConnection));

    candidate.getChildren().addAll(lName, tfName, lFirstName, tfFirstName, lSex, hSex, lMail, tfMail, lPseudo, tfPseudo, lPassword, tfPassword, lPasswordConfirm, tfPasswordConfirm, btDashBoard);
    candidate.setPadding(new Insets(15,15,0,0));
    candidate.setSpacing(3);
    //candidate.setAlignment(Pos.);

    return candidate; }

  public VBox creerGauche() {

    VBox candidate = new VBox();

    ImageView imageLogo = new ImageView();
    imageLogo.setImage(VariablesJoueur.LOGO_TEXT);
    imageLogo.setFitWidth(100);
    imageLogo.setPreserveRatio(true);

    Hyperlink hlHelp = new Hyperlink("Besoin d'aide ?");
    //hlHelp.setOnAction(new ActionHelp());

    ImageView imageHelp = new ImageView();
    imageHelp.setImage(VariablesJoueur.HELP);
    imageHelp.setPreserveRatio(true);
    imageHelp.setFitWidth(20);

    HBox hHelp = new HBox();
    hHelp.getChildren().addAll(hlHelp, imageHelp);
    hHelp.setAlignment(Pos.TOP_CENTER);

    Button btBack = new Button("Retour");
    btBack.setOnAction(new ActionBack(this.primaryStage, this.laConnection));
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

  public TextField getTfName() { return this.tfName; }

  public TextField getTfFirstName() { return this.tfFirstName; }

  public TextField getTfMail() { return this.tfMail; }

  public TextField getTfPseudo() { return this.tfPseudo; }

  public ToggleGroup getTgSex() { return this.tgSex; }

  public PasswordField getTfPassword() { return this.tfPassword; }

  public PasswordField getTfPasswordConfirm() {return this.tfPasswordConfirm; }

  public String getTitle() { return this.title; }}
