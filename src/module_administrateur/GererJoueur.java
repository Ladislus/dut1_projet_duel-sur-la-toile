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
import javafx.geometry.Orientation;
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
        bRetour.setOnAction(new ActionRetour(this.pa));
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));
        this.setTop(haut);
    }

    public void centre() {
        VBox centre = new VBox();

        Label l = new Label("Nombre de joueurs à activer : ");
        Button activer = new Button("Activer");
        Button supprimer = new Button("Supprimer");
        activer.setStyle("-fx-background-color: #009e0f;-fx-border-color: black");
        supprimer.setStyle("-fx-background-color: #cf2a27;-fx-border-color: black");
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

        HBox rechercheJ = new HBox();
        TextField recherche = new TextField("");
        recherche.setPrefWidth(214);
        recherche.setPromptText("Rechercher un joueur");
        Button lancerRecherche = new Button("Rechercher");
        rechercheJ.getChildren().addAll(recherche, lancerRecherche);

        VBox v = new VBox();

        //POUR CHAQUE JOUEUR
        BorderPane joueur = new BorderPane();
        Label lj = new Label("- Joueur1");
        CheckBox cb = new CheckBox();
        joueur.setLeft(lj);
        joueur.setRight(cb);
        BorderPane joueur2 = new BorderPane();
        Label lj2 = new Label("- Joueur2");
        CheckBox cb2 = new CheckBox();
        joueur2.setLeft(lj2);
        joueur2.setRight(cb2);

        v.getChildren().addAll(joueur, joueur2);
        listeJoueur.getChildren().addAll(rechercheJ, v);
        centre.getChildren().addAll(l, bouton, listeJoueur);
        centre.setPadding(new Insets(0,0,15,25));

        listeJoueur.setStyle("-fx-border-color: black;");
        listeJoueur.setPrefHeight(300);
        listeJoueur.setSpacing(5);
        v.setSpacing(15);
        v.setPadding(new Insets(5,0,0,10));
        centre.setSpacing(10);
        centre.setPadding(new Insets(0,25,15,25));
        this.setCenter(centre);
    }

    public void gauche() {
        VBox gauche = new VBox();
        Label l = new Label("Liste des joueurs");
        l.setPadding(new Insets(0,0,12,0));
        TextField recherche = new TextField("");
        recherche.setPromptText("Rechercher un joueur");
        VBox listeJoueur = new VBox();
        listeJoueur.setPrefHeight(450);
        listeJoueur.setStyle("-fx-border-color: black;");

        HBox rechercheJ = new HBox();
        Button lancerRecherche = new Button("Rechercher");
        rechercheJ.getChildren().addAll(recherche, lancerRecherche);

        VBox v = new VBox();

       //POUR CHAQUE JOUEUR
        HBox joueur = new HBox();
        Label lj = new Label("- Joueur1");
        Hyperlink hl = new Hyperlink("Profil");
        hl.setOnAction(new ActionProfilJoueur(this.pa, this));
        joueur.setSpacing(150);
        joueur.getChildren().addAll(lj, hl);

        HBox joueur2 = new HBox();
        Label lj2 = new Label("- Joueur2");
        Hyperlink hl2 = new Hyperlink("Profil");
        hl2.setOnAction(new ActionProfilJoueur(this.pa, this));
        joueur2.setSpacing(150);
        joueur2.getChildren().addAll(lj2, hl2);

        HBox joueur3 = new HBox();
        Label lj3 = new Label("- Joueur3");
        Hyperlink hl3 = new Hyperlink("Profil");
        hl3.setOnAction(new ActionProfilJoueur(this.pa, this));
        joueur3.setSpacing(150);
        joueur3.getChildren().addAll(lj3, hl3);
        //


        //if ( < ) {
            v.getChildren().addAll(joueur, joueur2, joueur3);
            listeJoueur.getChildren().addAll(rechercheJ, v);
            gauche.getChildren().addAll(l, listeJoueur);
            v.setPadding(new Insets(5,0,0,10));
            v.setSpacing(5);
            gauche.setPadding(new Insets(0,0,15,25));
            this.setLeft(gauche);
      //    }
        //  else {
  //          ScrollBar sb = new ScrollBar();
  //          sb.setOrientation(Orientation.VERTICAL);
  //          HBox h = new HBox();
  //          v.getChildren().addAll(joueur, joueur2, joueur3);
  //          h.getChildren().addAll(v, sb);
  //          listeJoueur.getChildren().addAll(rechercheJ, h);
  //          gauche.getChildren().addAll(l, listeJoueur);
  //          v.setPadding(new Insets(5,0,0,10));
  //          v.setSpacing(5);
  //          gauche.setPadding(new Insets(0,0,15,25));
  //          this.setLeft(gauche);
        //  }
    }
}
