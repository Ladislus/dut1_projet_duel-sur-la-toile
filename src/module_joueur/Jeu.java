package module_joueur;

import APIMySQL.GestionBD;

import javafx.scene.image.Image;

public class Jeu {

    private String title;

    private Image image;

    private String regle;

    /**
     Entité représentant un jeu de la base de donnée
     @param title : Une String contenant le titre du jeu
     @param image : Une chaine de byte convertie en image si non null
     @param regle : Une String contenant les règles du jeu
    */
    public Jeu(String title, byte[] image, String regle) {
        this.title = title;
        this.regle = regle;

        //Si pas d'image dans la base de données, affichage de l'image de base
        if (image != null)
            this.image = GestionBD.bytesToImage(image);
        else
            this.image = VariablesJoueur.LOGO; }

    String getRegle() { return regle; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Image getImage() { return image; }}
