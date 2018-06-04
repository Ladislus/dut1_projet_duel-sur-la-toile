package module_puissance4;

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
        this.joueurCourant = (joueurCourant)%2+1;
        this.getJ(joueurCourant).setCour(true);
    }

    public int jouerUnCoup(int numCol){
        int ligArrive = -1;
        if (this.getTableau().get(numCol).isNotFull()){
            ligArrive = this.getTableau().get(numCol).addPion(joueurCourant);
        }
        if (ligArrive!=-1)
            this.changeJCour();
        return ligArrive;
    }

    public List<Colonne> getTableau() {
        return tableau;
    }

    public int getPion(int l, int c){
        if (l>=0 && l<=5 && c>=0 && c<=6)
            return this.getTableau().get(c).get(l);
        return -1;
    }

    public Colonne getCol(int c){
        return this.getTableau().get(c);
    }

    /*public int getPuissance4(int l, int c){
        // Renvoie le numéro du joueur gagnant s'il y a un puissance 4, 0 sinon
        List<String> possibilites = this.connect4possibles(l,c);
        int p = this.getPion(l,c);

        for (String card : possibilites){
            int n = 0; // Si n >= 2, alors il y a un puissance 4
            if (card=="n" || card=="s"){
                if (this.getPion(l+2,c)==p){n++;}
                if (this.getPion(l+3,c)==p){n++;}
                if (this.getPion(l-2,c)==p){n++;}
                if (this.getPion(l-3,c)==p){n++;}
            }
            else if (card=="o" || card=="e"){
                if (this.getPion(l,c+2)==p){n++;}
                if (this.getPion(l,c+3)==p){n++;}
                if (this.getPion(l,c-2)==p){n++;}
                if (this.getPion(l,c-3)==p){n++;}
            }
            else if (card=="no" || card=="se"){
                if (this.getPion(l-2,c+2)==p){n++;}
                if (this.getPion(l-3,c+3)==p){n++;}
                if (this.getPion(l+2,c-2)==p){n++;}
                if (this.getPion(l+3,c-3)==p){n++;}
            }
            else if (card=="ne" || card=="so"){
                if (this.getPion(l-2,c-2)==p){n++;}
                if (this.getPion(l-3,c-3)==p){n++;}
                if (this.getPion(l+2,c+2)==p){n++;}
                if (this.getPion(l+3,c+3)==p){n++;}
            }

            if (n>=2){return p;}
        }
        return 0;
    }*/

    public int getPuissance4(int l, int c){
        if (vertical(c))return joueurCourant;
        else return 0;
    }

    private boolean vertical(int c){
        int res = 0;
        for (int i=0;i<6;i++){
            System.out.println(res);
            if (tableau.get(c).get(i)==joueurCourant){
                if (res==3) return true;
                res++;
            }
            else res = 0;
        }
        return false;
    }

    /*private boolean horizontal(int l, int c){

    }*/

    private List<String> connect4possibles(int l, int c) {
        // Renvoie la liste des directions (cardinaux) à tester
        List<String> res = new ArrayList<>();
        int p = this.getPion(l,c);

        // Si le pion n'existe pas, this.getPion() renvoie -1, forcément != p
        if (this.getPion(l-1,c)==p){res.add("s");}
        if (this.getPion(l-1,c-1)==p){res.add("so");}
        if (this.getPion(l-1,c+1)==p){res.add("se");}
        if (this.getPion(l+1,c)==p){res.add("n");}
        if (this.getPion(l+1,c-1)==p){res.add("no");}
        if (this.getPion(l+1,c+1)==p){res.add("ne");}
        if (this.getPion(l,c-1)==p){res.add("o");}
        if (this.getPion(l,c+1)==p){res.add("e");}

        return res;
    }

    public boolean isFull(){
        for (Colonne c : tableau){
            if (c.isNotFull()){return false;}
        }
        return true;
    }

}
