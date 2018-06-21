package module_joueur;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

import java.net.URISyntaxException;
import java.util.regex.Pattern;

class VariablesJoueur {

  public final static Font DEFAULT_TITLE_FONT = Font.font("Arial", 19);
  public final static Font DEFAULT_TEXT_FONT = Font.font("Arial", 10);
  public final static Font DEFAULT_SLOGAN_FONT = Font.font("Arial", 15);

  public final static double DEFAULT_APPLICATION_WIDTH = 850;
  public final static double DEFAULT_APPLICATION_HEIGHT = 650;

  public final static Color DEFAULT_ERROR_COLOR = Color.RED;

  public final static double DEFAULT_CONNECTION_WIDTH = 500;
  public final static double DEFAULT_CONNECTION_HEIGHT = 290;

  public final static double DEFAULT_EDITERPROFILE_HEIGHT = 335;
  public final static double DEFAULT_EDITERPROFILE_WIDTH = 555;


  public final static double DEFAULT_RECHERCHER_JOUEUR_WIDTH = 600;
  public final static double DEFAULT_RECHERCHER_JOUEUR_HEIGHT = 380;

  public final static double DEFAULT_REGISTRATION_WIDTH = 500;
  public final static double DEFAULT_REGISTRATION_HEIGHT = 500;

  public final static boolean IS_RESIZABLE = false;

  public final static String SLOGAN = "La plateforme de jeux vidéos innovante !";
  public final static String COPYRIGHT = "© Copyright : Duel sur la toile";

  public static Image LOGO = null;
  public static Image LOGO_TEXT = null;
  public static Image CONTACT = null;
  public static Image LOGOUT = null;
  public static Image USER = null;
  public static Image EDIT = null;
  static {
    try {
      LOGO = new Image(VariablesJoueur.class.getResource("/img/pub/icon.png").toURI().toString());
      LOGO_TEXT = new Image(VariablesJoueur.class.getResource("/img/pub/logo.png").toURI().toString());
      CONTACT = new Image(VariablesJoueur.class.getResource("/img/pub/contact.png").toURI().toString());
      LOGOUT = new Image(VariablesJoueur.class.getResource("/img/pub/log_out.png").toURI().toString());
      USER = new Image(VariablesJoueur.class.getResource("/img/pub/user.png").toURI().toString());
      EDIT = new Image(VariablesJoueur.class.getResource("/img/pub/edit.png").toURI().toString());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }



  public final static Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9.]+@[A-Z0-9]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
  public final static Pattern PASSWORD_PATTERN = Pattern.compile("^^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$"); }
