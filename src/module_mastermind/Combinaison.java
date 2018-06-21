package module_mastermind;

import java.util.ArrayList;

public class Combinaison extends ArrayList<Integer> { // Modèle de la combinaison du mastermind

    // 0 signifie "case vide", une case remplie a une valeur entre 1 et 6, chaque nombre étant associé à une couleur

    /**
     * Constructeur sans paramètre d'une combinaison, permet de créer une Combinaison vide
     */
    public Combinaison(){
        super();
        for (int i=0;i<4;i++){
            this.add(0);
        }
    }

    /**
     * Constructeur d'une combinaison, permet de de dupliquer une Combinaison
     * @param c
     */
    public Combinaison(Combinaison c){
        super();
        for(Integer i:c){
            this.add(i);
        }
    }

    /**
     * Ajoute le pion dans la combinaison au premier emplacement dans l'index (visuellement le plus à gauche)
     * @param num un int (compris entre 0 et 6 : règle tacite, ne plante pas sinon)
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
     * Permet de savoir si la Combinaison est pleine ou non
     * @return un boolean
     */
    public boolean isFull(){
        for (int i=0;i<4;i++){
            if (this.get(i) == 0){return false;}
        }
        return true;
    }

    /**
     * Enlève le pion à la position rentrée en paramètre, c'est à dire lui donne la valeur 0
     * @param pos un int
     * @return un Integer
     */
    public Integer remove(int pos){
        int prec = this.get(pos);
        this.set(pos,0);
        return prec;
    }

    /**
     * On supprime le premier pion égal à p dans la Combinaison. Il est admis que celui-ci existe
     * @param p un int (implicitement compris entre 1 et 6)
     */
    public void removePion(int p){
        int i = 0;
        while (this.get(i) != p){i++;}
        this.set(i,0);
    }

    /**
     * Enlève tous les pions de la Combinaison, c'est à dire leur donne tous la valeur 0
     */
    public void clear(){
        for (int i=0;i<4;i++){
            this.set(i,0);
        }
    }
}
