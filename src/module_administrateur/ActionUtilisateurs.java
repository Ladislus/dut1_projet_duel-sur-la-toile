package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionUtilisateurs implements EventHandler<ActionEvent> {

    private Stage primaryStage;

    public ActionUtilisateurs(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ((PageAccueil) this.primaryStage.getScene().getRoot()).getBp().setCenter(new GererJoueur(this.primaryStage));
    }
}
