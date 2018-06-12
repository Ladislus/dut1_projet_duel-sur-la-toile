package module_mastermind;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;


public class Mastermind extends Application {

    private Stage primaryStage;
    public static String chem = "./img/module_mastermind/";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        primaryStage.setTitle("Duel sur la toile - Mastermind");
        primaryStage.setScene(this.pageAccueil());
        primaryStage.show();
    }

    public void setScene(int n){
        if (n==1)
            primaryStage.setScene(pageAccueil());
        else if (n==2)
            primaryStage.setScene(new PartieM("j1").getScene());
    }

    public HBox boutonsAccueil() {
        HBox res = new HBox();
        ActionBoutonsAccueil handler = new ActionBoutonsAccueil(this);
        Font bouton = Font.font("Verdana",FontWeight.BOLD,25);

        File imageami = new File(chem+"jouerAmi.png");
        ImageView ami = new ImageView();
        ami.setImage(new Image(imageami.toURI().toString()));

        Button b1 = new Button("Duel contre un ami",ami);
        b1.setFont(bouton);
        b1.setContentDisplay(ContentDisplay.TOP);
        b1.setPrefSize(390,75.);
        b1.setOnAction(handler);
        res.getChildren().add(b1);

        File continu = new File(chem+"continuerPartie.png");
        ImageView continuPartie = new ImageView();
        continuPartie.setImage(new Image(continu.toURI().toString()));

        Button b2 = new Button("Reprendre", continuPartie);
        b2.setFont(bouton);
        b2.setContentDisplay(ContentDisplay.TOP);
        b2.setPrefSize(390,75.);
        b2.setOnAction(handler);
        res.getChildren().add(b2);

        res.setAlignment(Pos.CENTER);
        res.setSpacing(25);
        res.setPadding(new Insets(0,0,40,0));
        return res;
    }

    public Scene pageAccueil(){
        BorderPane res = new BorderPane();
        res.setCenter(new ImageView(new Image(new File(chem+"mastermind_logo1.png").toURI().toString())));

        res.setBottom(boutonsAccueil());
        return new Scene(res,850,650);
    }
}

