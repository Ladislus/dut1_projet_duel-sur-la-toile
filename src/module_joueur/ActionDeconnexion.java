package module_joueur;

import APIMySQL.ConnexionMySQL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionDeconnexion implements EventHandler<ActionEvent> {

    Stage primaryStage;
    ConnexionMySQL laConnection;

    public ActionDeconnexion(Stage primaryStage, ConnexionMySQL laConnection){
        this.laConnection = laConnection;
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ConnexionJoueur connexion = new ConnexionJoueur(this.primaryStage, this.laConnection);

        this.primaryStage.setTitle(connexion.getTitle());
        this.primaryStage.setScene(new Scene(connexion, VariablesJoueur.DEFAULT_CONNECTION_WIDTH, VariablesJoueur.DEFAULT_CONNECTION_HEIGHT));
    }
}
