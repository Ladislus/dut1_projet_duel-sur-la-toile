package module_21;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

import java.util.List;

public class ActionValiderCoup implements EventHandler<ActionEvent> {

    private Partie21 partie;

    public ActionValiderCoup(Partie21 partie21) {
        this.partie = partie21;
    }

    @Override
    public void handle(ActionEvent event) {
        List<Batonnet> lesBatons = this.partie.getListeBatons();
        Liste21 lesNum = this.partie.getPlateau().getListe21batons();

        int indice = this.getPremActive(lesBatons);
        int nbBat = this.nbBatonSelect(indice);
        int jCour = this.partie.getPlateau().getJCour();

        // On désactive d'abord tous les bâtons activés
        for (int i=indice;i>indice-3 && i>=0;i--){
            lesBatons.get(i).desactive();
            lesNum.set(i,0);
        }

        // Puis on sauvegarde les nouveaux bâtons en fonctions du nombre demandé
        for (int i=indice;i>indice-nbBat;i--){
            lesBatons.get(i).sauver(jCour);
            lesNum.set(i,jCour);
        }

        // Enfin, on active les 3 suivants
        indice -= nbBat;
        for (int i=indice;i>indice-3 && i>=1;i--){
            lesBatons.get(i).active();
        }

        this.partie.getPlateau().changeJCour();

        // S'il ne reste que le dernier Bâtonnet, la partie est terminée
        if (this.partie.getPlateau().getListe21batons().estComplet()){
            Batonnet batFin = this.partie.getListeBatons().get(0);
            batFin.sauver(this.partie.getPlateau().getJCour());
            batFin.setHeight(150);
            this.partie.getPlateau().changeJCour();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aide");
            alert.setHeaderText("Partie terminée !");
            alert.setContentText(this.partie.getPlateau().getJ(this.partie.getPlateau().getJCour()).getNom()+" a gagné !\n");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }


    }

    private int getPremActive(List<Batonnet> lesBatons) {
        int res = 20;
        for (int i=20;i>=0;i--){
            if (lesBatons.get(i).getHeight()==240){return res;}
            else{res--;}
        }
        return 0;
    }

    public int nbBatonSelect(int indice){
        int res = 0;
        for (int i=indice;i>indice-3 && i>=0;i--){
            if (this.partie.getPlateau().getListe21batons().get(i) != 0)
                res++;
        }
        return res;
    }
}
