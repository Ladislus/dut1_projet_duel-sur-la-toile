package module_puissance4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;

public class Puissance4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public static String chem = "./img/module_puissance4/";

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        primaryStage.setResizable(false);
        primaryStage.setTitle("Duel sur la toile - Connect 4");
        primaryStage.setScene(this.pageAccueil());
        primaryStage.show();
    }

    public void setScene(int n){
        if (n==1)
            primaryStage.setScene(pageAccueil());
        else if (n==2)
            primaryStage.setScene(new Partie().getScene());
    }

    public HBox boutonsAccueil(String[] boutons){
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
