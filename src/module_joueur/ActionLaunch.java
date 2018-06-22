package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.IOException;

public class ActionLaunch implements EventHandler<ActionEvent> {

    private String jeu;

    private Stage secondaryStage;

    /**
     Controlleur permettant de lancer les fichiers
     .jar contenu dans le dossier JAR
     @param secondaryStage : La page secondaire à propager
     @param jeu : Le nom du jeu à lancer
    */
    ActionLaunch(Stage secondaryStage, String jeu) {

        this.secondaryStage = secondaryStage;
        this.jeu = jeu; }

    @Override
    public void handle(ActionEvent event) {

        try { Runtime.getRuntime().exec("java -jar jar/" + jeu + ".jar"); }
        catch (IOException e) { e.printStackTrace(); }

        //Ferme la fenêtre de lancement de jeu
        this.secondaryStage.close();}}
