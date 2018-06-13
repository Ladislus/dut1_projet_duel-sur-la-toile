package module_administrateur;

import java.util.ArrayList;

public class Administration {

    private ArrayList<String> joueurAactiver;

    private ArrayList<String> listeRapportLu;

    public Administration() {
        this.joueurAactiver = new ArrayList<>();
        this.listeRapportLu = new ArrayList<>();
    }

    public void ajouterListeActiver(String joueur) {
        this.joueurAactiver.add(joueur);
    }

    public void retirerListeActiver(String joueur) {
        this.joueurAactiver.remove(joueur);
    }

    public ArrayList<String> getJoueurAactiver() {
        return this.joueurAactiver;
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
}
