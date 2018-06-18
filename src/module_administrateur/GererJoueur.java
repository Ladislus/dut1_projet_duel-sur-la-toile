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
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.cell.*;
import javafx.geometry.Pos;
import javafx.beans.property.SimpleStringProperty;
import APIMySQL.*;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
public class GererJoueur extends BorderPane {

    private PageAccueil pa;
    private Button activer;
    private Button supprimer;

    /** Constructeur de la page pour gérer les joueurs */
    public GererJoueur(PageAccueil pa) {
      super();
      this.pa = pa;
      this.haut();
      this.gauche();
      this.centre();
    }

    /** Retourne le bouton pour activer les joueurs cochés */
    public Button getButtonActiver() {
        return this.activer;
    }

    /** Retourne le bouton pour supprimer les joueurs cochés */
    public Button getButtonSupprimer() {
        return this.supprimer;
    }

    /** Création de l'entête de la page */
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

    /** Création du bouton pour activer les joueurs cochés */
    public Button creerBoutonActiver() {
        this.activer = new Button("Activer");
        this.activer.setDisable(true);
        ActionActiverJoueur acj = new ActionActiverJoueur(this);
        this.activer.setStyle("-fx-background-color: #009e0f;-fx-border-color: black");
        this.activer.setTextFill(Color.web("white"));
        this.activer.setPrefWidth(200);
        this.activer.setPrefHeight(50);
        this.activer.setOnAction(acj);
        return this.activer;
    }

    /** Création du bouton pour supprimer les joueurs cochés */
    public Button creerBoutonSupprimer() {
        this.supprimer = new Button("Supprimer");
        this.supprimer.setDisable(true);
        ActionSupprimerJoueur asj = new ActionSupprimerJoueur(this);
        this.supprimer.setStyle("-fx-background-color: #cf2a27;-fx-border-color: black");
        this.supprimer.setTextFill(Color.web("white"));
        this.supprimer.setPrefWidth(200);
        this.supprimer.setPrefHeight(50);
        this.supprimer.setOnAction(asj);
        return this.supprimer;
    }

    /** Création de la barre de recherche des joueurs avec le bouton rechercher */
    public HBox creerBarreRecherche() {
        HBox h = new HBox();
        TextField recherche = new TextField("");
        recherche.setPromptText("Rechercher un joueur");
        Button rechercher = new Button("Rechercher");
        recherche.setPrefWidth(190);
        h.getChildren().addAll(recherche, rechercher);
        return h;
    }

    /** Création du tableau contenant la liste de tous les joueurs à activer */
    public TableView<Joueur> creerTableListeJoueurAactiver() {
        TableView<Joueur> table = new TableView<>();
        TableColumn<Joueur, String> pseudo = new TableColumn<>("Pseudo");
        TableColumn<Joueur, Integer> id = new TableColumn<>("ID");
        TableColumn<Joueur, Hyperlink> profil = new TableColumn<>("Profil");
        TableColumn<Joueur, CheckBox> activer = new TableColumn<>("Activer");
        pseudo.setResizable(false);
        id.setResizable(false);
        profil.setResizable(false);
        activer.setResizable(false);
        pseudo.setMaxWidth( 1f * Integer.MAX_VALUE * 50 );
        id.setMaxWidth(43);
        profil.setMaxWidth(1f * Integer.MAX_VALUE * 20 );
        activer.setMaxWidth( 1f * Integer.MAX_VALUE * 50 );
        pseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        profil.setCellValueFactory(new PropertyValueFactory<>("profil"));
        activer.setCellValueFactory(new PropertyValueFactory<>("activer"));
        ObservableList<Joueur> liste = getListeJoueursTableViewAactiver();
        table.setItems(liste);
        table.getColumns().add(pseudo);
        table.getColumns().add(id);
        table.getColumns().add(profil);
        table.getColumns().add(activer);
        table.setPrefWidth(100);
        return table;
    }

    /** Création de la liste contenant les joueurs à activer */
    public ObservableList<Joueur> getListeJoueursTableViewAactiver() {
        // EXEMPLE => METTRE REQUETTE ICI
        Joueur j1 = new Joueur("Leo", 2, true);
        Joueur j2 = new Joueur("ab", 5, true);
        Joueur j3 = new Joueur("zf", 1, false);
        Joueur j4 = new Joueur("b", 4, false);
        Joueur j5 = new Joueur("za", 3, true);
        ObservableList<Joueur> liste = FXCollections.observableArrayList(j1, j2, j3, j4, j5);
        for (Joueur j : liste) {
            j.getActiver().setOnAction(new ActionCheckActiver(this, this.pa.getAdmin(), j));
        }
        return liste;
    }

    /** Création du centre de la page => liste de tous les joueurs à activer */
    public void centre() {
        VBox centre = new VBox();
        Label l = new Label("Nombre de joueurs à activer : ");
        HBox bouton = new HBox();
        bouton.getChildren().addAll(creerBoutonActiver(), creerBoutonSupprimer());
        bouton.setSpacing(10);
        centre.getChildren().addAll(l, bouton, creerBarreRecherche(), creerTableListeJoueurAactiver());
        centre.setSpacing(10);
        centre.setPadding(new Insets(0,25,15,25));
        this.setCenter(centre);
    }

    /** Création de la liste de tous les joueurs */
    public ObservableList<Joueur> getListeJoueursTableView() {

        Joueur j1 = new Joueur("Leo", 2, true);
        Joueur j2 = new Joueur("ab", 5, true);
        Joueur j3 = new Joueur("zf", 1, false);
        Joueur j4 = new Joueur("b", 4, false);
        Joueur j5 = new Joueur("za", 3, true);
        ObservableList<Joueur> liste = FXCollections.observableArrayList(j1, j2, j3, j4, j5);
        for (Joueur j : liste) {
            j.getProfil().setOnAction(new ActionProfilJoueur(this.pa, this, j));
        }
        return liste;
    }

    /** Création du tableau contenant la liste de tous les joueurs */
    public TableView<Joueur> creerTableListeJoueur() {
        TableView<Joueur> table = new TableView<Joueur>();
        TableColumn<Joueur, String> pseudo = new TableColumn<Joueur, String>("Pseudo");
        TableColumn<Joueur, Integer> id = new TableColumn<Joueur, Integer>("ID");
        TableColumn<Joueur, String> connecte = new TableColumn<Joueur, String>("Statut");
        TableColumn<Joueur, Hyperlink> profil = new TableColumn<Joueur, Hyperlink>("Profil");
        pseudo.setResizable(false);
        id.setResizable(false);
        connecte.setResizable(false);
        profil.setResizable(false);
        pseudo.setMaxWidth(1f * Integer.MAX_VALUE * 75 );
        id.setMaxWidth(41);
        connecte.setMaxWidth(1f * Integer.MAX_VALUE * 20 );
        profil.setMaxWidth(1f * Integer.MAX_VALUE * 20 );
        pseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        connecte.setCellValueFactory(cellData -> {
          if (cellData.getValue().getConnecte()) {
            return new SimpleStringProperty("connecte");
          }
          else {
            return new SimpleStringProperty("deconnecte");
          }
        });
        profil.setCellValueFactory(new PropertyValueFactory<>("profil"));
        ObservableList<Joueur> list = getListeJoueursTableView();
        table.setItems(list);
        table.getColumns().add(pseudo);
        table.getColumns().add(id);
        table.getColumns().add(connecte);
        table.getColumns().add(profil);
        table.setPrefWidth(100);
        return table;
    }

    /** Création de la gauche de la page => liste de tous les joueurs */
    public void gauche() {
        VBox gauche = new VBox();
        Label l = new Label("Liste des joueurs actifs");
        l.setPadding(new Insets(0,0,9,0));
        gauche.getChildren().addAll(l, creerBarreRecherche(), creerTableListeJoueur());
        gauche.setPadding(new Insets(0,0,15,25));
        this.setLeft(gauche);
    }
}
