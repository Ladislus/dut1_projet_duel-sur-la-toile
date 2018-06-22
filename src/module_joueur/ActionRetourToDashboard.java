package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionRetourToDashboard implements EventHandler<ActionEvent> {

    private Stage secondaryStage;

    /**
     Controlleur permettant le retour au Dashboard
     @param secondaryStage : La page principale à propager
    */
    ActionRetourToDashboard(Stage secondaryStage) {

        this.secondaryStage = secondaryStage; }


    @Override
    public void handle(ActionEvent actionEvent) { this.secondaryStage.close(); }}
