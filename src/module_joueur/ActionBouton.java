package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

class ActionBouton implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  public ActionBouton(Stage primaryStage) { this.primaryStage = primaryStage; }

  public void handle(ActionEvent actionEvent) {

    Button bt = (Button) actionEvent.getTarget();

    if (bt.getText().contains("Retour")) {

      ConnexionJoueur connection = new ConnexionJoueur(this.primaryStage);

      primaryStage.setTitle(connection.getTitle());
      primaryStage.setScene(new Scene(connection, VariablesJoueur.DEFAULT_CONNECTION_WIDTH, VariablesJoueur.DEFAULT_CONNECTION_HEIGHT)); }

    else if (bt.getText().contains("Vers l'aventure !")) {

      ConnexionJoueur connexion = (ConnexionJoueur) this.primaryStage.getScene().getRoot();

      String login = connexion.getTfLogin().getText();
      String password = connexion.getTfPassword().getText();

    }}}
