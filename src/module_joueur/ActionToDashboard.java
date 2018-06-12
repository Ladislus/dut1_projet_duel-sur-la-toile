package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionToDashboard implements EventHandler<ActionEvent> {
    InscriptionJoueur inscriptionJoueur;

    public ActionToDashboard(InscriptionJoueur inscriptionJoueur){
        this.inscriptionJoueur=inscriptionJoueur;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
/*        Stage stageInscription = (Stage) inscriptionJoueur.getBtDashboard().getScene().getWindow();
        stageInscription.close();
        Dashboard cj = new Dashboard();
        cj.start(new Stage());*/
    }

}