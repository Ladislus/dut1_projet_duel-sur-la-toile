package module_administrateur;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.ContentDisplay;
import module_joueur.ActionToAdmin;

public class PageAccueil extends BorderPane {

    /** Attributs de la classe PageAccueil */

    private Administration admin;

    private String title;

    private Stage primaryStage;

    public PageAccueil(Stage primaryStage) {

        super();

        this.title = "Admin";

        this.primaryStage = primaryStage;

        this.admin = new Administration();

        this.setTop(haut());
        this.setCenter(centre());
        this.setBottom(bas()); }

    public PageAccueil getBp() {
      return (PageAccueil) this.primaryStage.getScene().getRoot();
    }

    public Administration getAdmin() {
      return this.admin; }

    /** Création du VBox qui affiche le bouton "Voir les statistiques" ainsi que l'image */
    public VBox bas() {
      VBox bas = new VBox();
      //Image stat = new Image(getClass().getResourceAsStream("./img/module_administrateur/stat.png"));
      //Button bStat = new Button("Voir les statistiques", new ImageView(stat));
      Button bStat = new Button("Voir les statistiques");
      bStat.setContentDisplay(ContentDisplay.TOP);


      bStat.setOnAction(new ActionStatistiques(this.primaryStage));
      bStat.setPrefWidth(630);
      bStat.setPrefHeight(130);
      bas.getChildren().add(bStat);
      bas.setAlignment(Pos.BOTTOM_CENTER);
      bas.setPadding(new Insets(0,0,15,0));

      return bas;
    }

    /** Création du HBox qui affiche les boutons ainsi que les images pour "Gérer les jeux" et
    "Gérer les utilisateurs" */
    public HBox centre() {
      HBox centre = new HBox();
      //Image jeu = new Image(getClass().getResourceAsStream("./img/module_administrateur/jeu.png"));
      //Button bJeu = new Button("Gérer les jeux", new ImageView(jeu));
      Button bJeu = new Button("Gérer les jeux");
      bJeu.setContentDisplay(ContentDisplay.TOP);
      bJeu.setOnAction(new ActionJeu(this.primaryStage));
      bJeu.setPrefWidth(350);
      bJeu.setPrefHeight(220);


      //Image utilisateurs = new Image(getClass().getResourceAsStream("./img/module_administrateur/profil.png"));
      //Button bJoueur = new Button("Gérer les utilisateurs", new ImageView(utilisateurs));
      Button bJoueur = new Button("Gérer les utilisateurs");
      bJoueur.setContentDisplay(ContentDisplay.TOP);
      bJoueur.setPrefWidth(350);
      bJoueur.setPrefHeight(220);
      bJoueur.setOnAction(new ActionUtilisateurs(this.primaryStage));


      centre.getChildren().addAll(bJeu, bJoueur);
      centre.setPadding(new Insets(0,12,0,12));
      centre.setSpacing(16);

      return centre;
    }

    /** Création de l'entête de la page */
    public BorderPane haut() {
      BorderPane haut = new BorderPane();
      Label l = new Label("Administration");
      Button b = new Button("Accueil");
      haut.setLeft(l);
      haut.setRight(b);
      l.setFont(Font.font ("Arial", 25));
      haut.setPadding(new Insets(20,25,20,25));
      return haut; }

    public String getTitle() { return this.title; }}
