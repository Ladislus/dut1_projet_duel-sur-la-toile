package module_administrateur;

import javafx.scene.control.*;

/** Modèle du jeu */
public class Jeu {

  private int idJeu;
  private String nom;
  private String regles;
  private String sexe;
  private char active;
  private int idType;
  private CheckBox activer;

  /** Constructeur du joueur */
  public Joueur(int idJeu, String nom, String regles, String sexe, char active, int idType) {
    this.idJeu = idJeu;
    this.nom = nom;
    this.regles = regles;
    this.sexe = sexe;
    this.active = active;
    this.estActif = estActif;
    this.activer = new CheckBox();
  }

  public int getIdJeu() {
    return this.idJeu;
  }

  public String getNom() {
    return this.nom;
  }

  public String getRegles() {
    return this.regles;
  }

  public String getEmail() {
    return this.email;
  }

  public boolean getActive() {
    return this.active;
  }

  public Hyperlink getIdType() {
    return this.idType;
  }

  public CheckBox getActiver() {
    return this.activer;
  }

}
