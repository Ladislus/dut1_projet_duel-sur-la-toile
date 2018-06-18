package module_joueur;

import APIMySQL.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

class ActionConnection implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  public ActionConnection(Stage primaryStage) { this.primaryStage = primaryStage; }

  public void handle(ActionEvent actionEvent) {

    ConnexionJoueur page = (ConnexionJoueur) this.primaryStage.getScene().getRoot();

    String login = page.getTfLogin();
    String password = page.getTfPassword();

    try {

      if (!Utilisateur.isMdpValide(login, password)) {

        page.setTfPassword("");

        page.setInfo("Le mot de passe est invalide"); }

      else if (!Utilisateur.isActivated(login)) {

        page.setTfPassword("");

        page.setInfo("Le compte est désactivé"); }

      else {

        Dashboard dashboard = new Dashboard(this.primaryStage, new Joueur(Utilisateur.getIdByPseudo(login), login, Utilisateur.getEmailByPseudo(login)));

        this.primaryStage.setTitle(dashboard.getTitle());
        this.primaryStage.setScene(new Scene(dashboard, VariablesJoueur.DEFAULT_APPLICATION_WIDTH, VariablesJoueur.DEFAULT_APPLICATION_HEIGHT)); }}

    catch(APIMySQLException ex) {

      page.setTfPassword("");

      page.setInfo("Ce compte n'existe pas"); }}}
