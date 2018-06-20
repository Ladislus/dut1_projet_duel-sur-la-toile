package module_joueur;

import APIMySQL.GestionBD;
import APIMySQL.Utilisateur;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Vue de la Messagerie
 */
public class Messagerie extends SplitPane {

    private List<String> lesContacts;
    private static String chem = "./img/pub/";

    private Joueur user;
    private String contactCour;
    private Label nomContactCour;
    private TextField barre;
    private VBox lesMessages;
    private ScrollPane sp;

    public Messagerie(Joueur joueur){
        super();

        this.lesContacts = Utilisateur.getListeDamis(joueur.getPseudo());
        // ÉCRIRE FONCTION JDBC POUR OBTENIR LISTE DES CONTACTS

        this.user = joueur;

        this.getItems().addAll(this.menuContact(),this.pageMessages());
        this.setDividerPositions(62/850f);




    }

    private ScrollPane menuContact() {


        VBox contacts = new VBox();
        Button out = new Button("Sortir",new ImageView(new Image(new File(chem+"log_out.png").toURI().toString(),50.,50.,true,true)));
        out.setPadding(new Insets(2));
        out.setPrefWidth(300.);
        out.setAlignment(Pos.CENTER_LEFT);

        Label titre = new Label("Mes contacts",new ImageView(new Image(new File(chem+"messaging.png").toURI().toString(),50.,50.,true,true)));
        titre.setFont(Font.font("FreeSerif",FontWeight.BOLD,FontPosture.ITALIC,35));
        titre.setPadding(new Insets(5,0,6,4));
        titre.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);
        titre.setPadding(new Insets(4));

        Button accueil = new Button("ACCUEIL",new ImageView(new Image(new File(chem+"logoWithoutText.png").toURI().toString(),50.,50.,true,true)));
        accueil.setPadding(new Insets(3));
        accueil.setPrefWidth(300.);
        accueil.setAlignment(Pos.CENTER_LEFT);
        accueil.setFont(Font.font(15.));
        accueil.setUserData("ACC");
        accueil.setOnAction(new ActionChangeContact(this));


        contacts.getChildren().addAll(out,titre,accueil);

        List<String> liste = this.onglets();
        Collections.sort(liste);

        for (String nom : liste){
            ImageView img = new ImageView(new Image(new File(chem+"contact.png").toURI().toString()));
            img.setPreserveRatio(true);
            img.setFitHeight(55.);

            Button b = new Button(nom,img);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setFont(Font.font(15.));
            b.setPrefWidth(300.);
            b.setPadding(new Insets(2));
            b.setStyle("-fx-border-radius: 0;" +
                    "-fx-background-radius: 0;");
            b.setUserData(nom);
            b.setOnAction(new ActionChangeContact(this));

            contacts.getChildren().add(b);
        }

        ScrollPane res = new ScrollPane(contacts);
        res.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        res.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        res.setMinWidth(72);
        res.setMaxWidth(300);

        this.setResizableWithParent(res,false);

        return res;
    }

    private VBox pageMessages() {
        VBox res = new VBox();
        res.setPrefWidth(700.);

        ImageView jeu = new ImageView(new Image(new File(chem+"logoWithoutText.png").toURI().toString()));
        jeu.setPreserveRatio(true);
        jeu.setFitHeight(35);

        ImageView img = new ImageView(new Image(new File(chem+"contact.png").toURI().toString()));
        img.setPreserveRatio(true);
        img.setFitHeight(35);

        this.nomContactCour = new Label("ACCUEIL",img);
        this.nomContactCour.setUserData("ACC");
        this.nomContactCour.setFont(Font.font(30));

        HBox title = new HBox(this.nomContactCour);
        title.setAlignment(Pos.CENTER_LEFT);
        title.setStyle("-fx-border-color: #505050;" +
                "-fx-border-width: 0 0 1 0;");
        title.setPadding(new Insets(10,10,10,40));


        this.lesMessages = new VBox();
        lesMessages.setPadding(new Insets(15));
        lesMessages.setSpacing(20.);
        lesMessages.setPrefWidth(750.);

        this.sp = new ScrollPane(lesMessages);
        this.sp.setMinHeight(550.);
        sp.setVvalue(1D);
        this.barre = new TextField();
        this.barre.setPromptText("Écrire un message...");
        this.barre.setOnKeyReleased(new ActionEnvoiMessage(this));
        this.setOnMouseMoved(mouseEvent -> this.majMessages());

        this.majMessages();

        res.getChildren().addAll(title,sp,barre);
        return res;
    }

    public void majMessages() {
        System.out.println("zzz");

        this.lesMessages.getChildren().clear();
        for (MessageModele msg : this.getMessages(this.nomContactCour)){
            MessageVue newMsg = new MessageVue(msg);
            newMsg.setIsFromUser(msg.getNomExp().equals(this.user.getPseudo()));
            this.lesMessages.getChildren().add(newMsg);
        }
        lesMessages.heightProperty().addListener(observable -> sp.setVvalue(1D));
        this.sp.setContent(this.lesMessages);
    }

    private List<MessageModele> getMessagesACC() {
        List<MessageModele> res = new ArrayList<>();

        res.add(new MessageModele("ACCUEIL",this.user.getPseudo(),0,"Bonjour "+this.user.getPseudo()+" !"));
        res.add(new MessageModele(this.user.getPseudo(),"ACCUEIL",0,"Euh... Bonjour !"));
        res.add(new MessageModele("ACCUEIL",this.user.getPseudo(),0,"Bienvenue sur la Messagerie de \n  >> Duel sur la Toile <<\nCet accueil me permet de vous guider.\nÀ gauche, vous avez la fenêtre des contacts, que vous pouvez agrandir, mais aussi rétrécir quand vous utilisez la partie à gauche, où se trouvent toute la conversation avec le contact sélectionné !\nEn bas, vous trouverez la barre de message, utile pour... envoyer un message.\nEssayez !"));
        return res;
    }

    private List<MessageModele> getMessages(Label nomContactCour) {

        if (nomContactCour.getUserData().equals("ACC")){
            this.barre.setDisable(true);
            return this.getMessagesACC();
        }
        this.barre.setDisable(false);

        List<MessageModele> res = new ArrayList<>();

        //recup liste de message entre joueur courant et contact courant

        ArrayList<Object> listeIdMessage = (ArrayList<Object>) GestionBD.selectPreparedStatement("select idMsg from MESSAGE where idUt1 = "+user.getId()+" and idUt2="+Utilisateur.getIdByPseudo(contactCour)).get("idMsg");

        for(Object idMsg : listeIdMessage){
            String nomExp = Utilisateur.getPseudoById((Integer) GestionBD.selectPreparedStatement("select idUt1 from MESSAGE where idMsg = "+idMsg.toString()).get("idUt1").get(0));
            String nomDest = Utilisateur.getPseudoById((Integer) GestionBD.selectPreparedStatement("select idUt2 from MESSAGE where idMsg = "+idMsg.toString()).get("idUt2").get(0));
            Long dateEnvoi = Long.valueOf(0);
            String contenue =(String) GestionBD.selectPreparedStatement("select contenuMsg from MESSAGE where idMsg = "+idMsg.toString()).get("contenuMsg").get(0);
            MessageModele messageModele = new MessageModele(nomExp, nomDest, dateEnvoi, contenue);
            res.add(messageModele);
        }
        return res;
    }

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
        List<String> res = lesContacts;
        return res;
    }

    public TextField getBarre() {
        return barre;
    }
}
