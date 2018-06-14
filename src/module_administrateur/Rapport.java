package module_administrateur;

import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;

public class Rapport {

  private String pseudo;
  private String contenu;
  private Label labPseudo;
  private Label labContenu;
  private BorderPane b;
  private boolean lu;

  public Rapport(String pseudo, String contenu) {
    this.pseudo = pseudo;
    this.contenu = contenu;
    this.labPseudo = new Label(pseudo);
    this.labContenu = new Label(contenu);
    this.lu = false;
    this.b = new BorderPane();
  }

  public String getPseudo() {
    return this.pseudo;
  }

  public Label getLabPseudo() {
    return this.labPseudo;
  }

  public Label getLabContenu() {
    return this.labContenu;
  }

  public String getContenu() {
    return this.contenu;
  }

  public boolean getLu() {
      return this.lu;
  }

  public void setLu(boolean b) {
      this.lu = b;
  }

  public void setB(BorderPane b) {
    this.b = b;
  }

  public BorderPane getB() {
    return this.b;
  }

  @Override
  public String toString() {
    return this.pseudo + " : " + this.contenu + " " + this.lu;
  }
//  @Override
  //public boolean equals(Object o) {
  //  return (this.pseudo.equals((Rapport) o.getPseudo()) && this.contenu.equals((Rapport) o.getContenu()));
//  }
}
