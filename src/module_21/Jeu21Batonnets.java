package module_21;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Le Stage principal du jeu des 21 Bâtonnets
 * Étend Application
 */
public class Jeu21Batonnets extends Application {

    /** Le Stage principal */
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        primaryStage.setTitle("Duel sur la toile - 21 Bâtonnets");
        primaryStage.setScene(new Partie21(this,"Jean-Claude","~KikouDu45~").getScene());
        primaryStage.show();
    }

    private Scene pageAccueil() {
        BorderPane res = new BorderPane();

        return new Scene(res,850,650);
    }

    public void setScene(String titre){

    }

}
