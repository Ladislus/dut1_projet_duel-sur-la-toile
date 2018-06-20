package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;

/** Contrôleur du bouton pour activer les joueurs cochés */
public class ActionActiverJoueur implements EventHandler<ActionEvent> {

    GererJoueur gJoueur;
    PageAccueil pa;

    /** Constructeur de ce contrôleur */
    public ActionActiverJoueur(GererJoueur gJoueur, PageAccueil pa) {
        this.gJoueur = gJoueur;
        this.pa = pa;
    }

    /** Affiche une alerte de confirmation d'activation des joueurs cochés
        Si l'administrateur clique sur oui, chaque joueur dans la liste des joueurs à changer de statut sont activés
        Puis mise à jour de l'administration avec une réinitialisation de la liste et de l'affichage
        Enfin affiche une confirmation définitive d'activation */
    @Override
    public void handle(ActionEvent actionEvent) {
        ButtonType btoui = new ButtonType("Oui");
        ButtonType btnon = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de l'activation");
        alert.setHeaderText("Confirmation d'activation de joueur");
        alert.setContentText("Voulez-vous vraiment activer le(s) joueur(s) coché(s) ?");
        alert.getButtonTypes().setAll(btoui, btnon);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == btoui) {
            for (Joueur j : this.pa.getAdmin().getListeModif()) {
                this.pa.getAdmin().activerJoueur(j);
            }
            this.pa.getAdmin().majAdmin();
            this.gJoueur.majAffichage();

            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Validation de l'activation");
            alert.setHeaderText(null);
            alert.setContentText("Le(s) joueur(s) a/ont bien été activé(s)");
            alert.showAndWait();
        }
    }
}
