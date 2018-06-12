package module_joueur;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;

class ConnexionJoueur extends BorderPane {

  String title;

  Hyperlink hlRegister;
  Hyperlink hlPasswordForgotten;

  TextField tfLogin;

  PasswordField tfPassword;

  Button btConnection;

  Stage primaryStage;

  public ConnexionJoueur(Stage primaryStage) {

    super();

    this.primaryStage = primaryStage;

    this.title = "Acceuil : Connexion";

    this.setLeft(creerGauche());
    this.setRight(creerDroite());
    this.setBottom(creerBas()); }

  public VBox creerGauche() {

    VBox candidate = new VBox();

    Label slogan = new Label("La plateforme de jeux videos innovante !");
    slogan.setTextAlignment(TextAlignment.CENTER);
    slogan.setWrapText(true);
    slogan.setFont(Font.font("Arial", 15));

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

    hlRegister = new Hyperlink("Pas de compte ? S'inscrire maintenant");
    hlRegister.setOnAction(new ActionHyperlink(this.primaryStage));

    hlPasswordForgotten = new Hyperlink("Mot de passe oubliée ?");
    hlPasswordForgotten.setOnAction(new ActionHyperlink(this.primaryStage));

    Label title = new Label("Connexion");
    title.setFont(Font.font("Arial", 19));

    Label lLogin = new Label("Votre nom d'utilisateur : ");
    tfLogin = new TextField();

    Label lPassword = new Label("Votre mot de passe : ");
    tfPassword = new PasswordField();

    btConnection = new Button("Vers l'aventure ! -->>");
    //btConnection.setOnAction(new ActionBouton());

    candidate.setAlignment(Pos.TOP_CENTER);
    candidate.setPadding(new Insets(18,15,0,0));
    candidate.setPrefWidth(250);
    candidate.setSpacing(10);
    candidate.getChildren().addAll(title, lLogin, tfLogin, lPassword, tfPassword, hlRegister, hlPasswordForgotten, btConnection);

    return candidate; }

  public HBox creerBas() {

    HBox candidate = new HBox();

    Label lCopyright = new Label("© Copyright : Duel sur la toile");
    lCopyright.setFont(Font.font("Arial", 10));

    candidate.getChildren().add(lCopyright);
    candidate.setPadding(new Insets(0,0,5,5));

    return candidate; }

  public Hyperlink getHlRegister() { return this.hlRegister; }

  public Hyperlink getHlPasswordForgotten() { return this.hlPasswordForgotten; }

  public TextField getTfLogin() { return this.tfLogin; }

  public PasswordField getTfPassword() { return this.tfPassword; }

  public Button getbtConnection() { return this.btConnection; }

  public String getTitle() { return this.title; }}
