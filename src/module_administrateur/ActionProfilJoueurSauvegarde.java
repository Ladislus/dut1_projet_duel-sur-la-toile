package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;

public class ActionProfilJoueurSauvegarde implements EventHandler<ActionEvent>{

  ProfilJoueur pJoueur;

  public ActionProfilJoueurSauvegarde(ProfilJoueur pJoueur){
    this.pJoueur = pJoueur;
  }

  @Override
  public void handle(ActionEvent actionEvent){

    Button b = (Button) actionEvent.getSource();
    if((b.getText()) == "Sauvegarder"){
      ButtonType btoui = new ButtonType("Oui");
      ButtonType btnon = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Confirmation de la sauvegarde");
      alert.setHeaderText("Confirmation sauvegarde");
      alert.setContentText("Voulez-vous vraiment sauvegarder les\n informations modifiées ?");
      alert.getButtonTypes().setAll(btoui, btnon);
      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == btoui){
        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Validation de la sauvegarde");
        alert.setHeaderText(null);
        alert.setContentText("Les informations modifiées ont bien\n été sauvegardées.");
        alert.showAndWait();
      }
    }
  }

}
