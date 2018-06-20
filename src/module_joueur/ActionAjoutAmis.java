package module_joueur;

import APIMySQL.GestionBD;
import APIMySQL.Utilisateur;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.rmi.CORBA.Util;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class ActionAjoutAmis implements EventHandler<ActionEvent> {

    private String pseudo1;

    private String pseudo2;

    private Invitation invitation;

    public ActionAjoutAmis(String pseudo1, String pseudo2, Invitation invitation){
        this.pseudo1 = pseudo1;
        this.pseudo2 = pseudo2;
        this.invitation = invitation;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<Object> peerFriend = new ArrayList<>();
        peerFriend.add(Utilisateur.getIdByPseudo(pseudo1));
        System.out.println(Utilisateur.getIdByPseudo(pseudo2));
        peerFriend.add(Utilisateur.getIdByPseudo(pseudo2));
        ArrayList<Object> res = (ArrayList<Object>) GestionBD.selectPreparedStatement("select idUt2 from INVITATION where idUt1 = "+Utilisateur.getIdByPseudo(pseudo1)).get("idUt2");
        ArrayList<Object> res2 = (ArrayList<Object>) GestionBD.selectPreparedStatement("select idUt1 from INVITATION where idUt2 = "+Utilisateur.getIdByPseudo(pseudo2)).get("idUt1");
        if(res == null && res2 != null){
            if(!res2.contains(Utilisateur.getIdByPseudo(pseudo1))){
                insertJoueur(peerFriend);
            }
        }
        else if(res != null && res2 == null){
            if(!res.contains(Utilisateur.getIdByPseudo(pseudo2))){
                insertJoueur(peerFriend);
            }
        }
        else if(res == null && res2 == null){
            insertJoueur(peerFriend);
        }
        else{
            failed();
        }
    }
    public void insertJoueur(ArrayList<Object> peerFriend){
        try {
            GestionBD.updatePreparedStatement("insert into INVITATION values (null, CURRENT_TIMESTAMP, 'N', ?,?);", peerFriend);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        invitation.getTfSearch().clear();
        KeyEvent ke = new KeyEvent(KeyEvent.KEY_RELEASED, "", "",
                KeyCode.UNDEFINED, false, false, false, false);
        invitation.getTfSearch().fireEvent(ke);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText("Vous avez bien invitée le joueur "+pseudo2+" a faire partie de vos amis");
        alert.show();
        invitation.majAffichageInvitation();
    }

    public void failed(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERREUR");
        alert.setHeaderText("Vous avez deja invitée cette amis, ou deja été invitée par celui-ci");
        alert.show();
    }
}
