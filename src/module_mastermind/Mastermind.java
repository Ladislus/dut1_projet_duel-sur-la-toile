package module_mastermind;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Mastermind extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        primaryStage.setTitle("Duel sur la toile - Mastermind");
        primaryStage.setScene(this.laScene());
        primaryStage.show();
    }

    public Scene laScene() {
        BorderPane res = new BorderPane();
//
        res.setLeft(this.gauche());
        res.setTop(this.titre());
//        res.setCenter(this.plateau());

        return new Scene(res, 850, 650);
    }

    public VBox  titre(){
        VBox res = new VBox(5);
        Label titre = new Label("Mastermind");
        res.getChildren().addAll(titre);
        res.setAlignment(Pos.CENTER);
        return res;
    }

    public VBox gauche(){
        VBox res = new VBox(5);
        Button quitter = new Button("Quitter");
        Label timer = new Label("Time : 00:00:00");
        Label couleurs = new Label("Couleurs : ");
        GridPane tabCouleurs = new GridPane();

        Circle jaune = new Circle(15);
        jaune.setFill(Color.YELLOW);

        Circle rouge = new Circle(15);
        rouge.setFill(Color.RED);

        Circle bleu = new Circle(15);
        bleu.setFill(Color.BLUE);

        Circle marron = new Circle(15);
        marron.setFill(Color.SADDLEBROWN);

        Circle vert = new Circle(15);
        vert.setFill(Color.FORESTGREEN);

        Circle cyan = new Circle(15);
        cyan.setFill(Color.CYAN);

        //gridpane.add(truc, colonne, ligne);
        tabCouleurs.add(jaune,0,0);
        tabCouleurs.add(rouge,1,0);
        tabCouleurs.add(bleu,2,0);
        tabCouleurs.add(marron,0,1);
        tabCouleurs.add(vert,1,1);
        tabCouleurs.add(cyan,2,1);
        tabCouleurs.setHgap(5);
        tabCouleurs.setVgap(5);

        res.getChildren().addAll(quitter,timer,couleurs,tabCouleurs);

        return res;
    }
//
}