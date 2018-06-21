package module_puissance4;

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
import java.util.HashMap;

/**
 * Le Stage principal du Puissance 4
 * Étend Application
 */
public class Puissance4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /** chemin relatif pour retrouver les images du puissance 4 */
    public static final String chem = "/img/module_puissance4/";

    /** Le stage principal */
    private Stage primaryStage;

    /** Le dictionnaire qui relie un titre String à une Scène, pour en changer plus facilement */
    public static HashMap<String,Scene> attribution;

    /** Initialiser le puissance 4, avec le dictionnaire <titre,scène>*/
    @Override
    public void init(){
        this.attribution = new HashMap<>();
        this.attribution.put("Home",this.pageAccueil());
        this.attribution.put("New Game",new ChoixJoueurP4(this).getScene("New Game"));
        this.attribution.put("Resume Game",new ChoixJoueurP4(this).getScene("Resume Game"));
    }

    @Override
    public void start(Stage primaryStage) {
        this.init();

        this.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        primaryStage.setTitle("Duel sur la toile - Connect 4");
        primaryStage.setScene(this.pageAccueil());
        primaryStage.show();
    }

    /** Changer de page dans le module */
    public void setScene(String titre){
        primaryStage.setScene(this.attribution.get(titre));
    }

/** Démarrer une partie de Puissance 4 */
    public void newGame(Puissance4 p4,String j1,String j2){primaryStage.setScene(new PartieP4(p4,j1,j2).getScene());}

    public HBox boutonsAccueil(){
        HBox res = new HBox();
        Font bouton = Font.font("Verdana",FontWeight.BOLD,25);

        File imageami = new File(chem+"jouerAmi.png");
        ImageView ami = new ImageView();
        ami.setImage(new Image(imageami.toURI().toString()));

        Button b1 = new Button("New Game with a friend",ami);
        b1.setFont(bouton);
        b1.setContentDisplay(ContentDisplay.TOP);
        b1.setPrefSize(390,75.);
        b1.setOnAction(event -> this.setScene("New Game"));
        res.getChildren().add(b1);

        File continu = new File(chem+"continuerPartie.png");
        ImageView continuPartie = new ImageView();
        continuPartie.setImage(new Image(continu.toURI().toString()));

        Button b2 = new Button("Resume Game", continuPartie);
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

        res.setCenter(new ImageView(new Image(new File(chem+"connect4logo.png").toURI().toString())));
        res.setBottom(boutonsAccueil());
        return new Scene(res,850,650);
    }

    public String getRegle() {
        return "Connect 4 is a two-player dual game in which the players take turns dropping one colored disc from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column.\n\nThe objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs.";
    }
}
