package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ActionBoutonsAccueil implements EventHandler<ActionEvent> {
    // Contrôleur des boutons de l'accueil.

    private Mastermind mastermind;

    public ActionBoutonsAccueil(Mastermind mastermind) {
        this.mastermind = mastermind;
    }

    /**
     * Méthode appelée lors de l'utilisation du controlleur, permet de changer de scène
     * @param actionEvent un ActionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        this.mastermind.setScene("");
    }
}
