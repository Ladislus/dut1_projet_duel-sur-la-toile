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
//        res.setLeft(this.menu());
        res.setTop(this.titre());
//        res.setCenter(this.plateau());

        return new Scene(res, 850, 650);
    }

    public VBox  titre(){
        VBox res = new VBox(5);
        Label titre = new Label("Mastermind");
        res.getChildren().add(titre);
        res.setAlignment(Pos.CENTER);
        return res;
    }

    public VBox gauche(){
        VBox res = new VBox(5);
        Button quitter = new Button("Quitter");
        Label timer = new Label("Time : 00:00:00");
        Label couleurs = new Label("Couleurs : ");
        GridPane tabCouleurs = new GridPane();
        Circle jaune = new Circle(5, Color.YELLOW);

        return res;
    }

}