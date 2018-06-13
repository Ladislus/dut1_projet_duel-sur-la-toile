package module_administrateur;

import java.util.ArrayList;

public class Administration {

    private ArrayList<String> joueurAactiver;

    private ArrayList<String> listeRapport;
    private ArrayList<String> listeRapportLu;

    public Administration() {
        this.joueurAactiver = new ArrayList<>();
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
    public void ajouterRapport(String res) {
        this.listeRapport.add(res);
    }

    public void ajouterRapportLu(String res) {
        this.listeRapportLu.add(res);
    }

    public void retirerRapportLu(String res) {
        this.listeRapportLu.remove(res);
    }

    public ArrayList<String> getRapportLu() {
        return this.listeRapportLu;
    }

    public void supprimerRapport(ArrayList<String> listeRapportLu) {
        for (String rapp : listeRapportLu) {
            this.listeRapportLu.remove(rapp);
        }
    }
}
