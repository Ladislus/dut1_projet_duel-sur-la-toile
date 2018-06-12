package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionRetour implements EventHandler<ActionEvent> {

    PageAccueil pa;

    public ActionRetour(PageAccueil pa) {
        this.pa = pa;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.pa.getBp().setCenter(this.pa.constructB());
    }
}
