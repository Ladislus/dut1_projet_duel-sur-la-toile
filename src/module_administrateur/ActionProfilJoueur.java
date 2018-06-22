package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Contrôleur du bouton profil d'un joueur */
public class ActionProfilJoueur implements EventHandler<ActionEvent> {

    private Stage primaryStage;
    private GererJoueur gJoueur;
    private Joueur joueur;
    private Administration admin;

    /** Constructeur du contrôleur */
    public ActionProfilJoueur(Stage primaryStage, GererJoueur gJoueur, Joueur joueur, Administration admin) {
        this.primaryStage = primaryStage;
        this.gJoueur = gJoueur;
        this.joueur = joueur;
        this.admin = admin;
    }

    /** Change l'affichage de la page courante et deviens la vue du profil d'un joueur */
    @Override
    public void handle(ActionEvent actionEvent) {

        ProfilJoueur pJ = new ProfilJoueur(this.primaryStage, this.gJoueur, this.joueur, this.admin);

        this.primaryStage.setTitle(pJ.getTitle());
        this.primaryStage.setScene(new Scene(pJ, 650, 450));
    }
    public Administration getAdmin() { return this.admin; }
}
