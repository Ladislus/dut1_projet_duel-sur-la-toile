package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionProfilJoueur implements EventHandler<ActionEvent> {

    PageAccueil pa;
    GererJoueur gJoueur;
    String joueur;

    public ActionProfilJoueur(PageAccueil pa, GererJoueur gJoueur, String joueur) {
        this.pa = pa;
        this.gJoueur = gJoueur;
        this.joueur = joueur;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.pa.getBp().setCenter(new ProfilJoueur(this.pa, this.gJoueur));
    }
}
