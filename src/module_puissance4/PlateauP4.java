package module_puissance4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Modèle du plateau du puissance 4
 */
public class PlateauP4 {

    /** les joueurs qui s'opposent */
    private Joueur joueur1,joueur2;

    /** numéro du joueur à qui c'est le tour de jouer */
    private int joueurCourant; // vaut 1 ou 2

    /** le nombre de pions restants */
    public int nbPionsRest;

    /** la liste des Colonnes du plateau */
    private List<Colonne> tableau;

    public PlateauP4(String j1, String j2){
        this.joueur1 = new Joueur(j1);
        this.joueur2 = new Joueur(j2);
        joueurCourant = 1 + (int)(Math.random() * 2);
        this.changeJCour();

        tableau = new ArrayList<>();

        for (int c=0;c<7;c++){
            tableau.add(new Colonne());
        }

        this.nbPionsRest = 42;
    }

    public Joueur getJ(int n){
        if (n==1)
            return joueur1;
        else
            return joueur2;
    }

    /** Obtenir le numéro du joueur courant */
    public int getJCour(){return joueurCourant;}

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

    public List<Integer> getLig(int l) {
        List<Integer> res = new ArrayList<>();
        for (Colonne c : this.tableau){
            res.add(c.get(l));
        }
        return res;
    }

    /** Obtenir la liste des pions qui composent la diagonale classique qui contient le pion de coordonnées (l,c) en paramètres */
    public List<Integer> getDiag(int l,int c){
        // Diagonale classique (Nord-Ouest à Sud-Est)
        List<Integer> res = new ArrayList<>();
        int lCour = l+1;
        int cCour = c-1;
        while (this.getPion(lCour,cCour) != -1){ // On calcule les coordonnées du pion d'où on va commencer
            lCour++;
            cCour--;
        }
        lCour--;    // On est sorti du plateau, on revient aux coordonnées précédentes
        cCour++;
        int p = this.getPion(lCour,cCour);
        while(p != -1){
            res.add(p);
            lCour--;
            cCour++;
            p = this.getPion(lCour,cCour);
        }
        return res;
    }

    /** Obtenir la liste des pions qui composent la diagonale inversée qui contient le pion de coordonnées (l,c) en paramètres */
    public List<Integer> getDiagInv(int l,int c){
        // Diagonale inversée (Sud-Ouest à Nord-Est)
        List<Integer> res = new ArrayList<>();
        int lCour = l-1;
        int cCour = c-1;
        while (this.getPion(lCour,cCour) != -1){ // On calcule les coordonnées du pion d'où on va commencer
            lCour--;
            cCour--;
        }
        lCour++;    // On est sorti du plateau, on revient aux coordonnées précédentes
        cCour++;
        int p = this.getPion(lCour,cCour);
        while(p != -1){
            res.add(p);
            lCour++;
            cCour++;
            p = this.getPion(lCour,cCour);
        }
        return res;
    }

    /** Changer le joueur courant */
    public void changeJCour(){
        this.getJ(joueurCourant).setCour(false);
        this.joueurCourant = (joueurCourant)%2+1;
        this.getJ(joueurCourant).setCour(true);
    }

    public int jouerUnCoup(int numCol){
        this.nbPionsRest--;
        return this.getTableau().get(numCol).addPion(joueurCourant);
    }

    /** Obtenir l'état du jeu, avec un booléen (gagné ou non) et le nombre de pions aligné si c'est gagné */
    public ResultatP4 etatDuJeu(int l, int c){
        // Renvoie le numéro du joueur gagnant s'il y a un puissance 4, 0 sinon
        List<String> possibilites = this.directions(l,c);
        int p = this.getPion(l,c);

        for (String test : possibilites){
            int n = 0; // Si n >= 4, alors il y a un puissance 4
            if (test=="col"){
                n = this.plusLongueSuite(this.getCol(c));
            }
            else if (test=="lig"){
                n = this.plusLongueSuite(this.getLig(l));
            }
            else if (test=="diag"){
                n = this.plusLongueSuite(this.getDiag(l,c));
            }
            else if (test=="diagInv"){
                n = this.plusLongueSuite(this.getDiagInv(l,c));
            }
            if (n>=4){return new ResultatP4(true,n);}
        }
        return new ResultatP4(false,0);
    }

    public int plusLongueSuite(List<Integer> l) {
        // On cherche la plus longue suite de pions de la couleur du joueur courant
        int jCour = this.getJCour();
        int res = 0;
        int longCour = 0;
        for (int p : l){
            if (p == jCour)
                longCour++;
            else {
                if (longCour > res)
                    res = longCour;
                longCour = 0;
            }
        }
        if (longCour > res){
            res = longCour;
        }
        return res;
    }

    private List<String> directions(int l, int c) {
        // Renvoie la liste des tests à effectuer
        List<String> res = new ArrayList<>();
        int p = this.getPion(l,c);

        // Note : Si le pion n'existe pas, this.getPion() renvoie -1, forcément != p
        if (this.getPion(l+1,c)==p || this.getPion(l-1,c)==p){res.add("col");}
        if (this.getPion(l,c+1)==p || this.getPion(l,c-1)==p){res.add("lig");}
        if (this.getPion(l-1,c+1)==p || this.getPion(l+1,c-1)==p){res.add("diag");}
        if (this.getPion(l+1,c+1)==p || this.getPion(l-1,c-1)==p){res.add("diagInv");}

        return res;
    }

    /** Savoir si le tableau est plein ou non */
    public boolean isFull(){
        for (Colonne c : tableau){
            if (c.isNotFull()){return false;}
        }
        return true;
    }

}
