package module_joueur;

import APIMySQL.GestionBD;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;

public class ExecutableJoueur extends Application {

  public static void main(String [] args) { launch(args); }


  @Override
  public void start(Stage primaryStage) {

    GestionBD laConnection = null;

    try { laConnection = new GestionBD("192.168.1.100", "serveurDeJeux", "dst", "dst"); }
    catch (ClassNotFoundException e) {} //TODO faire l'alerte

    ConnexionJoueur connection = new ConnexionJoueur(primaryStage, laConnection);


      ConnexionJoueur cj = new ConnexionJoueur(primaryStage, laConnection);

      primaryStage.setTitle(cj.getTitle());
      primaryStage.setScene(new Scene(cj, 500, 290));
      primaryStage.setResizable(VariablesJoueur.IS_RESIZABLE);
      primaryStage.getIcons().add(VariablesJoueur.LOGO);
      primaryStage.show(); }}
