package module_joueur;

import APIMySQL.GestionBD;
import APIMySQL.Jeu;
import APIMySQL.Utilisateur;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

class Dashboard extends BorderPane {

  private String title;

  private Stage primaryStage;

  private Joueur joueur;

  private int nbJeux;

  private FlowPane hJeux;
  private FlowPane hNouveaute;

  private ArrayList<Button> listeBoutton;

  public Dashboard(Stage primaryStage, Joueur joueur) {

    super();

    this.title = "Dashboard";

    this.hJeux = new FlowPane();

    this.hNouveaute = new FlowPane();

    this.primaryStage = primaryStage;

    this.joueur = joueur;

    this.listeBoutton = new ArrayList<>();


    majAffichage();

    this.setTop(creerHaut());
    this.setLeft(creerGauche());
    this.setCenter(creerCentre());
    this.setRight(creerDroite()); }

  public HBox creerHaut() {

    Label lTitre = new Label("Bienvenue " + joueur.getPseudo());
    lTitre.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    HBox candidate = new HBox();
    candidate.setAlignment(Pos.TOP_CENTER);
    candidate.setPadding(new Insets(20));
    candidate.getChildren().addAll(lTitre);

    return candidate; }

  public VBox creerGauche() {

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
    btEditerProfile.setOnAction(new ActionToEditerProfile(primaryStage, joueur));
    btEditerProfile.setPrefWidth(150);

    Button btParametre = new Button("Mes paramètres");
    btParametre.setPrefWidth(150);

    Button btExit = new Button("", imageViewLogo);
    btExit.setOnAction(new ActionDeconnexion(primaryStage));

    param.getChildren().addAll(btParametre, btExit);
    param.setSpacing(10);
    param.setAlignment(Pos.TOP_CENTER);
    param.setPadding(new Insets(250,0,0,0));

    candidate.getChildren().addAll(btStat, btParti, btEditerProfile, param);
    candidate.setPadding(new Insets(70,0,0,10));
    candidate.setSpacing(20);

    return candidate; }

  public VBox creerDroite() {

    Label lbTotalContact = new Label("Total : "+listeBoutton.size()+" contact(s)");
    Label lListeDamis = new Label("Ma liste d'ami");
    lListeDamis.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    Button btMessage = new Button("4 messages non lu");
    btMessage.setPrefWidth(150);

    Button btListeDamis = new Button("Mes amis");
    btListeDamis.setPrefWidth(150);

    VBox vDroiteListeDamis = new VBox();
    vDroiteListeDamis.getChildren().addAll(listeBoutton);
    vDroiteListeDamis.setSpacing(5);
    vDroiteListeDamis.setPrefHeight(375);

    ScrollPane sDroiteListeDamis = new ScrollPane();
    sDroiteListeDamis.setContent(vDroiteListeDamis);
    sDroiteListeDamis.setFitToWidth(true);

    VBox candidate = new VBox();
    candidate.setPadding(new Insets(5));
    candidate.setSpacing(15);
    candidate.getChildren().addAll(lListeDamis, sDroiteListeDamis, btListeDamis, lbTotalContact, btMessage);

    return candidate; }

  public VBox creerCentre() {

    Label lbJeux = new Label("Ma bibliothèque ");

    ScrollPane scrollPaneJeux = new ScrollPane();
    scrollPaneJeux.setContent(hJeux);
    scrollPaneJeux.setFitToWidth(true);
    scrollPaneJeux.setPrefHeight(310);
    scrollPaneJeux.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0); -fx-focus-color: transparent;");
    scrollPaneJeux.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    hJeux.setPadding(new Insets(15,8,0,15));
    hJeux.setPrefWidth(scrollPaneJeux.getWidth());

    ScrollPane scrollPaneNouveaute = new ScrollPane();
    scrollPaneNouveaute.setContent(hNouveaute);
    scrollPaneNouveaute.setFitToWidth(true);
    scrollPaneNouveaute.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);-fx-focus-color: transparent;");
    scrollPaneNouveaute.setPrefHeight(310);
    scrollPaneNouveaute.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

    Label lbNouveaute = new Label("Nouveautés : ");
    hNouveaute.setPrefWidth(scrollPaneJeux.getWidth());

    VBox candidate = new VBox();
    candidate.getChildren().addAll(lbJeux, scrollPaneJeux, lbNouveaute, scrollPaneNouveaute);
    candidate.setSpacing(10);
    candidate.setPadding(new Insets(0,15,9,15));

    return candidate; }

  public void majAffichage(){

    ArrayList<String> btName = Utilisateur.getListeDamis(joueur.getPseudo());

    if(btName == null){

      btName = new ArrayList<>();
      btName.add("Ajouter un amis");

      for (String name : btName) {

        ImageView imageContact = new ImageView();
        imageContact.setImage(VariablesJoueur.CONTACT);
        imageContact.setPreserveRatio(true);
        imageContact.setFitWidth(20);

        Button btContact = new Button(name, imageContact);
        btContact.setOnAction(new ActionToAjouterAmi());
        btContact.setPrefWidth(150);
        btContact.setAlignment(Pos.CENTER_LEFT);

        listeBoutton.add(btContact); }}

    else {

      for (String name : btName) {

        ImageView imageContact = new ImageView();
        imageContact.setImage(VariablesJoueur.CONTACT);
        imageContact.setPreserveRatio(true);
        imageContact.setFitWidth(20);

        Button btContact = new Button(name, imageContact);
        btContact.setPrefWidth(150);
        btContact.setAlignment(Pos.CENTER_LEFT);

        listeBoutton.add(btContact); }}

    HashMap<String, List<Object>> listeJeux = Jeu.recupListeJeux();

    ArrayList<String> listeTitleJeux = new ArrayList<>();
    System.out.println(listeTitleJeux);
    if(listeTitleJeux.size() > 1){
        for(Object title : listeJeux.get("nomJeu")){
            String titleString = title.toString();
            listeTitleJeux.add(titleString); }

        for(int i = 0; i < listeTitleJeux.size(); i++) {

            module_joueur.Jeu jeu = new module_joueur.Jeu(listeTitleJeux.get(i));

            //TODDO: recuperer le blob de la bd
            File fileImage = new File("./img/pub/logo.png");
            ImageView ivJeux = new ImageView(new Image(fileImage.toURI().toString()));
            ivJeux.setPreserveRatio(true);
            ivJeux.setFitWidth(50);

            VBox vBoxJeux = new VBox();
            vBoxJeux.getChildren().addAll(ivJeux, new Label(jeu.getTitle()));
            vBoxJeux.setAlignment(Pos.TOP_CENTER);
            vBoxJeux.setOnMouseEntered(mouseEvent -> primaryStage.getScene().setCursor(Cursor.HAND));
            vBoxJeux.setOnMouseExited(mouseEvent -> primaryStage.getScene().setCursor(Cursor.DEFAULT));
            vBoxJeux.setPadding(new Insets(9,15,0,15));
            vBoxJeux.setOnMouseClicked(new ActionToMainJeux(this.primaryStage, jeu));

            hJeux.getChildren().add(vBoxJeux); }}
    }


  public String getTitle() { return this.title; }}
