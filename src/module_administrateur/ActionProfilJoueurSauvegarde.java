package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;
import APIMySQL.*;

public class ActionProfilJoueurSauvegarde implements EventHandler<ActionEvent>{

  ProfilJoueur pJoueur;
  Joueur joueur;

  public ActionProfilJoueurSauvegarde(ProfilJoueur pJoueur, Joueur joueur){
    this.pJoueur = pJoueur;
    this.joueur = joueur;
  }

  @Override
  public void handle(ActionEvent actionEvent){
    Button b = (Button) actionEvent.getSource();
    if((b.getText()) == "Sauvegarder"){
      ButtonType btoui = new ButtonType("Oui");
      ButtonType btnon = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Confirmation de la sauvegarde");
      alert.setHeaderText("Confirmation sauvegarde");
      alert.setContentText("Voulez-vous vraiment sauvegarder les\ninformations modifiées ?");
      alert.getButtonTypes().setAll(btoui, btnon);
      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == btoui){
          // GESTION DESACTIVATION JOUEUR
          if (Utilisateur.isActivated(this.joueur.getPseudo()) && this.pJoueur.getRbpasactiver().isSelected()) {
              Utilisateur.setUserInfo("activeUt", 0, "pseudoUt", this.joueur.getPseudo());
          }
          else if (!(Utilisateur.isActivated(this.joueur.getPseudo())) && this.pJoueur.getRbactiver().isSelected()) {
              Utilisateur.setUserInfo("activeUt", 1, "pseudoUt", this.joueur.getPseudo());
          }

          // GESTION MODIF PSEUDO
          if (!(joueur.getPseudo().equals(this.pJoueur.getTFpseudo()))) {
              Utilisateur.setUserInfo("pseudoUt", this.pJoueur.getTFpseudo(), "pseudoUt", this.joueur.getPseudo());
          }

          //GESTION MODIF EMAIL
          if (!(joueur.getEmail().equals(this.pJoueur.getTFemail()))) {
              Utilisateur.setUserInfo("emailUt", this.pJoueur.getTFemail(), "pseudoUt", this.joueur.getPseudo());
          }



        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Validation de la sauvegarde");
        alert.setHeaderText(null);
        alert.setContentText("Les informations modifiées ont bien\nété sauvegardées.");
        alert.showAndWait();
      }
    }
  }

}
