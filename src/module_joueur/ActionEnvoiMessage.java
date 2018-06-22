package module_joueur;

import APIMySQL.APIMySQLException;
import APIMySQL.Message;
import APIMySQL.Utilisateur;

import javafx.event.EventHandler;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ActionEnvoiMessage implements EventHandler<KeyEvent> {

    private final Messagerie messagerie;

    /**
     Le controlleur permettant l'envoie des messages dans la BD
     @param messagerie : La page de messagerie à propager
    */
    ActionEnvoiMessage(Messagerie messagerie) { this.messagerie = messagerie; }

    /**
     Fcontion permettant l'envoi du message dans la BD
     @param keyEvent : Le KeyEvent contenant la touche appuyé et l'action
    */
    @Override
    public void handle(KeyEvent keyEvent) {

        //Si la touche appuyé est ENTRER
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {

            //Récupère le message dans la barre
            String newMsg = this.messagerie.getBarreText();

            if (newMsg.length() > 0) {

                this.messagerie.getBarre().clear();
                this.messagerie.ajouteMessage(newMsg);

                try { Message.creerMessage(newMsg, this.messagerie.getUser().getId(), Utilisateur.getIdByPseudo(this.messagerie.getContactCour())); }
                catch (APIMySQLException | NullPointerException e) { e.printStackTrace(); }}}}}
