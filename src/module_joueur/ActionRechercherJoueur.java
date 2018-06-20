package module_joueur;

import APIMySQL.GestionBD;

import APIMySQL.Utilisateur;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class ActionRechercherJoueur implements EventHandler<KeyEvent> {

    private Invitation invitation;

    private Joueur joueur;

    private List<Object> listeDeJoueur;

    public ActionRechercherJoueur(Invitation invitation, Joueur joueur) {

        this.invitation = invitation;

        this.joueur = joueur;

        this.listeDeJoueur = new ArrayList<>(); }

    @Override
    public void handle(KeyEvent keyEvent) {

        if(invitation.getTfSearch().getText().contains(" ") || invitation.getTfSearch().getText().length() == 0) {
            try {

                listeDeJoueur.clear();
                invitation.majAffichageListeJoueur(listeDeJoueur); }

            catch (NullPointerException e){}}

        else {

            listeDeJoueur = GestionBD.selectPreparedStatement("select pseudoUt from UTILISATEUR where pseudoUt like '" + invitation.getTfSearch().getText() + "%'").get("pseudoUt");



            for (Object amiJoueur : listeDeJoueur){

                List<Object> listeBon = new ArrayList<>();

                if (!Utilisateur.getListeDamis(this.joueur.getPseudo()).contains(amiJoueur.toString()))
                    listeBon.add(amiJoueur);

                this.listeDeJoueur = listeBon; }

            invitation.majAffichageListeJoueur(listeDeJoueur); }}}
