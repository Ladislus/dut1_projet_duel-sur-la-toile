package module_puissance4;

import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Vue des joueurs
 */
public class Joueur extends Label{

    /** Nom du joueur */
    private String nom;

    /** Booléen pour dire si c'est au tour du joueur ou non */
    private boolean jCourant;


    public Joueur(String nom){
        super(nom);
        this.nom = nom;
        this.jCourant = false;
    }

    public String getNom() {return nom;}

    /** Changer la valeur du booléen jCourant
     * Si le joueur devient le joueur courant, le texte devient plus gros et noir
     * Sinon, le texte devient plus petit est gris
     */
    public void setCour(boolean b){
        this.jCourant = b;
        if (jCourant){
            this.setFont(Font.font("Verdana",FontWeight.BOLD,25));
            this.setTextFill(Paint.valueOf("black"));
        }
        else{
            this.setFont(Font.font("Verdana",FontWeight.NORMAL,15));
            this.setTextFill(Paint.valueOf("grey"));
        }

    }
}
