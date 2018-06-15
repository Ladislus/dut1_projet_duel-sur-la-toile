package module_puissance4;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.*;

public class ActionRechercherJoueur implements EventHandler<KeyEvent> {

    private ChoixJoueurP4 pageChoix;

    public ActionRechercherJoueur(ChoixJoueurP4 choixJoueurP4) {
        this.pageChoix = choixJoueurP4;
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
