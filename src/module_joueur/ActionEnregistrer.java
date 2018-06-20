package module_joueur;

import APIMySQL.APIMySQLException;
import APIMySQL.Utilisateur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.util.Optional;

public class ActionEnregistrer implements EventHandler<ActionEvent> {

  private Stage primaryStage;
  private Stage secondaryStage;

  private Joueur joueur;

  public ActionEnregistrer(Stage primaryStage, Stage secondaryStage, Joueur joueur) {

    this.primaryStage = primaryStage;
    this.secondaryStage = secondaryStage;

    this.joueur = joueur; }

  @Override
  public void handle(ActionEvent actionEvent) {

    EditionProfil page = (EditionProfil) this.secondaryStage.getScene().getRoot();

    String email = page.getTfEmail().getText();
    String pseudo = page.getTfPseudo().getText();
    String motdepasse = page.getPfMotDePasse().getText();
    String confirmMotDePasse = page.getPfConfirmMotDePasse().getText();
    String ancientPseudo = joueur.getPseudo();

    byte[] bytes = new byte[0];
    try { bytes = Files.readAllBytes(((EditionProfil)secondaryStage.getScene().getRoot()).getImagePath()); }
    catch (IOException e) { e.printStackTrace(); }

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

              Utilisateur.updateUtilisateur(pseudo, email, motdepasse, ancientPseudo, bytes);

              joueur.setEmail(email);
              joueur.setPseudo(pseudo);

              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Edition utilisateur");
              alert.setHeaderText("Vos modifications ont bien été enregistrées");

              secondaryStage.close();

              alert.showAndWait(); }}

          else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Edition utilisateur");
            alert.setHeaderText("Votre mot de passe ne correspond pas");
            alert.showAndWait(); }}

        else {

          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("ERREUR");
          alert.setHeaderText("Votre nouveau mot de passe n'est pas valide");
          alert.showAndWait(); }}

          catch (APIMySQLException ex) { ex.printStackTrace(); }}

    else {

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("INFORMATION");
      alert.setHeaderText("Vous avez annulé les changements");
      alert.showAndWait(); }}}