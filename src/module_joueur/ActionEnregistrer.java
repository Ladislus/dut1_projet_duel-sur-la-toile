package module_joueur;

import APIMySQL.APIMySQLException;
import APIMySQL.Utilisateur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;

public class ActionEnregistrer implements EventHandler<ActionEvent> {

  Stage primaryStage;

  Joueur joueur;

  public ActionEnregistrer(Stage primaryStage, Joueur joueur) {

    this.primaryStage = primaryStage;
    this.joueur = joueur; }

  @Override
  public void handle(ActionEvent actionEvent) {

    EditionProfil page = (EditionProfil) this.primaryStage.getScene().getRoot();

    String email = page.getTfEmail().getText();
    String pseudo = page.getTfPseudo().getText();
    String motdepasse = page.getPfMotDePasse().getText();
    String confirmMotDePasse = page.getPfConfirmMotDePasse().getText();
    String ancientPseudo = joueur.getPseudo();

    PasswordDialog confirm = new PasswordDialog();

    Optional<String> res = confirm.showAndWait();

    if (res.isPresent()) {

      try { if (Utilisateur.isMdpValide(joueur.getPseudo(), res.get())) {

          if(motdepasse.equals(confirmMotDePasse)) {

            if (!VariablesJoueur.PASSWORD_PATTERN.matcher(motdepasse).find() && !page.getPfMotDePasse().isDisable()) {

              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("ERREUR");
              alert.setHeaderText("Votre mot de passe n'est pas valide");
              alert.showAndWait(); }

            else if (!VariablesJoueur.EMAIL_PATTERN.matcher(email).find()) {

              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("ERREUR");
              alert.setHeaderText("Votre adresse email n'est pas valide");
              alert.showAndWait(); }

            else {

              Utilisateur.updateUtilisateur(pseudo, email, motdepasse, ancientPseudo);

              joueur.setEmail(email);
              joueur.setPseudo(pseudo);

              //TODO : récupérer l'image et la modifier

              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Edition utilisateur");
              alert.setHeaderText("Votre modification a bien été enregistrer");

              primaryStage.close();

              alert.showAndWait(); }}

          else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Edition utilisateur");
            alert.setHeaderText("Votre nouveau mot de passe de corespondent pas");
            alert.showAndWait(); }}

        else {

          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("ERREUR");
          alert.setHeaderText("Votre mot de passe n'est pas valide");
          alert.showAndWait(); }}

          catch (APIMySQLException ex) { ex.printStackTrace(); }}

    else {

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("INFORMATION");
      alert.setHeaderText("Vous avez annulé les changements");
      alert.showAndWait(); }}}
