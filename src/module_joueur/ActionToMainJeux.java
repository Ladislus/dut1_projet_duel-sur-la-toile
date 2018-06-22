package module_joueur;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ActionToMainJeux implements EventHandler<MouseEvent>{

    private Jeu jeu;

    /**
     Controlleur ouvrant le pop-up de lancement d'un jeu
     @param jeu : Le jeu à lancé
    */
    ActionToMainJeux(Jeu jeu) { this.jeu = jeu; }

    /**
     Ouvre une nouvelle page et y insert les infos du jeu
     @param mouseEvent : Le MouseEvent contenant l'action
    */
    @Override
    public void handle(MouseEvent mouseEvent) {

        Stage stageMainJeux = new Stage();
        stageMainJeux.setTitle(jeu.getTitle());
        stageMainJeux.setResizable(VariablesJoueur.IS_RESIZABLE);
        stageMainJeux.setScene(new Scene(new MainJeux(stageMainJeux, jeu), 600, 400));
        stageMainJeux.show(); }}
