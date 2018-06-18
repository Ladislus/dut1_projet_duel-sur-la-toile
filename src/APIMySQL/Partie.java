package APIMySQL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class Partie {
    private Partie(){}

    public static void creerPartie(int idJeu, int idUt1, int idUt2){
        ArrayList<Object> donnees = new ArrayList<>();
        Collections.addAll(donnees,(int)(System.currentTimeMillis()/1000L),0,"",idJeu,idUt1,0,idUt2,0);
        try {
            GestionBD.updatePreparedStatement("INSERT INTO PARTIE (debutPa,numEtape,etatPartie,idJeu,idUt1,score1,idUt2,score2) VALUES (?,?,?,?,?,?,?,?)",donnees);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
