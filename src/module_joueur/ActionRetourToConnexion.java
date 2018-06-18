package module_joueur;

import APIMySQL.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

class ActionRetourToConnexion implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  public ActionRetourToConnexion(Stage primaryStage) { this.primaryStage = primaryStage; }

  public void handle(ActionEvent actionEvent) {

    ConnexionJoueur connexion = new ConnexionJoueur(this.primaryStage);

    this.primaryStage.setTitle(connexion.getTitle());
    this.primaryStage.setScene(new Scene(connexion, VariablesJoueur.DEFAULT_CONNECTION_WIDTH, VariablesJoueur.DEFAULT_CONNECTION_HEIGHT)); }}
