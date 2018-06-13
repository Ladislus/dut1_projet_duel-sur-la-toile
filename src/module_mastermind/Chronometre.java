package module_mastermind;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.awt.*;

public class Chronometre extends Label {

    private Timeline timeline; // timeline qui va gérer le temps

    private KeyFrame keyFrame; // fenêtre de temps

    private ActionTemps actionTemps; // contrôleur associé au chronomètre

    public Chronometre(){
        super("00 : 00 : 00");
        this.actionTemps= new ActionTemps(this);
        this.keyFrame= new KeyFrame(new Duration(1), this.actionTemps);
        this.timeline= new Timeline(this.keyFrame);
        this.timeline.setCycleCount(Animation.INDEFINITE);
    }

    public void setTime(long tempsMillisec){
        long tpsCen = (tempsMillisec % 1000) / 10;
        long tpsSec = (tempsMillisec / 1000) % 60;
        long tpsMin = (tempsMillisec / (1000*60)) % 60;

        this.setText(tpsMin +" : "+ tpsSec +" : "+ tpsCen);
    }

    public void start(){
        this.timeline.play();
    }

    public void stop(){
        this.timeline.stop();
    }

    public void resetTime(){
        this.actionTemps.reset();
    }
}
