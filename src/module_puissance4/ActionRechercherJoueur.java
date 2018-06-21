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

    /**
     * Constructeur de ActionRechercherJoueur, qui permet de rechercher des joueurs parmi ceux
     * @param choixJoueurP4 un ChoixJoueurP4
     */
    public ActionRechercherJoueur(ChoixJoueurP4 choixJoueurP4) {
        this.pageChoix = choixJoueurP4;
    }

    /**
     * Trie la liste des joueurs affichés
     * @param event un KeyEvent
     */
    @Override
    public void handle(KeyEvent event) {
        this.trier(this.pageChoix.barre);
    }

    /**
     * Sélectionne tous les noms de joueurs qui contiennent ce qui est écrit dans la barre de recherche
     * @param barre un TextField
     */
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
