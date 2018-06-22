package module_joueur;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URISyntaxException;
import java.util.regex.Pattern;

class VariablesJoueur {

  final static Font DEFAULT_TITLE_FONT = Font.font("Arial", 19);
  final static Font DEFAULT_TEXT_FONT = Font.font("Arial", 10);
  final static Font DEFAULT_SLOGAN_FONT = Font.font("Arial", 15);

  final static double DEFAULT_APPLICATION_WIDTH = 850;
  final static double DEFAULT_APPLICATION_HEIGHT = 650;

  final static Color DEFAULT_ERROR_COLOR = Color.RED;

  final static double DEFAULT_CONNECTION_WIDTH = 500;
  final static double DEFAULT_CONNECTION_HEIGHT = 290;

  final static double DEFAULT_EDITERPROFILE_HEIGHT = 335;
  final static double DEFAULT_EDITERPROFILE_WIDTH = 555;

  final static double DEFAULT_RECHERCHER_JOUEUR_WIDTH = 600;
  final static double DEFAULT_RECHERCHER_JOUEUR_HEIGHT = 380;

  final static double DEFAULT_REGISTRATION_WIDTH = 500;
  final static double DEFAULT_REGISTRATION_HEIGHT = 500;

  final static boolean IS_RESIZABLE = false;

  final static String SLOGAN = "La plateforme de jeux vidéos innovante !";
  final static String COPYRIGHT = "© Copyright : Duel sur la toile";

  static Image LOGO = null;
  static Image LOGO_TEXT = null;
  static Image CONTACT = null;
  static Image LOGOUT = null;
  static Image USER = null;
  static Image EDIT = null;

  static {

    try {

      LOGO = new Image(VariablesJoueur.class.getResource("/img/pub/icon.png").toURI().toString());
      LOGO_TEXT = new Image(VariablesJoueur.class.getResource("/img/pub/logo.png").toURI().toString());
      CONTACT = new Image(VariablesJoueur.class.getResource("/img/pub/contact.png").toURI().toString());
      LOGOUT = new Image(VariablesJoueur.class.getResource("/img/pub/log_out.png").toURI().toString());
      USER = new Image(VariablesJoueur.class.getResource("/img/pub/user.png").toURI().toString());
      EDIT = new Image(VariablesJoueur.class.getResource("/img/pub/edit.png").toURI().toString()); }
      catch (URISyntaxException e) { e.printStackTrace(); }}

  final static Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9.]+@[A-Z0-9]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
  final static Pattern PASSWORD_PATTERN = Pattern.compile("^^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$"); }
