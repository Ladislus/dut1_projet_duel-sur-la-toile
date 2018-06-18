package module_joueur;

import APIMySQL.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

class ActionConnection implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  public ActionConnection(Stage primaryStage) {

    this.primaryStage = primaryStage;
    }

  public void handle(ActionEvent actionEvent) {

    ConnexionJoueur page = (ConnexionJoueur) this.primaryStage.getScene().getRoot();

    String login = page.getTfLogin().getText();
    String password = page.getTfPassword().getText();

    try {

      if (!Utilisateur.isMdpValide(login, password)) {

        page.setTfPassword("");

        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("ERREUR");
        a.setHeaderText("Le mot de passe est invalide");
        a.showAndWait(); }

      else if (!Utilisateur.isActivated(login)) {

        page.setTfPassword("");

        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("ERREUR");
        a.setHeaderText("Le compte est désactivé");
        a.showAndWait(); }

      else {

        Dashboard dashboard = new Dashboard(this.primaryStage, new Joueur(Utilisateur.getIdByPseudo(login),
                login, Utilisateur.getEmailByPseudo(login)));

        this.primaryStage.setTitle(dashboard.getTitle());
        this.primaryStage.setScene(new Scene(dashboard, VariablesJoueur.DEFAULT_APPLICATION_WIDTH, VariablesJoueur.DEFAULT_APPLICATION_HEIGHT)); }}

    catch(UtilisateurException ex) {

      page.setTfPassword("");

      Alert a = new Alert(Alert.AlertType.ERROR);
      a.setTitle("ERREUR");
      a.setHeaderText("Ce compte n'existe pas");
      a.showAndWait(); }}}
