package module_joueur;

import APIMySQL.ConnexionMySQL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

class EditionProfil extends BorderPane {

  String title;

  Stage primaryStage;

  Joueur joueur;

  TextField tfEmail;

  public EditionProfil(Stage primaryStage, Joueur joueur) {

    super();

    this.title = "Editez mon profil";
    this.joueur = joueur;

    this.primaryStage = primaryStage;

    this.setLeft(creerGauche());
    this.setRight(creerDroite());
    this.setBottom(creerBas()); }

  public VBox creerGauche() {

    Label lImage = new Label("Mon image");
    lImage.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    //TODO : si le joueur n'a pas d'image, mettre USER, sinon son image
    ImageView ivImageUser = new ImageView();
    ivImageUser.setImage(VariablesJoueur.USER);
    ivImageUser.setPreserveRatio(true);
    ivImageUser.setFitWidth(50);

    Button btModifier = new Button("Modifier");

    VBox vImage = new VBox();
    vImage.getChildren().addAll(lImage,ivImageUser, btModifier);
    vImage.setAlignment(Pos.TOP_CENTER);
    vImage.setSpacing(15);


    ImageView ivImageEditPseudo = new ImageView();
    ivImageEditPseudo.setImage(VariablesJoueur.EDIT);
    ivImageEditPseudo.setPreserveRatio(true);
    ivImageEditPseudo.setFitWidth(15);

    Label lPseudo = new Label("Mon pseudo");
    lPseudo.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    TextField tfPseudo = new TextField();
    tfPseudo.setText(joueur.getPseudo());
    tfPseudo.setDisable(true);

    Button btEdition = new Button("", ivImageEditPseudo);
    btEdition.setOnAction(actionEvent -> tfPseudo.setDisable(false));

    HBox hPseudoWithEditionButton = new HBox();
    hPseudoWithEditionButton.getChildren().addAll(tfPseudo, btEdition);
    hPseudoWithEditionButton.setAlignment(Pos.TOP_CENTER);

    VBox vPseudo = new VBox();
    vPseudo.setAlignment(Pos.TOP_CENTER);
    vPseudo.setSpacing(10);
    vPseudo.getChildren().addAll(lPseudo, hPseudoWithEditionButton);

    VBox candidate = new VBox();
    candidate.setPadding(new Insets(15, 0, 0, 15));
    candidate.setSpacing(25);
    candidate.setPrefWidth(230);
    candidate.getChildren().addAll(vImage, vPseudo);

    return candidate; }

  public VBox creerDroite() {


    ImageView ivImageEdit = new ImageView();
    ivImageEdit.setImage(VariablesJoueur.EDIT);
    ivImageEdit.setPreserveRatio(true);
    ivImageEdit.setFitWidth(15);

    Label lEmail = new Label("Email :");
    lEmail.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    tfEmail = new TextField();
    tfEmail.setText(joueur.getEmail());
    tfEmail.setDisable(true);

    Button btEditionEmail = new Button("", ivImageEdit);
    btEditionEmail.setOnAction(actionEvent -> tfEmail.setDisable(false));

    VBox vEmail = new VBox();
    vEmail.getChildren().addAll(lEmail, hEmail);
    vEmail.setAlignment(Pos.TOP_CENTER);
    vEmail.setSpacing(12);

    HBox hEmail = new HBox();
    hEmail.setAlignment(Pos.TOP_CENTER);
    hEmail.getChildren().addAll(tfEmail, btEditionEmail);

    ImageView ivImageEditMdp = new ImageView();
    ivImageEditMdp.setImage(VariablesJoueur.EDIT);
    ivImageEditMdp.setPreserveRatio(true);
    ivImageEditMdp.setFitWidth(15);

    Label lMotDePasse = new Label("Nouveau mot de passe :");
    lMotDePasse.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    PasswordField tfMotDePasse = new PasswordField();
    tfMotDePasse.setDisable(true);


    VBox vMotDePasse = new VBox();
    vMotDePasse.getChildren().addAll(lMotDePasse, hMotDePasse);
    vMotDePasse.setAlignment(Pos.TOP_CENTER);
    vMotDePasse.setSpacing(12);

    HBox hMotDePasse = new HBox();
    hMotDePasse.setAlignment(Pos.TOP_CENTER);
    hMotDePasse.getChildren().addAll(tfMotDePasse, btEditionMotPasse);

    Label lConfirmMotDePasse = new Label("Confirmation :");
    lConfirmMotDePasse.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    PasswordField tfConfirmMotDePasse = new PasswordField();
    tfConfirmMotDePasse.setDisable(true);
    tfConfirmMotDePasse.setPrefWidth(203);


    VBox vConfirmMotDePasse = new VBox();
    vConfirmMotDePasse.setAlignment(Pos.TOP_CENTER);
    vConfirmMotDePasse.setSpacing(12);
    vConfirmMotDePasse.getChildren().addAll(lConfirmMotDePasse, hConfirmMotDePasse);

    HBox hConfirmMotDePasse = new HBox();
    hConfirmMotDePasse.getChildren().addAll(tfConfirmMotDePasse);
    hConfirmMotDePasse.setAlignment(Pos.TOP_CENTER);

    Button btEditionMotPasse = new Button("", ivImageEditMdp);
    btEditionMotPasse.setOnAction(actionEvent -> {
      tfMotDePasse.setDisable(false);
      tfConfirmMotDePasse.setDisable(false); });

    VBox candidate = new VBox();
    candidate.getChildren().addAll(vEmail, vMotDePasse, vConfirmMotDePasse);
    candidate.setPadding(new Insets(15,6,0,0));
    candidate.setSpacing(22);
    candidate.setPrefWidth(300);

    return candidate; }

  public BorderPane creerBas() {

    Button btRetour = new Button("Retour");
    btRetour.setStyle("-fx-background-color: #2355a0; -fx-text-fill: #ffffff");
    btRetour.setOnAction(new ActionRetourToDashboard());

    Button btSuppressionCompte = new Button("Supprimer mon compte");
    btSuppressionCompte.setStyle("-fx-background-color: #cc250c; -fx-text-fill: #ffffff");
    btSuppressionCompte.setOnAction(new ActionSupressionCompte(primaryStage, joueur));

    Button btEnregistrer = new Button("Enregistrer");
    btEnregistrer.setStyle("-fx-background-color: #40b70c; -fx-text-fill: #ffffff");

    BorderPane candidate = new BorderPane();
    candidate.setLeft(btRetour);
    candidate.setCenter(btSuppressionCompte);
    candidate.setRight(btEnregistrer);
    candidate.setPadding(new Insets(0, 10, 10, 10));

    return candidate; }

    public String getTitle() { return this.title; }

    public TextField getTfEmail() { return this.tfEmail; }}
