package module_joueur;

import APIMySQL.GestionBD;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ExecutableJoueur extends Application {

  public static void main(String [] args) { launch(args); }


  @Override
  public void start(Stage primaryStage) {
      GestionBD laConnection = null;
      EditionProfil connection = new EditionProfil(primaryStage);
      ConnexionJoueur cj = new ConnexionJoueur(primaryStage, laConnection);

      primaryStage.setTitle(connection.getTitle());
      primaryStage.setScene(new Scene(connection, VariablesJoueur.DEFAULT_EDITERPROFILE_WIDTH, VariablesJoueur.DEFAULT_EDITERPROFILE_HEIGHT));
      primaryStage.setResizable(VariablesJoueur.IS_RESIZABLE);
      primaryStage.getIcons().add(VariablesJoueur.LOGO);
      primaryStage.show();
  }
}
