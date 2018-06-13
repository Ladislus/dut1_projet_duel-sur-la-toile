package module_puissance4;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.util.HashMap;

import static module_puissance4.Puissance4.chem;

public class ImgBouton extends ImageView {

    private static HashMap<String,File> dicoImage;

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
