package module_joueur;

import APIMySQL.ConnexionMySQL;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ExecutableJoueur extends Application {

  public static void main(String [] args) { launch(args); }

  @Override
  public void start(Stage primaryStage) {

    ConnexionMySQL laConnection = null;

    try { laConnection = new ConnexionMySQL("192.168.1.100", "serveurDeJeux", "dst", "dst"); }
    catch(ClassNotFoundException ex) {

      Alert a = new Alert(Alert.AlertType.ERROR);
      a.setTitle("CRITICAL ERROR");
      a.setHeaderText("Impossible de se connecter à la base de donnée");
      a.showAndWait();

      primaryStage.close(); }

    ConnexionJoueur connection = new ConnexionJoueur(primaryStage, laConnection);

    primaryStage.setTitle(connection.getTitle());
    primaryStage.setScene(new Scene(connection, VariablesJoueur.DEFAULT_CONNECTION_WIDTH, VariablesJoueur.DEFAULT_CONNECTION_HEIGHT));

    primaryStage.setResizable(VariablesJoueur.IS_RESIZABLE);
    primaryStage.getIcons().add(VariablesJoueur.LOGO);
    primaryStage.show(); }}
