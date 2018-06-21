package module_mastermind;

import APIMySQL.APIMySQLException;
import APIMySQL.Jeu;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.net.URISyntaxException;
import java.util.HashMap;

public class Mastermind extends Application {

    private Stage primaryStage;
    public static final String chem = "/img/module_mastermind/";
    private HashMap<String,Scene> attribution; // On attribue un titre aux Scènes, pour les appeler

    public static void main(String[] args) {
        launch(args);
    }

    /**
     *Peut modifier la fenetre où l'on se trouve
     * Initialisé a Accueil
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        this.attribution = new HashMap<>();
        this.attribution.put("Accueil",this.pageAccueil());
        this.attribution.put("Nouvelle Partie",new ChoixJoueurM(this).getScene("Nouvelle Partie"));
        this.attribution.put("Reprendre Partie",new ChoixJoueurM(this).getScene("Reprendre Partie"));
        try{
            Jeu.creerJeu("Mastermind","règles mastermind","jar/Mastermind.jar",1,"jar/Mastermind.jar");
        }
        catch (APIMySQLException a){}

        this.primaryStage = primaryStage;

        primaryStage.setResizable(false);
        primaryStage.setTitle("Duel sur la toile - Mastermind");
        primaryStage.setScene(this.pageAccueil());
        primaryStage.show();
    }

    /**
     * Créer une nouvelle partie avec les joueurs en parametre
     * @param j1
     * @param j2
     */
    public void newGame(String j1, String j2){
        primaryStage.setScene(new PartieM(this,j1,j2).getScene(this));
    }

    /**
     * Change la scene en fonction du titre placer en parametre
     * @param titre
     */
    public void setScene(String titre){
        primaryStage.setScene(this.attribution.get(titre));
    }

    /**
     * Quitte la plateforme
     */
    public void exit(){
        Platform.exit();
    }

    /**
     * Créer la vue des Bouttons de l'accueil
     * @return une HBox
     */
    private HBox boutonsAccueil() {
        HBox res = new HBox();
        Font bouton = Font.font("Verdana",FontWeight.BOLD,25);
        ImageView ami = new ImageView();
        try {
            ami.setImage(new Image(getClass().getResource(chem+"jouerAmi.png").toURI().toString()));

        Button b1 = new Button("Nouveau duel",ami);
        b1.setFont(bouton);
        b1.setContentDisplay(ContentDisplay.TOP);
        b1.setPrefSize(390,75.);
        b1.setOnAction(event -> this.setScene("Nouvelle Partie"));
        res.getChildren().add(b1);

        ImageView continuerPartie = new ImageView();
        continuerPartie.setImage(new Image(getClass().getResource(chem+"continuerPartie.png").toURI().toString()));

        Button b2 = new Button("Reprendre partie", continuerPartie);
        b2.setFont(bouton);
        b2.setContentDisplay(ContentDisplay.TOP);
        b2.setPrefSize(390,75.);
        b2.setOnAction(event -> this.setScene("Reprendre Partie"));
        res.getChildren().add(b2);

        res.setAlignment(Pos.CENTER);
        res.setSpacing(25);
        res.setPadding(new Insets(0,0,40,0));
        return res;
        } catch (URISyntaxException e) {
        e.printStackTrace();
        }
        return null;
    }

    /**
     * Créer la scene de la page d'accueil complete
     * @return une Scene
     */
    private Scene pageAccueil(){
        BorderPane res = new BorderPane();
        try {
            res.setCenter(new ImageView(new Image(getClass().getResource(chem+"mastermind_logo1.png").toURI().toString())));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        res.setBottom(boutonsAccueil());
        return new Scene(res,850,650);
    }
}

