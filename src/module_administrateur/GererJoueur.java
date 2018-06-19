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
    private ObservableList<Joueur> listeJoueur;
    private ObservableList<Joueur> listeJoueurAactiver;
    private TextField recherche;

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
        this.activer.setStyle("-fx-background-color: #009e0f;-fx-border-color: black");
        this.activer.setTextFill(Color.web("white"));
        this.activer.setPrefWidth(500);
        this.activer.setPrefHeight(50);
        this.activer.setOnAction(new ActionActiverJoueur(this, this.pa));
        return this.activer;
    }

    /** Création de la barre de recherche des joueurs avec le bouton rechercher */
    public HBox creerBarreRecherche() {
        HBox h = new HBox();
        this.recherche = new TextField("");
        this.recherche.setPromptText("Rechercher un joueur");
        Button rechercher = new Button("Rechercher");
        recherche.setPrefWidth(190);
        h.getChildren().addAll(this.recherche, rechercher);
        return h;
    }

    /** Création du tableau contenant la liste de tous les joueurs à activer */
    public TableView<Joueur> creerTableListeJoueurAactiver() {
        TableView<Joueur> table = new TableView<>();
        TableColumn<Joueur, String> pseudo = new TableColumn<>("Pseudo");
        TableColumn<Joueur, Integer> id = new TableColumn<>("ID");
        TableColumn<Joueur, Hyperlink> profil = new TableColumn<Joueur, Hyperlink>("Profil");
        TableColumn<Joueur, CheckBox> activer = new TableColumn<>("Activer");
        pseudo.setResizable(false);
        id.setResizable(false);
        profil.setResizable(false);
        activer.setResizable(false);
        pseudo.setPrefWidth(100);
        id.setPrefWidth(50);
        profil.setPrefWidth(75);
        activer.setPrefWidth(65);
        pseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        profil.setCellValueFactory(new PropertyValueFactory<>("profil"));
        activer.setCellValueFactory(new PropertyValueFactory<>("activer"));
        activer.setStyle( "-fx-alignment: CENTER;");
        profil.setStyle( "-fx-alignment: CENTER;");
        id.setStyle( "-fx-alignment: CENTER;");
        ObservableList<Joueur> liste = getListeJoueursTableViewAactiver();
        table.setItems(liste);
        table.getColumns().add(pseudo);
        table.getColumns().add(id);
        table.getColumns().add(profil);
        table.getColumns().add(activer);
        return table;
    }

    /** Création de la liste contenant les joueurs à activer */
    public ObservableList<Joueur> getListeJoueursTableViewAactiver() {
      this.listeJoueurAactiver = FXCollections.observableArrayList();
      try {
        HashMap<String, List<Object>> dico = GestionBD.selectPreparedStatement("select * from UTILISATEUR where activeUt IS NOT TRUE;");
        if (dico.size() == 0) {
            return this.listeJoueurAactiver;
        }
        else {
            for (int i = 0; i < dico.get("idUt").size(); i++) {
                Joueur j = new Joueur((String) dico.get("pseudoUt").get(i), Utilisateur.getIdByPseudo((String) dico.get("pseudoUt").get(i)));
                this.listeJoueurAactiver.add(j);
                j.getProfil().setOnAction(new ActionProfilJoueur(this.pa, this, j));
                j.getActiver().setOnAction(new ActionCheckActiver(this, this.pa.getAdmin(), j));
            }
        }
      }
      catch(SQLException e) {
      return this.listeJoueurAactiver;
    }

    /** Création du centre de la page => liste de tous les joueurs à activer */
    public void centre() {
        VBox centre = new VBox();
        Label l = new Label("Liste des joueurs désactivé");
        l.setFont(Font.font (15));
        HBox bouton = new HBox();
        bouton.getChildren().addAll(creerBoutonActiver());
        bouton.setSpacing(10);
        centre.getChildren().addAll(l, bouton, creerTableListeJoueurAactiver());
        centre.setSpacing(10);
        centre.setPadding(new Insets(0,25,15,25));
        this.setCenter(centre);
    }

    /** Création de la liste de tous les joueurs */
    public ObservableList<Joueur> getListeJoueursTableView() {
        this.listeJoueur = FXCollections.observableArrayList();
        try {
          HashMap<String, List<Object>> dico = GestionBD.selectPreparedStatement("select * from UTILISATEUR where activeUt IS TRUE;");
          if (dico.size() == 0) {
              return this.listeJoueur;
          }
          else {
              for (int i = 0; i < dico.get("idUt").size(); i++) {
                  Joueur j = new Joueur((String) dico.get("pseudoUt").get(i), Utilisateur.getIdByPseudo((String) dico.get("pseudoUt").get(i)));
                  j.getProfil().setOnAction(new ActionProfilJoueur(this.pa, this, j));
                  this.listeJoueur.add(j);
              }
          }
        }
        catch(SQLException e) {
        return this.listeJoueur;
    }

    /** Création du tableau contenant la liste de tous les joueurs */
    public TableView<Joueur> creerTableListeJoueur() {
        TableView<Joueur> table = new TableView<Joueur>();
        TableColumn<Joueur, String> pseudo = new TableColumn<Joueur, String>("Pseudo");
        TableColumn<Joueur, Integer> id = new TableColumn<Joueur, Integer>("ID");
        TableColumn<Joueur, Hyperlink> profil = new TableColumn<Joueur, Hyperlink>("Profil");
        pseudo.setResizable(false);
        id.setResizable(false);
        profil.setResizable(false);
        pseudo.setPrefWidth(100);
        id.setPrefWidth(50);
        profil.setPrefWidth(75);
        pseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        profil.setCellValueFactory(new PropertyValueFactory<>("profil"));
        profil.setStyle( "-fx-alignment: CENTER;");
        id.setStyle( "-fx-alignment: CENTER;");
        ObservableList<Joueur> list = getListeJoueursTableView();
        table.setItems(list);
        table.getColumns().add(pseudo);
        table.getColumns().add(id);
        table.getColumns().add(profil);
        return table;
    }

    /** Raffraichit la page de gérer joueur */
    public void majAffichage() {
        this.gauche();
        this.centre();
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
