package module_joueur;

import APIMySQL.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.List;
import java.util.ArrayList;

class ActionInscription implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  private ConnexionMySQL laConnection;

  public ActionInscription(Stage primaryStage, ConnexionMySQL laConnection) {

    this.primaryStage = primaryStage;
    this.laConnection = laConnection; }

  public void handle(ActionEvent actionEvent) {

    InscriptionJoueur page = (InscriptionJoueur) this.primaryStage.getScene().getRoot();

    List<String> listeErreur = new ArrayList<>();

    String mail = page.getTfMail().getText();
    if (!VariablesJoueur.EMAIL_PATTERN.matcher(mail).find()) { listeErreur.add("L'adresse mail n'est pas valide"); }

    String pseudo = page.getTfPseudo().getText();
    if (pseudo.length() < 4 || pseudo.length() > 30) { listeErreur.add("Le pseudonyme n'est pas valide"); }

    String password = page.getTfPassword().getText();
    if (!VariablesJoueur.PASSWORD_PATTERN.matcher(password).find()) { listeErreur.add("Le mot de passe n'est pas valide"); }
    else if (!page.getTfPasswordConfirm().getText().equals(password)) { listeErreur.add("Les mots de passe ne correspondent pas"); }

    String sex = (String) page.getTgSex().getSelectedToggle().getUserData();

    if ( listeErreur.size() != 0) {

      String erreur = "";
      for (String elem : listeErreur) { erreur += elem + "\n"; }

      Alert a = new Alert(Alert.AlertType.ERROR);
      a.setTitle("ERREUR");
      a.setHeaderText("Il y a des erreurs dans le formulaire");
      a.setContentText(erreur);
      a.showAndWait(); }

    else {

      try {

        Utilisateur.creerUtilisateur(laConnection, pseudo, mail, sex, password, "USER");

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("INFORMATION");
        a.setHeaderText("Le compte a été créé avec succès");
        a.showAndWait();

        ConnexionJoueur connexion = new ConnexionJoueur(primaryStage, laConnection);

        this.primaryStage.setTitle(connexion.getTitle());
        this.primaryStage.setScene(new Scene(connexion, VariablesJoueur.DEFAULT_CONNECTION_WIDTH, VariablesJoueur.DEFAULT_CONNECTION_HEIGHT)); }

      catch(UtilisateurException ex) {

        ex.printStackTrace();

        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("ERREUR");
        a.setHeaderText("Le compte existe déjà");
        a.showAndWait(); }}}}
