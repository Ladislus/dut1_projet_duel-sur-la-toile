package module_21;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.ArrayList;
import java.util.List;

public class Partie21 {

    /** Le Stage principal, qui étend Application */
    private Jeu21Batonnets jeu21Batonnets;

    /** Le modèle du jeu */
    private Plateau21 p;

    /** La liste des Bâtonnets de la vue */
    private List<Batonnet> listeBatons;


    public Partie21(Jeu21Batonnets jeu21Batonnets,String j1,String j2) {
        this.jeu21Batonnets = jeu21Batonnets;
        this.p = new Plateau21(j1,j2);
        this.listeBatons = new ArrayList<>();
    }

    public Scene getScene() {
        BorderPane res = new BorderPane();

        res.setCenter(this.Plateau21());
        res.setBottom(this.bas());
        res.setLeft(this.menu());
        res.setTop(this.haut());
        res.setRight(this.indic());

        return new Scene(res,850,650);
    }

    private HBox bas() {
        HBox res = new HBox();
        res.setAlignment(Pos.CENTER);
        res.setSpacing(20.);
        res.setPadding(new Insets(30,0,30,0));
        res.setPrefSize(700.,100.);

        HBox j1 = new HBox();
        j1.setPrefWidth(300.);
        Rectangle r1 = new Rectangle(10.,80.,Color.valueOf("#D501F6"));
        r1.setStroke(Paint.valueOf("black"));
        j1.getChildren().addAll(p.getJ(1), r1);
        j1.setSpacing(10.);
        j1.setAlignment(Pos.CENTER_RIGHT);

        HBox j2 = new HBox();
        j2.setPrefWidth(300.);
        Rectangle r2 = new Rectangle(10.,80.,Color.valueOf("#ECB70B"));
        r2.setStroke(Paint.valueOf("black"));
        r2.setStrokeWidth(0.2);
        j2.getChildren().addAll(r2,p.getJ(2));
        j2.setSpacing(10.);
        j2.setAlignment(Pos.CENTER_LEFT);

        res.getChildren().addAll(j1,j2);

        return res;
    }

    private HBox Plateau21() {
        HBox res = new HBox();
        res.setStyle("" +
                "-fx-border-radius: 20;" +
                "-fx-border-color: black;" +
                "-fx-background-color: linear-gradient(to right,#DF4747,#FFBFBF);" +
                "-fx-background-radius: 20;");
        res.setAlignment(Pos.CENTER);
        res.setPadding(new Insets(10));
        res.setSpacing(17.);

        for (int b=0;b<21;b++){
            Batonnet bat = new Batonnet();
            bat.setOnMouseClicked(new ActionSelectBaton(this));

            bat.setUserData(b);
            bat.desactive();


            this.listeBatons.add(bat);
            res.getChildren().add(bat);
        }
        this.listeBatons.get(0).setFill(Color.valueOf("#FE4040"));

        for (int i=0;i<3;i++){
            this.listeBatons.get(20-i).active();
        }

        return res;
    }

    public VBox menu() {
        VBox res = new VBox();
        res.setAlignment(Pos.BOTTOM_LEFT);
        res.setPadding(new Insets(5,5,30,5));
        res.setSpacing(20.);
        res.setPrefWidth(100.);

        Button save = new Button("Sauver\nPartie");

        String saveNormal = "-fx-background-color: linear-gradient(#F0E000,#FFA500);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";
        String saveHover = "-fx-background-color: linear-gradient(#ffFF80, #ffFF80);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";

        save.setStyle(saveNormal);
        save.setOnMouseEntered(e -> save.setStyle(saveHover));
        save.setOnMouseExited(e -> save.setStyle(saveNormal));
        save.setPrefWidth(115.);
        save.setOnAction(event -> this.jeu21Batonnets.setScene("Home"));


        Button forfeit = new Button("Déclarer\nforfait");

        String forfeitNormal = "-fx-background-color: linear-gradient(#FF4d40,#f02020);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";
        String forfeitHover = "-fx-background-color: linear-gradient(#ff8d80, #ff8d80);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";

        forfeit.setStyle(forfeitNormal);
        forfeit.setOnMouseEntered(e -> forfeit.setStyle(forfeitHover));
        forfeit.setOnMouseExited(e -> forfeit.setStyle(forfeitNormal));
        forfeit.setPrefWidth(115.);
        forfeit.setOnAction(event -> this.jeu21Batonnets.setScene("Home"));


        res.getChildren().addAll(save,forfeit);
        return res;
    }

    public VBox indic() {
        VBox res = new VBox();
        res.setPrefWidth(100.);
        res.setPadding(new Insets(100,5,0,10));
        res.setAlignment(Pos.TOP_CENTER);
        res.setSpacing(50.);

        String valideNormal = "-fx-background-color: linear-gradient(#3AF401,#2BB601);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";
        String valideHover = "-fx-background-color: linear-gradient(#55CE30,#55CE30);"+
                "-fx-background-radius: 5;"+
                "-fx-font-size: 15;";

        Button valider = new Button("Valider\nle coup");
        valider.setAlignment(Pos.CENTER);
        valider.setStyle(valideNormal);
        valider.setOnMouseEntered(e -> valider.setStyle(valideHover));
        valider.setOnMouseExited(e -> valider.setStyle(valideNormal));
        valider.setOnAction(new ActionValiderCoup(this));


        Button aide = new Button("?");
        aide.setFont(Font.font("Verdana", FontWeight.BOLD,25));
        aide.setTextFill(Color.WHITE);
        aide.setStyle("-fx-background-color: #202020");
        aide.setOnAction(new ActionHelp21());

        res.getChildren().addAll(valider,aide);
        return res;
    }

    private HBox haut() {
        HBox res = new HBox();
        res.setPrefHeight(100.);
        res.setAlignment(Pos.CENTER_LEFT);

//        File file = new File(chem+"connect4logo.png");
//        Image im = new Image(file.toURI().toString());
//        ImageView iv = new ImageView(im);
//        iv.setPreserveRatio(true);
//        iv.setFitHeight(60);

        res.getChildren().addAll();

        return res;
    }

    public List<Batonnet> getListeBatons() {
        return listeBatons;
    }

    public Plateau21 getPlateau() {
        return p;
    }
}
