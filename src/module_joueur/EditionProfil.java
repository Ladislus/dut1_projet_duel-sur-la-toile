package module_joueur;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

class EditionProfil extends BorderPane {

    String title;

    public EditionProfil(Stage primaryStage){
        super();

        this.title = "Editez mon profil";
        this.setLeft(creerGauche());
        this.setRight(creerDroite());
    }

    public VBox creerGauche(){
        VBox vPrincipal = new VBox();
        VBox vImage = new VBox();
        VBox vPseudo = new VBox();
        HBox hPseudoWithEditionButton = new HBox();

        // for image :
        Label lImage = new Label("Mon image");
        lImage.setFont(Font.font("Arial", 22));
        File fileImageUser = new File("./img/pub/user.png");
        ImageView ivImageUser = new ImageView();
        ivImageUser.setImage(new Image(fileImageUser.toURI().toString()));
        ivImageUser.setPreserveRatio(true);
        ivImageUser.setFitWidth(50);
        Button btModifier = new Button("Modifier");

        // for pseudo
        Label lPseudo = new Label("Mon pseudo");
        lPseudo.setFont(Font.font("Arial", 22));
        //Hbox vPseudo
        TextField tfPseudo = new TextField();
        Button btEdition = new Button();

        vImage.getChildren().addAll(lImage,ivImageUser, btModifier);
        vImage.setAlignment(Pos.TOP_CENTER);
        vImage.setSpacing(15);

        hPseudoWithEditionButton.getChildren().addAll(tfPseudo, btEdition);
        hPseudoWithEditionButton.setAlignment(Pos.TOP_CENTER);
        vPseudo.setAlignment(Pos.TOP_CENTER);
        vPseudo.setSpacing(10);
        vPseudo.getChildren().addAll(lPseudo, hPseudoWithEditionButton);

        vPrincipal.setPadding(new Insets(15,0,0,15));
        vPrincipal.setSpacing(25);
        vPrincipal.setPrefWidth(170);
        vPrincipal.getChildren().addAll(vImage, vPseudo);

        return vPrincipal;
    }

    public VBox creerDroite(){
        VBox vPrincipal = new VBox();
        VBox vEmail = new VBox();
        VBox vMotDePasse = new VBox();
        VBox vConfirmMotDePasse = new VBox();

        HBox hEmail = new HBox();
        HBox hMotDePasse = new HBox();

        //For email
        Label lEmail = new Label("Email :");
        lEmail.setFont(Font.font("Arial", 22));
        TextField tfEmail = new TextField();
        Button btEditionEmail = new Button();
        vEmail.getChildren().addAll(lEmail, hEmail);
        vEmail.setAlignment(Pos.TOP_CENTER);
        hEmail.setAlignment(Pos.TOP_CENTER);
        hEmail.getChildren().addAll(tfEmail, btEditionEmail);

        //for mot de passe
        Label lMotDePasse = new Label("Nouveau mot de passe :");
        lMotDePasse.setFont(Font.font("Arial", 22));
        PasswordField tfMotDePasse = new PasswordField();
        Button btEditionMotPasse = new Button();
        vMotDePasse.getChildren().addAll(lMotDePasse, hMotDePasse);
        vMotDePasse.setAlignment(Pos.TOP_CENTER);
        hMotDePasse.setAlignment(Pos.TOP_CENTER);
        hMotDePasse.getChildren().addAll(tfMotDePasse, btEditionMotPasse);

        //for confirm mot de passe
        Label lConfirmMotDePasse = new Label("Confirmation mot de passe :");
        lConfirmMotDePasse.setFont(Font.font("Arial",22));
        PasswordField tfConfirmMotDePasse = new PasswordField();
        tfConfirmMotDePasse.setPrefWidth(tfMotDePasse.getPrefWidth());
        vConfirmMotDePasse.setAlignment(Pos.TOP_CENTER);
        vConfirmMotDePasse.getChildren().addAll(lConfirmMotDePasse, tfConfirmMotDePasse);


        vPrincipal.getChildren().addAll(vEmail, vMotDePasse, vConfirmMotDePasse);
        vPrincipal.setPrefWidth(250);
        return vPrincipal;
    }

    public HBox creerBas(){
        return new HBox();
    }

    public String getTitle(){
        return this.title;
    }

}
