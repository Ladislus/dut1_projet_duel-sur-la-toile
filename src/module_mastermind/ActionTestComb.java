package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
        Button valider = (Button) actionEvent.getSource();
        if (plateauM.getCombiCour().isFull()){
            plateauM.jouerUnCoup();
            System.out.println(this.mastermind.getPlateau().getListeEssais().size());
            if (plateauM.aTrouveCombi()){
                this.mastermind.getChrono().stop();
<<<<<<< HEAD
=======
                valider.setDisable(true);
>>>>>>> b6ecb6fdb30e489c0723ceeda621a7e39e2b51c9
                Double temps = Double.parseDouble(this.mastermind.getChrono().getTime());
                int nbEssais = this.mastermind.getPlateau().getListeEssais().size();

                Double score = (temps/nbEssais)*10;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("VICTOIRE !");
                alert.setHeaderText("Vous avez gagné !");
                alert.setContentText("Bravo, vous avez trouvé la combinaison !\n" +
                        " Votre score est de "+score+" points ! \n" +
                        "Cliquer sur le bouton \"Rejouer\" pour refaire une partie, et sur \"Quitter\" pour arrêter.\n" +
                        "Bon jeu !");
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.showAndWait();
            }
            this.mastermind.ajouteResultat();

        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText("Combinaison incomplète");
            alert.setContentText("Veuillez mettre un pion sur chaque emplacement avant de valider.");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
//        System.out.println(plateauM.getListeEssais());
        this.mastermind.majAffichage();
    }
}
