package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

public class ActionCheckActiver implements EventHandler<ActionEvent> {

    GererJoueur gJoueur;
    String joueur;
    Administration a;

    public ActionCheckActiver(GererJoueur gJoueur, String joueur, Administration a) {
        this.gJoueur = gJoueur;
        this.joueur = joueur;
        this.a = a;
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
        System.out.println(this.a.getJoueurAactiver());
    }
}
