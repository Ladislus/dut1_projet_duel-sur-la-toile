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

public class ConnexionJoueur extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Accueil : Connexion");
        primaryStage.setScene(creerConnexionJoueur());
        primaryStage.setResizable(false);
        //primaryStage.getIcons().add(new Image("file:///C:\\Users\\bordecraft\\Desktop\\Projet Final 1A\\groupe12A\\module_joueur\\img\\logoWithoutText.png"));
        primaryStage.show();
    }

    public Scene creerConnexionJoueur(){
        BorderPane bp = new BorderPane();
        bp.setLeft(creerGauche());
        bp.setRight(creerDroite());
        bp.setBottom(creerBas());
        return new Scene(bp, 500,250);
    }
    public VBox creerGauche(){
        VBox vBox = new VBox();
        //Image image = new Image("file:///C:\\Users\\bordecraft\\Desktop\\Projet Final 1A\\groupe12A\\module_joueur\\img\\logo.png");
        ImageView logo = new ImageView();
        Label slogan = new Label("La plateforme de jeux videos innovante !");
        slogan.setTextAlignment(TextAlignment.CENTER);
        slogan.setWrapText(true);
        slogan.setFont(Font.font("Arial", 15));
        //logo.setImage(image);
        logo.setFitWidth(100);
        logo.setFitHeight(100);
        vBox.getChildren().addAll(logo, slogan);
        vBox.setPrefWidth(250);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(25,0,0,25));
        vBox.setAlignment(Pos.TOP_CENTER);
        return vBox;
    }
    public VBox creerDroite(){
        //todo: set fixed font for text
        VBox vBox = new VBox();
        Hyperlink hlRegister = new Hyperlink("Pas de compte ? S'inscrire maintenant");
        Label title = new Label("Connexion");
        Label lLogin = new Label("Votre nom d'utilisateur : ");
        Label lPassword = new Label("Votre mot de passe : ");
        TextField tfLogin = new TextField();
        PasswordField tfPassword = new PasswordField();
        Button btConnexion = new Button("Vers l'aventure ! -->>");
        title.setFont(Font.font("Arial", 19));
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(18,15,0,0));
        vBox.setPrefWidth(250);
        vBox.setSpacing(10);
        vBox.getChildren().addAll(title, lLogin, tfLogin, lPassword, tfPassword, hlRegister, btConnexion);
        return vBox;
    }
    public HBox creerBas(){
        HBox hBas = new HBox();
        hBas.setPadding(new Insets(0,0,5,5));
        Label lCopyright = new Label("© Copyright : Duel sur la toile");
        lCopyright.setFont(Font.font("Arial", 10));
        hBas.getChildren().add(lCopyright);
        return hBas;
    }

}
