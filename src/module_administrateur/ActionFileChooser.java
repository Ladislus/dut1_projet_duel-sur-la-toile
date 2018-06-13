package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.FileChooser;
import javafx.scene.control.*;
import java.io.File;
import javafx.scene.image.ImageView;

public class ActionFileChooser implements EventHandler<ActionEvent> {

    private GererJeu gJeu;
    private ProfilJoueur pJoueur;
    private ListView listview;

    public ActionFileChooser(GererJeu gJeu){
      this.gJeu = gJeu;
    }

    public ActionFileChooser(ProfilJoueur pJoueur){
      this.pJoueur = pJoueur;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

      Button b = (Button) actionEvent.getSource();
      FileChooser fc = new FileChooser();
      //fc.setInitialDirectory(new File("/home/nmartins/Documents/"));
      File fichierSelectionne = fc.showOpenDialog(null);
      fc.getExtensionFilters().addAll(new ExtensionFilter(
        "Image Files", "*.png", "*.jpg"));

      if (fichierSelectionne != null){
        if (fichierSelectionne.getName().contains(".png") || fichierSelectionne.getName().contains(".jpg")){
          listview.getItems().add(fichierSelectionne.getName());
          ImageView imagefilechooser = new ImageView(fichierSelectionne.toURI().toString());
        }
        else{
          Alert reponse = new Alert(Alert.AlertType.INFORMATION);
          reponse.setHeaderText("Le fichier n'est pas valide !");
          reponse.showAndWait();
        }
      }
      else{
        Alert reponse = new Alert(Alert.AlertType.INFORMATION);
        reponse.setHeaderText("Vous n'avez sélectionné aucun fichier !");
        reponse.showAndWait();
      }
    }
}
