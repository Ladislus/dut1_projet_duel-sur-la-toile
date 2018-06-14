package module_mastermind;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;

public class ActionSupprimerCouleur implements EventHandler<Event> {

    private PartieM mastermind;

    public ActionSupprimerCouleur(PartieM mastermind){
        this.mastermind = mastermind;
    }

    @Override
    public void handle(Event event){
        Circle cercle = (Circle)event.getSource();
        Plateau plateau = this.mastermind.getPlateau();
        int pos = (int)cercle.getUserData();
        Combinaison combCour = plateau.getCombiCour();
        if (combCour.get(pos) != 0){
            combCour.set(pos,0);
            System.out.println(combCour);
        }
        this.mastermind.majAffichage();
    }
}
