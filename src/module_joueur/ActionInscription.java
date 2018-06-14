package module_joueur;

import APIMySQL.GestionBD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

class ActionInscription implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  private GestionBD laConnection;

  public ActionInscription(Stage primaryStage, GestionBD laConnection) {

    this.primaryStage = primaryStage;
    this.laConnection = laConnection; }

  public void handle(ActionEvent actionEvent) {}}
