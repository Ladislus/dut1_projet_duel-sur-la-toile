package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/** Contrôleur du bouton retour */
public class ActionRetour implements EventHandler<ActionEvent> {

    private PageAccueil pa;
    private GererJoueur gJoueur;
    private String page;

    /** Constructeur du contrôleur pour aller à la page d'accueil */
    public ActionRetour(PageAccueil pa) {
    	this.pa = pa;
    	this.page = "Accueil";
    }

    /** Constructeur du contrôleur dans le cas pour aller à la page gérer les joueurs */
    public ActionRetour(PageAccueil pa, GererJoueur gJoueur) {
    	this.pa = pa;
        this.gJoueur = gJoueur;
        this.page = "GererJoueur";
    }

    /** Regarde à quelle page il faut aller
        Puis modifie le borderpane principal pour afficher la nouvelle page 
        Enfin fait une mise à jour des éléments de l'administration en les réinitialisant à vide (liste, ..) */
    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.page.equals("GererJoueur")) {
            this.pa.getBp().setCenter(new GererJoueur(this.pa));
            this.pa.getAdmin().majAdmin();
        }
        else {
            this.pa.getBp().setCenter(this.pa.constructB());
            this.pa.getAdmin().majAdmin();
        }
    }
}
