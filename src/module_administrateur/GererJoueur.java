package module_administrateur;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;
import APIMySQL.*;
import java.util.HashMap;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;
import java.util.Comparator;

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

    /** Remplace la liste de joueurs actuelle par la nouvelle en paramètre */
    public void setListeJoueurTB(ObservableList<Joueur> liste) {
        this.listeJoueur = liste;
    }

    /** Retourne la barre de recherche de joueur */
    public TextField getRecherche() {
        return this.recherche;
    }


    /** Rafraichit la liste de tous les joueurs */
    public void majTableView() {
      System.out.println(this.listeJoueur);
        this.setCenter(creerCentre());
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
        TableColumn<Joueur, Label> estActif = new TableColumn<Joueur, Label>("Statut");
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
                Label l = new Label("Activé");
                l.setTextFill(Color.web("#009e0f"));
                return new SimpleObjectProperty<>(l);
            }
            else {
                Label l = new Label("Désactivé");
                l.setTextFill(Color.web("#cf2a27"));
                return new SimpleObjectProperty<>(l);
            }
        });
        activer.setCellValueFactory(new PropertyValueFactory<>("activer"));

        estActif.setComparator(new Comparator<Label>() {
            @Override
            public int compare(Label l1, Label l2) {
                if (l1.getText().equals("Activé") && l2.getText().equals("Désactivé"))
                    return -1;
                return 1;
            }
        });

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
        //this.recherche.setOnKeyReleased(new ActionRechercherJoueur(this));
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
        entete.setPadding(new Insets(0,0,0,3));
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
