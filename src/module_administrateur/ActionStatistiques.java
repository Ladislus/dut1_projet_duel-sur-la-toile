package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionStatistiques implements EventHandler<ActionEvent> {

    private Stage primaryStage;

    public ActionStatistiques(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        VoirStatistiques stat = new VoirStatistiques(this.primaryStage);

        this.primaryStage.setTitle(stat.getTitle());
        this.primaryStage.setScene(new Scene(stat, 650, 450));
    }
}
