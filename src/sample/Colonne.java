package sample;


import java.util.ArrayList;

public class Colonne extends ArrayList<Integer> { // Modèle d'une colonne du plateau
    public Colonne(){
        super();
        for (int l=0;l<6;l++){
            this.add(0);
        }
    }

    public void addPion(int numJ){
        int l = 0;
        while (this.get(l)!=0){l++;}
        this.set(l,numJ);
    }

    public boolean isFull(){
        return this.get(5)!=0;
    }
}
