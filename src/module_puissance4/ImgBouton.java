package module_puissance4;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.util.HashMap;

import static module_puissance4.Puissance4.chem;

/**
 * Vue des boutons au-dessus des colonnes
 * un bouton sera soit désactivé (gris), rouge ou jaune en fonction du joueur qui passe sa souris dessus
 */
public class ImgBouton extends ImageView {

    /** dictionnaire reliant un titre String à son image File */
    private static HashMap<String,File> dicoImage;

    /**
     * Constructeur de la vue des boutons au dessus colonnes (images)
     * @param type une String
     */
    public ImgBouton(String type) {
        super();

        dicoImage = new HashMap<>();
        dicoImage.put("desactive",new File(chem+"boutColDesactive.png"));
        dicoImage.put("1",new File(chem+"boutColRed.png"));
        dicoImage.put("2",new File(chem+"boutColYellow.png"));

        this.setImage(new Image(dicoImage.get(type).toURI().toString()));
        this.setPreserveRatio(true);
        this.setFitWidth(25.);
    }
}
