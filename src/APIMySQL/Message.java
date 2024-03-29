package APIMySQL;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;

public class Message {

    /**
     * Permet de créer un message dans la BD
     * @param contenuMsg
     * @param idUt1
     * @param idUt2
     * @throws APIMySQLException
     */
    public static void creerMessage(String contenuMsg,int idUt1, int idUt2) throws APIMySQLException {
        ArrayList<Object> donnees = new ArrayList<>();
        Collections.addAll(donnees,new Timestamp(System.currentTimeMillis()),contenuMsg,"N",idUt1,idUt2);
        try {
            GestionBD.updatePreparedStatement("INSERT INTO MESSAGE (dateMsg,contenuMsg,luMsg,idUt1,idUt2) VALUES (?,?,?,?,?)",donnees);
        } catch (SQLException e) {
            throw new APIMySQLException("unkownIdUt");
        }
    }


}
