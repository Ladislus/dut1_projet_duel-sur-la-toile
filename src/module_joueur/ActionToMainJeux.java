package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ActionToMainJeux implements EventHandler<MouseEvent>{

    Stage primaryStage;
    Jeu jeu;


    public ActionToMainJeux(Stage primaryStage, Jeu jeu){
        this.primaryStage = primaryStage;
        this.jeu = jeu;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        Stage stageMainJeux = new Stage();
        stageMainJeux.setTitle(jeu.getTitle());
        stageMainJeux.setResizable(false);
        stageMainJeux.setScene(new Scene(new MainJeux(primaryStage, jeu), 600, 400));
        stageMainJeux.show();
    }
}
