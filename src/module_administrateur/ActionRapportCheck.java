package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

public class ActionRapportCheck implements EventHandler<ActionEvent> {

    VoirRapport rapp;

    public ActionRapportCheck(VoirRapport rapp) {
        this.rapp = rapp;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        CheckBox cb = (CheckBox) actionEvent.getSource();
        if (cb.isSelected()) {
            this.rapp.getPseudo().setStyle("-fx-font-style: italic;-fx-underline: true;-fx-font-color:#cccccc");
            this.rapp.getRapport().setStyle("-fx-font-style: italic;-fx-font-color:#cccccc");
        }
        else {
            this.rapp.getPseudo().setStyle("-fx-font-weight: bold;-fx-underline: true;");
            this.rapp.getRapport().setStyle("-fx-font-style: normal;-fx-font-color:black");
        }
    }
}
