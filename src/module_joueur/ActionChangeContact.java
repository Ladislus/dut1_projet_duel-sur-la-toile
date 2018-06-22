package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ActionChangeContact implements EventHandler<ActionEvent> {

    private final Messagerie messagerie;

    /**
     Constructeur d'un changement de contact
     @param messagerie : La page de messagerie à propager
    */
    ActionChangeContact(Messagerie messagerie) {
        this.messagerie = messagerie;
    }

    /**
     Permet le changement du contact affiché à l'écran dans la messagerie
     @param actionEvent : Un ActionEvent contenant l'action
    */
    @Override
    public void handle(ActionEvent actionEvent) {

        Button source = (Button) actionEvent.getSource();

        String nouvContact = (String) source.getUserData();

        this.messagerie.setNomContactCour(nouvContact);
        this.messagerie.majMessages(); }}
