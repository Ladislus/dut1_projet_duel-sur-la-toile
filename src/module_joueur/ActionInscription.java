package module_joueur;

import APIMySQL.GestionBD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.List;
import java.util.ArrayList;

class ActionInscription implements EventHandler<ActionEvent> {

  private Stage primaryStage;

  private GestionBD laConnection;

  public ActionInscription(Stage primaryStage, GestionBD laConnection) {

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

    else{}}}
