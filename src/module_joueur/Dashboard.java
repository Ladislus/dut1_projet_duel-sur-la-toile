package module_joueur;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
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
        return new Scene(bp, 900,450);
    }

    public HBox creerHaut(){
        HBox hHaut = new HBox();
        Label lTitre = new Label("Bienvenue XxX_DarkSasuke-69_XxX ");

        lTitre.setFont(Font.loadFont("file:./assets/roboto.ttf", 19));

        hHaut.setAlignment(Pos.TOP_CENTER);
        hHaut.setPadding(new Insets(20));
        hHaut.getChildren().add(lTitre);

        return hHaut;
    }

    public VBox creerGauche(){
        //todo : make to correspond to the IHM
        VBox vGauche = new VBox();

        Button btStat = new Button("Mes statistiques");
        Button btParti = new Button("Mes parties");
        Button btEditerProfile = new Button("Editer profile");
        Button btParametre = new Button("Parametre");

        btStat.setPrefWidth(150);
        btParti.setPrefWidth(150);
        btEditerProfile.setPrefWidth(150);
        btParametre.setPrefWidth(150);

        vGauche.getChildren().addAll(btStat, btParti, btEditerProfile, btParametre);
        vGauche.setPadding(new Insets(70,0,0,10));
        vGauche.setSpacing(40);

        return vGauche;
    }

    public VBox creerDroite(){
        VBox hDroiteCentral = new VBox();
        VBox hDroiteListeDamis = new VBox();

        Label lListeDamis = new Label("Ma liste d'amis");
        lListeDamis.setFont(new Font("Arial",20));

        //todo : Generation des bouton en fonction du nombre d'amis dans la bd et les afficher

        String[] btName = {"Jean Michel", "Jacque", "Tiouan", "Pierre"};
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
        hDroiteListeDamis.setPadding(new Insets(20,5,0,0));
        hDroiteListeDamis.setSpacing(5);

        hDroiteCentral.setPadding(new Insets(40,0,0,0));
        hDroiteCentral.getChildren().addAll(lListeDamis, hDroiteListeDamis);

        return hDroiteCentral;
    }

    public VBox creerCentre(){
        //todo: make that
        VBox vCentre = new VBox();
        return vCentre;
    }
}
