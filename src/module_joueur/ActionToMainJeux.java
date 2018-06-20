package module_joueur;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ActionToMainJeux implements EventHandler<MouseEvent>{

    private Jeu jeu;

    public ActionToMainJeux(Jeu jeu) { this.jeu = jeu; }

    @Override
    public void handle(MouseEvent mouseEvent) {

        Stage stageMainJeux = new Stage();
        stageMainJeux.setTitle(jeu.getTitle());
        stageMainJeux.setResizable(false);
        stageMainJeux.setScene(new Scene(new MainJeux(stageMainJeux, jeu), 600, 400));
        stageMainJeux.show(); }}
