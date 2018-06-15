package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionJeu implements EventHandler<ActionEvent> {

    PageAccueil pa;

    public ActionJeu(PageAccueil pa) {
        this.pa = pa;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.pa.getBp().setCenter(new GererJeu(this.pa));
    }
}
