package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

class ActionRetourToConnexion implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  /**
   Controlleur permettant de passé de InscriptionJoueur à ConnexionJoueur
   * @param primaryStage : La page principale propager
   */
  ActionRetourToConnexion(Stage primaryStage) { this.primaryStage = primaryStage; }

  /**
   Action créant le contenu de la page de connexion et l'affichant
   @param actionEvent : L'ActionEvent contenant l'action
  */
  @Override
  public void handle(ActionEvent actionEvent) {

    ConnexionJoueur connexion = new ConnexionJoueur(this.primaryStage);

    this.primaryStage.setTitle(connexion.getTitle());
    this.primaryStage.setScene(new Scene(connexion, VariablesJoueur.DEFAULT_CONNECTION_WIDTH, VariablesJoueur.DEFAULT_CONNECTION_HEIGHT)); }}
