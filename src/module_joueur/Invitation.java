package module_joueur;

import APIMySQL.GestionBD;
import APIMySQL.Utilisateur;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Invitation extends BorderPane {

    private TextField tfSearch;

    private VBox invitation;
    private VBox vRechercherAmis;

    private Joueur joueur;

    private Dashboard dashboard;

    private ArrayList<Button> listeDamisBoutton;

    /**
     Création de la page d'invitation en ami
     @param joueur : Le joueur courant
     @param dashboard : La page du dashboard à propager
    */
    Invitation(Joueur joueur, Dashboard dashboard) {

        this.joueur = joueur;

        this.dashboard = dashboard;

        this.invitation = new VBox();
        this.vRechercherAmis = new VBox();

        this.listeDamisBoutton = new ArrayList<>();

        this.tfSearch = new TextField();

        this.setLeft(creerGauche());
        this.setRight(creerDroite());

        majAffichageInvitation(); }

    /**
     Création de la partie gauche contenant la barre de
     recherche ainsi que la boite de résultats
     @return : Une VBox
    */
    private VBox creerGauche() {

        VBox candidate = new VBox();
        candidate.getChildren().addAll(creerHeader(), creerRechercheAmis());
        candidate.setPrefWidth(270);

        return candidate; }

    /**
     Création de lar partie haute contenant le titre
     ainsi que la barre de recherche
     @return : Une VBox
    */
    private VBox creerHeader() {

        Label lbTitle = new Label("Rechercher un joueur :");
        lbTitle.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

        tfSearch.setPromptText("Rechercher un joueur ...");
        tfSearch.setOnKeyReleased(new ActionRechercherJoueur(this, this.joueur));

        VBox vRechercherJoueurTf = new VBox();
        vRechercherJoueurTf.setPadding(new Insets(15,9,16,9));
        vRechercherJoueurTf.setAlignment(Pos.TOP_CENTER);
        vRechercherJoueurTf.setSpacing(12);
        vRechercherJoueurTf.getChildren().addAll(lbTitle, tfSearch);

        VBox candidate = new VBox();
        candidate.getChildren().addAll(vRechercherJoueurTf);

        return candidate; }

    /**
     Création de la partie de droite contenant la
     boite de résultat
     @return : Un Scrollpane
    */
    private ScrollPane creerRechercheAmis() {

        vRechercherAmis.setPadding(new Insets(9,15,0,15));
        vRechercherAmis.setSpacing(9);

        ScrollPane scrollPaneRechercherAmis = new ScrollPane();
        scrollPaneRechercherAmis.setPrefHeight(250);
        scrollPaneRechercherAmis.setPadding(new Insets(0,0,0,0));
        scrollPaneRechercherAmis.setContent(this.vRechercherAmis);

        return scrollPaneRechercherAmis; }

    /**
     Création de la partie droite contenant les demandes d'ami
     @return : Une VBox
    */
    private VBox creerDroite() {

        Label lbTitre = new Label("Invitations reçues :");
        lbTitre.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

        Button btRefresh = new Button("Rafraichir");
        btRefresh.setOnAction(actionEvent -> this.majAffichageInvitation());

        HBox hTitre = new HBox();
        hTitre.getChildren().addAll(lbTitre, btRefresh);
        hTitre.setSpacing(4);
        hTitre.setPadding(new Insets(9,0,0,0));

        ScrollPane scrollPaneInvitation = new ScrollPane();
        scrollPaneInvitation.setPrefHeight(300);
        scrollPaneInvitation.setFitToWidth(true);
        scrollPaneInvitation.setContent(invitation);

        VBox candidate = new VBox();
        candidate.getChildren().addAll(hTitre, scrollPaneInvitation);
        candidate.setPrefWidth(315);
        candidate.setSpacing(15);
        candidate.setPadding(new Insets(9,15,0,15));

        return candidate; }

    /**
     Mise à jour de l'affichage des amis trouvé par la recherche
     @param listeJoueur : La liste des joueurs déjà trouvé
    */
    void majAffichageListeJoueur(List<Object> listeJoueur) {

        vRechercherAmis.getChildren().removeAll(listeDamisBoutton);

        listeDamisBoutton = new ArrayList<>();

        try {

            for(Object ami : listeJoueur) {

                if (!ami.toString().equals(joueur.getPseudo())) {

                    Button btAmis = new Button(ami.toString());
                    btAmis.setStyle("-fx-background-color: white;");
                    btAmis.setPrefWidth(240);
                    btAmis.setOnAction(new ActionAjoutAmis(joueur.getPseudo(), btAmis.getText(), this));

                    listeDamisBoutton.add(btAmis); }}

            vRechercherAmis.getChildren().addAll(listeDamisBoutton); }

        catch (NullPointerException e) { vRechercherAmis.getChildren().clear(); }}

    /**
     Mise à jouer de l'affiche des invitation reçues
      */
    void majAffichageInvitation() {

        invitation.getChildren().clear();

        HashMap<String, List<Object>> hashMapInvitation = GestionBD.selectPreparedStatement("Select dateInv, etatInv, idUt1 " + "from INVITATION where idUt2="+joueur.getId());

        ArrayList<Object> listeId = (ArrayList<Object>) hashMapInvitation.get("idUt1");

        try {

            for(Object elem : listeId) {

                Label lbPseudo = new Label("De la part de "+Utilisateur.getPseudoById(Integer.valueOf(elem.toString())));
                Button btAccepter = new Button("✔️");
                btAccepter.setOnAction(new ActionInvitationAcceptOrRefuse(joueur.getId(), (Integer) elem, 0, this));
                Button btRefusee = new Button("☹");
                btRefusee.setOnAction(new ActionInvitationAcceptOrRefuse(joueur.getId(), (Integer) elem, 1, this));

                HBox hBox = new HBox();
                hBox.getChildren().addAll(lbPseudo, btAccepter, btRefusee);
                hBox.setPadding(new Insets(10,9,0,9));
                hBox.setSpacing(9);

                invitation.getChildren().add(hBox); }

            this.dashboard.majAffichage(); }

        catch (NullPointerException e) { this.dashboard.majAffichage(); }}

    public TextField getTfSearch() { return tfSearch; }}
