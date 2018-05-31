package sample;

import java.util.ArrayList;
import java.util.List;

public class Plateau { // Modèle du plateau du puissance 4

    private Joueur joueur1;

    private Joueur joueur2;

    private int joueurCourant; // vaut 1 ou 2

    private List<Colonne> tableau;

    public Plateau(String j1, String j2){
        this.joueur1 = new Joueur(j1);
        this.joueur2 = new Joueur(j2);
        joueurCourant = 1 + (int)(Math.random() * 2);
        this.changeJCour();

        tableau = new ArrayList<>();

        for (int c=0;c<7;c++){
            tableau.add(new Colonne());
        }
    }

    public Joueur getJ(int n){
        if (n==1)
            return joueur1;
        else
            return joueur2;
    }

    public int getJCour(){return joueurCourant;}

    public void changeJCour(){
        this.getJ(joueurCourant).setCour(false);
        joueurCourant = (joueurCourant)%2+1;
        this.getJ(joueurCourant).setCour(true);
    }
}
