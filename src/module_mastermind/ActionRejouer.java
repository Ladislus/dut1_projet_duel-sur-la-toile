package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;

import java.util.Optional;

public class ActionRejouer implements EventHandler<ActionEvent> {

    private PartieM mastermind;

    /**
     * Constructeur de ActionRejouer
     * @param m une PartieM
     */
    public ActionRejouer(PartieM m) {
        super();
        this.mastermind = m;
        }

    /**
     * Méthode appelée lors de l'utilisation du controlleur, permet de rejouer avec pop-up de confirmation
     * @param actionEvent un ActionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Rejouer");
        alert.setHeaderText("Recommencer une partie");
        alert.setContentText("Voulez vous vraiment recommencer une nouvelle partie ?\n" +
                "Toute progression actuelle sera perdue");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        Optional<ButtonType> result = alert.showAndWait();
        ButtonType button = result.orElse(ButtonType.CANCEL);

        if (button == ButtonType.OK) {
            this.mastermind.majBD();
            this.mastermind.setP(new PlateauM(this.mastermind.getJ1().getNom(),this.mastermind.getJ2().getNom()));
            this.mastermind.getChrono().stop();
            this.mastermind.getChrono().resetTime();
            this.mastermind.resetAffichage();
            this.mastermind.getChrono().start();
            this.mastermind.getValider().setDisable(false);
        }

    }
}
