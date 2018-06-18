package module_joueur;

import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

import java.io.File;

import java.util.regex.Pattern;

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

  public final static double DEFAULT_EDITERPROFILE_HEIGHT = 335;
  public final static double DEFAULT_EDITERPROFILE_WIDTH = 555;

  public final static double DEFAULT_REGISTRATION_WIDTH = 500;
  public final static double DEFAULT_REGISTRATION_HEIGHT = 430;

  public final static boolean IS_RESIZABLE = false;

  public final static String SLOGAN = "La plateforme de jeux vidéos innovante !";
  public final static String COPYRIGHT = "© Copyright : Duel sur la toile";

  public final static Image LOGO = new Image(new File("./img/pub/logoWithoutText.png").toURI().toString());
  public final static Image LOGO_TEXT = new Image(new File("./img/pub/logo.png").toURI().toString());
  public final static Image HELP = new Image(new File("./img/pub/help.png").toURI().toString());
  public final static Image CONTACT = new Image(new File("./img/pub/contact.png").toURI().toString());
  public final static Image LOGOUT = new Image(new File("./img/pub/log_out.png").toURI().toString());
  public final static Image USER = new Image(new File("./img/pub/user.png").toURI().toString());
  public final static Image EDIT = new Image(new File("./img/pub/edit.png").toURI().toString());

  public final static Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9.]+@[A-Z0-9]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
  public final static Pattern PASSWORD_PATTERN = Pattern.compile("^^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$"); }
