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

    public Combinaison(Combinaison c){
        super();
        for(Integer i:c){
            this.add(i);
        }
    }

    /**
     * Ajoute le pion dans la combianaison
     * @param num
     */
    public void addPion(int num){
//        for (int i=0;i<4;i++){
//            if (this.get(i) == 0){this.set(i,num);}
//        }
        boolean done = false;
        int posActuelle = 0;
        while (!done && posActuelle <4){
            if (this.get(posActuelle) == 0){
                this.set(posActuelle,num);
                done = !done;
            }
            posActuelle += 1;
        }

    }

    /**
     * Renvoye false si la liste n'est pas pleine (que des nombre different de 0)
     * renvoye true sinon
     */
    public boolean isFull(){
        for (int i=0;i<4;i++){
            if (this.get(i) == 0){return false;}
        }
        return true;
    }

    /**
     * Met a 0 a la position
     * @param pos
     * @return
     */
    public Integer remove(int pos){
        int prec = this.get(pos);
        this.set(pos,0);
        return prec;
    }

    /**
     * On supprime le premier pion égal à p dans la combi. Il est admis que celui-ci existe
     * @param p
     */
    public void removePion(int p){
        int i = 0;
        while (this.get(i) != p){i++;}
        this.set(i,0);
    }

    public void clear(){
        for (int i=0;i<4;i++){
            this.set(i,0);
        }
    }
}
