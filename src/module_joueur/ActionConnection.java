package module_joueur;

import APIMySQL.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

class ActionConnection implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  private GestionBD laConnection;

  public ActionConnection(Stage primaryStage, GestionBD laConnection) {

    this.primaryStage = primaryStage;
    this.laConnection = laConnection; }

  public void handle(ActionEvent actionEvent) {

    ConnexionJoueur page = (ConnexionJoueur) this.primaryStage.getScene().getRoot();

    String login = page.getTfLogin().getText();
    String password = page.getTfPassword().getText();

    // if () {    TODO tester le login / mdp avec Lucas
    //
    //   Dashboard dashboard = new Dashboard(this.primaryStage, this.laConnection);
    //
    //   this.primaryStage.setTitle(dashboard.getTitle());
    //   this.primaryStage.setScene(new Scene(dashboard, VariablesJoueur.DEFAULT_APPLICATION_WIDTH, VariablesJoueur.DEFAULT_APPLICATION_HEIGHT)); }
    //
    //else{}
}}
