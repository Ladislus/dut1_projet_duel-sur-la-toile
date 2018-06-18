package module_joueur;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class MainJeux extends VBox {

    String title;
    public MainJeux(Stage primaryStage){
        super();

        this.title = "Minecraft";
        this.getChildren().add(creerHeader());
        //this.getChildren().add(creerDescription());
        //this.getChildren().add(creerCoverFlow());
    }

    public VBox creerHeader(){
        VBox vPrincipal = new VBox();
        File fileImageJeux = new File("");
        ImageView ivImageJeux = new ImageView();
        ivImageJeux.setImage(new Image(fileImageJeux.toURI().toString()));
        ivImageJeux.setPreserveRatio(true);
        ivImageJeux.setFitWidth(50);
        Label lbJeux = new Label(title);
        //Button btLauch


        return vPrincipal;
    }
}
