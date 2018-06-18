package APIMySQL;

import java.sql.SQLException;

public class ExempleExecutable {
    public static void main(String[] args) throws ClassNotFoundException {
        // TEST : Essai de passer en bibliothèques statiques.
        try {
            GestionBD.updateStatement("INSERT INTO ROLE VALUES ('ADMIN')");
        } catch (SQLException e) {
            //e.printStackTrace();
        }

        try {
            Utilisateur.creerUtilisateur("test","test@gmail.com","M","couscous","admin");
        } catch (UtilisateurException e) {
            //e.printMessage();
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
