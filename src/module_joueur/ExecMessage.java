package module_joueur;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExecMessage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(new Messagerie(),850,650));
        primaryStage.show();
    }
}
