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

        this.primaryStage.setScene(new Scene(new PageAccueil(this.primaryStage), 650, 450));
    }}

