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

    /**
     Controlleur permettant le fonctionnement de la
     barre de recherche dans la page d'invitation
     @param invitation : La page d'invitation à propager
     @param joueur : Le joueur courant
    */
    ActionRechercherJoueur(Invitation invitation, Joueur joueur) {

        this.invitation = invitation;

        this.joueur = joueur;

        this.listeDeJoueur = new ArrayList<>(); }

    /**
     Lance une requête de l'API à partir du contenu
     de la barre de recherche
     @param keyEvent : Le KeyEvent contenant la touche
    */
    @Override
    public void handle(KeyEvent keyEvent) {

        //Test de la barre vide
        if (invitation.getTfSearch().getText().contains(" ") || invitation.getTfSearch().getText().length() == 0) {

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
