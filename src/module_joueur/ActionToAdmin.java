package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import module_administrateur.PageAccueil;

public class ActionToAdmin implements EventHandler<ActionEvent> {

    private Stage primaryStage;

    public ActionToAdmin(Stage primaryStage) { this.primaryStage = primaryStage; }

    @Override
    public void handle(ActionEvent actionEvent) {

        Stage secondaryStage = new Stage();

        PageAccueil pageAccueil = new PageAccueil(secondaryStage);

        secondaryStage.setTitle(pageAccueil.getTitle());
        secondaryStage.setScene(new Scene(pageAccueil, 650, 450));
        secondaryStage.show();
    }}

