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

        if (this.partie.getListeBatons().get(next).nbJoueur == 0) {
            this.partie.getListeBatons().get(next).setSelect(jCour);
            this.partie.getPlateau().getListe21batons().set(next,jCour);
        }
        else {
            this.partie.getPlateau().getListe21batons().set(next,0);
            if (next == 0)
                this.partie.getListeBatons().get(next).setSelect(21);
            else
                this.partie.getListeBatons().get(next).setSelect(0);
        }

    }
}
