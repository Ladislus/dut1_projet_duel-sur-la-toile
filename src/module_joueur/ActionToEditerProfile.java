package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActionToEditerProfile implements EventHandler<ActionEvent> {

    private Joueur joueur;

    private Stage primaryStage;

    /**
     Controlleur permettant l'affiche de l'edition de profil
     @param primaryStage : La page principale à propager
     @param joueur : Le joueur courant
    */
    ActionToEditerProfile(Stage primaryStage, Joueur joueur) {

        this.joueur = joueur;

        this.primaryStage = primaryStage; }

    /**
     Affiche un nouvelle page et la charge avec EditionProfil
     @param actionEvent : L'ActionEvent contenant l'action
    */
    @Override
    public void handle(ActionEvent actionEvent) {

        Stage stageEditionProfile = new Stage();

        EditionProfil editer = new EditionProfil(primaryStage, stageEditionProfile, joueur);

        stageEditionProfile.setResizable(VariablesJoueur.IS_RESIZABLE);
        stageEditionProfile.setTitle(editer.getTitle());
        stageEditionProfile.setScene(new Scene(editer, VariablesJoueur.DEFAULT_EDITERPROFILE_WIDTH, VariablesJoueur.DEFAULT_EDITERPROFILE_HEIGHT));
        stageEditionProfile.show(); }}
