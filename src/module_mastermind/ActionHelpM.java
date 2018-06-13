package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

public class ActionHelpM implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aide");
        alert.setHeaderText("Comment jouer au Mastermind ?");
        alert.setContentText("Le but du Mastermind est de trouver la combinaison choisie par l'adversaire le plus vite possible. \n uytuyxfgfgkjfdgfdfh"); //TODO mettre les règles du Mastermind ici
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.showAndWait();
    }
}
