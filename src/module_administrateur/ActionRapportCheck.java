package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import java.util.Collections;

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
            this.r.getLabPseudo().setStyle("-fx-font-style: italic;-fx-underline: true;-fx-font-color:#cccccc");
            this.r.getLabContenu().setStyle("-fx-font-style: italic;-fx-font-color:#cccccc");
            this.a.ajouterRapportLu(this.r);
            this.r.setLu(true);
        }
        else {
            this.r.getLabPseudo().setStyle("-fx-font-weight: bold;-fx-underline: true;");
            this.r.getLabContenu().setStyle("-fx-font-style: normal;-fx-font-color:black");
            this.a.retirerRapportLu(this.r);
            this.r.setLu(false);
        }
        if (this.a.getRapportLu().size() > 0) {
            this.rapp.getButtonSuppr().setDisable(false);
        }
        else {
            this.rapp.getButtonSuppr().setDisable(true);
        }

        Collections.sort(this.rapp.getListe(), new CompCheck());

        System.out.println(this.rapp.getListe());

    //  this.rapp.getLabel().setText("Nombre de rapport non lus : "+(this.a.getRapport().size()-this.a.getRapportLu().size()));
    }
}
