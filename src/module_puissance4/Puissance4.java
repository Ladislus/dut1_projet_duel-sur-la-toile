package module_puissance4;

import javafx.application.Application;
import javafx.stage.Stage;

public class Puissance4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setResizable(false);
        primaryStage.setTitle("Duel sur la toile - Connect 4");
        primaryStage.setScene(new Partie().getScene());
        primaryStage.show();
    }
}
