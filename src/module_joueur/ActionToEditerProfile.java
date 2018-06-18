package module_joueur;

import APIMySQL.ConnexionMySQL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionToEditerProfile implements EventHandler<ActionEvent> {

  Joueur joueur;

  Stage primaryStage;

  public ActionToEditerProfile(Stage primaryStage, Joueur joueur) {

    this.joueur = joueur;
    this.primaryStage = primaryStage; }

  @Override
  public void handle(ActionEvent actionEvent) {

    Stage stageEditionProfile = new Stage();
    stageEditionProfile.setTitle("Edition de mon profile");
    stageEditionProfile.setResizable(false);
    stageEditionProfile.setScene(new Scene(new EditionProfil(primaryStage, joueur), VariablesJoueur.DEFAULT_EDITERPROFILE_WIDTH, VariablesJoueur.DEFAULT_EDITERPROFILE_HEIGHT));
    stageEditionProfile.show(); }}
