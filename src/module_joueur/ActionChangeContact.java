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
<<<<<<< HEAD

        String nouvContact = source.getText();

        if (nouvContact == "ACCUEIL")
            nouvContact = "ACC";

=======
        String nouvContact = (String) source.getUserData();
>>>>>>> da1c5cdae2f37d3d93c2c9c22e98d1c53cf1473e
        this.messagerie.setNomContactCour(nouvContact);
        this.messagerie.majMessages(); }}