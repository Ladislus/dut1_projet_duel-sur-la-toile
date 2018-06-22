package module_joueur;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

class ConnexionJoueur extends BorderPane {

  private String title;

  private TextField tfLogin;

  private PasswordField tfPassword;

  private Stage primaryStage;

  private Label lInfo;

  /**
   Page afficher au lancement de l'application,
   permettant la connexion à la platforme
   @param primaryStage : La page principale à propager
  */
  ConnexionJoueur(Stage primaryStage) {

    super();

    this.primaryStage = primaryStage;

    this.title = "Accueil : Connexion";

    this.setLeft(creerGauche());
    this.setRight(creerDroite());
    this.setBottom(creerBas()); }

  /**
   Création de la partie gauche,
   contenant le logo et slogan
   @return : Une VBox
  */
  private VBox creerGauche() {

    VBox candidate = new VBox();

    Label slogan = new Label(VariablesJoueur.SLOGAN);
    slogan.setTextAlignment(TextAlignment.CENTER);
    slogan.setWrapText(true);
    slogan.setFont(VariablesJoueur.DEFAULT_SLOGAN_FONT);

    ImageView logo = new ImageView();
    logo.setImage(VariablesJoueur.LOGO_TEXT);
    logo.setFitWidth(100);
    logo.setFitHeight(100);

    this.lInfo = new Label("");
    lInfo.setAlignment(Pos.CENTER_LEFT);
    lInfo.setTextFill(VariablesJoueur.DEFAULT_ERROR_COLOR);

    candidate.getChildren().addAll(logo, slogan, lInfo);
    candidate.setPrefWidth(250);
    candidate.setSpacing(20);
    candidate.setPadding(new Insets(25,0,0,25));
    candidate.setAlignment(Pos.TOP_CENTER);

    return candidate; }

  /**
   Création de la partie droite de la page,
   contenant les champs de connexion et le bouton
   @return : Une VBox
  */
  private VBox creerDroite() {

    VBox candidate = new VBox();

    Hyperlink hlRegister = new Hyperlink("Pas de compte ? S'inscrire");
    hlRegister.setOnAction(new ActionToInscription(this.primaryStage));

    Hyperlink hlPasswordForgotten = new Hyperlink("Mot de passe oublié ?");
    //hlPasswordForgotten.setOnAction(new ActionToForgottenPassword(this.primaryStage));

    Label title = new Label("Connexion");
    title.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    Label lLogin = new Label("Pseudonyme : ");
    this.tfLogin = new TextField();
    tfLogin.setPromptText("Entrez votre pseudonyme ici");
    tfLogin.setOnKeyPressed(new ActionEntrerToDashboard(this.primaryStage));

    Label lPassword = new Label("Votre mot de passe : ");
    this.tfPassword = new PasswordField();
    tfPassword.setPromptText("Entrez votre mot de passe ici");
    tfPassword.setOnKeyPressed(new ActionEntrerToDashboard(this.primaryStage));

    Button btConnection = new Button("Vers l'aventure !");
    btConnection.setOnAction(new ActionConnection(this.primaryStage));

    candidate.setAlignment(Pos.TOP_CENTER);
    candidate.setPadding(new Insets(18,15,0,0));
    candidate.setPrefWidth(250);
    candidate.setSpacing(10);
    candidate.getChildren().addAll(title, lLogin, tfLogin, lPassword, tfPassword, hlRegister, hlPasswordForgotten, btConnection);

    return candidate; }

  /**
   Création de la partie inférieur contenant le copyright
   @return : Une HBox
  */
  private HBox creerBas() {

    HBox candidate = new HBox();

    Label lCopyright = new Label(VariablesJoueur.COPYRIGHT);
    lCopyright.setFont(VariablesJoueur.DEFAULT_TEXT_FONT);

    candidate.getChildren().add(lCopyright);
    candidate.setPadding(new Insets(0, 0, 5, 5));

    return candidate; }

  String getTfLogin() { return this.tfLogin.getText(); }

  String getTfPassword() { return this.tfPassword.getText(); }

  public String getTitle() { return this.title; }

  void setTfPassword(String s) { this.tfPassword.setText(s); }

  void setInfo(String message) { this.lInfo.setText(message); }}
