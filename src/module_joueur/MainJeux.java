package module_joueur;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class MainJeux extends VBox {

    String title;
    Jeu jeu;

    public MainJeux(Stage primaryStage, Jeu jeu) {

        super();
        this.jeu = jeu;
        this.title = jeu.getTitle();

        this.setSpacing(25);
        this.getChildren().add(creerHeader());
        this.getChildren().add(creerDescription());
        //this.getChildren().add(creerCoverFlow());
    }

    public HBox creerHeader() {
        HBox hPrincipal = new HBox();
        VBox vImageTitre = new VBox();

        File fileImageJeux = new File("./img/pub/logo.png");

        ImageView ivImageJeux = new ImageView();
        ivImageJeux.setImage(new Image(fileImageJeux.toURI().toString()));
        ivImageJeux.setPreserveRatio(true);

        ivImageJeux.setFitWidth(70);

        Label lbJeux = new Label(title);
        lbJeux.setFont(Font.font("Arial", 22));

        vImageTitre.getChildren().addAll(ivImageJeux, lbJeux);
        vImageTitre.setSpacing(12);

        HBox hBtLaunch = new HBox();
        Button btLauch = new Button("Lancer le jeux");
        btLauch.setPrefHeight(50);
        hBtLaunch.getChildren().addAll(btLauch);
        hBtLaunch.setPadding(new Insets(35,0,0,120));
        //Button btLauch
        hPrincipal.getChildren().addAll(vImageTitre, hBtLaunch);
        hPrincipal.setPadding(new Insets(15,0,0,10));

        return hPrincipal;
    }

    public VBox creerDescription(){
        VBox vPrincipal = new VBox();

        Label lbTitle = new Label("Description : ");
        lbTitle.setFont(Font.font("Arial", 19));

        Label lbDescription = new Label("Sudoribus sudoribus sudoribus quam urbium legiones excidium" +
                " matris Seleuciae amplificatis amplificatis ardore matris comes et fames desperatio bellicis et " +
                "fames matris comes et quam fames quam fames comes urbium viribus in concepta ardore et desperatio " +
                "amplificatis saeviore saeviore urbium quam tuebatur ardore viribus bellicis quam incendebat sudo" +
                "ribus Castricius Seleuciae Seleuciae tresque concepta comes et incendebat desperatio Castricius " +
                "Seleuciae induratae legiones sudoribus rabie induratae tuebatur quam saeviore tresque comes tre" +
                "sque excidium quam matris fames quam matris induratae viribus incohibili incendebat matris rabie" +
                " efferebantur induratae ardore tresque quam saeviore Seleuciae legiones excidium efferebantur des" +
                "peratio saeviore et saeviore et matris saeviore excidium ardore.");

        lbDescription.setWrapText(true);
        vPrincipal.getChildren().addAll(lbTitle, lbDescription);
        vPrincipal.setSpacing(10);
        vPrincipal.setPadding(new Insets(0,15,0,15));

        return vPrincipal;
    }

    public HBox creerCoverFlow(){
        HBox hPrincipal = new HBox();



        return hPrincipal;
    }

}
