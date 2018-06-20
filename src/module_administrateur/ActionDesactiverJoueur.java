package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;

/** Contrôleur du bouton pour désactiver les joueurs cochés */
public class ActionDesactiverJoueur implements EventHandler<ActionEvent> {

    GererJoueur gJoueur;
    PageAccueil pa;

    /** Constructeur de ce contrôleur */
    public ActionDesactiverJoueur(GererJoueur gJoueur, PageAccueil pa) {
        this.gJoueur = gJoueur;
        this.pa = pa;
    }

    /** Affiche une alerte de confirmation de désactivation des joueurs cochés
        Si l'administrateur clique sur oui, chaque joueur dans la liste des joueurs à changer de statut sont désactivés
        Puis mise à jour de l'administration avec une réinitialisation de la liste et de l'affichage
        Enfin affiche une confirmation définitive de désactivation */
    @Override
    public void handle(ActionEvent actionEvent) {
        ButtonType btoui = new ButtonType("Oui");
        ButtonType btnon = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de la désactivation");
        alert.setHeaderText("Confirmation de désactivation de joueur");
        alert.setContentText("Voulez-vous vraiment désactiver le(s) joueur(s) coché(s) ?");
        alert.getButtonTypes().setAll(btoui, btnon);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == btoui) {
            for (Joueur j : this.pa.getAdmin().getListeModif()) {
                this.pa.getAdmin().desactiverJoueur(j);
            }
            this.pa.getAdmin().majAdmin();
            this.gJoueur.majAffichage();

            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Validation de la désactivation");
            alert.setHeaderText(null);
            alert.setContentText("Le(s) joueur(s) a/ont bien été désactivé(s)");
            alert.showAndWait();
        }
    }
}