package module_puissance4;


import java.util.ArrayList;

public class Colonne extends ArrayList<Integer> { // Modèle d'une colonne du plateau
    // Une case est modélisée en contenant un entier comme ceci :
            // 0 : Pas de pion
            // 1 ou 2 : Pion du joueur 1 ou 2

    public Colonne(){
        super();
        for (int l=0;l<6;l++){
            this.add(0);
        }
    }

    public int addPion(int numJ){ // renvoie le num de la ligne où le pion a atterrit
        int l = 0;
        while (this.get(l)!=0){l++;}
        this.set(l,numJ);
        return l;
    }

    public boolean isNotFull(){
        return this.get(5)==0;
    }
    public boolean isFull(){
        return this.get(5)!=0;
    }
    // si la case la plus haute est occupée, la colonne est pleine
}
