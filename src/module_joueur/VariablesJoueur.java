package module_joueur;

import javafx.scene.paint.Color;
import javafx.scene.image.Image;

import java.io.File;

class VariablesJoueur {

  public final static Color DEFAULT_BACKGROUND_COLOR = Color.LIGHTBLUE;
  public final static Color DEFAULT_TEXT_COLOR = Color.LIGHTCORAL;

  public final static double DEFAULT_APPLICATION_WIDTH = 850;
  public final static double DEFAULT_APPLICATION_HEIGHT = 650;

  public final static boolean IS_RESIZABLE = false;

  public final static Image LOGO = new Image(new File("./img/pub/logoWithoutText.png").toURI().toString());
  public final static Image HELP = new Image(new File("./img/pub/help.png").toURI().toString()); }
