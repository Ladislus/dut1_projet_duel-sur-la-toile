package module_joueur;


import APIMySQL.GestionBD;
import APIMySQL.Utilisateur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ActionEnregistrer implements EventHandler<ActionEvent> {
    EditionProfil editionProfil;

    public ActionEnregistrer(EditionProfil editionProfil){
        this.editionProfil = editionProfil;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String email = editionProfil.getTfEmail().getText();
        String pseudo = editionProfil.getTfEmail().getText();
        String motdepasse = editionProfil.getPfMotDePasse().getText();
        String confirmMotDePasse = editionProfil.getPfConfirmMotDePasse().getText();

        
    }
}
