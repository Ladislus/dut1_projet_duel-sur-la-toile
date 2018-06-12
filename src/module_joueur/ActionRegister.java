package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionRegister implements EventHandler<ActionEvent> {

    ConnexionJoueur connexionJoueur;
    public ActionRegister(ConnexionJoueur connexionJoueur){
        this.connexionJoueur = connexionJoueur;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageConnexion = (Stage) connexionJoueur.getHlRegister().getScene().getWindow();
        InscriptionJoueur ij = new InscriptionJoueur();
        stageConnexion.close();
        //ij.start(new Stage());
    }
}
