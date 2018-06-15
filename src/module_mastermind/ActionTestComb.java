package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

public class ActionTestComb implements EventHandler<ActionEvent> {

    private PartieM mastermind;

    public ActionTestComb(PartieM mastermind) {
        this.mastermind = mastermind;
    }

    @Override
    /**
     * Test si la combinaison est complete, si oui, le plateauM est actualisé, en cas de victoire, affiche une pop up
     * si non, affiche une pop up d'erreur
     */
    public void handle(ActionEvent actionEvent){
        PlateauM plateauM = this.mastermind.getPlateau();
        if (!plateauM.getCombiCour().isFull()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Combinaison incomplète");
            alert.setContentText("Veuillez mettre un pion sur chaque emplacement avant de valider.");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
        plateauM.jouerUnCoup();
        if (plateauM.aTrouveCombi()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VICTOIRE !");
            alert.setHeaderText("Vous avez gagné !");
            alert.setContentText("Bravo, vous avez trouvé la combinaison !\n" +
                    " Votre score est de xxx points ! \n" +
                    "Cliquer sur le bouton \"Rejouer\" pour refaire une partie, et sur \"Quitter\" pour arrêter.\n" +
                    "Bon jeu !");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
        this.mastermind.majAffichage();
    }
}
