package module_21;

import module_puissance4.Joueur;

/**
 * Modèle du plateau des 21 Bâtonnets
 */
public class Plateau21 {

    /** les joueurs qui s'opposent */
    private Joueur joueur1,joueur2;

    /** numéro du joueur à qui c'est le tour de jouer */
    private int joueurCourant; // vaut 1 ou 2

    private Liste21 liste21batons;

    public Plateau21(String j1, String j2){
        this.joueur1 = new Joueur(j1);
        this.joueur2 = new Joueur(j2);
        joueurCourant = 1 + (int)(Math.random() * 2);
        this.changeJCour();

        this.liste21batons = new Liste21();

    }

    public Joueur getJ(int n){
        if (n==1)
            return joueur1;
        else
            return joueur2;
    }

    /** Obtenir le numéro du joueur courant */
    public int getJCour(){return joueurCourant;}

    /** Changer le joueur courant */
    public void changeJCour(){
        this.getJ(joueurCourant).setCour(false);
        this.joueurCourant = (joueurCourant)%2+1;
        this.getJ(joueurCourant).setCour(true);
    }

    /** Connaître le nombre de Bâtonnets encore à prendre */
    public int getNbBatonsRest() {
        return liste21batons.getNbBatonsRest();
    }

    public void jouerUnCoup(int nbBatons){
        this.liste21batons.jouer(this.joueurCourant,nbBatons);
    }

    public Liste21 getListe21batons() {
        return liste21batons;
    }
}
