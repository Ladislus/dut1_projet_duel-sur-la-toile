package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionSupprRapport implements EventHandler<ActionEvent> {

    VoirRapport rapp;
    Administration a;

    public ActionSupprRapport(VoirRapport rapp, Administration a) {
        this.rapp = rapp;
        this.a = a;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.a.supprimerRapport(this.a.getRapportLu());
    }
}
