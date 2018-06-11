package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionRetour implements EventHandler<ActionEvent> {

    VoirRapport vRapport;
    GererJoueur gJoueur;
    String pageActuelle;

    public ActionRetour(VoirRapport vRapport) {
        this.vRapport = vRapport;
        this.pageActuelle = "VoirRapport";
    }

    public ActionRetour(GererJoueur gJoueur) {
        this.gJoueur = gJoueur;
        this.pageActuelle = "GererJoueur";
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageConnexion;
        if (this.pageActuelle.equals("VoirRapport")) {
            stageConnexion = (Stage) this.vRapport.getbRetour().getScene().getWindow();

        }
        else {
            stageConnexion = (Stage) this.gJoueur.getbRetour().getScene().getWindow();
        }
        PageAccueil pa = new PageAccueil();
        stageConnexion.close();
        pa.start(new Stage());
    }
}
