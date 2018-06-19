package module_joueur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;
import java.io.InputStream;


public class ActionLaunch implements EventHandler<ActionEvent> {

    private String jeu;

    public ActionLaunch(String jeu) { this.jeu = jeu; }

    public void handle(ActionEvent event) {

        Process proc = null;
        try { proc = Runtime.getRuntime().exec("java -jar " + jeu + ".jar"); }
        catch (IOException e) { e.printStackTrace(); }

        InputStream in = proc.getInputStream();
        InputStream err = proc.getErrorStream(); }}
