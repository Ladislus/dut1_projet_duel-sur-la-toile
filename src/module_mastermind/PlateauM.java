package module_mastermind;

import module_puissance4.Joueur;

import java.util.ArrayList;
import java.util.List;

// Modèle du plateau du Mastermind

public class PlateauM {

    private List<Combinaison> listeEssais, listeResultats;

    private Combinaison combiMystere, combiCour;

    private Joueur joueur1, joueur2;

    /**
     * Constructeur du PlateauM
     * @param j1 une String quicontient le nom du Joueur 1
     * @param j2 une String quicontient le nom du Joueur 2
     */
    public PlateauM(String j1, String j2){
        this.joueur1 = new Joueur(j1);
        this.joueur2 = new Joueur(j2);
        this.listeEssais = new ArrayList<>();
        this.listeResultats = new ArrayList<>();
        combiMystere = new Combinaison();
        for (int i=0;i<4;i++){
            combiMystere.set(i,(int) (Math.random()*6)+1);
        }
        combiCour = new Combinaison();
    }

    /**
     * Redéfinit une nouvelle Combinaison mystère, utile lorsque l'on rejoue
     */
    public void setCombiMystere(){
        for (int i=0;i<4;i++){
            combiMystere.set(i,(int) (Math.random()*6)+1);
        }
    }

    /**
     * Renvoie la Combinaison mystère
     * @return une Combinaison
     */
    public Combinaison getCombiMystere() {
        return combiMystere;
    }

    /**
     * Renvoie la Combinaison courante (celle qui sera testée lors de l'appel de ActionTestComb
     * @return une Combinaison
     */
    public Combinaison getCombiCour() {
        return combiCour;
    }

    /**
     * Renvoie la liste de toutes les Combinaisons testées
     * @return une List<Combinaison>
     */
    public List<Combinaison> getListeEssais() {
        return listeEssais;
    }

    /**
     * Renvoie la liste de tous les indices donnés après les tests
     * @return une List<Combinaison>
     */
    public List<Combinaison> getListeResultats() {
        return listeResultats;
    }

    /**
     * Joue un coup: ajoute la Combinaison à listeEssais, les indices à listeResultats et remets la Combinaison courante à 0
     */
    public void jouerUnCoup(){
        Combinaison coup = new Combinaison();
        for (int i =0; i <4; i++){
            coup.set(i,this.combiCour.get(i));
        }
        this.listeEssais.add(coup);
        this.listeResultats.add(Resultat.compare(combiMystere,combiCour));
        this.combiCour = new Combinaison();
    }

    /**
     * Renvoie si la dernière Combinaison est égale à la Combinaison mystère
     * @return un boolean
     */
    public boolean aTrouveCombi(){
        Combinaison dernier = this.listeResultats.get(this.listeResultats.size()-1);
        for (int p : dernier){
            if (p != 1){return false;}
        }
        return true;
    }
}
