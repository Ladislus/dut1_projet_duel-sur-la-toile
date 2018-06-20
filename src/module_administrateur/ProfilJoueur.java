package module_administrateur;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.collections.*;
import java.io.File;
import javafx.scene.chart.*;
import APIMySQL.*;

/** Vue de la page pour voir et modifier le profil d'un joueur */
public class ProfilJoueur extends BorderPane {

    /** Attributs de ProfilJoueur */
    private GererJoueur gJoueur;
    private PageAccueil pa;
    private Joueur joueur;

    private RadioButton rbactiver;
    private RadioButton rbpasactiver;
    private RadioButton sexeH;
    private RadioButton sexeF;
    private ComboBox<String> cbrole;

    private ToggleGroup groupe;
    private TextField tfilechooser;

    private TextField tpseudo;
    private TextField tprenom;
    private TextField tnom;
    private TextField temail;

    /** Constructeur de cette vue */
    public ProfilJoueur(PageAccueil pa, GererJoueur gJoueur, Joueur joueur) {
        super();
        this.gJoueur = gJoueur;
        this.joueur = joueur;
        this.pa = pa;
        this.groupe = new ToggleGroup();
        this.tfilechooser = new TextField();
        this.haut();
        this.gauche();
        this.centre();
    }

    public RadioButton getRbactiver() {
        return this.rbactiver;
    }

    public ComboBox<String> getCbrole() {
        return this.cbrole;
    }

    public RadioButton getRbpasactiver() {
        return this.rbpasactiver;
    }

    public String getTFpseudo() {
        return this.tpseudo.getText();
    }

    public RadioButton getSexeH() {
        return this.sexeH;
    }

    public RadioButton getSexeF() {
        return this.sexeF;
    }

    public PageAccueil getPa() {
        return this.pa;
    }

    public String getTFprenom() {
        return this.tprenom.getText();
    }

    public String getTFnom() {
        return this.tnom.getText();
    }

    public String getTFemail() {
        return this.temail.getText();
    }

    /** Création du haut de la page avec le titre et le bouton retour */
    public void haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Profil de "+this.joueur.getPseudo());
        Button bRetour = new Button("< Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        bRetour.setOnAction(new ActionRetour(this.pa, this.gJoueur));
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));
        this.setTop(haut);
    }

    public Label creerLabelId() {
        Label l = new Label("ID :");
        return l;
    }

    public TextField creerTFid() {
        TextField tid = new TextField(this.joueur.getId()+"");
        tid.setDisable(true);
        return tid;
    }

    public Label creerLabelPseudo() {
        Label pseudo = new Label("Pseudo :");
        return pseudo;
    }

    public TextField creerTFpseudo() {
        this.tpseudo = new TextField(this.joueur.getPseudo());
        return this.tpseudo;
    }

    public Label creerLabelPrenom() {
        Label prenom = new Label("Prénom :");
        return prenom;
    }

    public TextField creerTFprenom() {
        this.tprenom = new TextField(this.joueur.getPrenom());
        return this.tprenom;
    }

    public Label creerLabelNom() {
        Label nom = new Label("Nom :");
        return nom;
    }

    public TextField creerTFnom() {
        this.tnom = new TextField(this.joueur.getNom());
        return this.tnom;
    }

    public Label creerLabelEmail() {
        Label email = new Label("Email :");
        return email;
    }

    public TextField creerTFemail() {
        this.temail = new TextField(this.joueur.getEmail());
        return this.temail;
    }

    public Label creerLabelSexe() {
        Label labelSexe = new Label("Sexe :");
        return labelSexe;
    }

    public HBox creerTGsexe() {
        this.sexeH = new RadioButton("Homme");
        this.sexeF = new RadioButton("Femme");
        ToggleGroup grp = new ToggleGroup();
        this.sexeH.setToggleGroup(grp);
        this.sexeF.setToggleGroup(grp);
        HBox h = new HBox();
        h.getChildren().addAll(this.sexeH, this.sexeF);
        h.setSpacing(10);
        if (this.joueur.getSexe().equals("M")) {
            this.sexeH.setSelected(true);
        }
        else {
            this.sexeF.setSelected(true);
        }
        return h;
    }

    public Label creerLabelRole() {
        Label role = new Label("Rôle : ");
        return role;
    }

    public ComboBox creerCBrole() {
        ObservableList<String> optionsRoles = FXCollections.observableArrayList("Utilisateur", "Administrateur");
        this.cbrole = new ComboBox<String>(optionsRoles);
        cbrole.setPrefWidth(175);
        if (this.joueur.getRole().equals("USER")) {
            this.cbrole.setValue("Utilisateur");
        }
        else {
            this.cbrole.setValue("Administrateur");
        }
        return this.cbrole;
    }

    public GridPane creerVBoxInfos(){
        GridPane gp = new GridPane();
        gp.add(creerLabelId(), 1, 1);
        gp.add(creerTFid(), 2, 1);
        gp.add(creerLabelPseudo(), 1, 2);
        gp.add(creerTFpseudo(), 2, 2);
        gp.add(creerLabelPrenom(), 1, 3);
        gp.add(creerTFprenom(), 2, 3);
        gp.add(creerLabelNom(), 1, 4);
        gp.add(creerTFnom(), 2, 4);
        gp.add(creerLabelEmail(), 1, 5);
        gp.add(creerTFemail(), 2, 5);
        gp.add(creerLabelSexe(), 1, 6);
        gp.add(creerTGsexe(), 2, 6);
        gp.add(creerLabelRole(), 1, 7);
        gp.add(creerCBrole(), 2, 7);
        gp.setHgap(25);
        gp.setVgap(7);
        return gp;
    }

    public HBox creerRadioBoutonActiverJoueur(){
        this.rbactiver = new RadioButton("Activé");
        this.rbpasactiver = new RadioButton("Désactivé");
        this.rbactiver.setToggleGroup(this.groupe);
        this.rbpasactiver.setToggleGroup(this.groupe);
        HBox hbactiverjoueur = new HBox();
        hbactiverjoueur.getChildren().addAll(new Label("État du compte :"), this.rbactiver, this.rbpasactiver);
        if (Utilisateur.isActivated(this.joueur.getPseudo())) {
            this.rbactiver.setSelected(true);
        }
        else {
            this.rbpasactiver.setSelected(true);
        }
        return hbactiverjoueur;
    }

    public Button creerBoutonSauvegarderModifs(){
        Button bsave = new Button("Sauvegarder");
        bsave.setOnAction(new ActionProfilJoueurSauvegarde(this, this.joueur));
        return bsave;
    }


    public HBox creerHBoxSauvegarderModifs(){
        HBox hbsave = new HBox();
        hbsave.getChildren().add(creerBoutonSauvegarderModifs());
        hbsave.setAlignment(Pos.CENTER);
        return hbsave;
    }

    public Label creerLabelImageProfil(){
        Label limageprofil = new Label("Image de profil :");
        return limageprofil;
    }

    public TextField creerTextFieldFileChooser(){
        this.tfilechooser.setPromptText("Choisissez une image");
        return this.tfilechooser;
    }

    public TextField getTextFieldFileChooser(){
        return this.tfilechooser;
    }

    public Button creerBoutonFileChooser(){
        Button bplus = new Button("+");
        ActionFileChooser afc = new ActionFileChooser(this);
        bplus.setOnAction(afc);
        return bplus;
    }

    public HBox creerHBoxFileChooser(){
        HBox hbfilechooser = new HBox();
        hbfilechooser.getChildren().addAll(creerTextFieldFileChooser(), creerBoutonFileChooser());
        return hbfilechooser;
    }


    public void gauche() {
        VBox vbgauche = new VBox(10);
        vbgauche.getChildren().addAll(creerVBoxInfos(), creerLabelImageProfil(),
                  creerHBoxFileChooser(), creerRadioBoutonActiverJoueur(), creerHBoxSauvegarderModifs());
        vbgauche.setPadding(new Insets(0,0,0,25));
        this.setLeft(vbgauche);
    }


    public Label creerLabelStats(){
        Label stats = new Label("Statistiques");
        stats.setStyle("-fx-font-weight: bold");
        return stats;
    }


    public Label creerLabelJeuPlusJoue(){
        Label jeuplusjoue = new Label("Jeu le plus joué : ");
        return jeuplusjoue;
    }


    public Label creerLabelTempsPlateforme(){
        Label tempsplateforme = new Label("Temps passé sur la plateforme : ");
        return tempsplateforme;
    }


    public Label creerLabelNbPartiesJouees(){
        Label nbpartiesjouees = new Label("Nombre de parties jouées : ");
        return nbpartiesjouees;
    }

    /** Retourne le label contenant le nombre d'ami du joueur */
    public Label creerLabelNbAmis(){
        Label nbamis = new Label("Nombre d'amis : ");
        return nbamis;
    }


    public VBox creerVBoxStats(){
        VBox vbstats = new VBox(15);
        vbstats.getChildren().addAll(creerLabelStats(), creerLabelJeuPlusJoue(),
                          creerLabelTempsPlateforme(), creerLabelNbPartiesJouees(), creerLabelNbAmis());
        vbstats.setPadding(new Insets(5,10,5,10));
        vbstats.setStyle("-fx-border-color: black;");
        vbstats.setPrefHeight(200);
        return vbstats;
    }


    public PieChart creerPieChart(){
        ObservableList<PieChart.Data> donneesdiagramme = FXCollections.observableArrayList(
            new PieChart.Data("Victoires", 60),
            new PieChart.Data("Défaites", 40));

        PieChart diagramme = new PieChart(donneesdiagramme);
        diagramme.setTitle("Ratio Victoires/Défaites");
        diagramme.setStartAngle(90);
        return diagramme;
    }


    public void centre() {
        VBox vbcentre = new VBox(15);
        vbcentre.getChildren().addAll(creerVBoxStats(), creerPieChart());
        vbcentre.setPadding(new Insets(20,25,20,25));
        this.setCenter(vbcentre);
    }

}
