package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ActionHelpM implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aide");
        alert.setHeaderText("Comment jouer au Mastermind ?");
        alert.setContentText(""); //TODO mettre les règles du Mastermind ici
        alert.showAndWait();
    }
}
