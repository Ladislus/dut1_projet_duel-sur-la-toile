package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ActionJouerCombi implements EventHandler<ActionEvent> {

    private PartieM mastermind;

    public ActionJouerCombi(PartieM mastermind){
        this.mastermind = mastermind;
    }

    @Override
    public void handle(ActionEvent actionEvent){

    }
}
