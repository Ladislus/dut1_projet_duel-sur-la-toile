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

    /** Constructeur du contrôleur */
    public ActionProfilJoueur(Stage primaryStage, GererJoueur gJoueur, Joueur joueur) {
        this.primaryStage = primaryStage;
        this.gJoueur = gJoueur;
        this.joueur = joueur;
    }

    /** Change l'affichage de la page courante et deviens la vue du profil d'un joueur */
    @Override
    public void handle(ActionEvent actionEvent) {

        ProfilJoueur pJ = new ProfilJoueur(this.primaryStage, this.gJoueur, this.joueur);

        this.primaryStage.setTitle(pJ.getTitle());
        this.primaryStage.setScene(new Scene(new ProfilJoueur(this.primaryStage, this.gJoueur, this.joueur), 650, 450));
    }
}
