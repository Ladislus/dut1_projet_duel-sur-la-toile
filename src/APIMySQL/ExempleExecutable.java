package APIMySQL;

import java.sql.SQLException;

public class ExempleExecutable {
    public static void main(String[] args) throws ClassNotFoundException {
        // TEST : Essai de passer en bibliothèques statiques.

        ConnexionMySQL co = new ConnexionMySQL("localhost", "serveurDeJeux", "dst", "dst");

        try {
            GestionBD.updateStatement(co,"INSERT INTO ROLE VALUES ('ADMIN')");
        } catch (SQLException e) {
            //e.printStackTrace();
        }

        try {
            Utilisateur.creerUtilisateur(co,"test","test@gmail.com","M","couscous","admin");
        } catch (UtilisateurException e) {
            //e.printMessage();
        }

        try {
            System.out.println(Utilisateur.isMdpValide(co,"test","couscous"));
            System.out.println(Utilisateur.isMdpValide(co,"test","test"));
            System.out.println(Utilisateur.isActivated(co,"test"));
            System.out.println(Utilisateur.isMdpValide(co,"test2","test"));
        } catch (UtilisateurException e) {
            e.printMessage();
        }

    }
}
