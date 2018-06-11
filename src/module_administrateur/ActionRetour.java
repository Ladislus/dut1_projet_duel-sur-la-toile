package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionRetour implements EventHandler<ActionEvent> {

    GererJoueur gererJoueur;
    VoirRapport voirRapport;

    public ActionRetour(GererJoueur gererJoueur) {
        this.gererJoueur = gererJoueur;
    }

    public ActionRetour(VoirRapport voirRapport) {
        this.voirRapport = voirRapport;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageConnexion = (Stage) gererJoueur.getbRetour().getScene().getWindow();
        PageAccueil a = new PageAccueil();
        stageConnexion.close();
        a.start(new Stage());
    }

}
