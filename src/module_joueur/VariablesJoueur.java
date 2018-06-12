package module_joueur;

import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

import java.io.File;

class VariablesJoueur {

  public final static Font DEFAULT_TITLE_FONT = Font.font("Arial", 19);
  public final static Font DEFAULT_TEXT_FONT = Font.font("Arial", 10);
  public final static Font DEFAULT_SLOGAN_FONT = Font.font("Arial", 15);

  public final static Color DEFAULT_BACKGROUND_COLOR = Color.LIGHTBLUE;
  public final static Color DEFAULT_TEXT_COLOR = Color.LIGHTCORAL;

  public final static double DEFAULT_APPLICATION_WIDTH = 850;
  public final static double DEFAULT_APPLICATION_HEIGHT = 650;

  public final static double DEFAULT_CONNECTION_WIDTH = 500;
  public final static double DEFAULT_CONNECTION_HEIGHT = 290;

  public final static double DEFAULT_REGISTRATION_WIDTH = 500;
  public final static double  DEFAULT_REGISTRATION_HEIGHT = 430;

  public final static boolean IS_RESIZABLE = false;

  public final static Image LOGO = new Image(new File("./img/pub/logoWithoutText.png").toURI().toString());
  public final static Image LOGO_TEXT = new Image(new File("./img/pub/logo.png").toURI().toString());
  public final static Image HELP = new Image(new File("./img/pub/help.png").toURI().toString()); }
