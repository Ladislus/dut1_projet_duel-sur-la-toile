package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionToMessagerie implements EventHandler<ActionEvent> {

    private Joueur joueur;

    /**
     Le controlleur permettant d'ouvrir la messagerie
     @param joueur : Le joueur courant
    */
    ActionToMessagerie(Joueur joueur) { this.joueur = joueur; }

    /**
     Créer une nouvelle page et y affiche la messagerie
     @param event : L'ActionEvent contenant l'action
    */
    @Override
    public void handle(ActionEvent event) {

        Stage messagerie = new Stage();

        messagerie.setScene(new Scene(new Messagerie(this.joueur), VariablesJoueur.DEFAULT_APPLICATION_WIDTH, VariablesJoueur.DEFAULT_APPLICATION_HEIGHT));
        messagerie.show(); }}
