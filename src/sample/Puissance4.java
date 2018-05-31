package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Puissance4 extends Application {

    private Plateau p; // Modèle du jeu

    @Override
    public void start(Stage primaryStage) throws Exception{

        p = new Plateau("Bernard","xX-Dark-Xx");

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Duel sur la toile - Connect 4");
        primaryStage.setScene(this.laScene());
        primaryStage.show();
    }

    public Scene laScene() {
        BorderPane res = new BorderPane();

        res.setLeft(this.menu());
        res.setBottom(this.bas());
        res.setCenter(this.plateau());

        return new Scene(res, 850, 650);
    }

    public GridPane plateau() {
        GridPane res = new GridPane();

        return res;
    }

    public HBox bas() {
        HBox res = new HBox();
        res.setAlignment(Pos.CENTER);
        res.setSpacing(20.);
        res.setPadding(new Insets(10,0,30,0));

        HBox j1 = new HBox();
        j1.setPrefWidth(300.);
        j1.getChildren().addAll(p.getJ(1), new Circle(20., Color.RED));
        j1.setSpacing(10.);
        j1.setAlignment(Pos.CENTER_RIGHT);

        HBox j2 = new HBox();
        j2.setPrefWidth(300.);
        j2.getChildren().addAll(new Circle(20., Color.YELLOW),p.getJ(2));
        j2.setSpacing(10.);
        j2.setAlignment(Pos.CENTER_LEFT);

        res.getChildren().addAll(j1,j2);

        return res;
    }

    public VBox menu() {
        VBox res = new VBox();
        res.setAlignment(Pos.BOTTOM_LEFT);
        res.setPadding(new Insets(5,5,30,5));
        res.setSpacing(20.);

        Button save = new Button("Save Game");
        save.setStyle("-fx-background-color: #FFA500;");
        save.setPrefWidth(95.);

        Button forfait = new Button("Forfait");
        forfait.setStyle("-fx-background-color: #E00000;");
        forfait.setPrefWidth(95.);


        res.getChildren().addAll(save,forfait);
        return res;
    }

    public void majAffichage(){

    }


    public static void main(String[] args) {launch(args);}
}
