package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionToEditerProfile implements EventHandler<ActionEvent> {

    Joueur joueur;

    Dashboard dashboard;

    Stage primaryStage;

    public ActionToEditerProfile(Stage primaryStage, Joueur joueur, Dashboard dashboard){
        this.joueur = joueur;

        this.dashboard = dashboard;
        
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageEditionProfile = new Stage();
        stageEditionProfile.setTitle("Edition de mon profile");
        stageEditionProfile.setResizable(false);
        stageEditionProfile.setScene(new Scene(new EditionProfil(primaryStage, joueur, dashboard), VariablesJoueur.DEFAULT_EDITERPROFILE_WIDTH, VariablesJoueur.DEFAULT_EDITERPROFILE_HEIGHT));
        stageEditionProfile.show();
    }
}
