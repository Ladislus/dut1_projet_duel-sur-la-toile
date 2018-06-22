package module_joueur;

import APIMySQL.Utilisateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ActionSuppressionCompte implements EventHandler<ActionEvent> {

  private Stage primaryStage;
  private Stage secondaryStage;

  private Joueur joueur;

  /**
   Controlleur permettant la suppression du compte
   @param primaryStage ; La page principale à propager
   @param secondaryStage : La page secondaire à propager
   @param joueur : Le joueur courant
  */
  ActionSuppressionCompte(Stage primaryStage, Stage secondaryStage, Joueur joueur) {

    this.primaryStage = primaryStage;
    this.secondaryStage = secondaryStage;

    this.joueur = joueur; }

  /**
   Action utilisant l'API supprimant le compte après confirmation
   @param actionEvent : L'actionEvent contenant l'action
  */
  @Override
  public void handle(ActionEvent actionEvent) {

    //Récupération de la page
    Stage page = (Stage) secondaryStage.getScene().getWindow();

    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("ATTENTION");
    alert.setHeaderText("Êtes vous sûr de vouloir supprimer votre compte ?");

    ButtonType okButton = new ButtonType("Oui", ButtonBar.ButtonData.YES);
    ButtonType noButton = new ButtonType("Non", ButtonBar.ButtonData.NO);

    alert.getButtonTypes().setAll(okButton, noButton);
    alert.showAndWait().ifPresent(type -> {

      //Si oui -> Suppression
      if (type.getButtonData().toString().equals("YES")) {

        try {

          Utilisateur.deleteUser(joueur.getPseudo());

          ConnexionJoueur connexion = new ConnexionJoueur(this.primaryStage);

          page.close();

          this.primaryStage.setTitle(connexion.getTitle());
          this.primaryStage.setScene(new Scene(connexion, VariablesJoueur.DEFAULT_CONNECTION_WIDTH, VariablesJoueur.DEFAULT_CONNECTION_HEIGHT)); }
          catch (SQLException e) { e.printStackTrace(); }}});}}
