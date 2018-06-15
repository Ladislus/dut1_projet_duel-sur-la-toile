package module_puissance4;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static module_puissance4.Puissance4.chem;


public class PartieP4 {
    // Vue de la plateforme de jeu Puissance 4

    private Puissance4 puissance4;
    private PlateauP4 p; // Modèle du jeu

    private List<List<Circle>> tableau; // Le tableau de pion
    private List<Button> listeBoutons; // Liste des boutons pour sélectionner une colonne
    private Button boutActiv; // Bouton de colonne activé

    public PartieP4(Puissance4 p4,String j1,String j2){
        this.puissance4 = p4;
        p = new PlateauP4(j1,j2);
    }

    public Scene getScene() {
        BorderPane res = new BorderPane();

        res.setLeft(this.menu());
        res.setBottom(this.bas());
        res.setTop(this.haut());
        res.setRight(this.indic());
        res.setCenter(this.PlateauP4());

        res.setOnKeyPressed(new ActionBoutonsClavier(this));

        return new Scene(res, 850, 650);
    }

    public List<Button> getListeBoutons() {
        return listeBoutons;
    }

    public Button getBoutActiv() {
        return boutActiv;
    }

    public void setBoutActiv(Button nouv){
        this.boutActiv = nouv;
    }

    public VBox menu() {
        VBox res = new VBox();
        res.setAlignment(Pos.BOTTOM_LEFT);
        res.setPadding(new Insets(5,5,30,5));
        res.setSpacing(20.);
        res.setPrefWidth(160.);

        Button save = new Button("Save Game");

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
        save.setOnAction(event -> this.puissance4.setScene("Home"));


        Button forfeit = new Button("Forfeit");

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
        forfeit.setOnAction(event -> this.puissance4.setScene("Home"));


        res.getChildren().addAll(save,forfeit);
        return res;
    }

    public VBox indic() {
        VBox res = new VBox();
        res.setPrefWidth(160.);
        res.setPadding(new Insets(50,5,0,10));

        Text info = new Text("TIPS !\nYou can play with the mouse or the keyboard !\n\nClick on the arrow on the columns\nOR\nTo move among the columns, press keys \nQ (left) and D (right).\n\nTo put a token,\n press key M.\n\nGood luck !");
        info.setWrappingWidth(140.);

        ImageView touches = new ImageView(new Image(new File(chem+"touchesP4.png").toURI().toString()));
        touches.setPreserveRatio(true);
        touches.setFitWidth(140.);

        res.getChildren().addAll(info,touches);
        return res;
    }

    private HBox haut() {
        HBox res = new HBox();
        res.setPrefHeight(100.);
        res.setAlignment(Pos.CENTER_LEFT);

        File file = new File(chem+"connect4logo.png");
        Image im = new Image(file.toURI().toString());
        ImageView iv = new ImageView(im);
        iv.setPreserveRatio(true);
        iv.setFitHeight(60);
        res.getChildren().addAll(iv);

        return res;
    }

    public HBox bas() {
        HBox res = new HBox();
        res.setAlignment(Pos.CENTER);
        res.setSpacing(20.);
        res.setPadding(new Insets(30,0,30,0));
        res.setPrefHeight(100.);

        HBox j1 = new HBox();
        j1.setPrefWidth(300.);
        Circle cercle = new Circle(20.,Color.RED);
        cercle.setStroke(Paint.valueOf("black"));
        j1.getChildren().addAll(p.getJ(1), cercle);
        j1.setSpacing(10.);
        j1.setAlignment(Pos.CENTER_RIGHT);

        HBox j2 = new HBox();
        j2.setPrefWidth(300.);
        Circle cercle2 = new Circle(20.,Color.valueOf("FFE000"));
        cercle2.setStroke(Paint.valueOf("black"));
        j2.getChildren().addAll(cercle2,p.getJ(2));
        j2.setSpacing(10.);
        j2.setAlignment(Pos.CENTER_LEFT);

        res.getChildren().addAll(j1,j2);

        return res;
    }

    public VBox PlateauP4() {
        VBox res = new VBox();


        // LIGNE DE BOUTONS POUR SÉLECTIONNER UNE COLONNE
        this.listeBoutons = new ArrayList<>();
        HBox ligneBoutons = new HBox();
        ligneBoutons.setSpacing(23.);
        ligneBoutons.setAlignment(Pos.CENTER);
        for (int c=0;c<7;c++){
            ImageView imDesactive = new ImgBouton("desactive");
            ImageView imRed = new ImgBouton("1");
            ImageView imYel = new ImgBouton("2");

            Button b = new Button("",imDesactive);
            b.setUserData(c);
            b.setOnMouseEntered(e -> {
                int n = (int) this.boutActiv.getUserData();
                this.boutActiv = b;
                this.majBoutons(n);
            } );
            b.setStyle("-fx-background-color: transparent;");
            b.setOnAction(new ActionJouerCol(this));

            this.listeBoutons.add(b);
            ligneBoutons.getChildren().add(b);
        }
        this.boutActiv = this.listeBoutons.get(3);
        this.boutActiv.setGraphic(new ImgBouton(String.valueOf(this.getPlateauP4().getJCour())));

        // TABLEAU DU PLATEAU
        tableau = new ArrayList<>();
        GridPane tab = new GridPane();
        tab.setStyle("-fx-background-color: #4F7EFF;" +
                     "-fx-border-width: 2px;" +
                     "-fx-border-color: black;" +
                     "-fx-background-radius: 30px 30px 0 0;" +
                     "-fx-border-radius: 30px 30px 0 0;");
        tab.setAlignment(Pos.CENTER);
        tab.setHgap(15.);
        tab.setVgap(15.);
        tab.setPadding(new Insets(5,0,10,0));

        for (int c=0;c<7;c++){
            tableau.add(new ArrayList<>());
            for (int l=0;l<6;l++){
                Circle cercle = new Circle(25.,Color.LIGHTGREY);
                cercle.setStroke(Paint.valueOf("black"));
                tab.add(cercle,c,5-l);
                tableau.get(c).add(cercle);
            }
        }

        res.getChildren().addAll(ligneBoutons,tab);
        return res;
    }

    public void majAffichage(int l, int c){
        if (this.p.getPion(l,c)==1)
            this.tableau.get(c).get(l).setFill(Color.RED);
        else if (this.p.getPion(l,c)==2)
            this.tableau.get(c).get(l).setFill(Color.YELLOW);
        if (this.p.getCol(c).isFull())
            this.listeBoutons.get(c).setDisable(true); // on désactive le bouton si sa colonne est pleine
        ResultatP4 etatJeu = this.p.etatDuJeu(l,c);
        if (etatJeu.contientPuissance){
            // Il y a un puissance 4
            int numJGagne = this.p.getJCour();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Connect 4 - Victory");
            alert.setHeaderText("And the winner is..."+this.p.getJ(numJGagne).getNom()+" !");
            alert.setContentText("The winner score is : "+this.p.nbPionsRest*etatJeu.nbPionsAlignes+" points !");
            alert.showAndWait();
        }
        if (etatJeu.contientPuissance || this.p.isFull()){
            for (Button b : listeBoutons)
                b.setDisable(true);
        }
    }

    public void majBoutons(int numAncien){
        this.listeBoutons.get(numAncien).setGraphic(new ImgBouton("desactive"));
        this.boutActiv.setGraphic(new ImgBouton(String.valueOf(this.getPlateauP4().getJCour())));
    }

    public PlateauP4 getPlateauP4() {
        return p;
    }
}
