package module_administrateur;

import APIMySQL.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.*;

/** Modèle de l'administration */
public class Administration {

    private ArrayList<Joueur> listeJmodifStatut;

    /** Constructeur de l'administration avec les initialisations */
    public Administration() {
        this.listeJmodifStatut = new ArrayList<>();
    }

    /** Réinitialise tous les éléments à vide */
    public void majAdmin() {
        this.listeJmodifStatut = new ArrayList<>();
    }

    ////////////////////
    // GERER JOUEUR //
    /////////////////

    /** Ajoute à la liste les joueurs à changer de statut (activé/désactivé) */
    public void ajouterListeModif(Joueur joueur) {
        this.listeJmodifStatut.add(joueur);
    }

    /** Retire de la liste les joueurs à changer de statut (activé/désactivé) */
    public void retirerListeModif(Joueur joueur) {
        this.listeJmodifStatut.remove(joueur);
    }

    /** Retourne la liste des joueurs à changer de statut (activé/désactivé) */
    public ArrayList<Joueur> getListeModif() {
        return this.listeJmodifStatut;
    }

    ///////////////////
    // REQUETTE SQL //
    /////////////////

    /** Retourne sous la forme d'un dictionnaire avec leur informations tous les utilisateurs */
    public HashMap<String, List<Object>> requetteListeJoueur() {
        return GestionBD.selectPreparedStatement("select * from UTILISATEUR;");
    }

    /** Permet de désactiver un joueur donné en paramètre */
    public void desactiverJoueur(Joueur j) {
        Utilisateur.setUserInfo("activeUt", 0, "pseudoUt", j.getPseudo());
    }

    /** Permet d'activer un joueur donné en paramètre */
    public void activerJoueur(Joueur j) {
        Utilisateur.setUserInfo("activeUt", 1, "pseudoUt", j.getPseudo());
    }

}
