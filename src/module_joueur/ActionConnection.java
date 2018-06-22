package module_joueur;

import APIMySQL.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

class ActionConnection implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  /**
   Action lancé lors du clique sur le bouton de connexion de la page de login
   @param primaryStage : La page principale à propager aux autres pages
  */
  ActionConnection(Stage primaryStage) { this.primaryStage = primaryStage; }

  /**
   Utilise l'API pour tester le couple pseudo/mot de passe et agit en conséquence
   @param actionEvent : L'ActionEvent contenant l'action
  */
  public void handle(ActionEvent actionEvent) {

    ConnexionJoueur page = (ConnexionJoueur) this.primaryStage.getScene().getRoot();

    String login = page.getTfLogin();
    String password = page.getTfPassword();

    try {

      //password invalide
      if (!Utilisateur.isMdpValide(login, password)) {

        page.setTfPassword("");

        page.setInfo("Le mot de passe est invalide"); }

      //compte desactivé
      else if (!Utilisateur.isActivated(login)) {

        page.setTfPassword("");

        page.setInfo("Le compte est désactivé"); }

      //compte activé, éxistant et couple login/password correct
      else {

        //test si l'utilisateur est admin
        Boolean isAdmin = GestionBD.selectPreparedStatement("select nomRole from UTILISATEUR where idUt = " + Utilisateur.getIdByPseudo(login) + ";").get("nomRole").get(0).equals("ADMIN");

        Dashboard dashboard = new Dashboard(this.primaryStage, new Joueur(Utilisateur.getIdByPseudo(login), login, Utilisateur.getEmailByPseudo(login)), isAdmin);

        this.primaryStage.setTitle(dashboard.getTitle());
        this.primaryStage.setScene(new Scene(dashboard, VariablesJoueur.DEFAULT_APPLICATION_WIDTH, VariablesJoueur.DEFAULT_APPLICATION_HEIGHT)); }}

    //Compte inexistant dans la BD (login invalide)
    catch(APIMySQLException ex) {

      page.setTfPassword("");

      page.setInfo("Ce compte n'existe pas"); }}}
