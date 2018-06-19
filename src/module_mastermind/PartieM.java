package module_mastermind;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import module_puissance4.Joueur;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartieM {

    public static String chem = "./img/module_mastermind/";

    public List<Button> listeCouleurs;

    private PlateauM p;

    private Joueur j1,j2;

    private Mastermind mastermind;

    private Circle c1,c2,c3,c4;
    private List<Circle> lCercle;
    private VBox listeComb;

    private Map<Integer,Color> attributionCouleur;
    private Map<Integer,Color> attributionIndices;

    public String etatPartie(){
        return "" +
                this.p.getCombiMystere() + "," +
                this.p.getListeEssais() + "," +
                this.p.getListeResultats() + "," +
                this.p.getCombiCour() + "," +
                this.getJ1() + "," +
                this.getJ2();
    }

    public PartieM(Mastermind m,String j1,String j2){
        this.mastermind = m;

        this.listeComb = new VBox(10);
        this.listeComb.setSpacing(20.);
        this.listeComb.setPrefWidth(450.);
        this.listeComb.setPrefHeight(600.);
        this.listeComb.setStyle("-fx-background-color: #DCDCDC");


        this.p = new PlateauM(j1,j2);

        this.attributionCouleur = new HashMap<>();
        this.attributionCouleur.put(0,Color.DARKGREY);
        this.attributionCouleur.put(1,Color.YELLOW);
        this.attributionCouleur.put(2,Color.RED);
        this.attributionCouleur.put(3,Color.BLUE);
        this.attributionCouleur.put(4,Color.SADDLEBROWN);
        this.attributionCouleur.put(5,Color.FORESTGREEN);
        this.attributionCouleur.put(6,Color.CYAN);

        this.attributionIndices = new HashMap<>();
        this.attributionIndices.put(0,Color.valueOf("#979797"));
        this.attributionIndices.put(1,Color.RED);
        this.attributionIndices.put(2,Color.WHITE);

        this.j1 = new Joueur(j1);
        this.j2 = new Joueur(j2);

        System.out.println(this.etatPartie());
    }

    public PlateauM getPlateau(){
        return this.p;
    }

    public Joueur getJ1() {
        return j1;
    }

    public Joueur getJ2() {
        return j2;
    }

    public void majAffichage(){

        lCercle = new ArrayList<>();
        lCercle.add(c1);
        lCercle.add(c2);
        lCercle.add(c3);
        lCercle.add(c4);

        for (Circle c : lCercle){
            int pos = this.getPlateau().getCombiCour().get(lCercle.indexOf(c));
            c.setFill(this.attributionCouleur.get(pos));
        }
    }

    public void ajouteResultat(){
        if ((this.p.getListeEssais().size() > 0 && this.p.getListeEssais() != null) && (this.p.getListeResultats().size() > 0 && this.p.getListeResultats() != null)){
            HBox nouvEssai = new HBox();
            nouvEssai.setSpacing(20);
            Label numEssai = new Label(this.p.getListeEssais().size()+"");
            numEssai.setFont(Font.font(30));
            nouvEssai.getChildren().add(numEssai);
            Combinaison dernierEssai = this.p.getListeEssais().get(this.p.getListeEssais().size()-1);
            for (int c : dernierEssai){
//                System.out.println(c);
                nouvEssai.getChildren().add(new Circle(25,this.attributionCouleur.get(c)));
            }
            GridPane indices = new GridPane();
            Combinaison dernierIndices = this.p.getListeResultats().get(this.p.getListeResultats().size()-1);
            for (int i = 1; i<5; i++){
                indices.add(new Circle(10,this.attributionIndices.get(dernierIndices.get(i-1))),(i-1)%2,(i-1)/2);
            }
            indices.setVgap(5);
            indices.setHgap(5);
            nouvEssai.getChildren().add(indices);
            nouvEssai.setMinWidth(425);
            nouvEssai.setAlignment(Pos.CENTER_RIGHT);
            nouvEssai.setPadding(new Insets(0,30,0,0));
            this.listeComb.getChildren().addAll(nouvEssai);
        }
    }

    /**
     * Créer la Scene du Mastermind
     */
    public Scene getScene(Mastermind m) {
        BorderPane res = new BorderPane();
        res.setLeft(menu(m));
        res.setTop(haut());
        res.setRight(plateauSP(this.listeComb));
        res.setBottom(bas());
        res.setPadding(new Insets(0,50,0,0));

        return new Scene(res, 850, 650);
    }

    public static HBox haut(){
        HBox res = new HBox(5);
        Label titre = new Label("Mastermind");
        titre.setFont(Font.font("Verdana", FontWeight.BOLD, 45));
        res.getChildren().addAll(titre);
        res.setAlignment(Pos.CENTER);
        res.setPadding(new Insets(0,0,20,0));
        return res;
    }

    public VBox menu(Mastermind m){
        VBox res = new VBox(25);

        Button quitter = new Button("Quitter");
        quitter.setOnAction(new ActionQuitterM(m));

        Label timer = new Label("Time : 200");
        timer.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        timer.setPadding(new Insets(75,0,0,0));

        Label couleurs = new Label("Couleurs :");
        couleurs.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        couleurs.setPadding(new Insets(50,0,0,0));

        GridPane tabCouleurs = new GridPane();

        for (int i = 1; i <7; i++){
            Circle cercle = new Circle(25);
            cercle.setFill(this.attributionCouleur.get(i));
            cercle.setUserData(i);
            cercle.setOnMouseClicked(new ActionMettreCouleur(this));

//          gridpane.add(truc, colonne, ligne);
            tabCouleurs.add(cercle,(i-1)%3,(i-1)/3);
        }

        Button aide = new Button("?");
        aide.setFont(Font.font("Verdana", FontWeight.BOLD,25));
        aide.setTextFill(Color.WHITE);
        aide.setStyle("-fx-background-color: #202020");
        aide.setOnAction(new ActionHelpM());


        tabCouleurs.setHgap(20);
        tabCouleurs.setVgap(20);

        tabCouleurs.setPadding(new Insets(0,0,50,30));

        res.getChildren().addAll(quitter,timer,couleurs,tabCouleurs,aide);

        res.setPadding(new Insets(0,0,0,20));

        return res;
    }


    public ScrollPane plateauSP(VBox plateau){

//        HBox temp = new HBox(20);
//        Label num = new Label(1+"");
//        num.setFont(Font.font(40));
//        temp.getChildren().add(num);
//
//        for(int k=0; k<4;k++){
//            Circle cercleGris = new Circle(25);
//            cercleGris.setFill(Color.DARKGREY);
//            temp.getChildren().addAll(cercleGris);
//        }
//
//        GridPane plateau = new GridPane();
//
//        Circle cercleIndice1 = new Circle(10);
//        cercleIndice1.setFill(Color.BLACK);
//
//        Circle cercleIndice2 = new Circle(10);
//        cercleIndice2.setFill(Color.BLACK);
//
//        Circle cercleIndice3 = new Circle(10);
//        cercleIndice3.setFill(Color.BLACK);
//
//        Circle cercleIndice4 = new Circle(10);
//        cercleIndice4.setFill(Color.BLACK);
//
//        plateau.add(cercleIndice1,1,0);
//        plateau.add(cercleIndice2,2,0);
//        plateau.add(cercleIndice3,1,1);
//        plateau.add(cercleIndice4,2,1);
//
//        plateau.setHgap(5);
//        plateau.setVgap(5);
//
//        temp.getChildren().addAll(plateau);
//
//        res.getChildren().addAll(temp);

        ScrollPane sp = new ScrollPane(plateau);
        sp.setHmin(200.);
        sp.setPadding(new Insets(15,0,0,0));
        sp.setStyle("-fx-background-color: #DCDCDC;" +
                "-fx-border-color: black;");
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        sp.setPrefViewportWidth(425);
        sp.setPrefHeight(800.);

        return sp;
    }

    public HBox bas(){
        HBox res = new HBox();
        res.setAlignment(Pos.CENTER);
        res.setSpacing(20.);
        res.setPrefHeight(100.);

        String supprNormal = "-fx-background-color: linear-gradient(#FFA500,#F40000);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";
        String supprHover = "-fx-background-color: linear-gradient(#ff8d80, #ff8d80);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";

        Button suppr = new Button("Supprimer");
        suppr.setOnAction(new ActionSupprimerTout(this));

        suppr.setStyle(supprNormal);
        suppr.setOnMouseEntered(e -> suppr.setStyle(supprHover));
        suppr.setOnMouseExited(e -> suppr.setStyle(supprNormal));

        String valNormal = "-fx-background-color: linear-gradient(#78EA21,#4FB601);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";
        String valHover = "-fx-background-color: linear-gradient(#00FF80, #00FF80);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";

        Button valider = new Button("Valider");
        valider.setOnAction(new ActionTestComb(this));

        valider.setStyle(valNormal);
        valider.setOnMouseEntered(e -> valider.setStyle(valHover));
        valider.setOnMouseExited(e -> valider.setStyle(valNormal));

        HBox adders = new HBox();

        c1 = new Circle(20);
        c1.setFill(Color.DARKGREY);
        c1.setUserData(0);
        c1.setOnMouseClicked(new ActionSupprimerCouleur(this));

        c2 = new Circle(20);
        c2.setFill(Color.DARKGREY);
        c2.setUserData(1);
        c2.setOnMouseClicked(new ActionSupprimerCouleur(this));

        c3 = new Circle(20);
        c3.setFill(Color.DARKGREY);
        c3.setUserData(2);
        c3.setOnMouseClicked(new ActionSupprimerCouleur(this));

        c4 = new Circle(20);
        c4.setFill(Color.DARKGREY);
        c4.setUserData(3);
        c4.setOnMouseClicked(new ActionSupprimerCouleur(this));


        adders.getChildren().addAll(c1,c2,c3,c4);

        res.getChildren().addAll(suppr,c1,c2,c3,c4,valider);

        res.setPadding(new Insets(-50,0,0,240));
        return res;
    }

}
