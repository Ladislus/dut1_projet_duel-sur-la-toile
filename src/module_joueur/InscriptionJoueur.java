package module_joueur;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class InscriptionJoueur extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Accueil : Inscription");
        primaryStage.setScene(creerInscriptionJoueur());
        primaryStage.setResizable(false);
        File imageFile = new File("./img/pub/logoWithoutText.png");
        primaryStage.getIcons().add(new Image(imageFile.toURI().toString()));
        primaryStage.show();
    }

    public Scene creerInscriptionJoueur(){
        BorderPane bp = new BorderPane();
        VBox vboxRegister = new VBox();
        Label lbRegister = new Label("Inscription");
        Label lbPseudo = new Label("Votre pseudo");
        Label lPassword = new Label("Votre mot de passe");
        Label lMail = new Label("Votre mail");
        

        return new Scene(bp, 500,300);
    }
}