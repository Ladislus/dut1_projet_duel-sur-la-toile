package module_joueur;

import module_administrateur.PageAccueil;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionToAdmin implements EventHandler<ActionEvent> {

    /**
     Controlleur permettant l'acces au module administrateur
     */
    ActionToAdmin() {}

    /**
     Création d'une nouvelle fenêtre contenant le
     module administrateur
     @param actionEvent : L'actionEvent contenant l'action
    */
    @Override
    public void handle(ActionEvent actionEvent) {

        Stage secondaryStage = new Stage();

        PageAccueil pageAccueil = new PageAccueil(secondaryStage);

        secondaryStage.setTitle(pageAccueil.getTitle());
        secondaryStage.setScene(new Scene(pageAccueil, 650, 450));
        secondaryStage.show(); }}

