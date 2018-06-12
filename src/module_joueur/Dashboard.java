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

public class Dashboard extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dashboard");
        primaryStage.setScene(creerDashboard());
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public Scene creerDashboard(){
        BorderPane bp = new BorderPane();
        bp.setTop(creerHaut());
        bp.setLeft(creerGauche());
        bp.setCenter(creerCentre());
        bp.setRight(creerDroite());
        return new Scene(bp, 850,650);
    }

    public HBox creerHaut(){
        HBox hHaut = new HBox();
        Label lTitre = new Label("Bienvenue XxX_DarkSasuke-69_XxX ");

        lTitre.setFont(Font.loadFont("file:./assets/roboto.ttf", 19));

        hHaut.setAlignment(Pos.TOP_CENTER);
        hHaut.setPadding(new Insets(20));
        hHaut.getChildren().addAll(lTitre);

        return hHaut;
    }

    public VBox creerGauche(){
        //todo : make to correspond to the IHM --> fini
        VBox vGauche = new VBox();
        VBox vParam = new VBox();

        Button btStat = new Button("Mes statistiques");
        Button btParti = new Button("Mes parties");
        Button btEditerProfile = new Button("Éditez mon profil");
        Button btParametre = new Button("Mes paramètres");

        File imageFileLogo = new File("./img/pub/log_out.png");//logo plateforme
        ImageView imageViewLogo = new ImageView();
        imageViewLogo.setImage(new Image(imageFileLogo.toURI().toString()));
        imageViewLogo.setPreserveRatio(true);
        imageViewLogo.setFitWidth(25);
        Button btExit = new Button("", imageViewLogo);

        btStat.setPrefWidth(150);
        btParti.setPrefWidth(150);
        btEditerProfile.setPrefWidth(150);
        btParametre.setPrefWidth(150);

        vParam.getChildren().addAll(btParametre, btExit);
        vParam.setSpacing(10);
        vParam.setAlignment(Pos.TOP_CENTER);
        vParam.setPadding(new Insets(250,0,0,0));

        vGauche.getChildren().addAll(btStat, btParti, btEditerProfile, vParam);
        vGauche.setPadding(new Insets(70,0,0,10));
        vGauche.setSpacing(20);

        return vGauche;
    }

    public VBox creerDroite(){
        VBox hDroiteCentral = new VBox();
        VBox hDroiteListeDamis = new VBox();
        ScrollPane sDroiteListeDamis = new ScrollPane();
        Label lbTotalContact = new Label("Total : 8 contacts");

        Label lListeDamis = new Label("Ma liste d'amis");
        Button btListeDamis = new Button("Mes amis");
        Button btMessage = new Button("4 messages non lu");
        btListeDamis.setPrefWidth(150);btMessage.setPrefWidth(150);
        lListeDamis.setFont(new Font("Arial",20));

        //todo : Generation des bouton en fonction du nombre d'amis dans la bd et les afficher

        String[] btName = {"Jean Michel", "Jacque", "Titouan", "Pierre", "Michelle", "Mirene", "Sergine", "Anastasia"};
        ArrayList<Button> listeButton = new ArrayList<>();

        for(String name : btName){
            File imageFile = new File("./img/pub/contact.png");
            ImageView imageContact = new ImageView();
            imageContact.setImage(new Image(imageFile.toURI().toString()));
            imageContact.setPreserveRatio(true);
            imageContact.setFitWidth(20);
            Button btContact = new Button(name, imageContact);
            btContact.setPrefWidth(150);
            btContact.setAlignment(Pos.CENTER_LEFT);
            listeButton.add(btContact);
        }

        hDroiteListeDamis.getChildren().addAll(listeButton);
        hDroiteListeDamis.setSpacing(5);
        hDroiteListeDamis.setPrefHeight(375);

        sDroiteListeDamis.setContent(hDroiteListeDamis);
        sDroiteListeDamis.setFitToWidth(true);

        hDroiteCentral.setPadding(new Insets(5));

        hDroiteCentral.setSpacing(15);
        hDroiteCentral.getChildren().addAll(lListeDamis, sDroiteListeDamis, btListeDamis, lbTotalContact, btMessage);

        return hDroiteCentral;
    }

    public VBox creerCentre(){
        //todo: make that
        VBox vCentre = new VBox();

        VBox vJeux = new VBox();
        VBox vNouveaute = new VBox();

        Label lbJeux = new Label("Jeux : ");
        Label lbNouveaute = new Label("Nouveautés : ");

        ScrollPane scrollPaneJeux = new ScrollPane();
        scrollPaneJeux.setPrefHeight(310);
        scrollPaneJeux.setContent(vJeux);

        ScrollPane scrollPaneNouveaute = new ScrollPane();
        scrollPaneNouveaute.setContent(vNouveaute);
        scrollPaneNouveaute.setPrefHeight(310);
        //todo remove that and place image

        for(int i = 0; i<150; i++){
            vJeux.getChildren().add(new Label("test"));
            vNouveaute.getChildren().add(new Label("test"));
        }

        vCentre.getChildren().addAll(lbJeux, scrollPaneJeux, lbNouveaute, scrollPaneNouveaute);
        vCentre.setSpacing(10);
        vCentre.setPadding(new Insets(0,15,9,15));

        return vCentre;
    }
}
