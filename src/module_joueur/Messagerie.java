package module_joueur;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Vue de la Messagerie
 */
public class Messagerie extends SplitPane {

    private List<Joueur> lesContacts;
    private static String chem = "./img/pub/";

    public Messagerie(){
        super();
        this.getItems().addAll(this.menuContact(),this.pageMessages());
        this.setDividerPositions(62/850f);


    }

    private ScrollPane pageMessages() {
        ScrollPane res = new ScrollPane();


        return res;
    }

    private ScrollPane menuContact() {


        VBox contacts = new VBox();
        Label titre = new Label("Mes contacts",new ImageView(new Image(new File(chem+"messaging.png").toURI().toString(),50.,50.,true,true)));
        titre.setFont(VariablesJoueur.DEFAULT_TITLE_FONT);
        titre.setPadding(new Insets(4));
        contacts.getChildren().add(titre);


        for (String nom : this.onglets()){
            ImageView img = new ImageView(new Image(new File(chem+"contact.png").toURI().toString()));
            img.setPreserveRatio(true);
            img.setFitHeight(55.);

            Button b = new Button(nom,img);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setFont(VariablesJoueur.DEFAULT_TEXT_FONT);
            b.setPrefWidth(300.);
            b.setPadding(new Insets(2));
            b.setStyle("-fx-border-radius: 0;" +
                    "-fx-background-radius: 0;");

            contacts.getChildren().add(b);
        }

        ScrollPane res = new ScrollPane(contacts);
        res.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        res.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        res.setMinWidth(72);
        res.setMaxWidth(300);

        this.setResizableWithParent(res,false);

        return res;
    }

    private List<String> onglets() {
        List<String> res = new ArrayList<>(Arrays.asList("Maffiou","Bordercraft","LuK","Benjam1","Valent1","Benjam2","LéOchocOLa","CoucousEat","Mattew","Antonio","LeProGamer45","BossDuGame","TonAmiWoody","MarioLeVrai","AlainSoralOfficiel"));

        return res;
    }

}
