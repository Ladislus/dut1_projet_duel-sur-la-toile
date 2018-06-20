package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ActionChangeContact implements EventHandler<ActionEvent> {

    private final Messagerie messagerie;

    public ActionChangeContact(Messagerie messagerie) {
        this.messagerie = messagerie;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Button source = (Button) actionEvent.getSource();

        String nouvContact = source.getText();

        if (nouvContact == "ACCUEIL")
            nouvContact = "ACC";

        this.messagerie.setNomContactCour(nouvContact);
        this.messagerie.majMessages(); }}