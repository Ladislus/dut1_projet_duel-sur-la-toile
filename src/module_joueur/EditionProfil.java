package module_joueur;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

class EditionProfil extends BorderPane {

    String title;

    public EditionProfil(){
        super();

        this.title = "Editez mon profil";
        this.setLeft(creerGauche());
    }

    public VBox creerGauche(){
        VBox vPrincipal = new VBox();
        HBox hPseudoWithEditionButton = new HBox();





        return vPrincipal;
    }

    public VBox creerDroite(){
        return new VBox();
    }

    public HBox creerBas(){
        return new HBox();
    }

}
