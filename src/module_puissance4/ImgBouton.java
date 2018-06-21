package module_puissance4;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * Vue des boutons au-dessus des colonnes
 * un bouton sera soit désactivé (gris), rouge ou jaune en fonction du joueur qui passe sa souris dessus
 */
public class ImgBouton extends ImageView {

    /** dictionnaire reliant un titre String à son image File */
    private static HashMap<String,Image> dicoImage;

    public ImgBouton(String type) {
        super();

        dicoImage = new HashMap<>();
        dicoImage.put("desactive",new Image(getClass().getResourceAsStream(Puissance4.chem+"boutColDesactive.png")));
        dicoImage.put("1",new Image(getClass().getResourceAsStream(Puissance4.chem+"boutColRed.png")));
        dicoImage.put("2",new Image(getClass().getResourceAsStream(Puissance4.chem+"boutColYellow.png")));
        this.setImage(dicoImage.get(type));
        this.setPreserveRatio(true);
        this.setFitWidth(25.);
    }
}
