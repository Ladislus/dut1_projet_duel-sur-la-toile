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
import java.util.HashMap;
import java.util.List;

/** Vue de la page pour gérer les joueurs */
public class GererJoueur extends BorderPane {

    private PageAccueil pa;
    private TextField recherche;
    private Button activer;
    private Button desactiver;
    private ObservableList<Joueur> listeJoueur;

    /** Constructeur de la page pour gérer les joueurs */
    public GererJoueur(PageAccueil pa) {
      super();
      this.pa = pa;
      this.creerGererJoueur();
    }

    /** Retourne le bouton activer les joueurs cochés */
    public Button getButtonActiver() {
        return this.activer;
    }

    /** Retourne le bouton désactiver les joueurs cochés */
    public Button getButtonDesactiver() {
        return this.desactiver;
    }

    /** Création du bouton pour activer les joueurs cochés */
    public Button creerBoutonActiver() {
        this.activer = new Button("Activer");
        this.activer.setDisable(true);
        this.activer.setStyle("-fx-background-color: #009e0f;-fx-border-color: black");
        this.activer.setTextFill(Color.web("white"));
        this.activer.setPrefWidth(200);
        this.activer.setPrefHeight(50);
        this.activer.setOnAction(new ActionActiverJoueur(this, this.pa));
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
        TableColumn<Joueur, CheckBox> activer = new TableColumn<>("Activer");
        pseudo.setResizable(false);
        id.setResizable(false);
        activer.setResizable(false);
        pseudo.setMaxWidth( 1f * Integer.MAX_VALUE * 50 );
        id.setMaxWidth(43);
        activer.setMaxWidth( 1f * Integer.MAX_VALUE * 50 );
        pseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        activer.setCellValueFactory(new PropertyValueFactory<>("activer"));
        ObservableList<Joueur> liste = getListeJoueursTableViewAactiver();
        table.setItems(liste);
        table.getColumns().add(pseudo);
        table.getColumns().add(id);
        table.getColumns().add(activer);
        table.setPrefWidth(100);
        return table;
    }

    /** Création de la liste contenant les joueurs à activer */
    public ObservableList<Joueur> getListeJoueursTableViewAactiver() {
      this.listeJoueurAactiver = FXCollections.observableArrayList();
      HashMap<String, List<Object>> dico = GestionBD.selectPreparedStatement("select * from UTILISATEUR where activeUt IS NOT TRUE;");
      if (dico.size() == 0) {
          return this.listeJoueurAactiver;
      }
      else {
          for (int i = 0; i < dico.get("idUt").size(); i++) {
              Joueur j = new Joueur((String) dico.get("pseudoUt").get(i), Utilisateur.getIdByPseudo((String) dico.get("pseudoUt").get(i)), (boolean) dico.get("activeUt").get(i));
              this.listeJoueurAactiver.add(j);
              j.getProfil().setOnAction(new ActionProfilJoueur(this.pa, this, j));
              j.getActiver().setOnAction(new ActionCheckActiver(this, this.pa.getAdmin(), j));
          }
      }
      return this.listeJoueurAactiver;
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
        this.listeJoueur = FXCollections.observableArrayList();
        HashMap<String, List<Object>> dico = GestionBD.selectPreparedStatement("select * from UTILISATEUR where activeUt IS TRUE;");
        if (dico.size() == 0) {
            return this.listeJoueur;
        }
        else {
            for (int i = 0; i < dico.get("idUt").size(); i++) {
                int id = Utilisateur.getIdByPseudo((String) dico.get("pseudoUt").get(i));
                String pseudo = (String) dico.get("pseudoUt").get(i);
                String prenom = Utilisateur.getUserInfo("prenom", "pseudoUt", pseudo);
                String nom = Utilisateur.getUserInfo("nom", "pseudoUt", pseudo);
                String email = Utilisateur.getEmailByPseudo(pseudo);
                String sexe = Utilisateur.getUserInfo("sexe", "pseudoUt", pseudo);
                String role = Utilisateur.getUserInfo("nomRole", "pseudoUt", pseudo);
                String stringEstActif = Utilisateur.getUserInfo("activeUt", "pseudoUt", pseudo);
                boolean estActif = Boolean.valueOf(stringEstActif);
                Joueur j = new Joueur(id, pseudo, prenom, nom, email, sexe, role, estActif);
                j.getProfil().setOnAction(new ActionProfilJoueur(this.pa, this, j));
                j.getActiver().setOnAction(new ActionCheckActiver(this, this.pa.getAdmin(), j));
                this.listeJoueur.add(j);
            }
        }
        return this.listeJoueur;
    }

    /** Création du tableau contenant la liste de tous les joueurs */
    public TableView<Joueur> creerTableListeJoueur() {
        TableView<Joueur> table = new TableView<Joueur>();

        TableColumn<Joueur, String> pseudo = new TableColumn<Joueur, String>("Pseudo");
        TableColumn<Joueur, Integer> id = new TableColumn<Joueur, Integer>("ID");
        TableColumn<Joueur, String> role = new TableColumn<Joueur, String>("Rôle");
        TableColumn<Joueur, Hyperlink> profil = new TableColumn<Joueur, Hyperlink>("Profil");
        TableColumn<Joueur, String> estActif = new TableColumn<Joueur, String>("Statut");
        TableColumn<Joueur, CheckBox> activer = new TableColumn<Joueur, CheckBox>("✓");

        pseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        role.setCellValueFactory(celldata -> {
            if (celldata.getValue().getRole().equals("USER")) {
                return new SimpleStringProperty("Utilisateur");
            }
            else {
                return new SimpleStringProperty("Administrateur");
            }
        });
        profil.setCellValueFactory(new PropertyValueFactory<>("profil"));
        estActif.setCellValueFactory(celldata -> {
            if (celldata.getValue().getEstActif()) {
                return new SimpleStringProperty("Activé");
            }
            else {
                return new SimpleStringProperty("Désactivé");
            }
        });
        activer.setCellValueFactory(new PropertyValueFactory<>("activer"));

        pseudo.setResizable(false);
        id.setResizable(false);
        role.setResizable(false);
        profil.setResizable(false);
        estActif.setResizable(false);
        activer.setResizable(false);

        pseudo.setPrefWidth(160);
        id.setPrefWidth(70);
        role.setPrefWidth(125);
        profil.setPrefWidth(80);
        estActif.setPrefWidth(110);
        activer.setPrefWidth(53);

        pseudo.setStyle( "-fx-alignment: CENTER;");
        id.setStyle( "-fx-alignment: CENTER;");
        role.setStyle( "-fx-alignment: CENTER;");
        profil.setStyle( "-fx-alignment: CENTER;");
        estActif.setStyle( "-fx-alignment: CENTER;");
        activer.setStyle( "-fx-alignment: CENTER;");

        ObservableList<Joueur> liste = getListeJoueursTableView();
        table.setItems(liste);

        table.getColumns().add(pseudo);
        table.getColumns().add(id);
        table.getColumns().add(role);
        table.getColumns().add(profil);
        table.getColumns().add(estActif);
        table.getColumns().add(activer);
        table.setStyle("-fx-selection-bar: #eeeded");

        return table;
    }

    /** Création du bouton pour désactiver les joueurs cochés */
    public Button creerBoutonDesactiver() {
        this.desactiver = new Button("Désactiver");
        this.desactiver.setDisable(true);
        this.desactiver.setStyle("-fx-background-color: #cf2a27;-fx-border-color: black");
        this.desactiver.setTextFill(Color.web("white"));
        this.desactiver.setPrefWidth(150);
        this.desactiver.setPrefHeight(35);
        this.desactiver.setOnAction(new ActionDesactiverJoueur(this, this.pa));
        return this.desactiver;
    }

    /** Création du bouton pour activer les joueurs cochés */
    public Button creerBoutonActiver() {
        this.activer = new Button("Activer");
        this.activer.setDisable(true);
        this.activer.setStyle("-fx-background-color: #009e0f;-fx-border-color: black");
        this.activer.setTextFill(Color.web("white"));
        this.activer.setPrefWidth(150);
        this.activer.setPrefHeight(35);
        this.activer.setOnAction(new ActionActiverJoueur(this, this.pa));
        return this.activer;
    }

    /** Création de la barre de recherche de joueurs */
    public TextField creerBarreRecherche() {
        this.recherche = new TextField();
        this.recherche.setPromptText("Rechercher un joueur");
        this.recherche.setPrefWidth(280);
        this.recherche.setPrefHeight(35);
        return this.recherche;
    }

    /** Création de la HBox contenant la barre de recherche et les boutons activer/desactiver */
    public HBox creerBouton() {
        HBox hboxEntete = new HBox();
        hboxEntete.getChildren().addAll(creerBarreRecherche(), creerBoutonActiver(), creerBoutonDesactiver());
        hboxEntete.setSpacing(10);
        hboxEntete.setPadding(new Insets(0,0,5,20));
        return hboxEntete;
    }

    /** Création du haut de la page avec le titre et le bouton retour */
    public BorderPane haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Gestion des joueurs");
        Button bRetour = new Button("< Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        bRetour.setOnAction(new ActionRetour(this.pa));
        l.setFont(Font.font("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));
        return haut;
    }

    /** Réunit la barre de recherche, les boutons et le sous-titre */
    public VBox entete() {
        VBox entete = new VBox();
        Label l = new Label("Liste de tous les joueurs");
        l.setPadding(new Insets(0,0,5,20));
        entete.getChildren().addAll(l, creerBouton());
        return entete;
    }

    /** Réunit les éléments graphiques du centre de la page => liste de tous les joueurs */
    public VBox creerCentre() {
        VBox centre = new VBox();
        centre.getChildren().addAll(creerTableListeJoueur());
        centre.setPadding(new Insets(20,25,20,25));
        return centre;
    }

    /** Réunit les éléments graphiques du haut de la page */
    public VBox creerTop() {
        VBox top = new VBox();
        top.getChildren().addAll(haut(), entete());
        return top;
    }

    /** Réunit tous les éléments graphiques et les met dans la page */
    public void creerGererJoueur() {
        this.setTop(creerTop());
        this.setCenter(creerCentre());
    }

    /** Rafraichit la page de gérer joueur */
    public void majAffichage() {
        this.creerGererJoueur();
    }
}
