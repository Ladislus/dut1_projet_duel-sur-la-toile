package module_administrateur;

import javafx.scene.control.*;

/** Modèle du jeu */
public class Jeu {

  private int idJeu;
  private String nomJeu;
  private String regleJeu;
  private String jarJeuPath;
  private char active;
  private int idType;
  private String imagePath;

  /** Constructeur du joueur */
  public Jeu(int idJeu, String nomJeu, String regleJeu, String jarJeuPath, char active, int idType, String imagePath) {
    this.idJeu = idJeu;
    this.nomJeu = nomJeu;
    this.regleJeu = regleJeu;
    this.jarJeuPath = jarJeuPath;
    this.active = active;
    this.imagePath = imagePath;
  }

  public Jeu(){}

  public int getIdJeu() {
    return this.idJeu;
  }

  public String getNomJeu() {
    return this.nomJeu;
  }

  public String getRegles() {
    return this.regleJeu;
  }

  public String getJarJeuPath(){
    return this.jarJeuPath;
  }

  public char getActive() {
    return this.active;
  }

  public int getIdType() {
    return this.idType;
  }

  public String getImagePath() {
    return this.imagePath;
  }

}
