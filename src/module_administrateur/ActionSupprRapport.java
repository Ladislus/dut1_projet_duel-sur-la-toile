package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar;
import java.util.Optional;

public class ActionSupprRapport implements EventHandler<ActionEvent> {

    VoirRapport rapp;
    Administration a;

    public ActionSupprRapport(VoirRapport rapp, Administration a) {
        this.rapp = rapp;
        this.a = a;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Confirmation");
      alert.setHeaderText("Confirmation de suppression");
      alert.setContentText("Voulez-vous vraiment supprimer ces profils ?");
      ButtonType buttonTypeOne = new ButtonType("Oui");
      ButtonType buttonTypeTwo = new ButtonType("Non");
      alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == buttonTypeOne){
          for (Rapport r : this.a.getRapportLu()) {
              this.a.supprimerRapportLu(r);
              this.rapp.getVBoxListeRapport().getChildren().remove(r.getB());
          }
      }
    }
}
