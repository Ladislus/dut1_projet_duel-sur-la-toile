package module_mastermind;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class ActionMettreCouleur implements EventHandler<Event> {

    private PartieM mastermind;

    /**
     * Constructeur du controlleur
     * @param mastermind une PartieM
     */
    public ActionMettreCouleur(PartieM mastermind){
        this.mastermind = mastermind;
    }

    /**
     * Méthode appelée lors de l'utilisation du controlleur, permet de mettre une couleur dans la combinaison courante,
     * à la position libre la plus à gauche possible
     * @param event un Event
     */
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
