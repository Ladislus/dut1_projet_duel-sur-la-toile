package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionRapport implements EventHandler<ActionEvent> {

    PageAccueil pAccueil;

    public ActionRapport(PageAccueil pAccueil) {
        this.pAccueil = pAccueil;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.pAccueil.getBp().setCenter(new VoirRapport(this.pAccueil));
    }
}
