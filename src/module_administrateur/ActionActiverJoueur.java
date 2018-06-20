package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;
import APIMySQL.*;

public class ActionActiverJoueur implements EventHandler<ActionEvent>{

  GererJoueur gJoueur;
  PageAccueil pa;

  public ActionActiverJoueur(GererJoueur gJoueur, PageAccueil pa){
    this.gJoueur = gJoueur;
    this.pa = pa;
  }

  @Override
  public void handle(ActionEvent actionEvent){
    Button b = (Button) actionEvent.getSource();
    if ((b.getText()) == "Activer"){
        ButtonType btoui = new ButtonType("Oui");
        ButtonType btnon = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de l'activation");
        alert.setHeaderText("Confirmation activation");
        alert.setContentText("Voulez-vous vraiment activer le(s) joueur(s) ?");
        alert.getButtonTypes().setAll(btoui, btnon);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == btoui){
            for (Joueur j : this.pa.getAdmin().getJoueurAactiver()) {
                Utilisateur.setUserInfo("activeUt", 1, "pseudoUt", j.getPseudo());
            }
            this.pa.getAdmin().retirerTousJoueurActiver(this.pa.getAdmin().getJoueurAactiver());
            this.gJoueur.majAffichage();

            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Validation de l'activation");
            alert.setHeaderText(null);
            alert.setContentText("Le(s) joueur(s) a/ont bien été activé.");
            alert.showAndWait();
        }
    }
  }

}
