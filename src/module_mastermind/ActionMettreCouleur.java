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
        Paint paint = cercle.getFill();
        Integer intCouleur = 0;
        if (paint == Color.YELLOW){
            intCouleur = 1;
        }
        else if (paint == Color.RED){
            intCouleur = 2;
        }
        else if (paint == Color.BLUE){
            intCouleur = 3;
        }
        else if (paint == Color.SADDLEBROWN){
            intCouleur = 4;
        }
        else if (paint == Color.FORESTGREEN){
            intCouleur = 5;
        }
        else{
            intCouleur = 6;
        }
        PlateauM plateauM = this.mastermind.getPlateau();
        Combinaison combCour = plateauM.getCombiCour();

        combCour.addPion(intCouleur);

        this.mastermind.majAffichage();
    }
}
