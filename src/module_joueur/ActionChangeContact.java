package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


/**
 * Controleur du changement de contact dans la messagerie
 */
public class ActionChangeContact implements EventHandler<ActionEvent> {

    private final Messagerie messagerie;

    public ActionChangeContact(Messagerie messagerie) {
        this.messagerie = messagerie;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button source = (Button) actionEvent.getSource();
        String nouvContact = (String) source.getUserData();
        this.messagerie.setNomContactCour(nouvContact);
        this.messagerie.majMessages();
    }
}
