package module_joueur;

import APIMySQL.GestionBD;
import APIMySQL.Utilisateur;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

import java.nio.file.Path;
import java.nio.file.Paths;

class EditionProfil extends BorderPane {

  private String title;

  private ImageView ivImageUser;

  private Stage primaryStage;
  private Stage secondaryStage;

  private Path imagePath;

  private Joueur joueur;

  private TextField tfPseudo;
  private TextField tfEmail;

  private PasswordField pfMotDePasse;
  private PasswordField pfConfirmMotDePasse;

  public EditionProfil(Stage primaryStage, Stage secondaryStage, Joueur joueur) {

    super();

    this.title = "Editez mon profil";
    this.joueur = joueur;

    this.joueur.setPseudo(Utilisateur.getPseudoById(joueur.getId()));
    this.joueur.setEmail(Utilisateur.getEmailByPseudo(joueur.getPseudo()));

    this.primaryStage = primaryStage;
    this.secondaryStage = secondaryStage;

    this.setLeft(creerGauche());
    this.setRight(creerDroite());
    this.setBottom(creerBas()); }

  public VBox creerGauche() {

    Label lImage = new Label("Mon image");
    lImage.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    this.ivImageUser = new ImageView();

    if (GestionBD.selectPreparedStatement("SELECT image from UTILISATEUR where idUt = " + this.joueur.getId() + ";").get("image").get(0) != null)
      ivImageUser.setImage(GestionBD.bytesToImage((byte[]) GestionBD.selectPreparedStatement("SELECT image from UTILISATEUR where idUt=" + this.joueur.getId()).get("image").get(0)));

    else
      ivImageUser.setImage(VariablesJoueur.USER);

    ivImageUser.setPreserveRatio(true);
    ivImageUser.setFitWidth(50);

    Button btModifier = new Button("Modifier");
    btModifier.setOnAction(actionEvent -> {

      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Open Resource File");
      fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
      File selectedFile = fileChooser.showOpenDialog(primaryStage);
      if (selectedFile != null) {
        this.imagePath = Paths.get(selectedFile.getAbsolutePath());
        ivImageUser.setImage(new Image(selectedFile.toURI().toString())); }});

    ImageView ivImageEditPseudo = new ImageView();
    ivImageEditPseudo.setImage(VariablesJoueur.EDIT);
    ivImageEditPseudo.setPreserveRatio(true);
    ivImageEditPseudo.setFitWidth(15);

    Label lPseudo = new Label("Mon pseudo");
    lPseudo.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    this.tfPseudo = new TextField();
    tfPseudo.setText(joueur.getPseudo());
    tfPseudo.setDisable(true);

    Button btEdition = new Button("", ivImageEditPseudo);
    btEdition.setOnAction(actionEvent -> tfPseudo.setDisable(false));

    VBox vImage = new VBox();
    vImage.getChildren().addAll(lImage,ivImageUser, btModifier);
    vImage.setAlignment(Pos.TOP_CENTER);
    vImage.setSpacing(15);

    HBox hPseudoWithEditionButton = new HBox();
    hPseudoWithEditionButton.getChildren().addAll(tfPseudo, btEdition);
    hPseudoWithEditionButton.setAlignment(Pos.TOP_CENTER);

    VBox vPseudo = new VBox();
    vPseudo.setAlignment(Pos.TOP_CENTER);
    vPseudo.setSpacing(10);
    vPseudo.getChildren().addAll(lPseudo, hPseudoWithEditionButton);

    VBox candidate = new VBox();
    candidate.setPadding(new Insets(15,0,0,15));
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

    this.tfEmail = new TextField();
    tfEmail.setText(joueur.getEmail());
    tfEmail.setDisable(true);

    Button btEditionEmail = new Button("", ivImageEdit);
    btEditionEmail.setOnAction(actionEvent -> tfEmail.setDisable(false));

    HBox hEmail = new HBox();
    hEmail.setAlignment(Pos.TOP_CENTER);
    hEmail.getChildren().addAll(tfEmail, btEditionEmail);

    VBox vEmail = new VBox();
    vEmail.getChildren().addAll(lEmail, hEmail);
    vEmail.setAlignment(Pos.TOP_CENTER);
    vEmail.setSpacing(12);

    ImageView ivImageEditMdp = new ImageView();
    ivImageEditMdp.setImage(VariablesJoueur.EDIT);
    ivImageEditMdp.setPreserveRatio(true);
    ivImageEditMdp.setFitWidth(15);

    Label lMotDePasse = new Label("Nouveau mot de passe :");
    lMotDePasse.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    this.pfMotDePasse = new PasswordField();
    pfMotDePasse.setDisable(true);

    Button btEditionMotPasse = new Button("", ivImageEditMdp);
    btEditionMotPasse.setOnAction(actionEvent -> {

      pfMotDePasse.setDisable(false);
      pfConfirmMotDePasse.setDisable(false); });

    HBox hMotDePasse = new HBox();
    hMotDePasse.setAlignment(Pos.TOP_CENTER);
    hMotDePasse.getChildren().addAll(pfMotDePasse, btEditionMotPasse);

    VBox vMotDePasse = new VBox();
    vMotDePasse.getChildren().addAll(lMotDePasse, hMotDePasse);
    vMotDePasse.setAlignment(Pos.TOP_CENTER);
    vMotDePasse.setSpacing(12);


    Label lConfirmMotDePasse = new Label("Confirmation :");
    lConfirmMotDePasse.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    this.pfConfirmMotDePasse = new PasswordField();
    pfConfirmMotDePasse.setDisable(true);
    pfConfirmMotDePasse.setPrefWidth(203);

    HBox hConfirmMotDePasse = new HBox();
    hConfirmMotDePasse.getChildren().addAll(pfConfirmMotDePasse);
    hConfirmMotDePasse.setAlignment(Pos.TOP_CENTER);

    VBox vConfirmMotDePasse = new VBox();
    vConfirmMotDePasse.setAlignment(Pos.TOP_CENTER);
    vConfirmMotDePasse.setSpacing(12);
    vConfirmMotDePasse.getChildren().addAll(lConfirmMotDePasse, hConfirmMotDePasse);

    VBox candidate = new VBox();
    candidate.getChildren().addAll(vEmail, vMotDePasse, vConfirmMotDePasse);
    candidate.setPadding(new Insets(15, 6, 0, 0));
    candidate.setSpacing(22);
    candidate.setPrefWidth(300);

    return candidate; }

  public BorderPane creerBas() {

    Button btRetour = new Button("Retour");
    btRetour.setOnAction(new ActionRetourToDashboard());

    Button btSuppressionCompte = new Button("Supprimer mon compte");
    btSuppressionCompte.setBackground(new Background(new BackgroundFill(Color.DARKRED, null, null)));
    btSuppressionCompte.setTextFill(Color.WHITE);
    btSuppressionCompte.setOnAction(new ActionSuppressionCompte(primaryStage, this.secondaryStage, joueur));

    Button btEnregistrer = new Button("Enregistrer");
    btEnregistrer.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
    btEnregistrer.setTextFill(Color.WHITE);
    btEnregistrer.setOnAction(new ActionEnregistrer(this.primaryStage, this.secondaryStage, joueur));

    BorderPane candidate = new BorderPane();
    candidate.setLeft(btRetour);
    candidate.setCenter(btSuppressionCompte);
    candidate.setRight(btEnregistrer);
    candidate.setPadding(new Insets(0, 10, 10, 10));

    return candidate; }

  public String getTitle() { return this.title; }

  public TextField getTfEmail() { return this.tfEmail; }

  public TextField getTfPseudo() { return this.tfPseudo; }

  public PasswordField getPfMotDePasse() { return this.pfMotDePasse; }

  public PasswordField getPfConfirmMotDePasse() { return this.pfConfirmMotDePasse; }

  public Path getImagePath() { return this.imagePath; }}
