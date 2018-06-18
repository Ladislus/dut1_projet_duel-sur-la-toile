package module_puissance4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Controleur de l'ajout d'un pion dans une colonne
 */
public class ActionJouerCol implements EventHandler<ActionEvent> {

    private PartieP4 jeu;

    public ActionJouerCol(PartieP4 puissance4) {
        this.jeu = puissance4;
    }

    /**
     * Ajoute le pion au bon ednroit en fonction du bouton (et donc de la colonne) qui a été actionné
     * Met à jour l'affichage
     * Change de joueur courant
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        Button source = (Button) actionEvent.getSource();
        int col = (int) source.getUserData();
        int lig = jeu.getPlateauP4().jouerUnCoup(col);
        this.jeu.majAffichage(lig,col);
        this.jeu.getPlateauP4().changeJCour();
    }
}
