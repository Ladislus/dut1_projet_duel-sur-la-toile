package APIMySQL;

import java.sql.SQLException;
import java.util.*;

public class Administrateur {

  private Administrateur(){}

  public static String getUserPseudo(ConnexionMySQL co){
    try {
      return GestionBD.selectPreparedStatement(co,"SELECT pseudoUt from UTILISATEUR where idUt = (?);");
    }
    catch (SQLException e) {
        e.printStackTrace();
        return null;
      }
  }

  public static String getUserPrenom(ConnexionMySQL co){
    try {
      return GestionBD.selectPreparedStatement(co,"SELECT prenomUt from UTILISATEUR where idUt = (?);");
    }
    catch (SQLException e) {
        e.printStackTrace();
        return null;
      }
  }

  public static String getUserNom(ConnexionMySQL co){
    try {
      return GestionBD.selectPreparedStatement(co,"SELECT nomUt from UTILISATEUR where idUt = (?);");
    }
    catch (SQLException e) {
        e.printStackTrace();
        return null;
      }
  }

  public static String getUserEmail(ConnexionMySQL co){
    try {
      return GestionBD.selectPreparedStatement(co,"SELECT emailUt from UTILISATEUR where idUt = (?);");
    }
    catch (SQLException e) {
        e.printStackTrace();
        return null;
      }
  }

  public static String getUserRole(ConnexionMySQL co){
    try {
      return GestionBD.selectPreparedStatement(co,"SELECT roleUt from UTILISATEUR where idUt = (?);");
    }
    catch (SQLException e) {
        e.printStackTrace();
        return null;
      }
  }

  public static String getUserNomJeuPlusJoue(ConnexionMySQL co){
    try {
      return GestionBD.selectPreparedStatement(co,"SELECT nomJeu from UTLISATEUR NATURAL JOIN JEU where idUt = (?) and nbPartie in(select max(nbPartie)	from JEU);");
    }
    catch (SQLException e) {
        e.printStackTrace();
        return null;
      }
  }

  public static String getUserTempsPlateforme(ConnexionMySQL co){
    try {
      return GestionBD.selectPreparedStatement(co,"SELECT max(tempsPlateforme) from UTILISATEUR where idUt = (?);");
    }
    catch (SQLException e) {
        e.printStackTrace();
        return null;
      }
  }

  public static String getUserNbAmis(ConnexionMySQL co){
    try {
      return GestionBD.selectPreparedStatement(co,"SELECT count(amis) from UTILISATEUR where idUt = (?);");
    }
    catch (SQLException e) {
        e.printStackTrace();
        return null;
      }
  }

  public static String getUserNbPartiesJouees(ConnexionMySQL co){
    try {
      return GestionBD.selectPreparedStatement(co,"SELECT count(parties) from UTILISATEUR where idUt = (?);");
    }
    catch (SQLException e) {
        e.printStackTrace();
        return null;
      }
  }



}
