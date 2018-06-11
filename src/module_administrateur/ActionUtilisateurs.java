package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionUtilisateurs implements EventHandler<ActionEvent> {

    PageAccueil pAccueil;

    public ActionUtilisateurs(PageAccueil pAccueil) {
        this.pAccueil = pAccueil;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageConnexion = (Stage) pAccueil.getbJoueur().getScene().getWindow();
        GererJoueur g = new GererJoueur();
        stageConnexion.close();
        g.start(new Stage());
    }
}
