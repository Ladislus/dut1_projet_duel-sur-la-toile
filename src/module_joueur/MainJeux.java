package module_joueur;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainJeux extends VBox {

    private String title;

    private Stage secondaryStage;

    private Jeu jeu;

    /**
     Fenêtre de lancement d'un jeu, contenant diverse informations
     @param secondaryStage : La page secondaire à propager
     @param jeu : Le jeu à lancé
    */
    MainJeux(Stage secondaryStage, Jeu jeu) {

        super();

        this.jeu = jeu;

        this.title = jeu.getTitle();

        this.secondaryStage = secondaryStage;

        this.setSpacing(25);
        this.getChildren().add(creerHeader());
        this.getChildren().add(creerDescription()); }

    /**
     Création du header contenant l'image, le bouton de lancement et le titre
      @return : Une HBox
    */
    private HBox creerHeader() {

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

    /**
     Création de la boite de description
     @return : Une VBox
    */
    private VBox creerDescription() {

        Label lbTitle = new Label("Description : ");
        lbTitle.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

        Label lbDescription = new Label(jeu.getRegle());
        lbDescription.setWrapText(true);


        VBox candidate = new VBox();
        candidate.getChildren().addAll(lbTitle, lbDescription);
        candidate.setSpacing(10);
        candidate.setPadding(new Insets(0,15,0,15));

        return candidate; }

    /**
     Création d'un page contenant des screenshots du jeu (Pas implémenté)
     @return : Une HBox
    */
    public HBox creerCoverFlow() {

        //TODO : Faire le coverFlow
        return new HBox(); }}
