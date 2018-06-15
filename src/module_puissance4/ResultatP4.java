package module_puissance4;

/**
 * Modèle du résultat d'un tour
 * contient un booléen pour dire si le jeu est gagné ou non
 * contient un entier pour dire combien de pions sont alignés si le jeu est gagné
 */
public class ResultatP4{

    public boolean contientPuissance;
    public int nbPionsAlignes;

    public ResultatP4(boolean res,int n){
        this.contientPuissance = res;
        this.nbPionsAlignes = n;
    }
}
