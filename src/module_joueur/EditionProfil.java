package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
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
        this.setBottom(creerBas());
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

        //image for edit pseudo
        File fileEditPseudo = new File("./img/pub/edit.png");
        ImageView ivImageEditPseudo = new ImageView();
        ivImageEditPseudo.setImage(new Image(fileEditPseudo.toURI().toString()));
        ivImageEditPseudo.setPreserveRatio(true);
        ivImageEditPseudo.setFitWidth(15);

        // for pseudo
        Label lPseudo = new Label("Mon pseudo");
        lPseudo.setFont(Font.font("Arial", 22));
        //Hbox vPseudo
        TextField tfPseudo = new TextField();
        tfPseudo.setDisable(true);
        Button btEdition = new Button("", ivImageEditPseudo);
        btEdition.setOnAction(actionEvent -> tfPseudo.setDisable(false));

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
        HBox hConfirmMotDePasse = new HBox();

        //For edition Image email
        File fileEdit = new File("./img/pub/edit.png");
        ImageView ivImageEdit = new ImageView();
        ivImageEdit.setImage(new Image(fileEdit.toURI().toString()));
        ivImageEdit.setPreserveRatio(true);
        ivImageEdit.setFitWidth(15);

        //For email
        Label lEmail = new Label("Email :");
        lEmail.setFont(Font.font("Arial", 22));
        TextField tfEmail = new TextField();
        tfEmail.setDisable(true);
        Button btEditionEmail = new Button("",ivImageEdit);
        btEditionEmail.setOnAction(actionEvent -> tfEmail.setDisable(false));

        vEmail.getChildren().addAll(lEmail, hEmail);
        vEmail.setAlignment(Pos.TOP_CENTER);
        vEmail.setSpacing(12);
        hEmail.setAlignment(Pos.TOP_CENTER);
        hEmail.getChildren().addAll(tfEmail, btEditionEmail);

        //For edition image mot de passe
        File fileEditMdp = new File("./img/pub/edit.png");
        ImageView ivImageEditMdp = new ImageView();
        ivImageEditMdp.setImage(new Image(fileEdit.toURI().toString()));
        ivImageEditMdp.setPreserveRatio(true);
        ivImageEditMdp.setFitWidth(15);

        //for mot de passe
        Label lMotDePasse = new Label("Nouveau mot de passe :");
        lMotDePasse.setFont(Font.font("Arial", 22));
        PasswordField tfMotDePasse = new PasswordField();
        tfMotDePasse.setDisable(true);
        Button btEditionMotPasse = new Button("", ivImageEditMdp);
        btEditionMotPasse.setOnAction(actionEvent -> tfMotDePasse.setDisable(false));
        vMotDePasse.getChildren().addAll(lMotDePasse, hMotDePasse);
        vMotDePasse.setAlignment(Pos.TOP_CENTER);
        vMotDePasse.setSpacing(12);
        hMotDePasse.setAlignment(Pos.TOP_CENTER);
        hMotDePasse.getChildren().addAll(tfMotDePasse, btEditionMotPasse);

        //for confirm mot de passe
        Label lConfirmMotDePasse = new Label("Confirmation :");
        lConfirmMotDePasse.setFont(Font.font("Arial",22));
        PasswordField tfConfirmMotDePasse = new PasswordField();
        tfConfirmMotDePasse.setDisable(true);
        vConfirmMotDePasse.setAlignment(Pos.TOP_CENTER);
        vConfirmMotDePasse.setSpacing(12);
        hConfirmMotDePasse.getChildren().addAll(tfConfirmMotDePasse);
        hConfirmMotDePasse.setAlignment(Pos.TOP_CENTER);
        tfConfirmMotDePasse.setPrefWidth(220);
        vConfirmMotDePasse.getChildren().addAll(lConfirmMotDePasse, hConfirmMotDePasse);


        vPrincipal.getChildren().addAll(vEmail, vMotDePasse, vConfirmMotDePasse);
        vPrincipal.setPadding(new Insets(15,6,0,0));
        vPrincipal.setSpacing(22);
        vPrincipal.setPrefWidth(350);
        return vPrincipal;
    }

    public BorderPane creerBas(){
        BorderPane bp = new BorderPane();
        Button btRetour = new Button("<-- Retour");
        btRetour.setStyle("-fx-background-color: #2355a0; -fx-text-fill: #ffffff");
        Button btSuppressionCompte = new Button("Supprimer mon compte");
        btSuppressionCompte.setStyle("-fx-background-color: #cc250c; -fx-text-fill: #ffffff");
        Button btEnregistrer = new Button("Enregistrer");
        btEnregistrer.setStyle("-fx-background-color: #40b70c; -fx-text-fill: #ffffff");
        bp.setLeft(btRetour);
        bp.setCenter(btSuppressionCompte);
        bp.setRight(btEnregistrer);
        bp.setPadding(new Insets(0,10,10,10));

        return bp;
    }

    public String getTitle(){
        return this.title;
    }

}
