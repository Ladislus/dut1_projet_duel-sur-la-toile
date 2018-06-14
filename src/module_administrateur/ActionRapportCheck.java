package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

public class ActionRapportCheck implements EventHandler<ActionEvent> {

    VoirRapport rapp;
    Administration a;
    Rapport r;

    public ActionRapportCheck(VoirRapport rapp, Administration a, Rapport r) {
        this.rapp = rapp;
        this.a = a;
        this.r = r;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        CheckBox cb = (CheckBox) actionEvent.getSource();
        System.out.println(this.a.getRapport().size()-this.a.getRapportLu().size());

        if (cb.isSelected()) {
            //this.rapp.getPseudo().setStyle("-fx-font-style: italic;-fx-underline: true;-fx-font-color:#cccccc");
            //this.rapp.getContenu().setStyle("-fx-font-style: italic;-fx-font-color:#cccccc");
            this.a.ajouterRapportLu(this.r);
        }
        else {
          //  this.rapp.getPseudo().setStyle("-fx-font-weight: bold;-fx-underline: true;");
          //  this.rapp.getContenu().setStyle("-fx-font-style: normal;-fx-font-color:black");
            this.a.retirerRapportLu(this.r);
        }
        if (this.a.getRapportLu().size() > 0) {
            this.rapp.getButtonSuppr().setDisable(false);
        }
        else {
            this.rapp.getButtonSuppr().setDisable(true);
        }

      //  this.rapp.getLabel().setText("Nombre de rapport non lus : "+(this.a.getRapport().size()-this.a.getRapportLu().size()));
    }
}
