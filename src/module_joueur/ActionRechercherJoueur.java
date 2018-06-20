package module_joueur;

import APIMySQL.GestionBD;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class ActionRechercherJoueur implements EventHandler<KeyEvent> {

    Invitation invitation;

    private List<Object> listeDeJoueur;

    public ActionRechercherJoueur(Invitation invitation){
        this.invitation = invitation;
        this.listeDeJoueur = new ArrayList<>();
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(invitation.getTfSearch().getText().contains(" ")|| invitation.getTfSearch().getText().length() == 0){
            try{
                listeDeJoueur.clear();
                invitation.majAffichageListeJoueur(listeDeJoueur);
            }
            catch (NullPointerException e){

            }

        }
        else{
            listeDeJoueur = GestionBD.selectPreparedStatement("select pseudoUt from UTILISATEUR where pseudoUt like '"+ invitation.getTfSearch().getText()+"%'").get("pseudoUt");
            invitation.majAffichageListeJoueur(listeDeJoueur);
        }

    }
}
