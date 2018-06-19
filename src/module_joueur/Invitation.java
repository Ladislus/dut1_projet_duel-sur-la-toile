package module_joueur;

import APIMySQL.GestionBD;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Invitation extends VBox {

    private Stage primaryStage;

    private TextField tfSearch;

    private FlowPane flRechercherAmis;

    private Joueur joueur;

    private Dashboard dashboard;

    private ArrayList<Button> listeDamisBoutton;

    public Invitation(Joueur joueur, Dashboard dashboard){
        //this.primaryStage = primaryStage;
        this.joueur = joueur;
        this.dashboard = dashboard;
        this.listeDamisBoutton = new ArrayList<>();
        this.flRechercherAmis = new FlowPane();
        this.tfSearch = new TextField();
        this.getChildren().addAll(creerHeader());
        this.getChildren().add(creerRechercheAmis());
        //majAffichage();
    }

    public VBox creerHeader(){
        VBox vPrincipal = new VBox();

        VBox vRechercherJoueurTf = new VBox();
        Label lbTitle = new Label("Rechercher un joueur :");
        lbTitle.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);
        tfSearch.setPromptText("Rechercher une personne ...");
        tfSearch.setOnKeyReleased(new ActionRechercherJoueur(this));
        vRechercherJoueurTf.setPadding(new Insets(15,9,0,9));
        vRechercherJoueurTf.setAlignment(Pos.TOP_CENTER);
        vRechercherJoueurTf.setSpacing(12);
        vRechercherJoueurTf.getChildren().addAll(lbTitle, tfSearch);

        //VBox listeAmis = new VBox();
        vPrincipal.getChildren().addAll(vRechercherJoueurTf);
        return vPrincipal;
    }

    public FlowPane creerRechercheAmis(){
        flRechercherAmis = new FlowPane();
        flRechercherAmis.setPadding(new Insets(9,15,0,15));
        flRechercherAmis.setHgap(5);
        flRechercherAmis.setVgap(5);
        return flRechercherAmis;
    }

    public void majAffichage(List<Object> listeJoueur){
        flRechercherAmis.getChildren().removeAll(listeDamisBoutton);
        listeDamisBoutton = new ArrayList<>();
        try {
            for(Object ami : listeJoueur){
                if (!ami.toString().equals(joueur.getPseudo())){
                    Button btAmis = new Button(ami.toString());
                    btAmis.setOnAction(new ActionAjoutAmis(joueur.getPseudo(), btAmis.getText(), dashboard));
                    listeDamisBoutton.add(btAmis);
                }
            }
            flRechercherAmis.getChildren().addAll(listeDamisBoutton);
        }
        catch (NullPointerException e){
            flRechercherAmis.getChildren().clear();
        }


    }

    public TextField getTfSearch() {
        return tfSearch;
    }
}
