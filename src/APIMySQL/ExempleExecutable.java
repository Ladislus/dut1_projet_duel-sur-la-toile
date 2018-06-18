package APIMySQL;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.SQLException;

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
            GestionBD.updateStatement("INSERT INTO TYPEJEU (nomTy) VALUES ('MMORPG')");
            String path = "/home/lucas/Downloads/JetBrains.png";
            Jeu.creerJeu("WoW","",path,1,path);
            //Partie.creerPartie();

        } catch (SQLException e) {
            //e.printMessage();
        }

        //Partie.creerPartie();

    }
}
