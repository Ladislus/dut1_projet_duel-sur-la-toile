package module_joueur;

import APIMySQL.APIMySQLException;
import APIMySQL.Message;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ActionEnvoiMessage implements EventHandler<KeyEvent> {
    private final Messagerie messagerie;

    public ActionEnvoiMessage(Messagerie messagerie) {
        this.messagerie = messagerie;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            String newMsg = this.messagerie.getBarreText();

            try {
                Message.creerMessage(newMsg,this.messagerie.getUser().getId(),this.messagerie.getContactCour().getId());
            }
            catch (APIMySQLException e) {
                e.printStackTrace();
            }

            this.messagerie.majMessages();
        }
    }
}
