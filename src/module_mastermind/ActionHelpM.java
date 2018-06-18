package module_mastermind;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

public class ActionHelpM implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aide");
        alert.setHeaderText("Comment jouer au Mastermind ?");
        alert.setContentText("Le but du Mastermind est de trouver la combinaison choisie par l'adversaire le plus vite possible.\n " +
                "Une combinaison est composée de 4 pions de couleurs.\n" +
                "Le bouton Supprimer permet d'enlever le dernier pion de la combianiason en cours.\n" +
                "Le bouton Valider permet de tester la combinaison choisie et la comparer avec celle que le joueur doit trouver.\n" +
                "Les 4 petits pions formant un carré à droite de la combinaison sont les indices: \n" +
                "   - un point bleu acier correspond à un pion de la bonne couleur mais mal placé.\n" +
                "   - un point noir correspond à un pion de la bonne couleur et bien placé.\n" +
                "   - sinon un rond gris clair apparait.\n" +
                "   \n" +
                "Bon jeu !");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.showAndWait();
    }
}
