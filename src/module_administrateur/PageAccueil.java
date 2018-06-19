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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ContentDisplay;

public class PageAccueil extends Application {

    BorderPane bp;
    Administration a;

    public static void main(String[] args) {
      launch(args);
    }

    public BorderPane getBp() {
      return this.bp;
    }

    public Administration getAdmin() {
      return this.a;
    }

    public VBox bas() {
      VBox bas = new VBox();
      ImageView stat = new ImageView();
      //stat.setImage(new Image(getClass().getResourceAsStream("./img/module_administrateur/stat.png".toURI().toString()));
      //Button bStat = new Button("Voir les statistiques", new ImageView(stat));
      Button bStat = new Button("Voir les statistiques", stat);
      //bStat.setGraphic(new ImageView(stat));
      bStat.setContentDisplay(ContentDisplay.TOP);


      bStat.setOnAction(new ActionStatistiques(this));
      bStat.setPrefWidth(630);
      bStat.setPrefHeight(130);
      bas.getChildren().add(bStat);
      bas.setAlignment(Pos.BOTTOM_CENTER);
      bas.setPadding(new Insets(0,0,15,0));

      return bas;
    }

    public HBox centre() {
      HBox centre = new HBox();
      //Image jeu = new Image(getClass().getResourceAsStream("./img/module_administrateur/jeu.png"));
      //Button bJeu = new Button("Gérer les jeux", new ImageView(jeu));
      Button bJeu = new Button("Gérer les jeux");
      bJeu.setContentDisplay(ContentDisplay.TOP);
      bJeu.setOnAction(new ActionJeu(this));
      bJeu.setPrefWidth(350);
      bJeu.setPrefHeight(220);


      //Image utilisateurs = new Image(getClass().getResourceAsStream("./img/module_administrateur/profil.png"));
      //Button bJoueur = new Button("Gérer les utilisateurs", new ImageView(utilisateurs));
      Button bJoueur = new Button("Gérer les utilisateurs");
      bJoueur.setContentDisplay(ContentDisplay.TOP);
      bJoueur.setPrefWidth(350);
      bJoueur.setPrefHeight(220);
      bJoueur.setOnAction(new ActionUtilisateurs(this));


      centre.getChildren().addAll(bJeu, bJoueur);
      centre.setPadding(new Insets(0,12,0,12));
      centre.setSpacing(16);

      return centre;
    }

    public BorderPane haut() {
      BorderPane haut = new BorderPane();
      Label l = new Label("Administration");
      Button b = new Button("< Accueil");
      haut.setLeft(l);
      haut.setRight(b);
      l.setFont(Font.font ("Arial", 25));
      haut.setPadding(new Insets(20,25,20,25));
      return haut;
    }

    public Scene scene() {
      this.bp = new BorderPane();
      this.bp.setCenter(this.constructB());
      this.a = new Administration();
      return new Scene(this.bp, 650, 450);
    }

    public BorderPane constructB() {
      BorderPane b = new BorderPane();
      b.setTop(haut());
      b.setCenter(centre());
      b.setBottom(bas());
      return b;
    }

    @Override
    public void start(Stage primaryStage) {
      primaryStage.setTitle("Duel sur la toile - Administration");
      primaryStage.setResizable(false);
      primaryStage.setScene(this.scene());
      primaryStage.show();
    }
}
