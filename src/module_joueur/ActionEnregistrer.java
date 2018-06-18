package module_joueur;


import APIMySQL.GestionBD;
import APIMySQL.Utilisateur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ActionEnregistrer implements EventHandler<ActionEvent> {
    EditionProfil editionProfil;
    Joueur joueur;

    public ActionEnregistrer(EditionProfil editionProfil, Joueur joueur){
        this.editionProfil = editionProfil;
        this.joueur = joueur;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String email = editionProfil.getTfEmail().getText();
        String ancientPseudo = joueur.getPseudo();
        String pseudo = editionProfil.getTfPseudo().getText();
        String motdepasse = editionProfil.getPfMotDePasse().getText();
        String confirmMotDePasse = editionProfil.getPfConfirmMotDePasse().getText();

        if(motdepasse.equals(confirmMotDePasse)){
            if (!VariablesJoueur.PASSWORD_PATTERN.matcher(motdepasse).find()&&!editionProfil.getPfMotDePasse().isDisable()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Edition utilisateur");
                alert.setHeaderText("Votre mot de passe n'est pas valide");
                alert.showAndWait();
            }
            else if(!VariablesJoueur.EMAIL_PATTERN.matcher(email).find()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Edition utilisateur");
                alert.setHeaderText("Votre adresse email n'est pas valide");
                alert.showAndWait();
            }
            else{
                Utilisateur.updateUtilisateur(pseudo, email, motdepasse, ancientPseudo);
                joueur.setEmail(email);
                joueur.setPseudo(pseudo);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Edition utilisateur");
                alert.setHeaderText("Votre modification a bien été enregistrer");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Edition utilisateur");
            alert.setHeaderText("Votre nouveau mot de passe de corespondent pas");
            alert.showAndWait();
        }

    }
}
