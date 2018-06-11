package module_mastermind;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
        res.setCenter(this.droite());

        return new Scene(res, 850, 850);
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

    public VBox droite(){
        VBox res = new VBox(10);

        for(int i=0; i<12;i++){
            HBox temp = new HBox(20);

            for(int k=0; k<4;k++){
                Circle cercleBleu = new Circle(25);
                cercleBleu.setFill(Color.DARKGREY);
                temp.getChildren().addAll(cercleBleu);
            }

            GridPane indices = new GridPane();

            Circle cercleIndice1 = new Circle(10);
            cercleIndice1.setFill(Color.BLACK);

            Circle cercleIndice2 = new Circle(10);
            cercleIndice2.setFill(Color.BLACK);

            Circle cercleIndice3 = new Circle(10);
            cercleIndice3.setFill(Color.BLACK);

            Circle cercleIndice4 = new Circle(10);
            cercleIndice4.setFill(Color.BLACK);

            indices.add(cercleIndice1,0,0);
            indices.add(cercleIndice2,1,0);
            indices.add(cercleIndice3,0,1);
            indices.add(cercleIndice4,1,1);

            indices.setHgap(5);
            indices.setVgap(5);

            temp.getChildren().addAll(indices);

            res.getChildren().addAll(temp);
        }

        return res;
    }

}