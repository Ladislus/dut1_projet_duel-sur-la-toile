package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ActionQuitter implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent a){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmer l'arrêt");
        alert.setHeaderText("Quitter la partie");
        alert.setContentText("Voulez vous vraiment quitter la partie ?");
        alert.showAndWait();
//        alert.getButtonTypes().get(1)
    }
}
