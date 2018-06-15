package module_joueur;

import APIMySQL.ConnexionMySQL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

class ActionToInscription implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  private ConnexionMySQL laConnection;

  public ActionToInscription(Stage primaryStage, ConnexionMySQL laConnection) {

    this.primaryStage = primaryStage;
    this.laConnection = laConnection; }

  public void handle(ActionEvent actionEvent) {

    InscriptionJoueur inscription = new InscriptionJoueur(this.primaryStage, this.laConnection);

    primaryStage.setTitle(inscription.getTitle());
    primaryStage.setScene(new Scene(inscription, VariablesJoueur.DEFAULT_REGISTRATION_WIDTH, VariablesJoueur.DEFAULT_REGISTRATION_HEIGHT)); }}
