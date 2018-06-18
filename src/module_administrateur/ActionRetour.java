package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionRetour implements EventHandler<ActionEvent> {

    private PageAccueil pa;
    private GererJoueur gJoueur;
    private String page;

    public ActionRetour(PageAccueil pa) {
    	this.pa = pa;
    	this.page = "Accueil";
    }

    public ActionRetour(PageAccueil pa, GererJoueur gJoueur) {
    	this.pa = pa;
      this.gJoueur = gJoueur;
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
