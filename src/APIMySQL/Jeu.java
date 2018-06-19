package APIMySQL;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Jeu {
    private Jeu(){}

    public static void creerJeu(String nomJeu, String regleJeu, String jarJeuPath, int idTy, String imagePath) throws SQLException {
        ArrayList<Object> donnees = new ArrayList<>();
        Collections.addAll(donnees,nomJeu,regleJeu,GestionBD.createBlob(jarJeuPath),1,idTy,GestionBD.createBlob(imagePath));
        GestionBD.updatePreparedStatement("INSERT INTO JEU (nomJeu,regleJeu,jarJeu,activeJeu,idTy,image) VALUES (?,?,?,?,?,?)",donnees);
    }

    public static HashMap<String, List<Object>> recupListeJeux(){
        try {
            return GestionBD.selectPreparedStatement("select * from JEU");
        } catch (SQLException e) {
            System.out.println("[Error] Probleme avec la recuperation de la liste des jeux");
        }
        return null;
    }
}
