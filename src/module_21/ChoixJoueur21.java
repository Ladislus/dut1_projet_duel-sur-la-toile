package module_21;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import static module_21.Jeu21Batonnets.chem;

/**
 *  Vue de la fenêtre pour choisir contre qui jouer
 */
public class ChoixJoueur21 {


    /** Le Stage principal, qui étend Application */
    private Jeu21Batonnets jeu21;

    /** "New Game" ou "Resume Game" */
    public String mode;

    public Set<String> listeAmis;
    public Set<String> listeAdvers; // Liste des joueurs avec qui une partie est en cours
    public Set<String> listeCour; // Liste des contacts à afficher
    public TextField barre;
    private VBox contacts; // Grille des contacts à afficher
    private BorderPane scene;
    private ScrollPane sp;


    public ChoixJoueur21(Jeu21Batonnets jeu){
        this.jeu21 = jeu;
        this.listeAmis = new HashSet<>();

        // TEST
        String[] noms = {"Mathieu","LuK","Valent1","Benjam2","LéOchocOLa","CoucousEat"};
        for (String nom : noms){
            this.listeAmis.add(nom);
        }
        this.listeAdvers = new HashSet<>();
        this.listeAdvers.add("Mathieu");
        this.listeAdvers.add("Benjam2");
    }

    public Scene getScene(String mode){ // "New Game" ou "Resume Game"
        this.mode = mode;

        BorderPane res = new BorderPane();
        res.requestFocus();

        res.setTop(this.haut());
        res.setCenter(this.centre());

        this.scene = res;
        return new Scene(res, 850, 650);
    }

    private HBox haut() {
        HBox res = new HBox();
        res.setSpacing(50.);
        res.setAlignment(Pos.CENTER_LEFT);

        ImageView iv = null;
        try {
            iv = new ImageView(getClass().getResource(chem+"logo21.png").toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        iv.setPreserveRatio(true);
        iv.setFitHeight(60);

        Button retour = new Button("Home");
        retour.setPrefSize(100.,30.);
        retour.setOnAction(event -> this.jeu21.setScene("Home"));
        Button changeMode;
        if (mode == "New Game"){changeMode = new Button("Resume Game");}
        else {changeMode = new Button("New Game");}
        changeMode.setPrefSize(150.,30.);
        changeMode.setOnAction(event -> this.jeu21.setScene(changeMode.getText()));

        res.getChildren().addAll(iv,retour,changeMode,new Label("Welcome "+"Bernard"+" !"));

        return res;
    }

    private HBox centre() {
        HBox res = new HBox();
        res.setSpacing(5.);
        res.setPadding(new Insets(20,10,0,10));


        VBox listeAmis = new VBox();
        listeAmis.setSpacing(5.);
        listeAmis.setPadding(new Insets(20,10,0,10));
        listeAmis.setPrefWidth(500.);

        Label titre = new Label();
        titre.setPadding(new Insets(50,0,30,0));
        if (mode == "New Game"){titre.setText("Qui voulez-vous défier ?");}
        else {titre.setText("Quelle partie reprendre ?");}
        titre.setFont(Font.font("FreeSerif",FontWeight.BOLD,FontPosture.ITALIC,45.));


        Label lab = new Label();
        if (mode == "New Game"){lab.setText("Votre liste d'amis :");}
        else {lab.setText("Partie(s) en cours :");}
        lab.setFont(Font.font("Verdana",FontWeight.BOLD,30.));

        barre = new TextField();
        barre.setPromptText("Search");
        barre.setMaxWidth(250.);
        barre.setOnKeyReleased(new ActionRechercherJoueur21(this));


        // LISTE DES CONTACTS
        if (mode == "New Game"){this.listeCour = this.listeAmis;}
        else {this.listeCour = this.listeAdvers;}

        this.contacts = new VBox();
        this.contacts.setSpacing(20.);

        this.sp = new ScrollPane(this.contacts);
        sp.setMinWidth(72);
        sp.setMaxWidth(300);

        this.majContacts();

        listeAmis.getChildren().addAll(titre,lab,this.barre,this.sp);


        // PARTIE RÈGLES
        VBox regle = new VBox();
        regle.setMaxWidth(300.);
        regle.setAlignment(Pos.BOTTOM_RIGHT);
        regle.setPadding(new Insets(0,0,50,0));

        ImageView img = null;
        try {
            img = new ImageView(new Image(getClass().getResource("/pub/info.png").toURI().toString(),30,30,true,true));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Label titre2 = new Label("Règle du jeu :",img);
        titre2.setFont(Font.font("FreeSerif",FontWeight.BOLD,FontPosture.ITALIC,35.));

        Label infos = new Label(this.jeu21.getRegle());
        infos.setWrapText(true);
        infos.setMaxWidth(270.);
        infos.setPadding(new Insets(10,0,0,2));

        ScrollPane sp2 = new ScrollPane(infos);
        sp2.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp2.setPrefHeight(150.);

        regle.getChildren().addAll(titre2,sp2);


        res.getChildren().addAll(listeAmis,regle);
        return res;
    }

    /** Mettre à jour la liste des contacts affichées dans la vue */
    public void majContacts() {
        this.contacts.getChildren().clear();

        for (String nom : this.listeCour){
            ImageView img = null;
            try {
                img = new ImageView(getClass().getResource("/img/pub/contact.png").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            img.setPreserveRatio(true);
            img.setFitHeight(50.);
            Button b = new Button(nom,img);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setContentDisplay(ContentDisplay.LEFT);
            b.setPrefSize(200.,50.);
            b.setFont(Font.font("Verdana",FontWeight.NORMAL,15));
            b.setOnAction(event -> this.jeu21.newGame(this.jeu21,"Bernard",b.getText()));
            this.contacts.getChildren().add(b);
        }

        this.sp.setContent(this.contacts);

    }
}
