package module_puissance4;


import java.util.ArrayList;

/**
 * Modèle d'une colonne du plateau
 * Une case est modélisée en contenant un entier comme ceci :
 * 0 : Pas de pion
 * 1 ou 2 : Pion du joueur 1 ou 2
 */
public class Colonne extends ArrayList<Integer> {

    /**
     * Constructeur de la classe Colonne
     */
    public Colonne(){
        super();
        for (int l=0;l<6;l++){
            this.add(0);
        }
    }

    /**
     * Méthode permettant d'ajouter un pion à une colonne
     * @param numJ un int correspondant au numéro du Joueur, suivant e numéro le pion aura une valeur différente, changeant sa couleur dans la vue
     * @return un int le numéro de la ligne dans laquelle le pion a été mis
     */
    public int addPion(int numJ){
        int l = 0;
        while (this.get(l)!=0){l++;}
        this.set(l,numJ);
        return l;
    }

    /**
     * Renvoie True si la colonne n'est pas pleine, c'est à dire si la dernière case n'est pas occupée
     * @return un boolean
     */
    public boolean isNotFull(){
        return this.get(5)==0;
    }

    /**
     * Renvoie True si la colonne est pleine, c'est à dire si la dernière case est occupée
     * @return un boolean
     */
    public boolean isFull(){
        return this.get(5)!=0;
    }
    //
}
