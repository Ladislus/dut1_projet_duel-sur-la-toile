package module_joueur;

import APIMySQL.GestionBD;
import javafx.scene.image.Image;

public class Jeu {

    private String title;

    Image image;

    private String regle;

    public Jeu(String title, byte[] image, String regle) {
        this.title = title;
        this.regle = regle;

        if (image != null)
            this.image = GestionBD.bytesToImage(image);
        else
            this.image = VariablesJoueur.LOGO; }

    public String getRegle() {
        return regle;
    }

    public void setRegle(String regle) {
        this.regle = regle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getImage() {
        return image;
    }
}
