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

    EditionProfil editionProfil = new EditionProfil(primaryStage);

    primaryStage.setTitle(editionProfil.getTitle());
    primaryStage.setScene(new Scene(editionProfil, VariablesJoueur.DEFAULT_CONNECTION_WIDTH, VariablesJoueur.DEFAULT_CONNECTION_HEIGHT));

    primaryStage.setResizable(VariablesJoueur.IS_RESIZABLE);
    primaryStage.getIcons().add(VariablesJoueur.LOGO);
    primaryStage.show(); }}
