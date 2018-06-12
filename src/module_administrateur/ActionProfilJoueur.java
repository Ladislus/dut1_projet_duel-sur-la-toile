package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionProfilJoueur implements EventHandler<ActionEvent> {

    PageAccueil pa;
    GererJoueur gJoueur;

    public ActionProfilJoueur(PageAccueil pa, GererJoueur gJoueur) {
        this.pa = pa;
        this.gJoueur = gJoueur;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.pa.getBp().setCenter(new ProfilJoueur(this.pa, this.gJoueur));
    }
}
