package module_mastermind;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


import java.util.*;

public class ActionRechercherJoueurM implements EventHandler<KeyEvent> {

    private ChoixJoueurM pageChoix;

    public ActionRechercherJoueurM(ChoixJoueurM choixJoueurM) {
        this.pageChoix = choixJoueurM;
    }

    @Override
    public void handle(KeyEvent event) {
        this.trier(this.pageChoix.barre);
    }

    private void trier(TextField barre) {
        Set<String> res = new HashSet<>();
        String racine = barre.getText();
        if (this.pageChoix.mode == "New Game"){this.pageChoix.listeCour = this.pageChoix.listeAmis;}
        else {this.pageChoix.listeCour = this.pageChoix.listeAdvers;}
        if (racine.length()>0) {
            for (String nom : this.pageChoix.listeCour) {
                if (nom.toLowerCase().contains(racine.toLowerCase())) {
                    res.add(nom);
                }
            }
            this.pageChoix.listeCour = res;
        }
        this.pageChoix.majContacts();
    }
}
