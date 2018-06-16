package module_joueur;


import APIMySQL.ConnexionMySQL;
import APIMySQL.GestionBD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class ActionSupressionCompte implements EventHandler<ActionEvent> {

    Stage primaryStage;
    ConnexionMySQL laConnection;

    public ActionSupressionCompte(Stage primaryStage, ConnexionMySQL laConnection){
        this.laConnection = laConnection;
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ConnexionJoueur connexion = new ConnexionJoueur(this.primaryStage, this.laConnection);

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Attention");
        alert.setContentText("Etes vous sure de vouloir supprimer votre compte ?");
        ButtonType okButton = new ButtonType("Oui", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("Non", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(okButton, noButton);
        alert.showAndWait().ifPresent(type -> {
            if (type.getButtonData().toString().equals("YES")) {
                //todo: change activeUt into the BD
                this.primaryStage.setTitle(connexion.getTitle());
                this.primaryStage.setScene(new Scene(connexion, VariablesJoueur.DEFAULT_CONNECTION_WIDTH, VariablesJoueur.DEFAULT_CONNECTION_HEIGHT));
            }
            else{

            }
        });
    }
}
