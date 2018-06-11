package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionProfilJoueur implements EventHandler<ActionEvent> {

    PageAccueil pAccueil;

    public ActionProfilJoueur(PageAccueil pAccueil) {
        this.pAccueil = pAccueil;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.pAccueil.getBp().setCenter(new ProfilJoueur());
    }
}
