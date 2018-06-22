package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionToInvitation implements EventHandler<ActionEvent> {

    private Joueur joueur;

    private Dashboard dashboard;

    /**
     Controlleur permettant d'ouvrir la page d'invitation
     @param joueur : Le joueur courant
     @param dashboard : Le dashboard à propager
    */
    ActionToInvitation(Joueur joueur, Dashboard dashboard) {

        this.joueur = joueur;
        this.dashboard = dashboard; }

    /**
     Créer un nouvelle fenêtre et la remplit avec Invitation
     @param actionEvent : L'ActionEvent contenant l'action
    */
    @Override
    public void handle(ActionEvent actionEvent) {

        Stage stageEditionProfile = new Stage();
        stageEditionProfile.setTitle("Ajout d'un ami");
        stageEditionProfile.setResizable(false);
        stageEditionProfile.setScene(new Scene(new Invitation(this.joueur, this.dashboard), VariablesJoueur.DEFAULT_RECHERCHER_JOUEUR_WIDTH, VariablesJoueur.DEFAULT_RECHERCHER_JOUEUR_HEIGHT));
        stageEditionProfile.show(); }}
