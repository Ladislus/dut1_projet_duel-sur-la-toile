package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ActionQuitterM implements EventHandler<ActionEvent> {

    private Mastermind mastermind;

    /**
     * Constructeur du controlleur
     * @param mastermind un Mastermind
     */
    public ActionQuitterM(Mastermind mastermind){
        this.mastermind=mastermind;
    }

    /**
     * Méthode appelée lors de l'utilisation du controlleur, permet de quitter le jeu, avec une pop-up de confirmation
     * @param  actionEvent un ActionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmer l'arrêt");
        alert.setHeaderText("Quitter la partie");
        alert.setContentText("Voulez vous vraiment quitter la partie ?");
        Optional<ButtonType> result = alert.showAndWait();
        ButtonType button = result.orElse(ButtonType.CANCEL);

        if (button == ButtonType.OK) {
            this.mastermind.exit();
        }
    }
}
