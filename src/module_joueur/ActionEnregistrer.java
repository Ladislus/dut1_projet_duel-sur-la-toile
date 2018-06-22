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

  private Stage secondaryStage;

  private Joueur joueur;

  /**
   Action déclenché lors du clique sur le bouton enregistrement de EditionProfil
   @param secondaryStage : La page secondaire contenant EditionProfil
   @param joueur : Le joueur courant
  */
  ActionEnregistrer(Stage secondaryStage, Joueur joueur) {

    this.secondaryStage = secondaryStage;

    this.joueur = joueur; }

  /**
   Action permettant l'enregistrement des modification apporté au compte dans EditionProfil
   @param actionEvent : L'actionEvent contenant l'action
  */
  @Override
  public void handle(ActionEvent actionEvent) {

    //Récuperation de l'intérieur de la page
    EditionProfil page = (EditionProfil) this.secondaryStage.getScene().getRoot();

    String email = page.getTfEmail().getText();
    String pseudo = page.getTfPseudo().getText();
    String motdepasse = page.getPfMotDePasse().getText();
    String confirmMotDePasse = page.getPfConfirmMotDePasse().getText();
    String ancientPseudo = joueur.getPseudo();

    //Récuperation de l'image dans l'ImageView
    byte[] bytes = new byte[0];
    try { bytes = Files.readAllBytes(((EditionProfil)secondaryStage.getScene().getRoot()).getImagePath()); }
    catch (IOException e) { e.printStackTrace(); }

    PasswordDialog confirm = new PasswordDialog();

    Optional<String> res = confirm.showAndWait();

    if (res.isPresent()) {

      try { if (Utilisateur.isMdpValide(joueur.getPseudo(), res.get())) {

          if(motdepasse.equals(confirmMotDePasse)) {

            //Le nouveau mot de passe ne répond pas critères
            if (!VariablesJoueur.PASSWORD_PATTERN.matcher(motdepasse).find() && !page.getPfMotDePasse().isDisable()) {

              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("ERREUR");
              alert.setHeaderText("Votre mot de passe n'est pas valide");
              alert.showAndWait(); }

            //L'adresse email n'est pas d'un format valide
            else if (!VariablesJoueur.EMAIL_PATTERN.matcher(email).find()) {

              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("ERREUR");
              alert.setHeaderText("Votre adresse email n'est pas valide");
              alert.showAndWait(); }

            //Met à jour et ferme la fenêtre
            else {

              Utilisateur.updateUtilisateur(pseudo, email, motdepasse, ancientPseudo, bytes);

              joueur.setEmail(email);
              joueur.setPseudo(pseudo);

              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Edition utilisateur");
              alert.setHeaderText("Vos modifications ont bien été enregistrées");

              secondaryStage.close();

              alert.showAndWait(); }}

          //Les deux nouveaux mot de passe ne correspondent pas
          else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Edition utilisateur");
            alert.setHeaderText("Votre mot de passe ne correspond pas");
            alert.showAndWait(); }}

        //Le nouveau mot de passe ne répond pas au critères
        else {

          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("ERREUR");
          alert.setHeaderText("Votre nouveau mot de passe n'est pas valide");
          alert.showAndWait(); }}

          catch (APIMySQLException ex) { ex.printStackTrace(); }}

    //Annulation des changements
    else {

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("INFORMATION");
      alert.setHeaderText("Vous avez annulé les changements");
      alert.showAndWait(); }}}
