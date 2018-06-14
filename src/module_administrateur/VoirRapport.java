package module_administrateur;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;

public class VoirRapport extends BorderPane {

    PageAccueil pa;

    Button suppr;
    VBox listeRapport;
    Label l;

    //EXEMPLE
    ArrayList<Rapport> liste;

    public VoirRapport(PageAccueil pa) {
        super();
        this.pa = pa;
        this.l = new Label();

        //EXEMPLE
        this.liste = new ArrayList<>();
        this.liste.add(new Rapport("Leo", "hjgjerg"));
        this.liste.add(new Rapport("Nolan", "gzeeeg"));
        this.liste.add(new Rapport("Valentin", "hg"));
        this.liste.add(new Rapport("ehhe", "gsrrhdgbgf"));
        this.liste.add(new Rapport("Ladhrhislas", "hrr"));
        this.liste.add(new Rapport("ehrh", "gsdgbgf"));
        this.liste.add(new Rapport("dd", "gsdgbgf"));
        this.liste.add(new Rapport("575", "g58"));

        this.haut();
        this.corp();
        this.l.setText("Nombre de rapport non lus : "+this.pa.getAdmin().getRapport().size());
    }

    public VBox getVBoxListeRapport() {
        return this.listeRapport;
    }

    public Label getLabel() {
        return this.l;
    }

    public void haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Rapport des joueurs");
        Button bRetour = new Button("< Retour");
        haut.setLeft(l);
        haut.setRight(bRetour);
        l.setFont(Font.font ("Arial", 25));
        bRetour.setOnAction(new ActionRetour(this.pa));
        haut.setPadding(new Insets(20,25,20,25));
        this.setTop(haut);
    }

    public BorderPane creerRapportJoueur(Rapport r) {
        Label pseudo = new Label(r.getPseudo());
        Label contenu = new Label(r.getContenu());
        contenu.setPadding(new Insets(0,0,0,10));
        pseudo.setStyle("-fx-font-weight: bold;-fx-underline: true;");
        CheckBox lu = new CheckBox();
        lu.setOnAction(new ActionRapportCheck(this, this.pa.getAdmin(), r));
        VBox v = new VBox();
        v.getChildren().addAll(pseudo, contenu);
        r.getB().setLeft(v);
        r.getB().setRight(lu);
        v.setSpacing(10);
        this.pa.getAdmin().ajouterRapport(r);
        return r.getB();
    }

    public BorderPane entete() {
        BorderPane entete = new BorderPane();
        this.suppr = new Button("Supprimer les rapports lus");
        this.suppr.setDisable(true);
        suppr.setOnAction(new ActionSupprRapport(this, this.pa.getAdmin()));
        suppr.setStyle("-fx-background-color: #cf2a27;-fx-border-color: black");
        suppr.setTextFill(Color.web("white"));
        suppr.setPrefWidth(200);
        suppr.setPrefHeight(50);
        entete.setLeft(this.l);
        entete.setRight(suppr);
        l.setPadding(new Insets(15,0,0,0));
        return entete;
    }

    public Button getButtonSuppr() {
        return this.suppr;
    }

    public ScrollPane listeRapport() {
      this.listeRapport = new VBox();
      ScrollPane s = new ScrollPane();
      s.setPrefSize(500, 1000);
      this.listeRapport.setPrefWidth(580);
      for (Rapport r : this.liste) {
          this.listeRapport.getChildren().add(creerRapportJoueur(r));
      }
      s.setStyle("-fx-border-color: black;");
      this.listeRapport.setPadding(new Insets(12,12,12,12));
      this.listeRapport.setSpacing(10);
      s.setContent(this.listeRapport);
      return s;
    }

    public void corp() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(0,25,25,25));
        vbox.getChildren().addAll(entete(), listeRapport());
        vbox.setSpacing(15);
        this.setCenter(vbox);
    }
}
