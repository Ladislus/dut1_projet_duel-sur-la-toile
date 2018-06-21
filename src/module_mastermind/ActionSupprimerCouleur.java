package module_mastermind;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;

public class ActionSupprimerCouleur implements EventHandler<Event> {

    private PartieM mastermind;

    /**
     * Constructeur du controlleur
     * @param mastermind une PartieM
     */
    public ActionSupprimerCouleur(PartieM mastermind){
        this.mastermind = mastermind;
    }

    /**
     * Méthode appelée lors de l'utilisation du controlleur, permet de supprimer une couleur dans la combinaison courante
     * @param event un Event
     */
    @Override
    public void handle(Event event){
        Circle cercle = (Circle)event.getSource();
        PlateauM plateauM = this.mastermind.getPlateau();
        int pos = (int)cercle.getUserData();
        Combinaison combCour = plateauM.getCombiCour();
        if (combCour.get(pos) != 0){
            combCour.set(pos,0);
        }
        this.mastermind.majAffichage();
    }
}
