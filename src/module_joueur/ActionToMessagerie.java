package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionToMessagerie implements EventHandler<ActionEvent> {

    Joueur joueur;

    public ActionToMessagerie(Joueur joueur) {
        this.joueur = joueur;
    }

    public void handle(ActionEvent event) {

        Stage messagerie = new Stage();
        messagerie.setAlwaysOnTop(true);

        messagerie.setScene(new Scene(new Messagerie(joueur), VariablesJoueur.DEFAULT_APPLICATION_WIDTH, VariablesJoueur.DEFAULT_APPLICATION_HEIGHT));
        messagerie.show(); }}
