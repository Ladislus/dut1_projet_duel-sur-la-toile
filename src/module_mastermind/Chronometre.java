package module_mastermind;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.util.Duration;

import java.awt.*;

public class Chronometre extends Label {

    private Timeline timeline; // timeline qui va gérer le temps

    private KeyFrame keyFrame; // fenêtre de temps

    private ActionTemps actionTemps; // contrôleur associé au chronomètre

    /**
     * Constructeur du Chronometre étendant Label, qui est un Label qui se décrémente avec le temps
     * (ici fixé à 200 secondes au départ)
     */
    public Chronometre(){
        super("200");
        this.actionTemps= new ActionTemps(this);
        this.keyFrame= new KeyFrame(new Duration(1), this.actionTemps);
        this.timeline= new Timeline(this.keyFrame);
        this.timeline.setCycleCount(Animation.INDEFINITE);
    }

    /**
     * Méthode permettant de mettre à jour le Label en fonction du temps restant
     * @param tempsMillisec le temps restant un long
     */
    public void setTime(long tempsMillisec){
        long tpsSec = (tempsMillisec / 1000) % 60;

        if (Double.parseDouble(getText()) < 1){
            this.stop();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("TEMPS ÉCOULÉ !");
            alert.setHeaderText("Vous avez perdu ...");
            alert.setContentText("Votre temps imparti est écoulé.\n" +
                    "Vous avez donc perdu la partie automatiquement.\n" +
                    "Votre score est de 0 points. Réessayer et surpassez vous !");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }
        else {
            this.setText(""+(200-tpsSec));
        }
    }

    /**
     * Renvoie une String du Label du Chronometre
     * @return une String
     */
    public String getTime(){
        return this.getText();
    }

    /**
     * Permet de démarrer le Chronometre
     */
    public void start(){
        this.timeline.play();
    }

    /**
     * Permet d'arrêter le Chronometre
     */
    public void stop(){
        this.timeline.stop();
    }

    /**
     * Remet le Chronometre à sa position initiale (200)
     */
    public void resetTime(){
        this.actionTemps.reset();
    }
}
