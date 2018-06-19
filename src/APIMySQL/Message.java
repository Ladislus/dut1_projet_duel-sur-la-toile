package APIMySQL;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;

public class Message {
    public static void creerMessage(String contenuMsg,int idUt1, int idUt2){
        ArrayList<Object> donnees = new ArrayList<>();
        Collections.addAll(donnees,new Timestamp(System.currentTimeMillis()),contenuMsg,"N",idUt1,idUt2);
        try {
            GestionBD.updatePreparedStatement("INSERT INTO MESSAGE (dateMsg,contenuMsg,luMsg,idUt1,idUt2) VALUES (?,?,?,?,?)",donnees);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
