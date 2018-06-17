package module_mastermind;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class ActionMettreCouleur implements EventHandler<Event> {

    private PartieM mastermind;

    public ActionMettreCouleur(PartieM mastermind){
        this.mastermind = mastermind;
    }

    @Override
    public void handle(Event event){
        Circle cercle = (Circle)event.getSource();
        Integer intCouleur;
        intCouleur = (int) cercle.getUserData();
        PlateauM plateauM = this.mastermind.getPlateau();
        Combinaison combCour = plateauM.getCombiCour();

        combCour.addPion(intCouleur);

        this.mastermind.majAffichage();
    }
}
