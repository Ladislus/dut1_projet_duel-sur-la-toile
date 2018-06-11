package module_mastermind;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


//
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//
//import java.util.List;
//
    public class PartieM {
//
//    public static String chem = "./img/module_puissance4/";
//
//    public List<Button> listeCouleurs;
//
//    private Plateau p;
//
//    public PartieM(String j1){
//        this.p = new Plateau("J1");
//    }

//    public Plateau getPlateau(){return this.p;}
//
//    public void majAffichage(int l, int c){}
//

    public static Scene getScene() {
        BorderPane res = new BorderPane();
        res.setLeft(menu());
        res.setTop(haut());
        res.setRight(plateau());
        res.setBottom(bas());

        return new Scene(res, 850, 650);
    }

    public static VBox haut(){
        VBox res = new VBox(5);
        Label titre = new Label("Mastermind");
        titre.setFont(Font.font("Verdana", FontWeight.BOLD, 45));
        res.getChildren().addAll(titre);
        res.setAlignment(Pos.CENTER);
        return res;
    }

    public static VBox menu(){
        VBox res = new VBox(5);

        Label timer = new Label("Time : 00:00:00");
        Label couleurs = new Label("Couleurs : ");
        GridPane tabCouleurs = new GridPane();

        Circle jaune = new Circle(15);
        jaune.setFill(Color.YELLOW);

        Circle rouge = new Circle(15);
        rouge.setFill(Color.RED);

        Circle bleu = new Circle(15);
        bleu.setFill(Color.BLUE);

        Circle marron = new Circle(15);
        marron.setFill(Color.SADDLEBROWN);

        Circle vert = new Circle(15);
        vert.setFill(Color.FORESTGREEN);

        Circle cyan = new Circle(15);
        cyan.setFill(Color.CYAN);

        //gridpane.add(truc, colonne, ligne);
        tabCouleurs.add(jaune,0,0);
        tabCouleurs.add(rouge,1,0);
        tabCouleurs.add(bleu,2,0);
        tabCouleurs.add(marron,0,1);
        tabCouleurs.add(vert,1,1);
        tabCouleurs.add(cyan,2,1);
        tabCouleurs.setHgap(5);
        tabCouleurs.setVgap(5);

        res.getChildren().addAll(timer,couleurs,tabCouleurs);

        return res;
    }

    public static VBox plateau(){
        VBox res = new VBox(10);
        res.setAlignment(Pos.CENTER_RIGHT);
        res.setPadding(new Insets(5,5,30,5));
        res.setSpacing(20.);
        res.setPrefWidth(160.);

        for(int i=0; i<7;i++){
            HBox temp = new HBox(20);

            for(int k=0; k<4;k++){
                Circle cercleBleu = new Circle(25);
                cercleBleu.setFill(Color.DARKGREY);
                temp.getChildren().addAll(cercleBleu);
            }

            GridPane plateau = new GridPane();

            Circle cercleIndice1 = new Circle(10);
            cercleIndice1.setFill(Color.BLACK);

            Circle cercleIndice2 = new Circle(10);
            cercleIndice2.setFill(Color.BLACK);

            Circle cercleIndice3 = new Circle(10);
            cercleIndice3.setFill(Color.BLACK);

            Circle cercleIndice4 = new Circle(10);
            cercleIndice4.setFill(Color.BLACK);

            plateau.add(cercleIndice1,1,0);
            plateau.add(cercleIndice2,2,0);
            plateau.add(cercleIndice3,1,1);
            plateau.add(cercleIndice4,2,1);

            plateau.setHgap(5);
            plateau.setVgap(5);

            temp.getChildren().addAll(plateau);

            res.getChildren().addAll(temp);
        }

//        res.getPadding();

        return res;
    }

    public static HBox bas(){
        HBox res = new HBox();
        res.setAlignment(Pos.CENTER);
        res.setSpacing(20.);
        res.setPadding(new Insets(30,0,30,0));
        res.setPrefHeight(100.);

        Button quitter = new Button("Quitter");
        Button suppr = new Button("Supprimer");
        Button valider = new Button("Valider");

        HBox adders = new HBox();

        Circle c1 = new Circle(15);
        c1.setFill(Color.DARKGREY);
        Circle c2 = new Circle(15);
        c2.setFill(Color.DARKGREY);
        Circle c3 = new Circle(15);
        c3.setFill(Color.DARKGREY);
        Circle c4 = new Circle(15);
        c4.setFill(Color.DARKGREY);

        adders.getChildren().addAll(c1,c2,c3,c4);

        res.getChildren().addAll(quitter,suppr,c1,c2,c3,c4,valider);

        return res;
    }// /
}
