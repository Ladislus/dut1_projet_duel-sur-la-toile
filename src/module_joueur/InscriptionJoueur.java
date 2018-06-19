package module_joueur;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class InscriptionJoueur extends BorderPane {

  private TextField tfPrenom;
  private TextField tfName;
  private TextField tfMail;
  private TextField tfPseudo;

  private ToggleGroup tgSex;

  private PasswordField tfPassword;
  private PasswordField tfPasswordConfirm;

  private String title;

  private Label lInfo;

  private Stage primaryStage;

  public InscriptionJoueur(Stage primaryStage) {

    super();

    this.primaryStage = primaryStage;

    this.title = "Accueil : Inscription";

    this.setTop(creerHaut());
    this.setLeft(creerGauche());
    this.setRight(creeDroite());
    this.setBottom(creerBas()); }

  public VBox creeDroite() {

    VBox candidate = new VBox();

    Label lSex = new Label("Sexe : ");

    this.tgSex = new ToggleGroup();

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

    Label lPrenom = new Label("Prénom : ");
    Tooltip ttPrenom = new Tooltip();
    ttPrenom.setText("Entrez ici votre prénom \nIl doit être inférieur à 100 caractères");
    this.tfPrenom = new TextField();
    tfPrenom.setPromptText("Entrez votre prénom ici");
    tfPrenom.setTooltip(ttPrenom);

    Label lName = new Label("Nom : ");
    Tooltip ttName = new Tooltip();
    ttName.setText("Entrez ici votre nom de famille \nIl doit être inférieur à 100 caractères");
    this.tfName = new TextField();
    tfName.setPromptText("Entrez votre nom ici");
    tfName.setTooltip(ttName);

    Label lMail = new Label("E-mail : ");
    Tooltip ttMail = new Tooltip();
    ttMail.setText("Entrez ici votre adresse email \nElle doit être de la forme \"exemple@exemple.fr\"\nLa longeur total doit être inférieur à 100 caractères");
    this.tfMail = new TextField();
    tfMail.setPromptText("Entrez votre email ici");
    tfMail.setTooltip(ttMail);

    Label lPseudo = new Label("Pseudonyme : ");
    Tooltip ttPseudo = new Tooltip();
    ttPseudo.setText("Entrez ici votre pseudonyme \nIl doit faire entre 4 et 30 caractères");
    this.tfPseudo = new TextField();
    tfPseudo.setPromptText("Entrez votre pseudo ici");
    tfPseudo.setTooltip(ttPseudo);

    Label lPassword = new Label("Mot de passe : ");
    Tooltip ttPassword = new Tooltip();
    ttPassword.setText("Entrez ici votre mot de passe \nIl doit faire minimum 8 caractères et contenir au moins\nune majuscule, une minuscule et un chiffre");
    this.tfPassword = new PasswordField();
    tfPassword.setPromptText("Entrez votre mot de passe ici");
    tfPassword.setTooltip(ttPassword);

    Label lPasswordConfirm = new Label("Confirmer mot de passe : ");
    Tooltip ttPasswordConfirm = new Tooltip();
    ttPasswordConfirm.setText("Entrez ici la confirmation de votre mot de passe \nIl doit faire minimum 8 caractères et contenir au moins\nune majuscule, une minuscule et un chiffre et \n être identique à celui ci-dessus");
    this.tfPasswordConfirm = new PasswordField();
    tfPasswordConfirm.setPromptText("Confirmez votre mot de passe ici");
    tfPasswordConfirm.setTooltip(ttPasswordConfirm);

    Button btConnect = new Button("S'inscrire !");
    btConnect.setOnAction(new ActionInscription(this.primaryStage));

    HBox hBtConnect = new HBox();
    hBtConnect.getChildren().add(btConnect);
    hBtConnect.setAlignment(Pos.BASELINE_CENTER);
    hBtConnect.setPadding(new Insets(15, 0, 0, 0));

    candidate.getChildren().addAll(lPrenom, tfPrenom, lName, tfName, lMail, tfMail, lPseudo, tfPseudo, lPassword, tfPassword, lPasswordConfirm, tfPasswordConfirm, lSex, hSex, hBtConnect);
    candidate.setPadding(new Insets(20,20,0,0));
    candidate.setSpacing(7);

    return candidate; }

  public VBox creerGauche() {

    VBox candidate = new VBox();

    ImageView imageLogo = new ImageView();
    imageLogo.setImage(VariablesJoueur.LOGO_TEXT);
    imageLogo.setFitWidth(100);
    imageLogo.setPreserveRatio(true);

    this.lInfo = new Label("");
    lInfo.setAlignment(Pos.CENTER_LEFT);
    lInfo.setTextFill(VariablesJoueur.DEFAULT_ERROR_COLOR);

    Button btBack = new Button("Retour");
    btBack.setOnAction(new ActionRetourToConnexion(this.primaryStage));
    btBack.setPrefWidth(100);

    candidate.getChildren().addAll(imageLogo, btBack, lInfo);
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

  public String getPrenom() { return this.tfPrenom.getText(); }

  public String getName() { return this.tfName.getText(); }

  public String getMail() { return this.tfMail.getText(); }

  public String getPseudo() { return this.tfPseudo.getText(); }

  public String getSex() { return (String) this.tgSex.getSelectedToggle().getUserData(); }

  public String getPassword() { return this.tfPassword.getText(); }

  public String getPasswordConfirm() {return this.tfPasswordConfirm.getText(); }

  public String getTitle() { return this.title; }

  public void setInfo(String message) { this.lInfo.setText(message); }}
