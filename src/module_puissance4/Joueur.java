package module_puissance4;

import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Joueur extends Label{ // Vue des joueurs

    private String nom;
    private boolean jCourant;


    public Joueur(String nom){
        super(nom);
        this.nom = nom;
        this.jCourant = false;
    }

    public String getNom() {return nom;}

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
