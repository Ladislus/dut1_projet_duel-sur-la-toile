package module_administrateur;

import javafx.scene.control.*;

public class Joueur {

  private String pseudo;
  private int id;
  private CheckBox activer;
  private Hyperlink profil;

  public Joueur(String pseudo, int id) {
    this.pseudo = pseudo;
    this.id = id;
    this.activer = new CheckBox();
    this.profil = new Hyperlink("Profil");
  }

  public String getPseudo() {
  	return this.pseudo;
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
