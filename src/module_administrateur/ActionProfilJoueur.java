package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import APIMySQL.*;

public class ActionProfilJoueur implements EventHandler<ActionEvent> {

    PageAccueil pa;
    GererJoueur gJoueur;
    Joueur joueur;

    public ActionProfilJoueur(PageAccueil pa, GererJoueur gJoueur, Joueur joueur) {
        this.pa = pa;
        this.gJoueur = gJoueur;
        this.joueur = joueur;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.pa.getBp().setCenter(new ProfilJoueur(this.pa, this.gJoueur, this.joueur));
    }
}
