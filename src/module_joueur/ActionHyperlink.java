package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.Scene;
import javafx.stage.Stage;

class ActionHyperlink implements EventHandler<ActionEvent> {

  Stage primaryStage;

  public ActionHyperlink(Stage primaryStage) { this.primaryStage = primaryStage; }

  public void handle(ActionEvent actionEvent) {

    Hyperlink hl = (Hyperlink) actionEvent.getTarget();

    if (hl.getText().contains("Pas de compte ? S'inscrire maintenant")) {

      InscriptionJoueur inscription = new InscriptionJoueur(this.primaryStage);

      primaryStage.setTitle(inscription.getTitle());
      primaryStage.setScene(new Scene(inscription, VariablesJoueur.DEFAULT_APPLICATION_WIDTH, VariablesJoueur.DEFAULT_APPLICATION_HEIGHT)); }

    else if (hl.getText().contains("Mot de passe oubliée ?")) {


    }}}
