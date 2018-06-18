package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Contrôleur du chronomètre
 */
public class ActionTemps implements EventHandler<ActionEvent> {

    private long tempsEcoule;

    private Chronometre chrono;

    ActionTemps (Chronometre chrono){
        this.chrono = chrono;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.tempsEcoule+=1;
        this.chrono.setTime(tempsEcoule);
    }

    public void reset(){
        this.chrono.setTime(0);
        this.tempsEcoule = 0;
    }
}