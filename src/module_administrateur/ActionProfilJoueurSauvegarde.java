package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;
import APIMySQL.*;

/** Contrôleur du bouton sauvegarder les modifications d'un joueur */
public class ActionProfilJoueurSauvegarde implements EventHandler<ActionEvent> {

    ProfilJoueur pJoueur;
    Joueur joueur;

    /** Constructeur du contrôleur */
    public ActionProfilJoueurSauvegarde(ProfilJoueur pJoueur, Joueur joueur) {
        this.pJoueur = pJoueur;
        this.joueur = joueur;
    }

    /** Affiche une alerte de confirmation de sauvegarde des informations modifiées du joueur
        Si l'administrateur clique sur oui, cherche quelles informations ont été modifiées
        Les modifie dans la base de donnée
        Puis affiche une confirmation définitive de sauvegarde */
    @Override
    public void handle(ActionEvent actionEvent) {
        ButtonType btoui = new ButtonType("Oui");
        ButtonType btnon = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de la sauvegarde");
        alert.setHeaderText("Confirmation de sauvegarde");
        alert.setContentText("Voulez-vous vraiment sauvegarder les\ninformations modifiées ?");
        alert.getButtonTypes().setAll(btoui, btnon);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == btoui) {
            // GESTION DESACTIVATION JOUEUR
            if (Utilisateur.isActivated(this.joueur.getPseudo()) && this.pJoueur.getRbpasactiver().isSelected()) {
                this.pJoueur.getPa().getAdmin().desactiverJoueur(this.joueur);
            }
            else if (!(Utilisateur.isActivated(this.joueur.getPseudo())) && this.pJoueur.getRbactiver().isSelected()) {
                this.pJoueur.getPa().getAdmin().activerJoueur(this.joueur);
            }

            // GESTION MODIF PSEUDO
            if (!(joueur.getPseudo().equals(this.pJoueur.getTFpseudo()))) {
                Utilisateur.setUserInfo("pseudoUt", this.pJoueur.getTFpseudo(), "pseudoUt", this.joueur.getPseudo());
            }

            // GESTION MODIF PRENOM
            if (!(joueur.getPrenom().equals(this.pJoueur.getTFprenom()))) {
                Utilisateur.setUserInfo("prenom", this.pJoueur.getTFprenom(), "pseudoUt", this.joueur.getPseudo());
            }

            // GESTION MODIF NOM
            if (!(joueur.getNom().equals(this.pJoueur.getTFnom()))) {
                Utilisateur.setUserInfo("nom", this.pJoueur.getTFnom(), "pseudoUt", this.joueur.getPseudo());
            }

            // GESTION MODIF SEXE
            if (joueur.getSexe().equals("M") && this.pJoueur.getSexeF().isSelected()) {
                Utilisateur.setUserInfo("sexe", "F", "pseudoUt", this.joueur.getPseudo());
            }
            else if (joueur.getSexe().equals("F") && this.pJoueur.getSexeH().isSelected()) {
                Utilisateur.setUserInfo("sexe", "M", "pseudoUt", this.joueur.getPseudo());
            }

            // GESTION MODIF ROLE
            if (joueur.getRole().equals("USER") && this.pJoueur.getCbrole().getValue().equals("Administrateur")) {
                Utilisateur.setUserInfo("nomRole", "ADMIN", "pseudoUt", this.joueur.getPseudo());
            }
            else if (joueur.getRole().equals("ADMIN") && this.pJoueur.getCbrole().getValue().equals("Utilisateur")) {
                Utilisateur.setUserInfo("nomRole", "USER", "pseudoUt", this.joueur.getPseudo());
            }

            // GESTION MODIF EMAIL
            if (!(joueur.getEmail().equals(this.pJoueur.getTFemail()))) {
                Utilisateur.setUserInfo("emailUt", this.pJoueur.getTFemail(), "pseudoUt", this.joueur.getPseudo());
            }

            // GESTION MODIF IMAGE PROFIL


            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Validation de la sauvegarde");
            alert.setHeaderText(null);
            alert.setContentText("Les informations modifiées ont bien\nété sauvegardées.");
            alert.showAndWait();
        }
    }
}
