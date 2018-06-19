package module_joueur;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AjoutAmi extends VBox {

    private Stage primaryStage;

    private ArrayList<String> listeDamis;

    
    public AjoutAmi(){
        //this.primaryStage = primaryStage;
        this.listeDamis = new ArrayList<>();
        this.getChildren().addAll(creerHeader());

        majAffichage();
    }

    public VBox creerHeader(){
        VBox vPrincipal = new VBox();

        VBox vRechercherJoueurTf = new VBox();
        Label lbTitle = new Label("Rechercher un joueur ...");
        lbTitle.setFont(Font.font("Arial", 22));
        TextField tfSearch = new TextField();
        tfSearch.setPromptText("Rechercher une personne ...");
        vRechercherJoueurTf.setPadding(new Insets(15,9,0,9));
        vRechercherJoueurTf.setAlignment(Pos.TOP_CENTER);
        vRechercherJoueurTf.setSpacing(12);
        vRechercherJoueurTf.getChildren().addAll(lbTitle, tfSearch);

        //VBox listeAmis = new VBox();
        vPrincipal.getChildren().addAll(vRechercherJoueurTf);
        return vPrincipal;
    }

    public FlowPane creerRechercheAmis(){
        FlowPane flRechercherAmis = new FlowPane();



        return flRechercherAmis;
    }

    public void majAffichage(){

    }


}
