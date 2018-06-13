package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

public class ActionRapportCheck implements EventHandler<ActionEvent> {

    VoirRapport rapp;
    Administration a;
    String joueur;
    String rapport;
    String res;

    public ActionRapportCheck(VoirRapport rapp, Administration a, String joueur, String rapport) {
        this.rapp = rapp;
        this.a = a;
        this.joueur = joueur;
        this.rapport = rapport;
        this.res = this.joueur+" : "+this.rapport;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        CheckBox cb = (CheckBox) actionEvent.getSource();
        if (cb.isSelected()) {
            this.rapp.getPseudo().setStyle("-fx-font-style: italic;-fx-underline: true;-fx-font-color:#cccccc");
            this.rapp.getRapport().setStyle("-fx-font-style: italic;-fx-font-color:#cccccc");
            this.a.ajouterRapportLu(this.res);
        }
        else {
            this.rapp.getPseudo().setStyle("-fx-font-weight: bold;-fx-underline: true;");
            this.rapp.getRapport().setStyle("-fx-font-style: normal;-fx-font-color:black");
            this.a.retirerRapportLu(this.res);
        }
        System.out.println(this.a.getRapportLu());
    }
}
