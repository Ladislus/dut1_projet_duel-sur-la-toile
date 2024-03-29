package module_joueur;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ExecutableJoueur extends Application {

  public static void main(String [] args) { launch(args); }

  /**
   Lanceur de l'application
   @param primaryStage : La page principale à propager
  */
  @Override
  public void start(Stage primaryStage) {

    ConnexionJoueur connection = new ConnexionJoueur(primaryStage);

    primaryStage.setTitle(connection.getTitle());
    primaryStage.setScene(new Scene(connection, VariablesJoueur.DEFAULT_CONNECTION_WIDTH, VariablesJoueur.DEFAULT_CONNECTION_HEIGHT));

    primaryStage.setResizable(VariablesJoueur.IS_RESIZABLE);
    primaryStage.getIcons().add(VariablesJoueur.LOGO);
    primaryStage.show(); }}
