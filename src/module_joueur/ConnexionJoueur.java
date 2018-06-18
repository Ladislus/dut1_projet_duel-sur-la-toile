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

  public ConnexionJoueur(Stage primaryStage) {

    super();

    this.primaryStage = primaryStage;

    this.title = "Accueil : Connexion";

    this.setLeft(creerGauche());
    this.setRight(creerDroite());
    this.setBottom(creerBas()); }

  public VBox creerGauche() {

    VBox candidate = new VBox();

    Label slogan = new Label(VariablesJoueur.SLOGAN);
    slogan.setTextAlignment(TextAlignment.CENTER);
    slogan.setWrapText(true);
    slogan.setFont(VariablesJoueur.DEFAULT_SLOGAN_FONT);

    ImageView logo = new ImageView();
    logo.setImage(VariablesJoueur.LOGO_TEXT);
    logo.setFitWidth(100);
    logo.setFitHeight(100);

    candidate.getChildren().addAll(logo, slogan);
    candidate.setPrefWidth(250);
    candidate.setSpacing(20);
    candidate.setPadding(new Insets(25,0,0,25));
    candidate.setAlignment(Pos.TOP_CENTER);

    return candidate; }

  public VBox creerDroite() {

    VBox candidate = new VBox();

    Hyperlink hlRegister = new Hyperlink("Pas de compte ? S'inscrire");
    hlRegister.setOnAction(new ActionToInscription(this.primaryStage));

    Hyperlink hlPasswordForgotten = new Hyperlink("Mot de passe oublié ?");
    //hlPasswordForgotten.setOnAction(new ActionToForgottenPassword(this.primaryStage));

    Label title = new Label("Connexion");
    title.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    Label lLogin = new Label("Pseudonyme : ");
    tfLogin = new TextField();
    tfLogin.setPromptText("Entrez votre pseudonyme ici");

    Label lPassword = new Label("Votre mot de passe : ");
    tfPassword = new PasswordField();
    tfPassword.setPromptText("Entrez votre mot de passe ici");

    Button btConnection = new Button("Vers l'aventure !");
    btConnection.setOnAction(new ActionConnection(this.primaryStage));

    candidate.setAlignment(Pos.TOP_CENTER);
    candidate.setPadding(new Insets(18,15,0,0));
    candidate.setPrefWidth(250);
    candidate.setSpacing(10);
    candidate.getChildren().addAll(title, lLogin, tfLogin, lPassword, tfPassword, hlRegister, hlPasswordForgotten, btConnection);

    return candidate; }

  public HBox creerBas() {

    HBox candidate = new HBox();

    Label lCopyright = new Label(VariablesJoueur.COPYRIGHT);
    lCopyright.setFont(VariablesJoueur.DEFAULT_TEXT_FONT);

    candidate.getChildren().add(lCopyright);
    candidate.setPadding(new Insets(0, 0, 5, 5));

    return candidate; }

  public TextField getTfLogin() { return this.tfLogin; }

  public PasswordField getTfPassword() { return this.tfPassword; }

  public void setTfPassword(String s) { this.tfPassword.setText(s); }

  public String getTitle() { return this.title; }}
