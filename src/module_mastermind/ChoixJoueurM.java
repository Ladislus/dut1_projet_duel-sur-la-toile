package module_mastermind;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.util.*;

import static module_puissance4.Puissance4.chem;

public class ChoixJoueurM {
    // Vue de la fenêtre pour choisir contre qui jouer

    private Mastermind mastermind;

    public String mode; // New Game ou Resume Game

    public Set<String> listeAmis;
    public Set<String> listeAdvers; // Liste des joueurs avec qui une partie est en cours
    public Set<String> listeCour; // Liste des contacts à afficher
    public TextField barre;
    private GridPane contacts; // Grille des contacts à afficher
    private BorderPane scene;

    public ChoixJoueurM(Mastermind m){
        this.mastermind = m;
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

        Image im = new Image(new File(chem+"mastermind_logo1.png").toURI().toString());
        ImageView iv = new ImageView(im);
        iv.setPreserveRatio(true);
        iv.setFitHeight(60);

        Button retour = new Button("Home");
        retour.setPrefSize(100.,30.);
        retour.setOnAction(event -> this.mastermind.setScene("Home"));
        Button changeMode;
        if (mode == "New Game"){changeMode = new Button("Resume Game");}
        else {changeMode = new Button("New Game");}
        changeMode.setPrefSize(150.,30.);
        changeMode.setOnAction(event -> this.mastermind.setScene(changeMode.getText()));

        res.getChildren().addAll(iv,retour,changeMode,new Label("Welcome "+"Bernard"+" !"));

        return res;
    }

    private VBox centre() {
        VBox res = new VBox();
        res.setAlignment(Pos.TOP_CENTER);
        res.setSpacing(5.);
        res.setPadding(new Insets(20,10,0,10));


        Label titre = new Label();
        titre.setPadding(new Insets(50,0,30,0));
        if (mode == "New Game"){titre.setText("Against whom do you want to play ?");}
        else {titre.setText("Which game do you want to resume ?");}
        titre.setFont(Font.font("FreeSerif",FontWeight.BOLD,FontPosture.ITALIC,45.));


        Label lab = new Label();
        if (mode == "New Game"){lab.setText("Your friendlist :");}
        else {lab.setText("Games in progress :");}
        lab.setFont(Font.font("Verdana",FontWeight.BOLD,30.));

        barre = new TextField();
        barre.setPromptText("Search");
        barre.setMaxWidth(250.);
        barre.setOnKeyReleased(new ActionRechercherJoueurM(this));


        // LISTE DES CONTACTS
        if (mode == "New Game"){this.listeCour = this.listeAmis;}
        else {this.listeCour = this.listeAdvers;}

        this.contacts = new GridPane();
        this.contacts.setVgap(20.);
        this.contacts.setHgap(20.);
        this.contacts.setAlignment(Pos.TOP_CENTER);

        this.majContacts();

        res.getChildren().addAll(titre,lab,this.barre,this.contacts);
        return res;
    }

    public void majContacts() {
        this.contacts.getChildren().clear();


        int i = 0;
        for (String nom : this.listeCour){
            ImageView img = new ImageView(new Image(new File(chem+"../pub/contact.png").toURI().toString()));
            img.setPreserveRatio(true);
            img.setFitHeight(50.);
            Button b = new Button(nom,img);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setContentDisplay(ContentDisplay.LEFT);
            b.setPrefSize(200.,50.);
            b.setFont(Font.font("Verdana",FontWeight.NORMAL,15));
            b.setOnAction(event -> this.mastermind.newGame(this.mastermind,"Bernard",b.getText()));
            this.contacts.add(b,i%3,i/3);
            i++;
        }

    }
}
