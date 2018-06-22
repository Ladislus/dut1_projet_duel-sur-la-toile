package module_joueur;

import APIMySQL.*;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ActionEntrerToDashboard implements EventHandler<KeyEvent> {

  private Stage primaryStage;

  /**
   Controlleur permettant la connexion grâce à la touche ENTRER
   @param primaryStage : La page principale à propager
  */
  ActionEntrerToDashboard(Stage primaryStage) { this.primaryStage = primaryStage; }

  /**
   Action permettant la connexion grâce à la touche ENTRER
   @param keyEvent : Le KeyEvent contenant l'action et la touche
  */
  @Override
  public void handle(KeyEvent keyEvent) {

      //Si la touche appuyé est ENTRER
      if (keyEvent.getCode().equals(KeyCode.ENTER)) {

        ConnexionJoueur page = (ConnexionJoueur) this.primaryStage.getScene().getRoot();

        String login = page.getTfLogin();
        String password = page.getTfPassword();

        //Identique à ActionConnection
        try {

          if (!Utilisateur.isMdpValide(login, password)) {

            page.setTfPassword("");

            page.setInfo("Le mot de passe est invalide"); }

          else if (!Utilisateur.isActivated(login)) {

            page.setTfPassword("");

            page.setInfo("Le compte est désactivé"); }

          else {

            Boolean isAdmin = GestionBD.selectPreparedStatement("select nomRole from UTILISATEUR where idUt = " + Utilisateur.getIdByPseudo(login) + ";").get("nomRole").get(0).equals("ADMIN");

            Dashboard dashboard = new Dashboard(this.primaryStage, new Joueur(Utilisateur.getIdByPseudo(login), login, Utilisateur.getEmailByPseudo(login)), isAdmin);

            this.primaryStage.setTitle(dashboard.getTitle());
            this.primaryStage.setScene(new Scene(dashboard, VariablesJoueur.DEFAULT_APPLICATION_WIDTH, VariablesJoueur.DEFAULT_APPLICATION_HEIGHT)); }}

        catch(APIMySQLException ex) {

          page.setTfPassword("");

          page.setInfo("Ce compte n'existe pas"); }}}}
