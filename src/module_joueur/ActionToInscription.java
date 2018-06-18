package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

class ActionToInscription implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  

  public ActionToInscription(Stage primaryStage) {

    this.primaryStage = primaryStage;
    }

  public void handle(ActionEvent actionEvent) {

    InscriptionJoueur inscription = new InscriptionJoueur(this.primaryStage);

    primaryStage.setTitle(inscription.getTitle());
    primaryStage.setScene(new Scene(inscription, VariablesJoueur.DEFAULT_REGISTRATION_WIDTH, VariablesJoueur.DEFAULT_REGISTRATION_HEIGHT)); }}
