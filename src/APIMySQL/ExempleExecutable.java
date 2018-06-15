package APIMySQL;

import java.sql.SQLException;

public class ExempleExecutable {
    public static void main(String[] args) throws ClassNotFoundException {
        // TEST : Essai de passer en bibliothèques statiques.

        ConnexionMySQL co = new ConnexionMySQL("192.168.1.100", "serveurDeJeux", "dst", "dst");

<<<<<<< HEAD
        GestionBD.updateStatement(co,"INSERT INTO ROLE VALUES ('ADMIN')");

        try {
            Utilisateur.creerUtilisateur(co,"test","test@gmail.com","couscous","admin");
        } catch (UtilisateurException e) {
            e.printStackTrace();
=======
        try {
            GestionBD.updateStatement(co,"INSERT INTO ROLE VALUES ('ADMIN')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
>>>>>>> e0d98be32e79b887b8687659bb663004dd9fdfa0
        }

        try {
            Utilisateur.creerUtilisateur(co,"test","test@gmail.com","couscous","admin");
            System.out.println(Utilisateur.isMdpValide(co,"test","couscous"));
            System.out.println(Utilisateur.isMdpValide(co,"test","test"));
            System.out.println(Utilisateur.isMdpValide(co,"test2","test"));
        } catch (UtilisateurException e) {
            e.printMessage();
        }

    }
}
