package APIMySQL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Jeu {
    private Jeu(){}

    public static void creerJeu(String nomJeu, String regleJeu, byte[] jarJeu, int idTy, byte[] image) throws SQLException {
        ArrayList<Object> donnees = new ArrayList<>();
        //ConnexionMySQL.mysql.createBlob(jarJeu)
        Collections.addAll(donnees,nomJeu,regleJeu,jarJeu,1,idTy,image);
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
