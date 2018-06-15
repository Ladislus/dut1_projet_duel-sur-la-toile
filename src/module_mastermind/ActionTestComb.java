package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ActionTestComb implements EventHandler<ActionEvent> {

    private PartieM mastermind;

    public ActionTestComb(PartieM mastermind) {
        this.mastermind = mastermind;
    }

    @Override
    /***
     *
     */
    public void handle(ActionEvent actionEvent){
        PlateauM plateauM = this.mastermind.getPlateau();
        plateauM.jouerUnCoup();
        if (plateauM.aTrouveCombi()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VICTOIRE !");
            alert.setHeaderText("Vous avez gagné !");
            alert.setContentText("Bravo, vous avez trouvé la combinaison !\n" +
                    " Votre score est de xxx points ! \n" +
                    "Cliquer sur le bouton \"Rejouer\" pour refaire une partie, et sur \"Quitter\" pour arrêter.\n" +
                    "Bon jeu !");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("DÉFAITE ...");
            alert.setHeaderText("Vous avez perdu ...");
            alert.setContentText("Malheureusement, vous n'avez pas réussi cette fois-ci.\n" +
                    "Retentez votre chance en cliquant sur \"Rejouer\" ou arrêtez vous ici en cliquant sur \"Quitter\".");
        }
        this.mastermind.majAffichage();
    }
}
