package module_joueur;

import APIMySQL.GestionBD;
import APIMySQL.Utilisateur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.sql.SQLException;
import java.util.ArrayList;

public class ActionAjoutAmis implements EventHandler<ActionEvent> {

    private String pseudo1;

    private String pseudo2;

    private Dashboard dashboard;

    public ActionAjoutAmis(String pseudo1, String pseudo2, Dashboard dashboard){
        this.pseudo1 = pseudo1;
        this.pseudo2 = pseudo2;
        this.dashboard = dashboard;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<Object> peerFriend = new ArrayList<>();
        peerFriend.add(Utilisateur.getIdByPseudo(pseudo1));
        peerFriend.add(Utilisateur.getIdByPseudo(pseudo2));
        System.out.println(peerFriend);
        try {
            GestionBD.updatePreparedStatement("insert into INVITATION values (null, CURRENT_TIMESTAMP, 'N', ?,?);", peerFriend);
            dashboard.majAffichage();
        } catch (SQLException e) {
            //Deja ami avec cette personne
        }
    }
}
