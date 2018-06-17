package module_21;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

/**
 * Vue d'un bâtonnet
 */
public class Batonnet extends Rectangle {

    /** Vaut 0 ou vaut le numéro du joueur qui l'a saisi */
    public int nbJoueur;

    private static HashMap<Integer,Color> attributionCouleurs;

    public Batonnet(){
        super(12.,200.,Color.valueOf("#D7B2B2"));
        this.nbJoueur = 0;
        this.attributionCouleurs = new HashMap<>();
        this.attributionCouleurs.put(0, Color.valueOf("#D7B2B2"));
        this.attributionCouleurs.put(1, Color.valueOf("#D501F6"));
        this.attributionCouleurs.put(2, Color.valueOf("#ECB70B"));
        this.attributionCouleurs.put(21,Color.valueOf("#FE4040"));

        this.setStyle("-fx-effect: dropshadow(gaussian,#202020,10,0.6,1.2,1);");
    }

    public void setSelect(int num){
        if (num != 21)
            this.nbJoueur = num;
        else
            this.nbJoueur = 0;
        this.setFill(this.attributionCouleurs.get(num));
    }

    public void active(){
        this.setDisable(false);
        this.setHeight(240.);
    }

    public void desactive(){
        this.setDisable(true);
        this.setHeight(200.);
        this.setFill(this.attributionCouleurs.get(0));
    }

    public void sauver(int numJ){
        this.setDisable(true);
        this.setHeight(100.);
        this.setFill(this.attributionCouleurs.get(numJ));
    }
}
