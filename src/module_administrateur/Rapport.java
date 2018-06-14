package module_administrateur;

import javafx.scene.layout.BorderPane;

public class Rapport {

  private String pseudo;
  private String contenu;
  private BorderPane b;

  public Rapport(String pseudo, String contenu) {
    this.pseudo = pseudo;
    this.contenu = contenu;
    this.b = new BorderPane();
  }

  public String getPseudo() {
    return this.pseudo;
  }

  public String getContenu() {
    return this.contenu;
  }

  @Override
  public String toString() {
    return this.pseudo + " : " + this.contenu;
  }

  public void setB(BorderPane b) {
    this.b = b;
  }

  public BorderPane getB() {
    return this.b;
  }

//  @Override
  //public boolean equals(Object o) {
  //  return (this.pseudo.equals((Rapport) o.getPseudo()) && this.contenu.equals((Rapport) o.getContenu()));
//  }
}
