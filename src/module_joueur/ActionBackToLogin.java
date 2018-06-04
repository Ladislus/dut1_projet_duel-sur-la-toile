package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionBackToLogin implements EventHandler<ActionEvent>{

    InscriptionJoueur inscriptionJoueur;
    public ActionBackToLogin(InscriptionJoueur inscriptionJoueur){
        this.inscriptionJoueur=inscriptionJoueur;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageConnexion = (Stage) inscriptionJoueur.getBtRetour().getScene().getWindow();
        ConnexionJoueur cj = new ConnexionJoueur();
        stageConnexion.close();
        cj.start(new Stage());
    }
}
