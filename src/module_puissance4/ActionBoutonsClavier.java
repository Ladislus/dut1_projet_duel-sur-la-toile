package module_puissance4;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class ActionBoutonsClavier implements EventHandler<KeyEvent> {

    private PartieP4 jeu;

    public ActionBoutonsClavier(PartieP4 puissance4) {
        this.jeu = puissance4;
    }


    @Override
    public void handle(KeyEvent event) {
        KeyCode touche = event.getCode();
        int numBout = (int) this.jeu.getBoutActiv().getUserData();
        if (touche == KeyCode.Q && numBout > 0){ // On change le bouton activé vers la gauche, dans la couleur du joueur courant
            this.jeu.setBoutActiv(this.jeu.getListeBoutons().get(numBout-1));
            this.jeu.majBoutons(numBout);
        }
        else if (touche == KeyCode.D && numBout < 6){ // On change le bouton activé vers la droite
            this.jeu.setBoutActiv(this.jeu.getListeBoutons().get(numBout+1));
            this.jeu.majBoutons(numBout);
        }
        else if (touche == KeyCode.M && this.jeu.getPlateauP4().getCol(numBout).isNotFull()){ // On ajoute un pion avec '*'
            int lig = jeu.getPlateauP4().jouerUnCoup(numBout);
            this.jeu.majAffichage(lig,numBout);
            this.jeu.getPlateauP4().changeJCour();
        }
    }
}
