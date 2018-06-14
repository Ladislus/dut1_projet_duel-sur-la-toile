package module_administrateur;
import APIMySQL.*;
import APIMySQL.GestionBD;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExempleExecutable {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        GestionBD gestionBD = new GestionBD("192.168.1.100", "serveurDeJeux", "dst", "dst");
        System.out.println(gestionBD.init());
        //Exemple pour ajouter des données
        //ArrayList<Object> donnee = new ArrayList<>();
        //donnee.add("ADMIN");
        //donnee.add("USER");
        //gestionBD.insertRequete("insert into ROLE values (?)", donnee);
        HashMap<String, List<Object>> res = gestionBD.selectRequestWithPreparedStatement("Select * from ROLE;");
        //retourne {nomRole=[ADMIN, USER]}
        System.out.println(res);

    }
}
