package module_administrateur;

import java.util.ArrayList;

public class Administration {

    private ArrayList<String> joueurAactiver;

    public Administration() {
        this.joueurAactiver = new ArrayList<>();
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
}
