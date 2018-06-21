package module_administrateur;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.collections.*;

public class VoirStatistiques extends BorderPane {

    /** Attribut de VoirStatistiques */
    private Stage primaryStage;

    private String title;

    /** Constructeur de la page pour voir les statistiques */
    public VoirStatistiques(Stage primaryStage) {
        super();

        this.title = "Statistiques";
        this.primaryStage = primaryStage;
        this.haut();
        this.gauche();
        this.droite(); }

    /** Création de l'entête de la page */
    public void haut() {
        BorderPane haut = new BorderPane();
        Label l = new Label("Statistiques");
        Button bRetour = new Button("Retour");
        bRetour.setOnAction(new ActionRetour(this.primaryStage));
        haut.setLeft(l);
        haut.setRight(bRetour);
        l.setFont(Font.font ("Arial", 25));
        haut.setPadding(new Insets(20,25,20,25));
        this.setTop(haut);
    }

    /** Création du DatePicker qui permet de choisir une date pour regarder les statistiques d'une
    certaine période */
    public DatePicker creerDatePicker(){
      DatePicker dp = new DatePicker();
      dp.setPrefWidth(120);

      return dp;
    }

    /** Création du Label qui affiche "au" pour dire du XX/XX/XXXX 'au' XX/XX/XXXX */
    public Label creerLabelDatePicker(){
      Label lau = new Label("au");

      return lau;
    }

    /** Création du HBox contenant les infos des DatePicker et du label */
    public HBox creerHBoxDatePicker(){
      HBox hbdate = new HBox(15);
      hbdate.getChildren().addAll(creerDatePicker(), creerLabelDatePicker(), creerDatePicker());

      return hbdate;
    }

    /** Création du Label qui affiche "Joueurs connectés" */
    public Label creerLabelJoueursConnectes(){
      Label jconnecte = new Label("Joueurs connectés : ");

      return jconnecte;
    }

    /** Création du Label qui affiche "Nombre de joueurs inscrits" */
    public Label creerLabelNbJoueursInscrits(){
      Label nbjinscrits = new Label("Nombre de joueurs inscrits : ");

      return nbjinscrits;
    }

    /** Création du Label qui affiche "Nombre de parties totales de la plateforme" */
    public Label creerLabelNbPartiesPlateforme(){
      Label nbpartiestotales = new Label("Nombre de parties totales de la plateforme : ");

      return nbpartiestotales;
    }

    /** Création du Label qui affiche "Statistiques des jeux" */
    public Label creerLabelStatsJeu(){
      Label statsjeux = new Label("Statistiques des jeux");
      statsjeux.setStyle("-fx-font-weight: bold");

      return statsjeux;
    }

    /** Création du ComboBox contenant le nom des jeux */
    public ComboBox<String> creerComboBoxOptions(){
      ObservableList<String> optionsJeux = FXCollections.observableArrayList("Puissance 4", "Mastermind");
      ComboBox<String> cbJeux = new ComboBox<String>(optionsJeux);
      cbJeux.setPrefWidth(300);

      return cbJeux;
    }

    /** Création du Label qui affiche "Nombre de parties totales" pour toute la plateforme */
    public Label creerLabelNbPartiesJeu(){
      Label nbpartiestotalesjeu = new Label("Nombre de parties totales : ");

      return nbpartiestotalesjeu;
    }

    /** Création du Label qui affiche "Meilleur joueur" pour toute la plateforme */
    public Label creerLabelMeilleurJoueur(){
      Label meilleurj = new Label("Meilleur joueur : ");

      return meilleurj;
    }

    /** Création du Label qui affiche "Statistiques sur une période" */
    public Label creerLabelStatsPeriode(){
      Label statsperiode = new Label("Statistiques sur une période : ");
      statsperiode.setStyle("-fx-font-weight: bold");

      return statsperiode;
    }

    /** Création du Label qui affiche "Nombre de parties totales" pour une période */
    public Label creerLabelNbPartiesJeuPeriode(){
      Label nbpartiestotalesjeuperiode = new Label("Nombre de parties totales : ");

      return nbpartiestotalesjeuperiode;
    }

    /** Création du Label qui affiche "Meilleur joueur" pour une période */
    public Label creerLabelMeilleurJoueurPeriode(){
      Label meilleurjperiode = new Label("Meilleur joueur : ");

      return meilleurjperiode;
    }

    /** Création du VBox contenant certaines méthodes du dessus */
    public VBox creerVBoxStatsJeux(){
      VBox vbstatsjeux = new VBox(10);
      vbstatsjeux.getChildren().addAll(creerComboBoxOptions(), creerLabelNbPartiesPlateforme(),
        creerLabelMeilleurJoueur(), creerLabelStatsPeriode(), creerHBoxDatePicker(),
          creerLabelNbPartiesJeuPeriode(), creerLabelMeilleurJoueurPeriode());
      vbstatsjeux.setPadding(new Insets(5,10,5,10));
      vbstatsjeux.setStyle("-fx-border-color: black;");
      vbstatsjeux.setPrefHeight(250);

      return vbstatsjeux;
    }

    /** VBox permettant d'afficher la partie gauche de la vue */
    public void gauche() {
        VBox vbgauche = new VBox(10);
        vbgauche.getChildren().addAll(creerLabelJoueursConnectes(), creerLabelNbJoueursInscrits(),
          creerLabelNbPartiesPlateforme(), creerLabelStatsJeu(), creerVBoxStatsJeux());
        vbgauche.setPadding(new Insets(20,25,20,25));

        this.setLeft(vbgauche);
    }

    /** Création du Label qui affiche "Nombre de parties en cours" */
    public Label creerLabelNbPartiesEnCours(){
      Label nbpartiesencours = new Label("Nombre de parties en cours : ");

      return nbpartiesencours;
    }

    /** Création du Label qui affiche "Record de connectés" */
    public Label creerLabelRecordConnectes(){
      Label recordconnectes = new Label("Record de connectés : ");

      return recordconnectes;
    }

    /** Création du Label qui affiche "Meilleurs joueurs de la plateforme" */
    public Label creerLabelMeilleursJoueurs(){
      Label meilleurjplateforme = new Label("Meilleurs joueurs de la plateforme");

      return meilleurjplateforme;
    }

    /** Création du Label qui n'affiche rien */
    public Label creerLabelVide(){
      Label vide = new Label(" ");

      return vide;
    }

    /** Création du Label qui affiche "Joueur1" */
    public Label creerLabelJoueur1(){
      Label lj1 = new Label("Joueur1");

      return lj1;
    }

    /** Création du Label qui affiche "Joueur2" */
    public Label creerLabelJoueur2(){
      Label lj2 = new Label("Joueur2");

      return lj2;
    }

    /** Création du Label qui affiche "75% V/D" */
    public Label creerLabelRatio1(){
      Label ratioj1 = new Label("75% V/D");

      return ratioj1;
    }

    /** Création du Label qui affiche "65% V/D" */
    public Label creerLabelRatio2(){
      Label ratioj2 = new Label("65% V/D");

      return ratioj2;
    }

    /** Création du HBox contenant les infos concernant le Joueur1" */
    public HBox creerHBoxJ1(){
      HBox hbj1 = new HBox(120);
      hbj1.getChildren().addAll(creerLabelJoueur1(), creerLabelRatio1());

      return hbj1;
    }

    /** Création du HBox contenant les infos concernant le Joueur2 */
    public HBox creerHBoxJ2(){
      HBox hbj2 = new HBox(120);
      hbj2.getChildren().addAll(creerLabelJoueur2(), creerLabelRatio2());

      return hbj2;
    }

    /** Création du VBox contenant le label des meilleurs joueurs et des HBox des Joueur1 et 2 */
    public VBox creerVBoxMeilleursJoueurs(){
      VBox vbmeilleurjplateforme = new VBox(10);
      vbmeilleurjplateforme.getChildren().addAll(creerLabelMeilleursJoueurs(), creerHBoxJ1(),
        creerHBoxJ2());
      vbmeilleurjplateforme.setPadding(new Insets(5,10,5,10));
      vbmeilleurjplateforme.setStyle("-fx-border-color: black;");
      vbmeilleurjplateforme.setPrefHeight(250);

      return vbmeilleurjplateforme;
    }

    /** VBox permettant d'afficher la partie droite de la vue */
    public void droite() {
      VBox vbdroite = new VBox(10);
      vbdroite.getChildren().addAll(creerLabelNbPartiesEnCours(), creerLabelRecordConnectes(),
        creerLabelVide(), creerLabelVide(), creerVBoxMeilleursJoueurs());
      vbdroite.setPadding(new Insets(20,25,20,25));

      this.setRight(vbdroite);
    }

    public String getTitle() { return this.title; }
}
