package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionToInvitation implements EventHandler<ActionEvent> {

    private Joueur joueur;

    private Dashboard dashboard;

    public ActionToInvitation(Joueur joueur, Dashboard dashboard){
        this.joueur = joueur;
        this.dashboard = dashboard;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stageEditionProfile = new Stage();
        stageEditionProfile.setTitle("Ajout d'un ami");
        stageEditionProfile.setResizable(false);
        stageEditionProfile.setScene(new Scene(new Invitation(joueur, dashboard), VariablesJoueur.DEFAULT_RECHERCHER_JOUEUR_WIDTH, VariablesJoueur.DEFAULT_RECHERCHER_JOUEUR_HEIGHT));
        stageEditionProfile.show();
    }
}
