package module_puissance4;


import java.util.ArrayList;

/**
 * Modèle d'une colonne du plateau
 * Une case est modélisée en contenant un entier comme ceci :
 * 0 : Pas de pion
 * 1 ou 2 : Pion du joueur 1 ou 2
 */
public class Colonne extends ArrayList<Integer> {

    /** Créer une colonne : Liste d'entiers à 0 au départ */
    public Colonne(){
        super();
        for (int l=0;l<6;l++){
            this.add(0);
        }
    }

    /** Ajouter un pion : renvoie le numéro de la ligne où le pion a atterrit */
    public int addPion(int numJ){
        int l = 0;
        while (this.get(l)!=0){l++;}
        this.set(l,numJ);
        return l;
    }

    /**
     * Renvoie True si la colonne n'est pas pleine
     * si la case la plus haute est occupée, la colonne est pleine
     */
    public boolean isNotFull(){
        return this.get(5)==0;
    }

    /**
     * Renvoie True si la colonne est pleine
     * si la case la plus haute est occupée, la colonne est pleine
     */
    public boolean isFull(){
        return this.get(5)!=0;
    }
    //
}
