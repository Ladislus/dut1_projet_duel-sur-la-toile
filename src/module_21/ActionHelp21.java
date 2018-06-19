package module_21;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

public class ActionHelp21 implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aide");
        alert.setHeaderText("Qu'est-ce que le jeu des 21 Bâtonnets ?");
        alert.setContentText("Aussi appelé Jeu de Nim...\n" +
                "Ce jeu en 1v1 est un jeu de réflexion dont la règle est très simple :\n\n" +
                "Vous avez 21 Batônnets face à vous (ce qui explique un peu le nom du jeu) et les adversaires y retirent " +
                "chacun leur tour 1, 2 ou 3 Bâtonnets. Celui qui est contraint de retirer le dernier a perdu !\n\n" +
                "NB : Commencez à droite !\n\n" +
                "Bonne chance !");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.showAndWait();

    }
}
