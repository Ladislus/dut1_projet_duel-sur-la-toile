package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Contrôleur du chronomètre
 */
public class ActionTemps implements EventHandler<ActionEvent> {

    private long tempsEcoule;

    private Chronometre chrono;

    /**
     * Constructeur du controlleur
     * @param chrono un Chronometre
     */
    ActionTemps (Chronometre chrono){
        this.chrono = chrono;
    }

    /**
     * Méthode appelée lors de l'utilisation du controlleur, permet de décrémenter le timer
     * @param actionEvent un ActionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        this.tempsEcoule+=1;
        this.chrono.setTime(tempsEcoule);
    }

    /**
     * Méthode appelée lors de la méthode de la classe Chronometre resetTime()
     */
    public void reset(){
        this.chrono.setTime(0);
        this.tempsEcoule = 0;
    }
}