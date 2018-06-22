package APIMySQL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Jeu {
    private Jeu(){}

    /**
     * Permet de créer un jeux dans la bd
     * @param nomJeu
     * @param regleJeu
     * @param jarJeuPath
     * @param idTy
     * @param imagePath
     * @throws APIMySQLException
     */
    public static void creerJeu(String nomJeu, String regleJeu, String jarJeuPath, int idTy, String imagePath) throws APIMySQLException {
        ArrayList<Object> donnees = new ArrayList<>();
        try {
            Collections.addAll(donnees,nomJeu,regleJeu,GestionBD.createBlob(jarJeuPath),1,idTy,GestionBD.createBlob(imagePath));
            GestionBD.updatePreparedStatement("INSERT INTO JEU (nomJeu,regleJeu,jarJeu,activeJeu,idTy,image) VALUES (?,?,?,?,?,?)",donnees);
        } catch (IOException e) {
        } catch (SQLException e) {
            throw new APIMySQLException("gameNameTaken");
        }
    }

    /**
     * Permet de recuperée la liste des jeux
     * @return HashMap<String, List<Object>>
     */
    public static HashMap<String, List<Object>> recupListeJeux(){
        return GestionBD.selectPreparedStatement("select * from JEU");
    }
}
