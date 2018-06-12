package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionRetour implements EventHandler<ActionEvent> {

    PageAccueil pa;
    GererJoueur gJoueur;
    String page;

    public ActionRetour(PageAccueil pa) {
        this.pa = pa;
        this.page = "PageAccueil";
    }

    public ActionRetour(PageAccueil pa, GererJoueur gJoueur) {
        this.gJoueur = gJoueur;
        this.pa = pa;
        this.page = "GererJoueur";
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.page.equals("GererJoueur")) {
            this.pa.getBp().setCenter(new GererJoueur(this.pa));
        }
        else {
            this.pa.getBp().setCenter(this.pa.constructB());
        }
    }
}
