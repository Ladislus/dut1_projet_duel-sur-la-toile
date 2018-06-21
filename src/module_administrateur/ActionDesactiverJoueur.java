package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;

/** Contrôleur du bouton pour désactiver les joueurs cochés */
public class ActionDesactiverJoueur implements EventHandler<ActionEvent> {

    GererJoueur gJoueur;
    private Stage primaryStage;

    /** Constructeur de ce contrôleur */
    public ActionDesactiverJoueur(GererJoueur gJoueur, Stage primaryStage) {
        this.gJoueur = gJoueur;
        this.primaryStage = primaryStage;
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
        alert.setContentText("Voulez-vous vraiment désactiver le(s)\njoueur(s) coché(s) ?");
        alert.getButtonTypes().setAll(btoui, btnon);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == btoui) {

            PageAccueil page = (PageAccueil) this.primaryStage.getScene().getRoot();

            for (Joueur j : page.getAdmin().getListeModif()) {
                page.getAdmin().desactiverJoueur(j);
            }
            page.getAdmin().majAdmin();
            this.gJoueur.majAffichage();

            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Validation de la désactivation");
            alert.setHeaderText(null);
            alert.setContentText("Le(s) joueur(s) a/ont bien été désactivé(s)");
            alert.showAndWait();
        }
    }
}
