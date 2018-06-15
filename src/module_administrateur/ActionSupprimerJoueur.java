package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;

public class ActionSupprimerJoueur implements EventHandler<ActionEvent>{

  GererJoueur gJoueur;

  public ActionSupprimerJoueur(GererJoueur gJoueur){
    this.gJoueur = gJoueur;
  }

  @Override
  public void handle(ActionEvent actionEvent){

    Button b = (Button) actionEvent.getSource();
    if((b.getText()) == "Supprimer"){
      ButtonType btoui = new ButtonType("Oui");
      ButtonType btnon = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Confirmation de la suppression");
      alert.setHeaderText("Confirmation suppression");
      alert.setContentText("Voulez-vous vraiment supprimer le(s) joueur(s) ?");
      alert.getButtonTypes().setAll(btoui, btnon);
      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == btoui){
        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Validation de la suppression");
        alert.setHeaderText(null);
        alert.setContentText("Le(s) joueur(s) a/ont bien été supprimé.");
        alert.showAndWait();
      }
    }
  }

}
