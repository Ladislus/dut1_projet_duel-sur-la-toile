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
    private static HashMap<String,File> dicoImage;

    public ImgBouton(String type) {
        super();

        dicoImage = new HashMap<>();
        try {
            dicoImage.put("desactive",new File(getClass().getResource(Puissance4.chem+"boutColDesactive.png").toURI()));
            dicoImage.put("1",new File(getClass().getResource(Puissance4.chem+"boutColRed.png").toURI()));
            dicoImage.put("2",new File(getClass().getResource(Puissance4.chem+"boutColYellow.png").toURI()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        this.setImage(new Image(dicoImage.get(type).toURI().toString()));
        this.setPreserveRatio(true);
        this.setFitWidth(25.);
    }
}
