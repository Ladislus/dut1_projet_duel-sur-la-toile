package APIMySQL;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Jeu {
    private Jeu(){}

    public static void creerJeu(String nomJeu, String regleJeu, String jarJeuPath, int idTy, String imagePath) throws APIMySQLException {
        ArrayList<Object> donnees = new ArrayList<>();
        try {
            Collections.addAll(donnees,nomJeu,regleJeu,GestionBD.createBlob(jarJeuPath),1,idTy,GestionBD.createBlob(imagePath));
            GestionBD.updatePreparedStatement("INSERT INTO JEU (nomJeu,regleJeu,jarJeu,activeJeu,idTy,image) VALUES (?,?,?,?,?,?)",donnees);
        } catch (IOException e) {
            System.out.println("Ce fichier n'existe pas.");
        } catch (SQLException e) {
            throw new APIMySQLException("gameNameTaken");
        }

    }
}
