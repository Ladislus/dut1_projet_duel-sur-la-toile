package APIMySQL;

public class ExempleExecutable {
    public static void main(String[] args) {
        // TEST : Essai de passer en bibliothèques statiques.

        try {
            Utilisateur.creerUtilisateur("test","test@gmail.com","M","Mr","Test","couscous","admin");
        } catch (UtilisateurException e) {
            e.printMessage();
        }

        try {
            System.out.println(Utilisateur.isMdpValide("test","couscous"));
            System.out.println(Utilisateur.isMdpValide("test","test"));
            System.out.println(Utilisateur.isActivated("test"));
            System.out.println(Utilisateur.isMdpValide("test2","test"));
        } catch (UtilisateurException e) {
            //e.printMessage();
        }

        //Partie.creerPartie();

    }
}
