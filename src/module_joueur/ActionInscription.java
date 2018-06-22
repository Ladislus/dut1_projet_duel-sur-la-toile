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

  /**
   Controlleur permettant l'inscription à la platforme
   @param primaryStage : La page principale à propager
  */
  ActionInscription(Stage primaryStage) { this.primaryStage = primaryStage; }

  /**
   Test la validitée des différent champs lors de l'appuie sur le bouton,
   si tout est bon, enregistre le compte et affiche la Dashboard
   @param actionEvent : L'ActionEvent contenant l'action
  */
  public void handle(ActionEvent actionEvent) {

    //Récupération de la page pour obtenir les differents champs
    InscriptionJoueur page = (InscriptionJoueur) this.primaryStage.getScene().getRoot();

    List<String> listeErreur = new ArrayList<>();

    String prenom = page.getPrenom();
    if (prenom.length() == 0) { listeErreur.add("Veuillez entrez un prénom"); }

    String name = page.getName().toUpperCase();
    if (name.length() == 0) { listeErreur.add("Veuillez entrez un nom"); }

    String mail = page.getMail();
    if (mail.length() == 0) { listeErreur.add("Veuillez entrez une adresse mail"); }
    //Test le pattern de l'email, pour verifier qu'il soit du type xxxxx@xxxx.xxx
    else if (!VariablesJoueur.EMAIL_PATTERN.matcher(mail).find()) { listeErreur.add("L'adresse mail n'est pas valide"); }

    String pseudo = page.getPseudo();
    if (pseudo.length() == 0) { listeErreur.add("Veuillez entrez un pseudo"); }
    //Test si le pseudo fait entre 4 et 30 caractères
    else if (pseudo.length() < 4 || pseudo.length() > 30) { listeErreur.add("Le pseudo n'est pas valide"); }

    String password = page.getPassword();
    if (password.length() == 0) { listeErreur.add("Veuillez entrez un mot de passe"); }
    //Test si le mot de passe contient au moins une majuscule, une minuscule, un chiffre, et fait plus de 8 caractères
    else if (!VariablesJoueur.PASSWORD_PATTERN.matcher(password).find()) { listeErreur.add("Le mot de passe n'est pas valide"); }
    //Test si les deux champs de mot de passe correspondent
    else if (!page.getPasswordConfirm().equals(password)) { listeErreur.add("Les mots de passe ne correspondent pas"); }

    String sex = page.getSex();

    //Affiche la liste des erreurs s'il y en a
    if ( listeErreur.size() != 0) {

      String erreur = "";

      for (String elem : listeErreur) { erreur += elem + "\n"; }

      page.setInfo(erreur); }

    //Création du compte dans la BD et affichage du dashboard
    else {

      try {

        Utilisateur.creerUtilisateur(pseudo, mail, sex, prenom, name, password, "USER");

        Dashboard dashboard = new Dashboard(this.primaryStage, new Joueur(Utilisateur.getIdByPseudo(pseudo), pseudo, Utilisateur.getEmailByPseudo(pseudo)), false);

        this.primaryStage.setTitle(dashboard.getTitle());
        this.primaryStage.setScene(new Scene(dashboard, VariablesJoueur.DEFAULT_APPLICATION_WIDTH, VariablesJoueur.DEFAULT_APPLICATION_HEIGHT));


        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("INFORMATION");
        a.setHeaderText("Le compte a été créé avec succès");
        a.showAndWait(); }

      //Compte existant déjà
      catch(APIMySQLException ex) {

        ex.printStackTrace();

        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("ERREUR");
        a.setHeaderText("Le compte existe déjà");
        a.showAndWait(); }}}}
