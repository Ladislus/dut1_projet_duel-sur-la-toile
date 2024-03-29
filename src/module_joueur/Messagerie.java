package module_joueur;

import APIMySQL.GestionBD;
import APIMySQL.Utilisateur;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.net.URISyntaxException;

import java.util.*;


public class Messagerie extends SplitPane {

    private List<String> lesContacts;
    private static String chem = "/img/pub/";

    private Joueur user;
    private String contactCour;
    private Label nomContactCour;
    private TextField barre;
    private VBox lesMessages;
    private ScrollPane sp;

    /**
     Création de la vue de la messagerie
     @param joueur : Le joueur courant
    */
    Messagerie(Joueur joueur){
        super();

        this.lesContacts = Utilisateur.getListeDamis(joueur.getPseudo());
        // ÉCRIRE FONCTION JDBC POUR OBTENIR LISTE DES CONTACTS

        this.user = joueur;

        this.getItems().addAll(this.menuContact(),this.pageMessages());
        this.setDividerPositions(62/850f); }

    /**
     Création de la barre de contacte de gauche
     @return : Un Scrollpane
    */
    private ScrollPane menuContact() {

        VBox contacts = new VBox();
        Button out = null;

        try { out = new Button("Sortir",new ImageView(new Image(getClass().getResource(chem+"log_out.png").toURI().toString(),50.,50.,true,true))); }
        catch (URISyntaxException e) { e.printStackTrace(); }

        out.setPadding(new Insets(2));
        out.setPrefWidth(300.);
        out.setAlignment(Pos.CENTER_LEFT);

        Label titre = null;

        try { titre = new Label("Mes contacts",new ImageView(new Image(getClass().getResource(chem+"messaging.png").toURI().toString(),50.,50.,true,true))); }
        catch (URISyntaxException e) { e.printStackTrace(); }

        titre.setFont(Font.font("FreeSerif",FontWeight.BOLD,FontPosture.ITALIC,35));
        titre.setPadding(new Insets(5,0,6,4));
        titre.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);
        titre.setPadding(new Insets(4));

        Button accueil = null;

        try { accueil = new Button("ACCUEIL",new ImageView(new Image(getClass().getResource(chem+"logoWithoutText.png").toURI().toString(),50.,50.,true,true))); }
        catch (URISyntaxException e) { e.printStackTrace(); }

        accueil.setPadding(new Insets(3));
        accueil.setPrefWidth(300.);
        accueil.setAlignment(Pos.CENTER_LEFT);
        accueil.setFont(Font.font(15.));
        accueil.setUserData("ACC");
        accueil.setOnAction(new ActionChangeContact(this));

        contacts.getChildren().addAll(out,titre,accueil);

        List<String> liste = this.onglets();
        Collections.sort(liste);

        for (String nom : liste) {

            ImageView img = null;

            try { img = new ImageView(new Image(getClass().getResource(chem + "contact.png").toURI().toString())); }
            catch (URISyntaxException e) { e.printStackTrace(); }

            img.setPreserveRatio(true);
            img.setFitHeight(55.);

            Button b = new Button(nom,img);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setFont(Font.font(15.));
            b.setPrefWidth(300.);
            b.setPadding(new Insets(2));
            b.setStyle("-fx-border-radius: 0;" + "-fx-background-radius: 0;");
            b.setUserData(nom);
            b.setOnAction(new ActionChangeContact(this));

            contacts.getChildren().add(b); }

        ScrollPane res = new ScrollPane(contacts);
        res.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        res.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        res.setMinWidth(72);
        res.setMaxWidth(300);

        this.setResizableWithParent(res,false);

        return res; }

    /**
     Création de la page contenant les messages
     @return : Une VBox
    */
    private VBox pageMessages() {
        VBox res = new VBox();
        res.setPrefWidth(700.);

        ImageView jeu = null;

        try { jeu = new ImageView(new Image(getClass().getResource(chem+"logoWithoutText.png").toURI().toString())); }
        catch (URISyntaxException e) { e.printStackTrace(); }

        jeu.setPreserveRatio(true);
        jeu.setFitHeight(35);

        ImageView img = null;

        try { img = new ImageView(new Image(getClass().getResource(chem+"contact.png").toURI().toString())); }
        catch (URISyntaxException e) { e.printStackTrace(); }

        img.setPreserveRatio(true);
        img.setFitHeight(35);

        this.nomContactCour = new Label("ACCUEIL",img);
        this.nomContactCour.setUserData("ACC");
        this.nomContactCour.setFont(Font.font(30));

        HBox title = new HBox(this.nomContactCour);
        title.setAlignment(Pos.CENTER_LEFT);
        title.setStyle("-fx-border-color: #505050;" + "-fx-border-width: 0 0 1 0;");
        title.setPadding(new Insets(10,10,10,40));

        this.lesMessages = new VBox();
        lesMessages.setPadding(new Insets(15));
        lesMessages.setSpacing(20.);
        lesMessages.setPrefWidth(750.);

        this.sp = new ScrollPane(lesMessages);
        this.sp.setMinHeight(550.);
        this.sp.setVvalue(1D);

        this.barre = new TextField();
        this.barre.setPromptText("Écrire un message...");
        this.barre.setOnKeyReleased(new ActionEnvoiMessage(this));
        this.setOnMouseMoved(mouseEvent -> this.majMessages());

        this.majMessages();

        res.getChildren().addAll(title,sp,barre);

        return res; }

    /**
     Fonction ajoutant le message passé en paramètre dans la fenêtre de message
     @param newMsg
    */
    void ajouteMessage(String newMsg) {

        MessageModele newModele = new MessageModele(this.user.getPseudo(), this.contactCour,System.currentTimeMillis(),newMsg);
        MessageVue newVue = new MessageVue(newModele);

        newVue.setIsFromUser(newModele.getNomExp().equals(this.user.getPseudo()));

        this.lesMessages.getChildren().add(newVue);
        this.sp.setContent(this.lesMessages); }

    /**
     Fonction mettant à jour les messages
    */
    void majMessages() {
        this.lesMessages.getChildren().clear();
        for (MessageModele msg : this.getMessages(this.nomContactCour)){
            MessageVue newMsg = new MessageVue(msg);
            newMsg.setIsFromUser(msg.getNomExp().equals(this.user.getPseudo()));
            this.lesMessages.getChildren().add(newMsg); }

        lesMessages.heightProperty().addListener(observable -> sp.setVvalue(1D));
        this.sp.setContent(this.lesMessages); }

    /**
     Création du message personnalisé de l'acceuil
     @return : Une liste de message
    */
    private List<MessageModele> getMessagesACC() {
        List<MessageModele> res = new ArrayList<>();

        res.add(new MessageModele("ACCUEIL",this.user.getPseudo(),0,"Bonjour "+this.user.getPseudo()+" !"));
        res.add(new MessageModele(this.user.getPseudo(),"ACCUEIL",0,"Euh... Bonjour !"));
        res.add(new MessageModele("ACCUEIL",this.user.getPseudo(),0,"Bienvenue sur la Messagerie de \n  >> Duel sur la Toile <<\nCet accueil me permet de vous guider.\nÀ gauche, vous avez la fenêtre des contacts, que vous pouvez agrandir, mais aussi rétrécir quand vous utilisez la partie à gauche, où se trouvent toute la conversation avec le contact sélectionné !\nEn bas, vous trouverez la barre de message, utile pour... envoyer un message.\nEssayez !"));

        return res; }

    /**
     Retourne la liste des messages d'un contact
     @param nomContactCour : Le label du contact choisi
     @return : Une liste de messages
    */
    private List<MessageModele> getMessages(Label nomContactCour) {

        if (nomContactCour.getUserData().equals("ACC")){
            this.barre.setDisable(true);
            return this.getMessagesACC(); }

        this.barre.setDisable(false);

        List<MessageModele> res = new ArrayList<>();

        //recup liste de message entre joueur courant et contact courant
        try {

            ArrayList<Object> listeIdMessage1 = (ArrayList<Object>) GestionBD.selectPreparedStatement("select idMsg from MESSAGE where idUt1 = " + user.getId() + " and idUt2=" + Utilisateur.getIdByPseudo(contactCour) + " or idUt1 = " + Utilisateur.getIdByPseudo(contactCour) + " and idUt2=" + user.getId()).get("idMsg");

            for (Object idMsg : listeIdMessage1) {
                String nomExp = Utilisateur.getPseudoById((Integer) GestionBD.selectPreparedStatement("select idUt1 from MESSAGE where idMsg = " + idMsg.toString()).get("idUt1").get(0));
                String nomDest = Utilisateur.getPseudoById((Integer) GestionBD.selectPreparedStatement("select idUt2 from MESSAGE where idMsg = " + idMsg.toString()).get("idUt2").get(0));
                HashMap<String, List<Object>> resReq = GestionBD.selectPreparedStatement("select contenuMsg, dateMsg from MESSAGE where idMsg = " + idMsg.toString());
                String contenu = (String) resReq.get("contenuMsg").get(0);
                Date dateEnvoi = (Date) resReq.get("dateMsg").get(0);
                MessageModele messageModele = new MessageModele(nomExp, nomDest, dateEnvoi.getTime(), contenu);
                res.add(messageModele); }}

        catch (NullPointerException e) { return new ArrayList<>(); }

        return res; }

    /**
     Fonction permmetant de mettre à jour le nom du contact courant
     @param nouv : Une String contenant le nom du nouveau contact courant
    */
    void setNomContactCour(String nouv) {

        this.contactCour = nouv;

        if (nouv.equals("ACC"))
            this.nomContactCour.setText("ACCUEIL");
        else
            this.nomContactCour.setText(nouv);

        this.nomContactCour.setUserData(nouv); }

    String getBarreText() { return barre.getText(); }

    Joueur getUser() { return user; }

    String getContactCour() { return contactCour; }

    private List<String> onglets() {

        List<String> res = lesContacts;

        return res; }

    public TextField getBarre() { return barre; }}
