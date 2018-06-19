package APIMySQL;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

public class ExempleExecutable {
    public static void main(String[] args) {
        try {
            Utilisateur.creerUtilisateur("test","test@gmail.com","M","Mr","Test","couscous","ADMIN");
            Utilisateur.creerUtilisateur("test2","test2@gmail.com","F","Mme","Test2","tajine","ADMIN");
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
            String path = "/run/media/lucas/Data/Downloads/DM Facturation - Lucas Mirloup.jpg";
            Jeu.creerJeu("WoW","",path,1,path);
            Message.creerMessage("Coucou ^^",1,2);
        } catch (APIMySQLException e){e.printStackTrace();}

        Partie.creerPartie(1,1,2);

        try {
            Blob blob = GestionBD.createBlob("/run/media/lucas/Data/Downloads/DM Facturation - Lucas Mirloup.jpg");
            Utilisateur.creerUtilisateur("testImage","testimage@gmail.com","O","Test","Image",1,"image","ADMIN",blob);
            Image image = GestionBD.blobToImage(blob);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        System.out.println(GestionBD.selectPreparedStatement("SELECT * FROM MESSAGE WHERE idUt1='1'"));
    }
}
