package module_joueur;

import APIMySQL.GestionBD;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class ExecutableJoueur extends Application {

  public static void main(String [] args) { launch(args); }

  @Override
  public void start(Stage primaryStage) {

    GestionBD laConnection = null;

    ConnexionJoueur connection = new ConnexionJoueur(primaryStage, laConnection);

    primaryStage.setTitle(connection.getTitle());
    primaryStage.setScene(new Scene(connection, VariablesJoueur.DEFAULT_CONNECTION_WIDTH, VariablesJoueur.DEFAULT_CONNECTION_HEIGHT));

    primaryStage.setResizable(VariablesJoueur.IS_RESIZABLE);
    primaryStage.getIcons().add(VariablesJoueur.LOGO);
    primaryStage.show(); }}
