package module_administrateur;

import APIMySQL.*;
import java.util.ArrayList;
import java.sql.*;

public class Administration {

    private ArrayList<Joueur> joueurAactiver;

    private ArrayList<Rapport> listeRapport;
    private ArrayList<Rapport> listeRapportLu;

    public Administration() {
        this.joueurAactiver = new ArrayList<>();
        this.listeRapport = new ArrayList<>();
        this.listeRapportLu = new ArrayList<>();
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
        try {
          cpt = GestionBD.selectPreparedStatement("select * from UTILISATEUR where activeUt IS NOT TRUE;").get("pseudoUt").size();
        }
        catch(SQLException e) {}
        return cpt;
    }

    //GERER RAPPORT
    public void ajouterRapport(Rapport r) {
        this.listeRapport.add(r);
    }

    public ArrayList<Rapport> getRapport() {
        return this.listeRapport;
    }

    public void ajouterRapportLu(Rapport r) {
        this.listeRapportLu.add(r);
    }

    public void retirerRapportLu(Rapport r) {
        this.listeRapportLu.remove(r);
    }

    public ArrayList<Rapport> getRapportLu() {
        return this.listeRapportLu;
    }

    public void supprimerRapportLu(Rapport r) {
        this.listeRapport.remove(r);
    }
}
