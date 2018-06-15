package module_joueur;

import APIMySQL.GestionBD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

class ActionBack implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  private GestionBD laConnection;

  public ActionBack(Stage primaryStage, GestionBD laConnection) {

    this.primaryStage = primaryStage;
    this.laConnection = laConnection; }

  public void handle(ActionEvent actionEvent) {

    ConnexionJoueur connexion = new ConnexionJoueur(this.primaryStage, this.laConnection);

    this.primaryStage.setTitle(connexion.getTitle());
    this.primaryStage.setScene(new Scene(connexion, VariablesJoueur.DEFAULT_CONNECTION_WIDTH, VariablesJoueur.DEFAULT_CONNECTION_HEIGHT)); }}