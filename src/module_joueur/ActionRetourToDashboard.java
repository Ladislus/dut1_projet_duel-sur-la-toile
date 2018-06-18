package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ActionRetourToDashboard implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {

        Button btRetour = (Button) actionEvent.getSource();
        Stage EditionProfile = (Stage) btRetour.getScene().getWindow();
        
        EditionProfile.close(); }}
