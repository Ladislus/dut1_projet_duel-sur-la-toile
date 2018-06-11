package module_mastermind;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    public static String chem = "./img/module_puissance4/";

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
            primaryStage.setScene(new PartieM().getScene());
    }

    public HBox boutonsAccueil(String[] boutons) {
        HBox res = new HBox();
        ActionBoutonsAccueil handler = new ActionBoutonsAccueil(this);
        for (String s:boutons){
            Button temp = new Button(s);
            temp.setOnAction(handler);
            res.getChildren().add(temp);
        }
        res.setAlignment(Pos.CENTER);
        res.setSpacing(25);
        return res;
    }

    public Scene pageAccueil(){
        BorderPane res = new BorderPane();
        res.setCenter(new ImageView(new Image(new File(chem+"connect4logo.png").toURI().toString())));
        String[] boutons = {"Duel aléatoire","Duel contre un ami","Reprendre"};
        res.setBottom(boutonsAccueil(boutons));
        return new Scene(res);
    }

}