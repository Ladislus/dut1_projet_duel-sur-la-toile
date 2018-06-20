package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/** Contrôleur du bouton profil d'un joueur */
public class ActionProfilJoueur implements EventHandler<ActionEvent> {

    PageAccueil pa;
    GererJoueur gJoueur;
    Joueur joueur;

    /** Constructeur du contrôleur */
    public ActionProfilJoueur(PageAccueil pa, GererJoueur gJoueur, Joueur joueur) {
        this.pa = pa;
        this.gJoueur = gJoueur;
        this.joueur = joueur;
    }

    /** Change l'affichage de la page courante et deviens la vue du profil d'un joueur */
    @Override
    public void handle(ActionEvent actionEvent) {
        this.pa.getBp().setCenter(new ProfilJoueur(this.pa, this.gJoueur, this.joueur));
    }
}
