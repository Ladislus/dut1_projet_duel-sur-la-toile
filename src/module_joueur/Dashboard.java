package module_joueur;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import APIMySQL.GestionBD;

import java.util.ArrayList;

class Dashboard extends BorderPane {

  private String title;

  private Stage primaryStage;

  private GestionBD laConnection;

  public Dashboard(Stage primaryStage, GestionBD laConnection) {

    super();

    this.title = "Dashboard";

    this.primaryStage = primaryStage;

    this.laConnection = laConnection;

    this.setTop(creerHaut());
    this.setLeft(creerGauche());
    this.setCenter(creerCentre());
    this.setRight(creerDroite()); }

  public HBox creerHaut() {

    Label lTitre = new Label("Bienvenue XxX_DarkSasuke-69_XxX ");
    lTitre.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    HBox candidate = new HBox();
    candidate.setAlignment(Pos.TOP_CENTER);
    candidate.setPadding(new Insets(20));
    candidate.getChildren().addAll(lTitre);

    return candidate; }

  public VBox creerGauche() {

    //todo : make to correspond to the IHM --> fini
    VBox candidate = new VBox();
    VBox param = new VBox();

    ImageView imageViewLogo = new ImageView();
    imageViewLogo.setImage(VariablesJoueur.LOGOUT);
    imageViewLogo.setPreserveRatio(true);
    imageViewLogo.setFitWidth(25);

    Button btStat = new Button("Mes statistiques");
    btStat.setPrefWidth(150);

    Button btParti = new Button("Mes parties");
    btParti.setPrefWidth(150);

    Button btEditerProfile = new Button("Éditez mon profil");
    btEditerProfile.setPrefWidth(150);

    Button btParametre = new Button("Mes paramètres");
    btParametre.setPrefWidth(150);

    Button btExit = new Button("", imageViewLogo);

    param.getChildren().addAll(btParametre, btExit);
    param.setSpacing(10);
    param.setAlignment(Pos.TOP_CENTER);
    param.setPadding(new Insets(250,0,0,0));

    candidate.getChildren().addAll(btStat, btParti, btEditerProfile, param);
    candidate.setPadding(new Insets(70,0,0,10));
    candidate.setSpacing(20);

    return candidate; }

  public VBox creerDroite() {

    VBox candidate = new VBox();
    VBox hDroiteListeDamis = new VBox();

    ScrollPane sDroiteListeDamis = new ScrollPane();

    Label lbTotalContact = new Label("Total : 8 contacts");
    Label lListeDamis = new Label("Ma liste d'amis");
    lListeDamis.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    Button btMessage = new Button("4 messages non lu");
    btMessage.setPrefWidth(150);

    Button btListeDamis = new Button("Mes amis");
    btListeDamis.setPrefWidth(150);

    //todo : Generation des bouton en fonction du nombre d'amis dans la bd et les afficher

    String[] btName = {"Jean Michel", "Jacque", "Titouan", "Pierre", "Michelle", "Mirene", "Sergine", "Anastasia"};

    ArrayList<Button> listeButton = new ArrayList<>();

    for (String name : btName) {

      ImageView imageContact = new ImageView();
      imageContact.setImage(VariablesJoueur.CONTACT);
      imageContact.setPreserveRatio(true);
      imageContact.setFitWidth(20);

      Button btContact = new Button(name, imageContact);
      btContact.setPrefWidth(150);
      btContact.setAlignment(Pos.CENTER_LEFT);
      listeButton.add(btContact); }

    hDroiteListeDamis.getChildren().addAll(listeButton);
    hDroiteListeDamis.setSpacing(5);
    hDroiteListeDamis.setPrefHeight(375);

    sDroiteListeDamis.setContent(hDroiteListeDamis);
    sDroiteListeDamis.setFitToWidth(true);

    candidate.setPadding(new Insets(5));
    candidate.setSpacing(15);
    candidate.getChildren().addAll(lListeDamis, sDroiteListeDamis, btListeDamis, lbTotalContact, btMessage);

    return candidate; }

  public VBox creerCentre() {

    //TODO: make that
    VBox candidate = new VBox();
    VBox vJeux = new VBox();
    VBox vNouveaute = new VBox();

    Label lbJeux = new Label("Jeux : ");
    Label lbNouveaute = new Label("Nouveautés : ");

    ScrollPane scrollPaneJeux = new ScrollPane();
    scrollPaneJeux.setPrefHeight(310);
    scrollPaneJeux.setContent(vJeux);

    ScrollPane scrollPaneNouveaute = new ScrollPane();
    scrollPaneNouveaute.setContent(vNouveaute);
    scrollPaneNouveaute.setPrefHeight(310);

    //todo remove that and place image

    for(int i = 0; i < 150; i++) {

      vJeux.getChildren().add(new Label("test"));
      vNouveaute.getChildren().add(new Label("test")); }

    candidate.getChildren().addAll(lbJeux, scrollPaneJeux, lbNouveaute, scrollPaneNouveaute);
    candidate.setSpacing(10);
    candidate.setPadding(new Insets(0,15,9,15));

    return candidate; }

  public String getTitle() { return this.title; }}
