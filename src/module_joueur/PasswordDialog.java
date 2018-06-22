package module_joueur;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

class PasswordDialog extends Dialog<String> {

  private PasswordField passwordField;

  /**
   Création d'un boite de dialogue spéciale, contenant un PasswordField
   */
  PasswordDialog() {

    setTitle("CONFIRMATION");
    setHeaderText("Nous voulons vérifier que c'est bien vous \nVeuillez entrer votre mot de passe");

    ButtonType passwordButtonType = new ButtonType("OK", ButtonData.OK_DONE);
    getDialogPane().getButtonTypes().addAll(passwordButtonType, ButtonType.CANCEL);

    this.passwordField = new PasswordField();
    passwordField.setPromptText("Password");

    HBox hBox = new HBox();
    hBox.getChildren().add(passwordField);
    hBox.setPadding(new Insets(20));

    HBox.setHgrow(passwordField, Priority.ALWAYS);

    getDialogPane().setContent(hBox);

    Platform.runLater(() -> passwordField.requestFocus());

    setResultConverter(dialogButton -> {

      if (dialogButton == passwordButtonType)
        return passwordField.getText();

      return null; }); }}
