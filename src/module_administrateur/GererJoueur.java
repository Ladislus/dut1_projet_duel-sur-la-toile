package module_administrateur;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.lang.Math;

public class GererJoueur extends BorderPane {

    PageAccueil pa;
    Button activer;
    Button supprimer;

    public GererJoueur(PageAccueil pa) {
      super();
      this.pa = pa;
      this.haut();
      this.gauche();
      this.centre();
    }

    public Button getButtonActiver() {
        return this.activer;
    }

    public Button getButtonSupprimer() {
        return this.supprimer;
    }

    public void haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Gestion des joueurs");
        Button bRetour = new Button("< Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        bRetour.setOnAction(new ActionRetour(this.pa));
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));
        this.setTop(haut);
    }

    public Button creerBoutonSupprimer() {
        this.supprimer = new Button("Supprimer");
        ActionSupprimerJoueur asj = new ActionSupprimerJoueur(this);
        this.supprimer.setStyle("-fx-background-color: #cf2a27;-fx-border-color: black");
        this.supprimer.setTextFill(Color.web("white"));
        this.supprimer.setPrefWidth(200);
        this.supprimer.setPrefHeight(50);
        this.supprimer.setOnAction(asj);
        return this.supprimer;
    }

    public Button creerBoutonActiver() {
        this.activer = new Button("Activer");
        ActionActiverJoueur acj = new ActionActiverJoueur(this);
        this.activer.setStyle("-fx-background-color: #009e0f;-fx-border-color: black");
        this.activer.setTextFill(Color.web("white"));
        this.activer.setPrefWidth(200);
        this.activer.setPrefHeight(50);
        this.activer.setOnAction(acj);
        return this.activer;
    }

    public HBox creerJoueurActiver() {
        HBox joueur = new HBox();
        Label lj = new Label("Joueur1");
        CheckBox cb = new CheckBox();
        cb.setOnAction(new ActionCheckActiver(this, this.pa.getAdmin(), "Joueur1"));
        joueur.getChildren().addAll(lj, cb);
        joueur.setSpacing(185);
        return joueur;
    }

    public void centre() {
        VBox centre = new VBox();
        Label l = new Label("Nombre de joueurs à activer : ");
        HBox bouton = new HBox();
        bouton.getChildren().addAll(creerBoutonActiver(), creerBoutonSupprimer());
        bouton.setSpacing(10);
        TextField recherche = new TextField();
        recherche.setPromptText("Rechercher un joueur");

        ScrollPane listeJoueur = new ScrollPane();
        listeJoueur.setPrefSize(280, 1000);

        VBox v = new VBox();

        for (int i=0; i<20; i++) {
            v.getChildren().addAll(creerJoueurActiver());
        }

        listeJoueur.setStyle("-fx-border-color: black;");
        v.setPadding(new Insets(5,0,0,10));
        v.setSpacing(10);

        listeJoueur.setContent(v);
        centre.getChildren().addAll(l, bouton, recherche, listeJoueur);
        centre.setSpacing(10);
        centre.setPadding(new Insets(0,25,15,25));
        this.setCenter(centre);
    }

    public HBox creerJoueurListeJoueur() {
        HBox joueur = new HBox();
      //  String pseudo = "l";
      //  int longPseudo = pseudo.length();
      //  Label lj = new Label("- "+pseudo+" ");
      //  for (int i=0; i<36-(longPseudo-6) ; i++) {
      //    lj.setText(lj.getText()+".");
      //  }
      //  lj.setText("- Joueur ....................................");
        Label lj = new Label("- Joueur ");
        Hyperlink hl = new Hyperlink("Profil");
        hl.setOnAction(new ActionProfilJoueur(this.pa, this, "Joueur"));
        joueur.setSpacing(150);
        joueur.getChildren().addAll(lj, hl);
        return joueur;
    }

    public void gauche() {
        VBox gauche = new VBox();
        Label l = new Label("Liste des joueurs");
        l.setPadding(new Insets(0,0,9,0));
        TextField recherche = new TextField();
        recherche.setPromptText("Rechercher un joueur");

        ScrollPane listeJoueur = new ScrollPane();
        listeJoueur.setPrefSize(280, 1000);
        listeJoueur.setStyle("-fx-border-color: black;");

        VBox v = new VBox();

        for (int i=0; i<20; i++) {
          v.getChildren().addAll(creerJoueurListeJoueur());

        }
        listeJoueur.setContent(v);
        gauche.getChildren().addAll(l, recherche, listeJoueur);
        v.setPadding(new Insets(5,0,0,10));
        v.setSpacing(5);
        gauche.setPadding(new Insets(0,0,15,25));
        this.setLeft(gauche);
    }
}
