package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

public class ActionCheckActiver implements EventHandler<ActionEvent> {

    GererJoueur gJoueur;
    Administration a;
    Joueur joueur;

    public ActionCheckActiver(GererJoueur gJoueur, Administration a, Joueur joueur) {
        this.gJoueur = gJoueur;
        this.a = a;
        this.joueur = joueur;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        CheckBox cb = (CheckBox) actionEvent.getSource();
        if (cb.isSelected()) {
            this.a.ajouterListeActiver(this.joueur);
        }
        else {
            this.a.retirerListeActiver(this.joueur);
        }
        if (this.a.getJoueurAactiver().size() == 0) {
            this.gJoueur.getButtonSupprimer().setDisable(true);
            this.gJoueur.getButtonActiver().setDisable(true);
        }
        else {
            this.gJoueur.getButtonSupprimer().setDisable(false);
            this.gJoueur.getButtonActiver().setDisable(false);
        }
        System.out.println(this.a.getJoueurAactiver());
    }
}
