package module_21;

import javafx.application.Application;
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

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * Le Stage principal du jeu des 21 Bâtonnets
 * Étend Application
 */
public class Jeu21Batonnets extends Application {

    /** Le Stage principal */
    private Stage primaryStage;

    /** Le dictionnaire qui relie un titre String à une Scène, pour en changer plus facilement */
    private HashMap<String,Scene> attribution;

    /** chemin relatif pour retrouver les images du puissance 4 */
    public static String chem = "/img/module_21/";



    /** Initialiser le jeu du 21, avec le dictionnaire <titre,scène>*/
    @Override
    public void init(){
        this.attribution = new HashMap<>();
        this.attribution.put("Home",this.pageAccueil());
        this.attribution.put("New Game",new ChoixJoueur21(this).getScene("New Game"));
        this.attribution.put("Resume Game",new ChoixJoueur21(this).getScene("Resume Game"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        primaryStage.setTitle("Duel sur la toile - 21 Bâtonnets");
        this.setScene("Home");
        primaryStage.show();
    }

    /** Changer de page dans le module */
    public void setScene(String titre){
        primaryStage.setScene(this.attribution.get(titre));
    }

    /** Démarrer une partie de 21 */
    public void newGame(Jeu21Batonnets jeu21,String j1,String j2){primaryStage.setScene(new Partie21(this,j1,j2).getScene());}

    public HBox boutonsAccueil(){
        HBox res = new HBox();
        Font bouton = Font.font("Verdana",FontWeight.BOLD,25);

        ImageView ami = new ImageView();
        try {
            ami.setImage(new Image(getClass().getResource(chem+"jouerAmi.png").toURI().toString()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Button b1 = new Button("Nouvelle partie",ami);
        b1.setFont(bouton);
        b1.setContentDisplay(ContentDisplay.TOP);
        b1.setPrefSize(390,75.);
        b1.setOnAction(event -> this.setScene("New Game"));
        res.getChildren().add(b1);

        ImageView continuPartie = new ImageView();
        try {
            continuPartie.setImage(new Image(getClass().getResource(chem+"continuerPartie.png").toURI().toString()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Button b2 = new Button("Reprendre une partie", continuPartie);
        b2.setFont(bouton);
        b2.setContentDisplay(ContentDisplay.TOP);
        b2.setPrefSize(390,75.);
        b2.setOnAction(event -> this.setScene("Resume Game"));
        res.getChildren().add(b2);

        res.setAlignment(Pos.CENTER);
        res.setSpacing(25);
        res.setPadding(new Insets(0,0,40,0));
        return res;
    }

    public Scene pageAccueil(){
        BorderPane res = new BorderPane();

        try {
            res.setCenter(new ImageView(new Image(getClass().getResource(chem+"logo21.png").toURI().toString())));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        res.setBottom(boutonsAccueil());
        return new Scene(res,850,650);
    }

    public String getRegle() {
        return "Aussi appelé Jeu de Nim...\n" +
                "Ce jeu en 1v1 est un jeu de réflexion dont la règle est très simple :\n\n" +
                "Vous avez 21 Batônnets face à vous (ce qui explique un peu le nom du jeu) et les adversaires y retirent " +
                "chacun leur tour 1, 2 ou 3 Bâtonnets. Celui qui est contraint de retirer le dernier a perdu !\n\n" +
                "NB : Commencez à droite !\n\n" +
                "Bonne chance !";
    }
}
