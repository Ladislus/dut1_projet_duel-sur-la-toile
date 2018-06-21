package module_joueur;

import APIMySQL.GestionBD;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainJeux extends VBox {

    private String title;

    private Stage secondaryStage;

    private Jeu jeu;

    public MainJeux(Stage secondaryStage, Jeu jeu) {

        super();

        this.jeu = jeu;

        this.title = jeu.getTitle();

        this.secondaryStage = secondaryStage;

        this.setSpacing(25);
        this.getChildren().add(creerHeader());
        this.getChildren().add(creerDescription()); }

    public HBox creerHeader() {

        ImageView ivImageJeux = new ImageView();
        ivImageJeux.setImage(jeu.getImage());
        ivImageJeux.setPreserveRatio(true);
        ivImageJeux.setFitWidth(70);

        Label lbJeux = new Label(title);
        lbJeux.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

        VBox vImageTitre = new VBox();
        vImageTitre.getChildren().addAll(ivImageJeux, lbJeux);
        vImageTitre.setSpacing(12);

        Button btLauch = new Button("Lancer le jeu");
        btLauch.setOnAction(new ActionLaunch(this.secondaryStage, jeu.getTitle()));
        btLauch.setPrefHeight(50);

        HBox hBtLaunch = new HBox();
        hBtLaunch.getChildren().addAll(btLauch);
        hBtLaunch.setPadding(new Insets(35,0,0,120));

        HBox candidate = new HBox();
        candidate.getChildren().addAll(vImageTitre, hBtLaunch);
        candidate.setPadding(new Insets(15,0,0,10));

        return candidate; }

    public VBox creerDescription() {

        Label lbTitle = new Label("Description : ");
        lbTitle.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

        Label lbDescription = new Label(jeu.getRegle());
        lbDescription.setWrapText(true);


        VBox candidate = new VBox();
        candidate.getChildren().addAll(lbTitle, lbDescription);
        candidate.setSpacing(10);
        candidate.setPadding(new Insets(0,15,0,15));

        return candidate; }

    public HBox creerCoverFlow() {

        //TODO : Faire le coverFlow

        HBox hPrincipal = new HBox();

        return hPrincipal; }}
