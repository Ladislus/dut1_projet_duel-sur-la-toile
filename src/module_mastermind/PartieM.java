package module_mastermind;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.util.List;

public class PartieM {
//
    public static String chem = "./img/module_mastermind/";

    public List<Button> listeCouleurs;

    private Plateau p;

    private Mastermind mastermind;

    public PartieM(String j1){
        this.p = new Plateau();
    }

    public Plateau getPlateau(){
        return this.p;
    }

    public void majAffichage(){}
//

    public static Scene getScene(Mastermind m) {
        BorderPane res = new BorderPane();
        res.setLeft(menu(m));
        res.setTop(haut());
        res.setRight(plateau());
        res.setBottom(bas());

        return new Scene(res, 700, 650);
    }

    public static VBox haut(){
        VBox res = new VBox(5);
        Label titre = new Label("Mastermind");
        titre.setFont(Font.font("Verdana", FontWeight.BOLD, 45));
        res.getChildren().addAll(titre);
        res.setAlignment(Pos.CENTER);
        return res;
    }

    public static VBox menu(Mastermind m){
        VBox res = new VBox(25);

        Button quitter = new Button("Quitter");
        quitter.setOnAction(new ActionQuitterM(m));

        Label timer = new Label("Time : 00:00:00");
        timer.setPadding(new Insets(75,0,0,0));

        Label couleurs = new Label("Couleurs :");
        couleurs.setPadding(new Insets(50,0,0,0));

        GridPane tabCouleurs = new GridPane();

        Circle jaune = new Circle(25);
        jaune.setFill(Color.YELLOW);

        Circle rouge = new Circle(25);
        rouge.setFill(Color.RED);

        Circle bleu = new Circle(25);
        bleu.setFill(Color.BLUE);

        Circle marron = new Circle(25);
        marron.setFill(Color.SADDLEBROWN);

        Circle vert = new Circle(25);
        vert.setFill(Color.FORESTGREEN);

        Circle cyan = new Circle(25);
        cyan.setFill(Color.CYAN);


        File intero = new File(chem+"intero.png");
        ImageView inter = new ImageView();
        inter.setImage(new Image(intero.toURI().toString()));

        Button aide = new Button("",inter);
        aide.setOnAction(new ActionHelpM());


        //gridpane.add(truc, colonne, ligne);
        tabCouleurs.add(jaune,0,0);
        tabCouleurs.add(rouge,1,0);
        tabCouleurs.add(bleu,2,0);
        tabCouleurs.add(marron,0,1);
        tabCouleurs.add(vert,1,1);
        tabCouleurs.add(cyan,2,1);
        tabCouleurs.setHgap(5);
        tabCouleurs.setVgap(5);

        tabCouleurs.setPadding(new Insets(0,0,90,15));

        res.getChildren().addAll(quitter,timer,couleurs,tabCouleurs,aide);

        res.setPadding(new Insets(0,0,0,10));

        return res;
    }

    public static VBox plateau(){
        VBox res = new VBox(10);
        res.setAlignment(Pos.CENTER_RIGHT);
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

//        ScrollPane sp = new ScrollPane(res);
//        sp.setHmin(200.);
//        sp.setPadding(new Insets(0,0,0,0));
//        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        res.setPadding(new Insets(20,100,0,0));

        return res;
    }

    public static HBox bas(){
        HBox res = new HBox();
        res.setAlignment(Pos.CENTER);
        res.setSpacing(20.);
        res.setPadding(new Insets(30,0,30,0));
        res.setPrefHeight(100.);

        Button suppr = new Button("Supprimer");
        Button valider = new Button("Valider");

        HBox adders = new HBox();

        Circle c1 = new Circle(20);
        c1.setFill(Color.DARKGREY);
        Circle c2 = new Circle(20);
        c2.setFill(Color.DARKGREY);
        Circle c3 = new Circle(20);
        c3.setFill(Color.DARKGREY);
        Circle c4 = new Circle(20);
        c4.setFill(Color.DARKGREY);

        adders.getChildren().addAll(c1,c2,c3,c4);

        res.getChildren().addAll(suppr,c1,c2,c3,c4,valider);

        res.setPadding(new Insets(0,0,0,75));
        return res;
    }

}
