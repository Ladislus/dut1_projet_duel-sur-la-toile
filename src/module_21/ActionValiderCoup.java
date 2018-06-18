package module_21;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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

        System.out.println(indice);

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
        for (int i=indice;i>indice-3 && i>=0;i--){
            lesBatons.get(i).active();
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
