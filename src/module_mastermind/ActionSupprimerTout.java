package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ActionSupprimerTout implements EventHandler<ActionEvent> {

    private PartieM mastermind;

    public ActionSupprimerTout(PartieM mastermind){
        this.mastermind = mastermind;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Plateau plateau = this.mastermind.getPlateau();
        Combinaison combCour = plateau.getCombiCour();
        for (int i = 0; i < 4; i++){
            combCour.set(i,0);
        }
        this.mastermind.majAffichage();
    }
}
