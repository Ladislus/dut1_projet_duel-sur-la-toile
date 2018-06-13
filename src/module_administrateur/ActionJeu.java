package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionJeu implements EventHandler<ActionEvent> {

    PageAccueil pAccueil;

    public ActionJeu(PageAccueil pAccueil) {
        this.pAccueil = pAccueil;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.pAccueil.getBp().setCenter(new GererJeu(this.pAccueil));
    }
}
