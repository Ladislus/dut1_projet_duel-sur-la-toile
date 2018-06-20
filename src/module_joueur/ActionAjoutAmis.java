package module_joueur;

import APIMySQL.GestionBD;
import APIMySQL.Utilisateur;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.sql.SQLException;
import java.util.ArrayList;

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
        peerFriend.add(Utilisateur.getIdByPseudo(pseudo2));
        try{
            if(GestionBD.selectPreparedStatement("select idUt2 from INVITATION where idUt1 = "+Utilisateur.getIdByPseudo(pseudo1)).get("idUt2").size()<1){
                try {
                    GestionBD.updatePreparedStatement("insert into INVITATION values (null, CURRENT_TIMESTAMP, 'N', ?,?);", peerFriend);
                    invitation.getTfSearch().clear();
                    KeyEvent ke = new KeyEvent(KeyEvent.KEY_RELEASED,
                            "", "",
                            KeyCode.UNDEFINED, false, false, false, false);
                    invitation.getTfSearch().fireEvent(ke);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMATION");
                    alert.setHeaderText("Vous avez bien invitée le joueur "+pseudo2+" a faire partie de vos amis");
                    alert.show();
                    invitation.majAffichageInvitation();
                } catch (SQLException e) {
                    //Deja ami avec cette personne
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERREUR");
                alert.setHeaderText("Vous avez deja invitée cette amis");
                alert.show();
            }
        }
        catch (NullPointerException e){
            try {
                GestionBD.updatePreparedStatement("insert into INVITATION values (null, CURRENT_TIMESTAMP, 'N', ?,?);", peerFriend);
                invitation.getTfSearch().clear();
                KeyEvent ke = new KeyEvent(KeyEvent.KEY_RELEASED,
                        "", "",
                        KeyCode.UNDEFINED, false, false, false, false);
                invitation.getTfSearch().fireEvent(ke);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMATION");
                alert.setHeaderText("Vous avez bien invitée le joueur "+pseudo2+" a faire partie de vos amis");
                alert.show();
                invitation.majAffichageInvitation();
            } catch (SQLException f) {
                //Deja ami avec cette personne
            }
        }




    }
}
