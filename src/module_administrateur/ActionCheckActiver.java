package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

/** Contrôleur de la checkbox des joueurs qu'on souhaite activer/désactiver */
public class ActionCheckActiver implements EventHandler<ActionEvent> {

    GererJoueur gJoueur;
    Administration a;
    Joueur joueur;

    /** Constructeur du contrôleur */
    public ActionCheckActiver(GererJoueur gJoueur, Administration a, Joueur joueur) {
        this.gJoueur = gJoueur;
        this.a = a;
        this.joueur = joueur;
    }

    /** Regarde si la checkbox est selectionnée
        Si oui l'ajoute dans la liste des joueurs à activer ou désactiver
        Si on décoche la checkbox on l'enlève de cette liste
        Puis active ou désactive les boutons activer/désactiver si la liste de joueur est vide ou non */
    @Override
    public void handle(ActionEvent actionEvent) {
        CheckBox cb = (CheckBox) actionEvent.getSource();
        if (cb.isSelected()) {
            this.a.ajouterListeModif(this.joueur);
        }
        else {
            this.a.retirerListeModif(this.joueur);
        }
        if (this.a.getListeModif().size() == 0) {
            this.gJoueur.getButtonActiver().setDisable(true);
            this.gJoueur.getButtonDesactiver().setDisable(true);
        }
        else {
            this.gJoueur.getButtonActiver().setDisable(false);
            this.gJoueur.getButtonDesactiver().setDisable(false);
        }
        System.out.println(this.a.getListeModif());
    }
}
