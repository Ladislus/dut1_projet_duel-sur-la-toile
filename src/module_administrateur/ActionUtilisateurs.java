package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionUtilisateurs implements EventHandler<ActionEvent> {

    PageAccueil pa;

    public ActionUtilisateurs(PageAccueil pa) {
        this.pa = pa;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.pa.getBp().setCenter(new GererJoueur(this.pa));
    }
}
