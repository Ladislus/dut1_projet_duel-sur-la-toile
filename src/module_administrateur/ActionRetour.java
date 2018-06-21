package module_administrateur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Contrôleur du bouton retour */
public class ActionRetour implements EventHandler<ActionEvent> {

    private Stage primaryStage;

    private String title;

    private GererJoueur gJoueur;

    /** Constructeur du contrôleur pour aller à la title d'accueil */
    public ActionRetour(Stage primaryStage) {

    	this.primaryStage = primaryStage;
    	this.title = "Accueil"; }

    /** Constructeur du contrôleur dans le cas pour aller à la title gérer les joueurs */
    public ActionRetour(Stage primaryStage, GererJoueur gJoueur) {
    	this.primaryStage = primaryStage;

        this.gJoueur = gJoueur;
        this.title = "GererJoueur"; }

    /** Regarde à quelle title il faut aller
        Puis modifie le borderpane principal pour afficher la nouvelle title
        Enfin fait une mise à jour des éléments de l'administration en les réinitialisant à vide (liste, ..) */
    @Override
    public void handle(ActionEvent actionEvent) {

        PageAccueil page = (PageAccueil) this.primaryStage.getScene().getRoot();

        if (this.title.equals("GererJoueur")) {
            page.setCenter(new GererJoueur(this.primaryStage));
            page.getAdmin().majAdmin(); }
        else {
            this.primaryStage.setTitle(new PageAccueil(this.primaryStage).getTitle());
            this.primaryStage.setScene(new Scene(new PageAccueil(this.primaryStage), 650, 450));
            ((PageAccueil)this.primaryStage.getScene().getRoot()).getAdmin().majAdmin(); }}}
