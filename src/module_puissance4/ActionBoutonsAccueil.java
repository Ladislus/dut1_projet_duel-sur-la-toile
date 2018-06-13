package module_puissance4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ActionBoutonsAccueil implements EventHandler<ActionEvent> {
    // Contrôleur des boutons de l'accueil.

    private Puissance4 puissance4;

    public ActionBoutonsAccueil(Puissance4 puissance4){
        this.puissance4 = puissance4;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        puissance4.setScene("PartieP4");
    }
}
