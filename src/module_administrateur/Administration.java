package module_administrateur;

import APIMySQL.*;
import java.util.ArrayList;
import java.sql.*;

public class Administration {

    private ArrayList<Joueur> joueurAactiver;


    public Administration() {
        this.joueurAactiver = new ArrayList<>();
    }

    //GERER JOUEUR
    public void ajouterListeActiver(Joueur joueur) {
        this.joueurAactiver.add(joueur);
    }

    public void retirerListeActiver(Joueur joueur) {
        this.joueurAactiver.remove(joueur);
    }

    public void retirerTousJoueurActiver(ArrayList<Joueur> liste) {
        ArrayList<Joueur> newListe = new ArrayList<>();
        newListe.addAll(liste);
        for (Joueur j : liste) {
            newListe.remove(j);
        }
        this.joueurAactiver = newListe;
    }

    public ArrayList<Joueur> getJoueurAactiver() {
        return this.joueurAactiver;
    }

    public int cptJoueurActiver() {
        int cpt = 0;
        cpt = GestionBD.selectPreparedStatement("select * from UTILISATEUR where activeUt IS NOT TRUE;").get("pseudoUt").size();
        return cpt;
    }

}
