package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class ActionDeconnexion implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  /**
   Action de déconnexion de l'utilisateur
   @param primaryStage : La page principale à propager
  */
  ActionDeconnexion(Stage primaryStage) { this.primaryStage = primaryStage; }

  /**
   Demande confirmation de déconnection, puis renvoie à ConnexionJoueur
   @param actionEvent : L'actionEvent contenant l'action
  */
  @Override
  public void handle(ActionEvent actionEvent) {

    ConnexionJoueur connexion = new ConnexionJoueur(this.primaryStage);

    //Demande de confirmation
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("INFORMATION");
    alert.setHeaderText("Voulez-vous vraiment vous déconnecter ?");

    ButtonType okButton = new ButtonType("Oui", ButtonBar.ButtonData.YES);
    ButtonType noButton = new ButtonType("Non", ButtonBar.ButtonData.NO);

    alert.getButtonTypes().setAll(okButton, noButton);

    //Si oui -> Déconnexion
    alert.showAndWait().ifPresent(type -> {

      if (type.getButtonData().toString().equals("YES")) {
        this.primaryStage.setTitle(connexion.getTitle());
        this.primaryStage.setScene(new Scene(connexion, VariablesJoueur.DEFAULT_CONNECTION_WIDTH, VariablesJoueur.DEFAULT_CONNECTION_HEIGHT)); }}); }}
