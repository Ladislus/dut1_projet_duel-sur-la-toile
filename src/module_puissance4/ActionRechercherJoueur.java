package module_puissance4;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.*;

/**
 * Contrôleur pour sélectionner un adversaire
 */
public class ActionRechercherJoueur implements EventHandler<KeyEvent> {

    /** Vue de la fenêtre avec les différentes listes des joueurs */
    private ChoixJoueurP4 pageChoix;

    public ActionRechercherJoueur(ChoixJoueurP4 choixJoueurP4) {
        this.pageChoix = choixJoueurP4;
    }

    /** Trie la liste des joueurs affichés */
    @Override
    public void handle(KeyEvent event) {
        this.trier(this.pageChoix.barre);
    }

    /** Sélectionne tous les noms de joueurs qui contiennent ce qu'il est écrit dans la barre de recherche */
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
