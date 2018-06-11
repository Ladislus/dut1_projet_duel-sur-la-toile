package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionRapport implements EventHandler<ActionEvent> {

    PageAccueil pAccueil;

    public ActionRapport(PageAccueil pAccueil) {
        this.pAccueil = pAccueil;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageConnexion = (Stage) pAccueil.getbJoueur().getScene().getWindow();
        VoirRapport v = new VoirRapport();
        stageConnexion.close();
        v.start(new Stage());
    }
}
