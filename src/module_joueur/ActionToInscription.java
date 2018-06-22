package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

class ActionToInscription implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  /**
   Controlleur permettant d'accéder à la page d'inscription
   @param primaryStage : La page principale à propager
  */
  ActionToInscription(Stage primaryStage) { this.primaryStage = primaryStage; }

  /**
   Modifie le contenu de la page principale avec une InscriptionJoueur
   @param actionEvent : L'ActionEvent contenant l'action
  */
  @Override
  public void handle(ActionEvent actionEvent) {

    InscriptionJoueur inscription = new InscriptionJoueur(this.primaryStage);

    primaryStage.setTitle(inscription.getTitle());
    primaryStage.setScene(new Scene(inscription, VariablesJoueur.DEFAULT_REGISTRATION_WIDTH, VariablesJoueur.DEFAULT_REGISTRATION_HEIGHT)); }}
