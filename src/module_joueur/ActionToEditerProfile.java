package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionToEditerProfile implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageEditionProfile = new Stage();
        stageEditionProfile.setTitle("Edition de mon profile");
        stageEditionProfile.setScene(new Scene(new EditionProfil(), VariablesJoueur.DEFAULT_EDITERPROFILE_WIDTH, VariablesJoueur.DEFAULT_EDITERPROFILE_HEIGHT));
        stageEditionProfile.show();
    }
}
