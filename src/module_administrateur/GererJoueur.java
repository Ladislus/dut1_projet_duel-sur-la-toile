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

public class GererJoueur extends BorderPane {

    PageAccueil pa;

    public GererJoueur(PageAccueil pa) {
      super();
      this.pa = pa;
      this.haut();
      this.gauche();
      this.centre();
    }

    public void haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Gestion des joueurs");
        Button bRetour = new Button("< Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        bRetour.setOnAction(new ActionRetour());
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));
        this.setTop(haut);
    }

    public void centre() {
        VBox centre = new VBox();

        Label l = new Label("Nombre de joueurs à activer : ");
        Button activer = new Button("Activer");
        Button supprimer = new Button("Supprimer");
        activer.setStyle("-fx-background-color: #009e0f;");
        supprimer.setStyle("-fx-background-color: #cf2a27;");
        activer.setTextFill(Color.web("white"));
        supprimer.setTextFill(Color.web("white"));
        activer.setPrefWidth(200);
        activer.setPrefHeight(50);
        supprimer.setPrefWidth(200);
        supprimer.setPrefHeight(50);
        HBox bouton = new HBox();
        bouton.getChildren().addAll(activer, supprimer);
        bouton.setSpacing(10);
        VBox listeJoueur = new VBox();
        TextField recherche = new TextField("Rechercher un joueur");

        VBox v = new VBox();

        //POUR CHAQUE JOUEUR
        BorderPane joueur = new BorderPane();
        Label lj = new Label("Joueur1");
        CheckBox cb = new CheckBox();
        joueur.setLeft(lj);
        joueur.setRight(cb);
        BorderPane joueur2 = new BorderPane();
        Label lj2 = new Label("Joueur2");
        CheckBox cb2 = new CheckBox();
        joueur2.setLeft(lj2);
        joueur2.setRight(cb2);

        v.getChildren().addAll(joueur, joueur2);
        listeJoueur.getChildren().addAll(recherche, v);
        listeJoueur.setStyle("-fx-border-color: black;");
        listeJoueur.setPrefHeight(300);
        listeJoueur.setSpacing(5);
        v.setPadding(new Insets(5,0,0,10));
        v.setSpacing(10);


        centre.getChildren().addAll(l, bouton, listeJoueur);
        centre.setSpacing(10);

        centre.setPadding(new Insets(0,25,15,25));

        this.setCenter(centre);
    }

    public void gauche() {
        VBox gauche = new VBox();
        Label l = new Label("Liste des joueurs");
        l.setPadding(new Insets(0,0,12,0));
        TextField recherche = new TextField("Rechercher un joueur");
        VBox listeJoueur = new VBox();
        listeJoueur.setPrefHeight(450);
        listeJoueur.setStyle("-fx-border-color: black;");

//SI NOMBRE DE JOUEUR EST SUPERIEUR A VALEUR ALORS AFFICHER UNE BARRE DE DEFILEMENT

        VBox v = new VBox();

       //POUR CHAQUE JOUEUR
        HBox joueur = new HBox();
        Label lj = new Label("- Joueur1");
        Hyperlink hl = new Hyperlink("Profil");
        hl.setOnAction(new ActionProfilJoueur(this.pa));
        joueur.setSpacing(150);
        joueur.getChildren().addAll(lj, hl);

        HBox joueur2 = new HBox();
        Label lj2 = new Label("- Joueur2");
        Hyperlink hl2 = new Hyperlink("Profil");
        hl2.setOnAction(new ActionProfilJoueur(this.pa));
        joueur2.setSpacing(150);
        joueur2.getChildren().addAll(lj2, hl2);

        HBox joueur3 = new HBox();
        Label lj3 = new Label("- Joueur3");
        Hyperlink hl3 = new Hyperlink("Profil");
        hl3.setOnAction(new ActionProfilJoueur(this.pa));
        joueur3.setSpacing(150);
        joueur3.getChildren().addAll(lj3, hl3);
        //

        v.getChildren().addAll(joueur, joueur2, joueur3);
        listeJoueur.getChildren().addAll(recherche, v);
        gauche.getChildren().addAll(l, listeJoueur);
        v.setPadding(new Insets(5,0,0,10));
        v.setSpacing(5);
        gauche.setPadding(new Insets(0,0,15,25));
        this.setLeft(gauche);
    }
}
