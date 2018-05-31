import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ActionRegister implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        InscriptionJoueur ij = new InscriptionJoueur();
        ij.start(new Stage());
    }
}
