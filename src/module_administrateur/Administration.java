package module_administrateur;

import java.util.ArrayList;

public class Administration {

    private ArrayList<String> joueurAactiver;

    private ArrayList<Rapport> listeRapport;
    private ArrayList<Rapport> listeRapportLu;

    public Administration() {
        this.joueurAactiver = new ArrayList<>();
        this.listeRapport = new ArrayList<>();
        this.listeRapportLu = new ArrayList<>();
    }

    //GERER JOUEUR
    public void ajouterListeActiver(String joueur) {
        this.joueurAactiver.add(joueur);
    }

    public void retirerListeActiver(String joueur) {
        this.joueurAactiver.remove(joueur);
    }

    public ArrayList<String> getJoueurAactiver() {
        return this.joueurAactiver;
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