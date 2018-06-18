package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;

public class ActionGererJeuDesactiver implements EventHandler<ActionEvent>{

  GererJeu gJeu;

  public ActionGererJeuDesactiver(GererJeu gJeu){
    this.gJeu = gJeu;
  }

  @Override
  public void handle(ActionEvent actionEvent){

    Button b = (Button) actionEvent.getSource();
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Validation de la désactivation");
    alert.setHeaderText(null);
    alert.setContentText("Le jeu ne sera pas activé.");
    alert.showAndWait();
  }

}
