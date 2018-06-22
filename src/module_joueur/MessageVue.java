package module_joueur;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;


class MessageVue extends VBox {

    private Label titre;
    private Label contenu;

    /**
     Création des boite contenat les messages dans la messagerie
     @param msg : Le message
    */
    MessageVue(MessageModele msg) {

        super();

        this.setSpacing(2.);

        if (msg.getDateEnvoi()==0)
            this.titre = new Label("Temps non défini");
        else
            this.titre = new Label(msg.getDateEnvoiString());

        this.titre.setFont(Font.font("Verdana",FontWeight.NORMAL,FontPosture.ITALIC,10));
        this.titre.setStyle("-fx-background-color: transparent;");
        this.titre.setPadding(new Insets(0,5,0,5));

        this.contenu = new Label(msg.getContenu());
        this.contenu.setPadding(new Insets(10.));
        this.contenu.setFont(Font.font(20.));
        this.contenu.setWrapText(true);


        this.getChildren().addAll(titre,contenu);
        this.setStyle("-fx-background-color: transparent;"); }

    void setIsFromUser(boolean b) {

        if (b)
            this.putRight();
        else
            this.putLeft(); }

    /**
     Fonction permmettant de mettre à droite les messages envoyé
    */
    private void putRight() {

        this.setAlignment(Pos.TOP_RIGHT);
        this.setAlignment(Pos.TOP_RIGHT);
        this.setPadding(new Insets(0,0,0,250));
        this.contenu.setTextAlignment(TextAlignment.RIGHT);
        this.contenu.setStyle("-fx-background-color: lightgray;" + "-fx-background-radius: 25 20 0 20;" + "-fx-border-radius: 25 20 0 20;"); }

    /**
     Fonction permmettant de mettre à gauche les messages reçus
    */
    private void putLeft() {
        this.setAlignment(Pos.TOP_LEFT);
        this.setAlignment(Pos.TOP_LEFT);
        this.setPadding(new Insets(0,250,0,0));
        this.contenu.setStyle("-fx-background-color: lightblue;" + "-fx-background-radius: 20 25 20 0;" + "-fx-border-radius: 20 25 20 0;"); }}
