package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionRetour implements EventHandler<ActionEvent> {

    VoirRapport vRapport;
    GererJoueur gJoueur;
    VoirStatistiques vStat;
    ProfilJoueur pJoueur;
    PageAccueil pa;
    String pageActuelle;

    @Override
    public void handle(ActionEvent actionEvent) {
        this.pa.getBp().setCenter(this.pa.constructB());
    }
}
