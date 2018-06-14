package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ActionBoutonsAccueil implements EventHandler<ActionEvent> {
    // Contrôleur des boutons de l'accueil.

    private Mastermind mastermind;

    public ActionBoutonsAccueil(Mastermind mastermind) {
        this.mastermind = mastermind;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        mastermind.setScene(2);
    }
}
