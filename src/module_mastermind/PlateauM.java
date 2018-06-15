package module_mastermind;


import module_puissance4.Joueur;

import java.util.ArrayList;
import java.util.List;

public class PlateauM { // Modèle du plateau du Mastermind

    private List<Combinaison> listeEssais, listeResultats;

    private Combinaison combiMystere, combiCour;

    private Joueur joueur1, joueur2;

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

    public Combinaison getCombiMystere() {
        return combiMystere;
    }

    public Combinaison getCombiCour() {
        return combiCour;
    }

    public List<Combinaison> getListeEssais() {
        return listeEssais;
    }

    public List<Combinaison> getListeResultats() {
        return listeResultats;
    }

    /**
     * Ajoute la combinaison essayer a la liste des combinaisons essayer auparavant
     * donne les resultats
     * recréer une nouvelle combinaison vide
     */
    public void jouerUnCoup(){
        this.listeEssais.add(combiCour);
        this.listeResultats.add(Resultat.compare(combiMystere,combiCour));
        this.combiCour = new Combinaison();
    }

    /**
     * test si la derniere combinaison testée est la meme que celle recherchée
     */
    public boolean aTrouveCombi(){
        Combinaison dernier = this.listeResultats.get(this.listeResultats.size()-1);
        for (int p : dernier){
            if (p != 1){return false;}
        }
        return true;
    }
}
