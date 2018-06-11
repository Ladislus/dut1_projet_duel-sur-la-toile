package module_joueur;

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
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class InscriptionJoueur extends Application {

    Button btRetour;

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
        bp.setTop(creerHaut());
        bp.setLeft(creerGauche());
        bp.setRight(creeDroite());
        bp.setBottom(creerBas());
        return new Scene(bp, 540,430);
    }
    public VBox creeDroite() {
        VBox Droite = new VBox();
        Label nom = new Label("Nom : ");
        Label prenom = new Label("Prenom : ");
        Label sexe = new Label("Sexe : ");
        Label email = new Label("E-mail : ");
        Label pseudo = new Label("Pseudonyme : ");
        Label motdepasse = new Label("Mot de passe : ");
        Label cmotdepasse = new Label("Confirmer mot de passe : ");
        HBox hNom = new HBox();
        HBox hPrenom= new HBox();
        HBox hSexe = new HBox();
        HBox hEmail = new HBox();
        HBox hPseudo = new HBox();
        HBox hMotdePasse = new HBox();
        HBox hCMotDePasse = new HBox();
        Button btDashBoard = new Button("Accéder a la plateforme !");
        btDashBoard.setPrefWidth(170);
        //List for generation
        ArrayList<HBox> generationHbox = new ArrayList<HBox>(){
            {
                add(hNom);add(hPrenom);add(hSexe);add(hEmail);add(hPseudo);add(hMotdePasse);add(hCMotDePasse);
            }
        };
        //generation
        for(int i = 0; i<7; i++){
            if(i==2){
                //case sexe
                ToggleGroup toggleGroup = new ToggleGroup();
                RadioButton rdHomme = new RadioButton("Homme");
                RadioButton rdFemme = new RadioButton("Femme");
                RadioButton rdAutre = new RadioButton("Autre");
                rdHomme.setToggleGroup(toggleGroup);
                rdFemme.setToggleGroup(toggleGroup);
                rdAutre.setToggleGroup(toggleGroup);
                generationHbox.get(i).getChildren().addAll(rdHomme, rdFemme, rdAutre);
                generationHbox.get(i).setSpacing(5);
                generationHbox.get(i).setPadding(new Insets(5,0,5,0));
            }
            else{
                TextField tf = new TextField();
                File imageFile = new File("./img/pub/help.png");
                ImageView imageView = new ImageView();
                imageView.setImage(new Image(imageFile.toURI().toString()));
                imageView.setPreserveRatio(true);
                imageView.setFitWidth(20);
                generationHbox.get(i).getChildren().add(tf);
                generationHbox.get(i).getChildren().add(imageView);
            }
        }
        Droite.getChildren().addAll(nom, generationHbox.get(0),prenom, generationHbox.get(1), sexe, generationHbox.get(2), email, generationHbox.get(3),
                pseudo, generationHbox.get(4), motdepasse, generationHbox.get(5), cmotdepasse, generationHbox.get(6), btDashBoard);
        Droite.setPadding(new Insets(15,15,0,0));
        Droite.setSpacing(3);
        //Droite.setAlignment(Pos.);
        return Droite;
    }

    public VBox creerGauche(){
        VBox Gauche = new VBox();

        File imageFileLogo = new File("./img/pub/logo.png");//logo plateforme
        ImageView imageViewLogo = new ImageView();
        imageViewLogo.setImage(new Image(imageFileLogo.toURI().toString()));
        imageViewLogo.setPreserveRatio(true);
        imageViewLogo.setFitWidth(100);

        Hyperlink hyperlinkAide = new Hyperlink("Besoin d'aide ?");
        HBox hBoxAide = new HBox();

        File imageFileHelp = new File("./img/pub/help.png");//Image help
        ImageView imageViewHelp = new ImageView();
        imageViewHelp.setImage(new Image(imageFileHelp.toURI().toString()));
        imageViewHelp.setPreserveRatio(true);
        imageViewHelp.setFitWidth(20);

        hBoxAide.getChildren().add(hyperlinkAide);
        hBoxAide.getChildren().add(imageViewHelp);
        hBoxAide.setAlignment(Pos.TOP_CENTER);

        btRetour = new Button("<-- Retours connexion");
        btRetour.setOnAction(new ActionBackToLogin(this));
        btRetour.setPrefWidth(200);

        Gauche.getChildren().addAll(imageViewLogo,hBoxAide, btRetour);
        Gauche.setSpacing(50);
        Gauche.setPrefWidth(315);
        Gauche.setPadding(new Insets(25,0,0,0));
        Gauche.setAlignment(Pos.TOP_CENTER);

        return Gauche;
    }
    public HBox creerHaut(){
        HBox haut = new HBox();
        Label title = new Label("Inscription");
        haut.getChildren().addAll(title);
        haut.setAlignment(Pos.TOP_CENTER);
        haut.setPadding(new Insets(7,0,0,0));
        title.setFont(Font.font("Arial", 19));
        return haut;
    }
    public HBox creerBas(){
        HBox hBas = new HBox();
        Label lCopyright = new Label("© Copyright : Duel sur la toile");
        lCopyright.setFont(Font.font("Arial", 10));
        hBas.getChildren().add(lCopyright);
        hBas.setPadding(new Insets(0,0,5,5));
        return hBas;
    }
    public Button getBtRetour(){
        return this.btRetour;
    }
}