package module_administrateur;

import javafx.scene.control.*;

public class Joueur {

  private String pseudo;
  private String email;
  private int id;
  private String sexe;
  private String role;
  private CheckBox activer;
  private Hyperlink profil;

  public Joueur(int id, String pseudo, String email, String sexe) {
    this.id = id;
    this.pseudo = pseudo;
    this.email = email;
    this.sexe = sexe;
    this.role = "Utilisateur";
    this.activer = new CheckBox();
    this.profil = new Hyperlink("Profil");
  }

  public String getPseudo() {
  	return this.pseudo;
  }

  public String getSexe() {
  	return this.email;
  }

  public String getEmail() {
    return this.email;
  }

  public String getRole() {
    return this.role;
  }

  public Hyperlink getProfil() {
    return this.profil;
  }

  public CheckBox getActiver() {
    return this.activer;
  }

  public int getId() {
  	return this.id;
  }

  public String toString() {
    return this.pseudo;
  }
}
