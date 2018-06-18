package module_21;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ActionSelectBaton implements EventHandler<MouseEvent> {

    private Partie21 partie;

    public ActionSelectBaton(Partie21 partie21) {
        this.partie = partie21;
    }

    @Override
    public void handle(MouseEvent event) {
        Batonnet bat = (Batonnet) event.getSource();
        int jCour = this.partie.getPlateau().getJCour();
        int next = this.partie.getPlateau().getListe21batons().getNext();

        if (bat.nbJoueur > 0){
            bat.setSelect(0);
            this.partie.removeBatonSelect();
            this.partie.getPlateau().getListe21batons().set((int) bat.getUserData(),0);
        }

        else if (this.partie.getListeBatons().get(next).nbJoueur == 0) {
            this.partie.getListeBatons().get(next).setSelect(jCour);
            this.partie.getPlateau().getListe21batons().set(next,jCour);
            this.partie.addBatonSelect();
        }
        else {
            this.partie.getPlateau().getListe21batons().set(next,0);
            if (next == 0)
                this.partie.getListeBatons().get(next).setSelect(21);
            else
                this.partie.getListeBatons().get(next).setSelect(0);
        }

        this.partie.getValider().setDisable(this.partie.getNbBatonsSelect()==0);

        // Si plus d'un Bâtonnet est sélectionné, le bouton Valider s'active


    }
}
