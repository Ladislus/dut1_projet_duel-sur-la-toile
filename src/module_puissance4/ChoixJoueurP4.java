package module_puissance4;


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

/**
 *  Vue de la fenêtre pour choisir contre qui jouer
 */
public class ChoixJoueurP4 {

    /** Le Stage principal, qui étend Application */
    private Puissance4 puissance4;

    /** "New Game" ou "Resume Game" */
    public String mode;

    private static String chem = "../src/module_mastermind/pub/";

    public Set<String> listeAmis;
    public Set<String> listeAdvers; // Liste des joueurs avec qui une partie est en cours
    public Set<String> listeCour; // Liste des contacts à afficher
    public TextField barre;
    private GridPane contacts; // Grille des contacts à afficher
    private BorderPane scene;

    public ChoixJoueurP4(Puissance4 p){
        this.puissance4 = p;
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

        Image im = new Image(new File(chem+"connect4logo.png").toURI().toString());
        ImageView iv = new ImageView(im);
        iv.setPreserveRatio(true);
        iv.setFitHeight(60);

        Button retour = new Button("Home");
        retour.setPrefSize(100.,30.);
        retour.setOnAction(event -> this.puissance4.setScene("Home"));
        Button changeMode;
        if (mode == "New Game"){changeMode = new Button("Resume Game");}
        else {changeMode = new Button("New Game");}
        changeMode.setPrefSize(150.,30.);
        changeMode.setOnAction(event -> this.puissance4.setScene(changeMode.getText()));

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
        barre.setOnKeyReleased(new module_puissance4.ActionRechercherJoueur(this));


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

    /** Mettre à jour la liste des contacts affichées dans la vue */
    public void majContacts() {
        this.contacts.getChildren().clear();


        int i = 0;

        Button bAleatoire = new Button("Aléatoire");
        bAleatoire.setPrefSize(200.,60.);
        this.contacts.add(bAleatoire,i%3,i/3);

        i++;

        for (String nom : this.listeCour){
            ImageView img = new ImageView(new Image(new File(chem+"contact.png").toURI().toString()));
            img.setPreserveRatio(true);
            img.setFitHeight(50.);
            Button b = new Button(nom,img);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setContentDisplay(ContentDisplay.LEFT);
            b.setPrefSize(200.,50.);
            b.setFont(Font.font("Verdana",FontWeight.NORMAL,15));
            b.setOnAction(event -> this.puissance4.newGame(this.puissance4,"Bernard",b.getText()));
            this.contacts.add(b,i%3,i/3);
            i++;
        }

    }
}
