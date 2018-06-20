package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ActionRejouer implements EventHandler<ActionEvent> {

    private PartieM mastermind;

    /**
     * Constructeur de ActionRejouer
     * @param m une PartieM
     */
    public ActionRejouer(PartieM m) {
        super();
        this.mastermind = m;
        }

    @Override
    public void handle(ActionEvent actionEvent){

    }
}
