package module_joueur;

import com.sun.xml.internal.bind.v2.TODO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AjoutAmi extends VBox {

    private ArrayList<String> listeDamis;

    Stage primaryStage;

    public AjoutAmi(Stage primaryStage) {

        this.primaryStage = primaryStage;

        this.listeDamis = new ArrayList<>();

        this.getChildren().addAll(creerHeader());

        majAffichage(); }

    public VBox creerHeader() {

        Label lbTitle = new Label("Rechercher un joueur ...");
        lbTitle.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);

        TextField tfSearch = new TextField();
        tfSearch.setPromptText("Rechercher un joueur ...");

        VBox vRechercherJoueurTf = new VBox();
        vRechercherJoueurTf.setPadding(new Insets(15,9,0,9));
        vRechercherJoueurTf.setAlignment(Pos.TOP_CENTER);
        vRechercherJoueurTf.setSpacing(12);
        vRechercherJoueurTf.getChildren().addAll(lbTitle, tfSearch);

        VBox candidate = new VBox();
        candidate.getChildren().addAll(vRechercherJoueurTf);

        return candidate; }

    public FlowPane creerRechercheAmis() {

        FlowPane flRechercherAmis = new FlowPane();

        //TODO

        return flRechercherAmis; }

    public void majAffichage(){}}
