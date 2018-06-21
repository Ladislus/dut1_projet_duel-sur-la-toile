package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionUtilisateurs implements EventHandler<ActionEvent> {

    private Stage primaryStage;

    private Administration admin;

    public ActionUtilisateurs(Stage primaryStage, Administration admin) {

        this.admin = admin;
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        GererJoueur gJ = new GererJoueur(this.primaryStage, this.admin);

        this.primaryStage.setScene(new Scene(gJ, 650, 450));
        this.primaryStage.setTitle(gJ.getTitle());
    }
}
