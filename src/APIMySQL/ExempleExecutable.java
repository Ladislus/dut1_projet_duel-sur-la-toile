package APIMySQL;

import java.sql.SQLException;

public class ExempleExecutable {
    public static void main(String[] args) throws ClassNotFoundException {
        // TEST : Essai de passer en bibliothèques statiques.

        ConnexionMySQL co = new ConnexionMySQL("192.168.1.100", "serveurDeJeux", "dst", "dst");

        try {
            GestionBD.updateStatement(co,"INSERT INTO ROLE VALUES ('ADMIN')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }

        try {
            Utilisateur.creerUtilisateur(co,"test","test@gmail.com","M","couscous","admin");
            System.out.println(Utilisateur.isMdpValide(co,"test","couscous"));
            System.out.println(Utilisateur.isMdpValide(co,"test","test"));
            System.out.println(Utilisateur.isActivated(co,"test"));
            System.out.println(Utilisateur.isMdpValide(co,"test2","test"));
        } catch (UtilisateurException e) {
            e.printMessage();
        }

    }
}
