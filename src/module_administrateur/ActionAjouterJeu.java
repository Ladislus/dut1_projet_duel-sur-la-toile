package module_administrateur;

import APIMySQL.Jeu;
import APIMySQL.APIMySQLException;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;

public class ActionAjouterJeu implements EventHandler<ActionEvent>{

  GererJeu gJeu;

  public ActionAjouterJeu(GererJeu gJeu){
    this.gJeu = gJeu;
  }

  @Override
  public void handle(ActionEvent actionEvent) {

    Button b = (Button) actionEvent.getSource();
    if((b.getText()) == "Ajouter"){
      ButtonType btoui = new ButtonType("Oui");
      ButtonType btnon = new ButtonType("Non", ButtonData.CANCEL_CLOSE);
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Confirmation de l'ajout");
      alert.setHeaderText("Confirmation ajout");
      alert.setContentText("Voulez-vous vraiment ajouter le jeu ?");
      alert.getButtonTypes().setAll(btoui, btnon);
      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == btoui){
        try{
          Jeu.creerJeu(gJeu.getNom(), gJeu.getRegles(), "/home/nmartins/Téléchargements/n.png", gJeu.getType(), "/home/nmartins/Téléchargements/n.png");
          alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("Validation de l'ajout du jeu");
          alert.setHeaderText(null);
          alert.setContentText("Le jeu a bien été ajouté.");
          alert.showAndWait();
        }
        catch (SQLException e) {
          alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("Ajout du jeu impossible");
          alert.setHeaderText(null);
          alert.setContentText("Le jeu n'a pas été ajouté.");
          alert.showAndWait();
          e.printStackTrace();
        }
      }
    }
  }

}
