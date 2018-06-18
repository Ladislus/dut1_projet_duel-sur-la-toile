package module_joueur;

import APIMySQL.GestionBD;
import APIMySQL.Jeu;
import APIMySQL.Utilisateur;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

class Dashboard extends BorderPane {

  private String title;

  private Stage primaryStage;

  

  private Joueur joueur;

  private ArrayList<Button> listeBoutton;

  public Dashboard(Stage primaryStage, Joueur joueur) {

    super();

    this.title = "Dashboard";

    this.primaryStage = primaryStage;

    

    this.joueur = joueur;

    this.listeBoutton = new ArrayList<>();

    majAffichage();

    this.setTop(creerHaut());
    this.setLeft(creerGauche());
    this.setCenter(creerCentre());
    this.setRight(creerDroite()); }

  public HBox creerHaut() {

    Label lTitre = new Label("Bienvenue "+joueur.getPseudo());
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

    VBox candidate = new VBox();
    VBox hDroiteListeDamis = new VBox();

    ScrollPane sDroiteListeDamis = new ScrollPane();

    Label lbTotalContact = new Label("Total : "+listeBoutton.size()+" contact(s)");
    Label lListeDamis = new Label("Ma liste d'amis");
    lListeDamis.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

    Button btMessage = new Button("4 messages non lu");
    btMessage.setPrefWidth(150);

    Button btListeDamis = new Button("Mes amis");
    btListeDamis.setPrefWidth(150);

    hDroiteListeDamis.getChildren().addAll(listeBoutton);
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
    FlowPane hJeux = new FlowPane();
    FlowPane hNouveaute = new FlowPane();

    Label lbJeux = new Label("Jeux : ");
    Label lbNouveaute = new Label("Nouveautés : ");

    ScrollPane scrollPaneJeux = new ScrollPane();
    scrollPaneJeux.setPrefHeight(310);
    scrollPaneJeux.setContent(hJeux);
    scrollPaneJeux.setFitToWidth(true);
    scrollPaneJeux.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

    ScrollPane scrollPaneNouveaute = new ScrollPane();
    scrollPaneNouveaute.setContent(hNouveaute);
    scrollPaneNouveaute.setPrefHeight(310);
    scrollPaneNouveaute.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

    //todo remove that and place image

    for(int i = 0; i < 155; i++) {

      hJeux.getChildren().add(new Label("test"));
      hNouveaute.getChildren().add(new Label("test")); }

    candidate.getChildren().addAll(lbJeux, scrollPaneJeux, lbNouveaute, scrollPaneNouveaute);
    candidate.setSpacing(10);
    candidate.setPadding(new Insets(0,15,9,15));

    return candidate;
  }

  public void majAffichage(){

      //Generation des bouton en fonction du nombre d'amis dans la bd et les afficher
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
              btContact.setPrefWidth(150);
              btContact.setAlignment(Pos.CENTER_LEFT);
              listeBoutton.add(btContact);
          }
      }
      else{
          for (String name : btName) {
              ImageView imageContact = new ImageView();
              imageContact.setImage(VariablesJoueur.CONTACT);
              imageContact.setPreserveRatio(true);
              imageContact.setFitWidth(20);

              Button btContact = new Button(name, imageContact);
              btContact.setPrefWidth(150);
              btContact.setAlignment(Pos.CENTER_LEFT);
              listeBoutton.add(btContact);
          }
      }
      //On refresh la liste des jeux
      HashMap<String, List<Object>> listeJeux = Jeu.recupListeJeux();
      for(String key: listeJeux.keySet()){
          System.out.println(listeJeux.get(key).get(0));
      }
  }

  public String getTitle() {
      return this.title;
  }

}
