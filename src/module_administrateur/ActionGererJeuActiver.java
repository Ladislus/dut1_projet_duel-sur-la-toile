package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;

public class ActionGererJeuActiver implements EventHandler<ActionEvent>{

  GererJeu gJeu;

  public ActionGererJeuActiver(GererJeu gJeu){
    this.gJeu = gJeu;
  }

  @Override
  public void handle(ActionEvent actionEvent){

    Button b = (Button) actionEvent.getSource();
    if((b.getText()) == "Activer"){
      b.setDisable(true);
    }
    else{
      b.setDisable(false);
    }
  }

}
