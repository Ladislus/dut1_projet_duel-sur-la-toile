package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionToAjouterAmi implements EventHandler<ActionEvent> {

    public ActionToAjouterAmi(){

    }


    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageEditionProfile = new Stage();
        stageEditionProfile.setTitle("Ajout d'un ami");
        stageEditionProfile.setResizable(false);
        stageEditionProfile.setScene(new Scene(new AjoutAmi(), VariablesJoueur.DEFAULT_EDITERPROFILE_WIDTH, VariablesJoueur.DEFAULT_EDITERPROFILE_HEIGHT));
        stageEditionProfile.show();
    }
}
