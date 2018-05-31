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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.EventListener;


public class Puissance4 extends Application {

    private Plateau p; // Modèle du jeu

    private GridPane tab; // Le tableau de pion

    @Override
    public void start(Stage primaryStage) throws Exception{

        p = new Plateau("Bernard","xX-Dark-Xx");

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Duel sur la toile - Connect 4");
        primaryStage.setScene(this.laScene());
        primaryStage.show();
    }

    public Scene laScene() {
        BorderPane res = new BorderPane();

        res.setLeft(this.menu());
        res.setBottom(this.bas());
        res.setTop(this.haut());
        res.setRight(this.indic());
        res.setCenter(this.plateau());

        return new Scene(res, 850, 650);
    }

    public VBox menu() {
        VBox res = new VBox();
        res.setAlignment(Pos.BOTTOM_LEFT);
        res.setPadding(new Insets(5,5,30,5));
        res.setSpacing(20.);
        res.setPrefWidth(160.);

        Button save = new Button("Save Game");

        String saveNormal = "-fx-background-color: linear-gradient(#F0E000,#FFA500);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";
        String saveHover = "-fx-background-color: linear-gradient(#ffFF80, #ffFF80);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";

        save.setStyle(saveNormal);
        save.setOnMouseEntered(e -> save.setStyle(saveHover));
        save.setOnMouseExited(e -> save.setStyle(saveNormal));
        save.setPrefWidth(115.);

        Button forfait = new Button("Forfait");

        String forfaitNormal = "-fx-background-color: linear-gradient(#FF4d40,#f02020);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";
        String forfaitHover = "-fx-background-color: linear-gradient(#ff8d80, #ff8d80);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";

        forfait.setStyle(forfaitNormal);
        forfait.setOnMouseEntered(e -> forfait.setStyle(forfaitHover));
        forfait.setOnMouseExited(e -> forfait.setStyle(forfaitNormal));
        forfait.setPrefWidth(115.);


        res.getChildren().addAll(save,forfait);
        return res;
    }

    public VBox indic() {
        VBox res = new VBox();
        res.setPrefWidth(160.);

        return res;
    }

    private HBox haut() {
        HBox res = new HBox();
        res.setPrefHeight(100.);
        res.setAlignment(Pos.CENTER_LEFT);

        File file = new File("./img/connect4logo.png");
        Image im = new Image(file.toURI().toString());
        ImageView iv = new ImageView(im);
        iv.setPreserveRatio(true);
        iv.setFitHeight(60);
        res.getChildren().addAll(iv);

        return res;
    }

    public HBox bas() {
        HBox res = new HBox();
        res.setAlignment(Pos.CENTER);
        res.setSpacing(20.);
        res.setPadding(new Insets(30,0,30,0));
        res.setPrefHeight(100.);

        HBox j1 = new HBox();
        j1.setPrefWidth(300.);
        Circle cercle = new Circle(20.,Color.RED);
        cercle.setStroke(Paint.valueOf("black"));
        j1.getChildren().addAll(p.getJ(1), cercle);
        j1.setSpacing(10.);
        j1.setAlignment(Pos.CENTER_RIGHT);

        HBox j2 = new HBox();
        j2.setPrefWidth(300.);
        Circle cercle2 = new Circle(20.,Color.valueOf("FFE000"));
        cercle2.setStroke(Paint.valueOf("black"));
        j2.getChildren().addAll(cercle2,p.getJ(2));
        j2.setSpacing(10.);
        j2.setAlignment(Pos.CENTER_LEFT);

        res.getChildren().addAll(j1,j2);

        return res;
    }

    public VBox plateau() {
        VBox res = new VBox();

        // LIGNE DE BOUTONS POUR SÉLECTIONNER UNE COLONNE

        File file1 = new File("./img/boutColDesactive.png");
        File file2 = new File("./img/boutColActive.png");

        HBox ligneBoutons = new HBox();
        ligneBoutons.setSpacing(23.);
        ligneBoutons.setAlignment(Pos.CENTER);
        for (int c=0;c<7;c++){
            ImageView imDesactive = new ImageView(new Image(file1.toURI().toString()));
            imDesactive.setPreserveRatio(true);
            imDesactive.setFitWidth(25.);

            ImageView imActive = new ImageView(new Image(file2.toURI().toString()));
            imActive.setPreserveRatio(true);
            imActive.setFitWidth(25.);

            Button b = new Button("",imDesactive);
            b.setUserData(c);
            b.setOnMouseEntered(e -> b.setGraphic(imActive));
            b.setOnMouseExited(e -> b.setGraphic(imDesactive));
            b.setStyle("-fx-background-color: transparent;");
            b.setOnAction(new ActionJouerCol(this));
            ligneBoutons.getChildren().add(b);
        }

        // TABLEAU DU PLATEAU

        tab = new GridPane();
        tab.setStyle("-fx-background-color: #4F7EFF;" +
                     "-fx-border-width: 2px;" +
                     "-fx-border-color: black;" +
                     "-fx-background-radius: 30px 30px 0 0;" +
                     "-fx-border-radius: 30px 30px 0 0;");
        tab.setAlignment(Pos.CENTER);
        tab.setHgap(15.);
        tab.setVgap(15.);
        tab.setPadding(new Insets(0,0,10,0));

        for (int c=0;c<7;c++){
            for (int l=0;l<6;l++){
                Circle cercle = new Circle(25.,Color.LIGHTGREY);
                cercle.setStroke(Paint.valueOf("black"));
                tab.add(cercle,c,l+1);
            }
        }

        res.getChildren().addAll(ligneBoutons,tab);
        return res;
    }

    public Plateau getPlateau() {
        return p;
    }

    public GridPane getTab(){
        return tab;
    }


    public void majAffichage(){
//        for (int c=0;c<7;c++){
//            for (int l=0;l<6;l++){
//                if (this.getPlateau().getPion(l,c)==1){this.getTab().get
//            }
//        }
    }


    public static void main(String[] args) {launch(args);}
}
