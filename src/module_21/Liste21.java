package module_21;

import java.util.ArrayList;

/**
 * Modèle de la liste des 21 Bâtonnets
 * Un Bâtonnet est modélisé en contenant un entier comme ceci :
 * 0 : N'est pas pris
 * 1 ou 2 : pris par le joueur 1 ou 2
 */
public class Liste21 extends ArrayList<Integer> {

    /** Booléen pour dire si les 21 Bâtonnets sont priss ou non */
    public boolean estComplet;

    public Liste21(){
        super();
        for (int b=0;b<21;b++){
            this.add(0);
        }
        this.estComplet = false;
    }

    /** Connaître le nombre de Bâtonnets encore à prendre */
    public int getNbBatonsRest(){
        int res = 21;
        for (int i=20;i>=0;i--){
            if (this.get(i) != 0){res--;}
            else {return res;}
        }
        return 0;
    }

    /** Obtenir l'indice du prochain Bâtonnet à prendre */
    public int getNext(){
        return this.getNbBatonsRest()-1;
    }

    /**
     * Changer les Bâtonnets sélectionnés de 0 à numJ
     * Il peut être pris 1, 2 ou 3 Bâtonnets à la fois
     */
    public void jouer(int numJ,int nbBatons){
        for (int i=0;i<nbBatons;i++){
            this.set(this.getNext(),numJ);
        }
        if (this.getNbBatonsRest() == 0){ this.estComplet = true; }
    }

}
