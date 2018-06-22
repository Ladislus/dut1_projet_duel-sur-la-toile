package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionJeu implements EventHandler<ActionEvent> {

    private Stage primaryStage;

    public ActionJeu(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        GererJeu gJ = new GererJeu(this.primaryStage);

        this.primaryStage.setTitle(gJ.getTitle());
        this.primaryStage.setScene(new Scene(gJ, 650, 450)); }}
