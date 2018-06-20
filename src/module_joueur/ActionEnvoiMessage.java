package module_joueur;

import APIMySQL.APIMySQLException;
import APIMySQL.Message;
import APIMySQL.Utilisateur;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.rmi.CORBA.Util;

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
                Message.creerMessage(newMsg,this.messagerie.getUser().getId(),Utilisateur.getIdByPseudo(this.messagerie.getContactCour()));
            }
            catch (APIMySQLException e) {
                e.printStackTrace();
            }
            catch (NullPointerException e){
                e.printStackTrace();
            }

            this.messagerie.majMessages();
        }
    }
}
