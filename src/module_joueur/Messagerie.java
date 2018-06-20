package module_joueur;

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
import javafx.stage.Stage;

import java.io.File;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Messagerie extends SplitPane {

<<<<<<< HEAD
    private static String chem = "./img/pub/";

    private String nomUser;

=======
    private List<String> lesContacts;
    private static String chem = "./img/pub/";

    private Joueur user;
    private String contactCour;
>>>>>>> da1c5cdae2f37d3d93c2c9c22e98d1c53cf1473e
    private Label nomContactCour;

    private TextField barre;

    private VBox lesMessages;
    private ScrollPane sp;

<<<<<<< HEAD
    Stage secondaryStage;

    //TODO : Reduire la taille global des textes / Boutons
=======
    public Messagerie(Joueur joueur){
        super();

        this.lesContacts = new ArrayList<>();
        // ÉCRIRE FONCTION JDBC POUR OBTENIR LISTE DES CONTACTS

        this.user = joueur;
>>>>>>> da1c5cdae2f37d3d93c2c9c22e98d1c53cf1473e

    public Messagerie(Stage secondaryStage) {

        super();

        this.secondaryStage = secondaryStage;

        //TODO : Recuperer le nom de l'utilisateur
        this.nomUser = "Mathieu";
        this.nomContactCour = new Label("");

        this.getItems().addAll(this.menuContact(),this.pageMessages());
        this.setDividerPositions(62 / 850f); }

    private ScrollPane menuContact() {

        Button out = new Button("Sortir", new ImageView(new Image(new File(chem + "log_out.png").toURI().toString(),50.,50.,true,true)));
        out.setPadding(new Insets(2));
        out.setPrefWidth(300.);
        out.setAlignment(Pos.CENTER_LEFT);

<<<<<<< HEAD
        Label titre = new Label("Mes contacts", new ImageView(new Image(new File(chem + "messaging.png").toURI().toString(),50.,50.,true,true)));
        titre.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);
        titre.setPadding(new Insets(4));
        titre.setFont(Font.font("",FontWeight.BOLD,FontPosture.ITALIC,35));
=======
        Label titre = new Label("Mes contacts",new ImageView(new Image(new File(chem+"messaging.png").toURI().toString(),50.,50.,true,true)));
        titre.setFont(Font.font("FreeSerif",FontWeight.BOLD,FontPosture.ITALIC,35));
>>>>>>> da1c5cdae2f37d3d93c2c9c22e98d1c53cf1473e
        titre.setPadding(new Insets(5,0,6,4));
        titre.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);
        titre.setPadding(new Insets(4));


        Button accueil = new Button("Accueil", new ImageView(new Image(new File(chem + "logoWithoutText.png").toURI().toString(),50.,50.,true,true)));
        accueil.setPadding(new Insets(3));
        accueil.setPrefWidth(300.);
        accueil.setAlignment(Pos.CENTER_LEFT);
<<<<<<< HEAD
        accueil.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);
=======
        accueil.setFont(Font.font(15.));
        accueil.setUserData("ACC");
        accueil.setOnAction(new ActionChangeContact(this));

>>>>>>> da1c5cdae2f37d3d93c2c9c22e98d1c53cf1473e

        VBox contacts = new VBox();
        contacts.getChildren().addAll(titre, out, accueil);

        List<String> liste = this.onglets();
        Collections.sort(liste);

        for (String nom : liste) {

            ImageView img = new ImageView(new Image(new File(chem + "contact.png").toURI().toString()));
            img.setPreserveRatio(true);
            img.setFitHeight(55.);

            Button b = new Button(nom,img);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setFont(Font.font(15.));
            b.setPrefWidth(300.);
            b.setPadding(new Insets(2));
<<<<<<< HEAD
            b.setStyle("-fx-border-radius: 0;" + "-fx-background-radius: 0;");
=======
            b.setStyle("-fx-border-radius: 0;" +
                    "-fx-background-radius: 0;");
            b.setUserData(nom);
>>>>>>> da1c5cdae2f37d3d93c2c9c22e98d1c53cf1473e
            b.setOnAction(new ActionChangeContact(this));

            contacts.getChildren().add(b); }

        ScrollPane candidate = new ScrollPane(contacts);
        candidate.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        candidate.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        candidate.setMinWidth(72);
        candidate.setMaxWidth(300);

        this.setResizableWithParent(candidate,false);

        return candidate; }

    private VBox pageMessages() {

<<<<<<< HEAD
        ImageView jeu = new ImageView(new Image(new File(chem + "logoWithoutText.png").toURI().toString()));
        jeu.setPreserveRatio(true);
        jeu.setFitHeight(35);

        this.nomContactCour = new Label("Accceuil");
        this.nomContactCour.setFont(Font.font(30));

        Button inviteJeu = new Button("Inviter à jouer", jeu);
        inviteJeu.setFont(Font.font(15));
=======
        ImageView jeu = new ImageView(new Image(new File(chem+"logoWithoutText.png").toURI().toString()));
        jeu.setPreserveRatio(true);
        jeu.setFitHeight(35);

        ImageView img = new ImageView(new Image(new File(chem+"contact.png").toURI().toString()));
        img.setPreserveRatio(true);
        img.setFitHeight(35);
>>>>>>> da1c5cdae2f37d3d93c2c9c22e98d1c53cf1473e

        this.nomContactCour = new Label("ACCUEIL",img);
        this.nomContactCour.setUserData("ACC");
        this.nomContactCour.setFont(Font.font(30));

        HBox title = new HBox(this.nomContactCour);
        title.setAlignment(Pos.CENTER_LEFT);
        title.setStyle("-fx-border-color: #505050;" +
                "-fx-border-width: 0 0 1 0;");
        title.setPadding(new Insets(10,10,10,40));

<<<<<<< HEAD
        HBox haut = new HBox();
        haut.setPadding(new Insets(10,10,10,40));
        haut.setStyle("-fx-border-color: #505050;" + "-fx-border-width: 0 0 1 0;");
        haut.getChildren().addAll(title,invite);
=======
>>>>>>> da1c5cdae2f37d3d93c2c9c22e98d1c53cf1473e

        this.lesMessages = new VBox();
        lesMessages.setPadding(new Insets(15));
        lesMessages.setSpacing(20.);
        lesMessages.setPrefWidth(750.);

        this.sp = new ScrollPane(lesMessages);
        this.sp.setMinHeight(550.);

        this.barre = new TextField();
        this.barre.setPromptText("Écrire un message...");
        this.barre.setOnKeyReleased(new ActionEnvoiMessage(this));

<<<<<<< HEAD
        VBox candidate = new VBox();
        candidate.setPrefWidth(700.);
        candidate.getChildren().addAll(haut,sp,barre);

        return candidate; }
=======
        this.majMessages();

        res.getChildren().addAll(title,sp,barre);
        return res;
    }
>>>>>>> da1c5cdae2f37d3d93c2c9c22e98d1c53cf1473e

    public void majMessages() {

        this.lesMessages.getChildren().clear();
<<<<<<< HEAD

        for (MessageModele msg : this.getMessages(this.nomUser,this.nomContactCour)) {

            MessageVue newMsg = new MessageVue(msg);
            newMsg.setIsFromUser(msg.getNomExp().equals(this.nomUser));

            this.lesMessages.getChildren().add(newMsg); }}

    private List<MessageModele> getMessagesACCIN(String nomUser) {

        //TODO : Utiliser nomUser

        List<MessageModele> candidate = new ArrayList<>();

        candidate.add(new MessageModele("ACC","Mathieu",0,"Bonjour "+this.nomUser+" !\nComment allez-vous ?"));
        candidate.add(new MessageModele("Mathieu","ACC",0,"Euh... Bonjour !\nÇa va bien."));
        candidate.add(new MessageModele("ACC","Mathieu",0,"Moi aussi !\nBienvenue sur la Messagerie de Duel sur la Toile !\nÀ gauche, vous avez la fenêtre des contacts, que vous pouvez agrandir, mais aussi rétrécir quand vous utilisez la partie à gauche,\n\nICI →\n\noù se trouvent toute la conversation avec le contact sélectionné !\nEn bas, vous trouverez la barre de message, utile pour... envoyer un message.\nEssayez !"));
        candidate.add(new MessageModele("Mathieu","ACC",0,"Excellent ! Ça fonctionne !"));
        candidate.add(new MessageModele("ACC","Mathieu",0,"Et c'est pas fini !\nVous pouvez inviter le contact avec qui vous parlez à démarrer une partie de n'importe quel jeu de la plateforme !\nPour cela, cliquez sur le bouton en haut ↑ !\nEssayez !"));

        return candidate; }

    private List<MessageModele> getMessages(String nomUser, Label nomContactCour) {

        //TODO : Utiliser nomUser et nomContactCour

        List<MessageModele> candidate = new ArrayList<>();
=======
        for (MessageModele msg : this.getMessages(this.nomContactCour)){
            MessageVue newMsg = new MessageVue(msg);
            newMsg.setIsFromUser(msg.getNomExp().equals(this.user.getPseudo()));
            this.lesMessages.getChildren().add(newMsg);
        }
        this.sp.setContent(this.lesMessages);
    }

    private List<MessageModele> getMessagesACC() {
        List<MessageModele> res = new ArrayList<>();

        res.add(new MessageModele("ACCUEIL","Mathieu",0,"Bonjour "+this.user.getPseudo()+" !"));
        res.add(new MessageModele("Mathieu","ACCUEIL",0,"Euh... Bonjour !"));
        res.add(new MessageModele("ACCUEIL","Mathieu",0,"Bienvenue sur la Messagerie de \n  >> Duel sur la Toile <<\nCet accueil me permet de vous guider.\nÀ gauche, vous avez la fenêtre des contacts, que vous pouvez agrandir, mais aussi rétrécir quand vous utilisez la partie à gauche, où se trouvent toute la conversation avec le contact sélectionné !\nEn bas, vous trouverez la barre de message, utile pour... envoyer un message.\nEssayez !"));
        return res;
    }

    private List<MessageModele> getMessages(Label nomContactCour) {

        if (nomContactCour.getUserData().equals("ACC")){
            this.barre.setDisable(true);
            return this.getMessagesACC();
        }
        this.barre.setDisable(false);

        List<MessageModele> res = new ArrayList<>();


>>>>>>> da1c5cdae2f37d3d93c2c9c22e98d1c53cf1473e

        candidate.add(new MessageModele("Mathieu","Bernard",123456,"Salut !\nComment vas-tu ?"));
        candidate.add(new MessageModele("Bernard","Mathieu",123567,"ça va et toi ?"));
        candidate.add(new MessageModele("Mathieu","Bernard",123789,"Your son's trombone probably has a lacquer finish on it that prevents the silver polish from doing its thing. You'll have to strip the lacquer off before you will be able to polish the silver. If it has the manufacturer's original finish, it is probably an epoxy coating that has been baked on. Stripping this type of coating involves nasty caustic strippers, so you might be better off handing this over to a professional musical instrument repair technician."));
        candidate.add(new MessageModele("Bernard","Mathieu",123789,"Ok ! Nice !"));

        String[] liste = {"a", "b", "c", "d", "e", "f", "g"};

        for (String s : liste)
            candidate.add(new MessageModele("Bernard","Mathieu",123789,s));

        return candidate; }

    public Label getNomContactCour() {
        return nomContactCour;
    }

    public void setNomContactCour(String nouv){
        this.contactCour = nouv;
        if (nouv.equals("ACC"))
            this.nomContactCour.setText("ACCUEIL");
        else
            this.nomContactCour.setText(nouv);
        this.nomContactCour.setUserData(nouv);

    }

    public String getBarreText() {
        return barre.getText();
    }

    public Joueur getUser() {
        return user;
    }

    public String getContactCour() {
        return contactCour;
    }

    private List<String> onglets() {

        //TODO : Recuperer les bons amis

        List<String> res = new ArrayList<>(Arrays.asList("Bernard","Maffiou","Bordercraft","LuK","Benjam1","Valent1","Benjam2","LéOchocOLa","CoucousEat","Mattew","Antonio","LeProGamer45","BossDuGame","TonAmiWoody","MarioLeVrai","AlainSoralOfficiel"));

        return res; }}
