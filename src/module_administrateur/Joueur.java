package module_administrateur;

import javafx.scene.control.*;

/** Modèle du joueur */
public class Joueur {

  private int id;
  private String pseudo;
  private String prenom;
  private String nom;
  private String email;
  private String sexe;
  private String role;
  private boolean estActif;
  private CheckBox activer;
  private Hyperlink profil;

  /** Constructeur du joueur */
  public Joueur(int id, String pseudo, String prenom, String nom, String email, String sexe, String role, boolean estActif) {
    this.id = id;
    this.pseudo = pseudo;
    this.prenom = prenom;
    this.nom = nom;
    this.email = email;
    this.sexe = sexe;
    this.role = role;
    this.estActif = estActif;
    this.activer = new CheckBox();
    this.profil = new Hyperlink("Profil");
  }

  public int getId() {
    return this.id;
  }

  public String getPseudo() {
  	return this.pseudo;
  }

  public String getPrenom() {
    return this.prenom;
  }

  public String getNom() {
    return this.nom;
  }

  public String getSexe() {
  	return this.sexe;
  }

  public String getRole() {
    return this.role;
  }

  public String getEmail() {
    return this.email;
  }

  public boolean getEstActif() {
    return this.estActif;
  }

  public Hyperlink getProfil() {
    return this.profil;
  }

  public CheckBox getActiver() {
    return this.activer;
  }

  public String toString() {
    return this.pseudo;
  }
}
