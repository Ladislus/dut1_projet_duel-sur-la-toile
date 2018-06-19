package APIMySQL;

import java.sql.SQLException;

public class ExempleExecutable {
    public static void main(String[] args) {
        try {
            Utilisateur.creerUtilisateur("test","test@gmail.com","M","Mr","Test","couscous","admin");
            Utilisateur.creerUtilisateur("test2","test2@gmail.com","F","Mme","Test2","tajine","admin");
        } catch (APIMySQLException e) {
            e.printMessage();
        }

        try {
            System.out.println(Utilisateur.isMdpValide("test","couscous"));
            System.out.println(Utilisateur.isMdpValide("test","test"));
            System.out.println(Utilisateur.isActivated("test"));
        } catch (SQLException e) {/*e.printMessage();*/}

        try {
            GestionBD.updateStatement("INSERT INTO TYPEJEU (nomTy) VALUES ('MMORPG')");
        } catch (SQLException e){e.printStackTrace();}

        try {
            String path = "/run/media/lucas/Data/Downloads/DM Facturation - Lucas Mirloup.jpg";
            Jeu.creerJeu("WoW","",path,1,path);
        } catch (APIMySQLException e){e.printStackTrace();}

        Partie.creerPartie(1,1,2);
    }
}
