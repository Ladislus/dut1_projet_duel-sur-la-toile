package module_joueur;

import APIMySQL.GestionBD;
import APIMySQL.Jeu;
import APIMySQL.Utilisateur;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dashboard extends BorderPane {

  private Boolean isAdmin;

  private String title;

  private Stage primaryStage;

  private Joueur joueur;

  private VBox vDroiteListeDamis;

  private FlowPane hJeux;
  private FlowPane hNouveaute;

  private ArrayList<Button> listeBoutton;

  /**
   Création du dashboard du joueur
   @param primaryStage : La page principale à propager
   @param joueur : Le joueur courant
   @param isAdmin : Boolean indiquant si l'utilisateur est admin ou non
  */
  public Dashboard(Stage primaryStage, Joueur joueur, Boolean isAdmin) {

    super();

    this.isAdmin = isAdmin;

    this.title = "Dashboard";

    this.vDroiteListeDamis = new VBox();

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

  /**
   Création de la partie haute contenant le titre
   @return : Une Hbox
  */
  private HBox creerHaut() {

    Label lTitre = new Label("Bienvenue " + joueur.getPseudo());
    lTitre.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    HBox candidate = new HBox();
    candidate.setAlignment(Pos.TOP_CENTER);
    candidate.setPadding(new Insets(20));
    candidate.getChildren().addAll(lTitre);

    return candidate; }

  /**
   Création de la partie gauche, contenant les boutons de menu
   @return : Une VBox
  */
  private VBox creerGauche() {

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

    Button btEditerProfile = new Button("Éditer mon profil");
    btEditerProfile.setOnAction(new ActionToEditerProfile(this.primaryStage, joueur));
    btEditerProfile.setPrefWidth(150);

    Button btExit = new Button("", imageViewLogo);
    btExit.setOnAction(new ActionDeconnexion(this.primaryStage));

    //Ajout dud bouton d'acces à l'administration si l'utilisateur est admin
    if (isAdmin) {

      Button btAdmin = new Button("Admin");
      btAdmin.setOnAction(new ActionToAdmin());

      param.getChildren().addAll(btAdmin, btExit); }

    else { param.getChildren().add(btExit); }

    param.setSpacing(10);
    param.setAlignment(Pos.TOP_CENTER);
    param.setPadding(new Insets(250,0,0,0));

    candidate.getChildren().addAll(btStat, btParti, btEditerProfile, param);
    candidate.setPadding(new Insets(70,0,0,10));
    candidate.setSpacing(20);

    return candidate; }

  /**
   Création de la partie droite, contenant la liste d'amis
   ainsi que l'acces à la messagerie
   @return : Une VBox
  */
  private VBox creerDroite() {

    Label lbTotalContact = new Label("Total : " + listeBoutton.size() + " contact(s)");
    Label lListeDamis = new Label("Ma liste d'ami");
    lListeDamis.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    //TODO : Mettre si des messages sont non lus
    Button btMessage = new Button("Messagerie");
    btMessage.setOnAction(new ActionToMessagerie(joueur));
    btMessage.setPrefWidth(150);

    Button btListeDamis = new Button("Invitation");
    btListeDamis.setOnAction(new ActionToInvitation(joueur, this));
    btListeDamis.setPrefWidth(150);

    vDroiteListeDamis.setSpacing(5);
    vDroiteListeDamis.setPrefHeight(375);

    ScrollPane sDroiteListeDamis = new ScrollPane();
    sDroiteListeDamis.setContent(vDroiteListeDamis);
    sDroiteListeDamis.setFitToWidth(true);

    VBox candidate = new VBox();
    candidate.setPadding(new Insets(5));
    candidate.setSpacing(15);
    candidate.getChildren().addAll(lListeDamis, sDroiteListeDamis, lbTotalContact, btListeDamis, btMessage);

    return candidate; }

  /**
   Création du centre du dashboard, contenant les deux bibliothèques de jeux
   @return : Une VBox
  */
  private VBox creerCentre() {

    Label lbJeux = new Label("Jeux : ");

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

  /**
   Mise à jour de l'affichage de du dashboard
  */
  public void majAffichage() {

    listeBoutton.clear();

    ArrayList<String> btName = Utilisateur.getListeDamis(joueur.getPseudo());

    if(!(btName == null)){
      for (String name : btName) {

        ImageView imageContact = new ImageView();
        if (GestionBD.selectPreparedStatement("SELECT image from UTILISATEUR where idUt = " + Utilisateur.getIdByPseudo(name) + ";").get("image").get(0) != null)
            imageContact.setImage(GestionBD.bytesToImage((byte[]) GestionBD.selectPreparedStatement("SELECT image from UTILISATEUR where idUt=" + Utilisateur.getIdByPseudo(name)).get("image").get(0)));

        else
            imageContact.setImage(VariablesJoueur.CONTACT);

        imageContact.setPreserveRatio(true);
        imageContact.setFitWidth(35);

        Button btContact = new Button(name, imageContact);
        btContact.setPrefWidth(150);
        btContact.setAlignment(Pos.CENTER_LEFT);

        listeBoutton.add(btContact); }

      vDroiteListeDamis.getChildren().clear();
      vDroiteListeDamis.getChildren().addAll(listeBoutton); }

    hJeux.getChildren().clear();

    HashMap<String, List<Object>> listeJeux = Jeu.recupListeJeux();

    ArrayList<String> listeTitleJeux = new ArrayList<>();

    if (listeJeux.size() > 0) {

        for (Object title : listeJeux.get("nomJeu")) { listeTitleJeux.add(title.toString()); }

        for (int i = 0; i < listeTitleJeux.size(); i++) {

          String titre = listeTitleJeux.get(i);

          byte[] bytes = (byte[]) GestionBD.selectPreparedStatement("SELECT image from JEU where nomJeu = '" + titre + "';").get("image").get(0);

          String regles = (String) GestionBD.selectPreparedStatement("SELECT regleJeu from JEU where nomJeu = '" + titre + "';").get("regleJeu").get(0);


          module_joueur.Jeu jeu = new module_joueur.Jeu(titre, bytes, regles);

          ImageView ivJeux = new ImageView();
          ivJeux.setImage(jeu.getImage());
          ivJeux.setPreserveRatio(true);
          ivJeux.setFitWidth(50);

          VBox vBoxJeux = new VBox();
          vBoxJeux.getChildren().addAll(ivJeux, new Label(jeu.getTitle()));
          vBoxJeux.setAlignment(Pos.TOP_CENTER);
          vBoxJeux.setOnMouseEntered(mouseEvent -> primaryStage.getScene().setCursor(Cursor.HAND));
          vBoxJeux.setOnMouseExited(mouseEvent -> primaryStage.getScene().setCursor(Cursor.DEFAULT));
          vBoxJeux.setPadding(new Insets(9,15,0,15));
          vBoxJeux.setOnMouseClicked(new ActionToMainJeux(jeu));

          hJeux.getChildren().add(vBoxJeux); }}}

  public String getTitle() { return this.title; }}
