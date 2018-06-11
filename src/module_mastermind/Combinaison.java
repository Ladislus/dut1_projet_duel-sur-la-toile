package module_mastermind;

import java.util.ArrayList;

public class Combinaison extends ArrayList<Integer> { // Modèle de la combinaison du mastermind

    // 0 signifie "case vide", une case remplie a une valeur entre 1 et 6, chaque nombre étant associé à une couleur

    public Combinaison(){
        super();
        for (int i=0;i<4;i++){
            this.add(0);
        }
    }

    public void addPion(int num){
        for (int i=0;i<4;i++){
            if (this.get(i) != 0){this.set(i,num);}
        }
    }

    public boolean isFull(){
        for (int i=0;i<4;i++){
            if (this.get(i) == 0){return false;}
        }
        return true;
    }

    public Integer remove(int pos){
        int prec = this.get(pos);
        this.set(pos,0);
        return prec;
    }
    public void removePion(int p){ // On supprime le premier pion égal à p dans la combi. Il est admis que celui-ci existe
        int i = 0;
        while (this.get(i) != p){i++;}
        this.set(i,0);
    }
}
