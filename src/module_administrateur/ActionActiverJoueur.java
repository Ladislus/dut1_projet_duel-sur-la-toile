package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;

public class ActionActiverJoueur implements EventHandler<ActionEvent>{

  GererJoueur gJoueur;

  public ActionActiverJoueur(GererJoueur gJoueur){
    this.gJoueur = gJoueur;
  }

  @Override
  public void handle(ActionEvent actionEvent){

    Button b = (Button) actionEvent.getSource();
    if((b.getText()) == "Activer"){
      ButtonType btoui = new ButtonType("Oui");
      ButtonType btnon = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Confirmation de l'activation");
      alert.setHeaderText("Confirmation activation");
      alert.setContentText("Voulez-vous vraiment activer le joueur ?");
      alert.getButtonTypes().setAll(btoui, btnon);
      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == btoui){
        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Validation de l'activation");
        alert.setHeaderText(null);
        alert.setContentText("Le joueur a bien été activé.");
        alert.showAndWait();
      }
    }
  }

}
