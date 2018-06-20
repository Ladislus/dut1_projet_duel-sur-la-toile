package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.IOException;

public class ActionLaunch implements EventHandler<ActionEvent> {

    private String jeu;

    private Stage secondaryStage;

    public ActionLaunch(Stage secondaryStage, String jeu) {

        this.secondaryStage = secondaryStage;
        this.jeu = jeu; }

    public void handle(ActionEvent event) {

        try { Runtime.getRuntime().exec("java -jar jar/" + jeu + ".jar"); }
        catch (IOException e) { e.printStackTrace(); }

        this.secondaryStage.close();}}
