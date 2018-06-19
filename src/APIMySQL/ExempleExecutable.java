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

        GestionBD.updateStatement("INSERT INTO TYPEJEU (nomTy) VALUES ('MMORPG')");

        try {
            String path = "/home/lucas/Downloads/JetBrains.png";
            Jeu.creerJeu("WoW","",path,1,path);
            Message.creerMessage("Coucou ^^",1,2);
        } catch (APIMySQLException e){e.printStackTrace();}

        Partie.creerPartie(1,1,2);

        System.out.println(GestionBD.selectPreparedStatement("SELECT * FROM MESSAGE WHERE idUt1='1'"));
    }
}
