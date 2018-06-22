package module_joueur;

import APIMySQL.GestionBD;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.sql.SQLException;

import java.util.ArrayList;

public class ActionInvitationAcceptOrRefuse implements EventHandler<ActionEvent> {

    private Invitation invitation;

    private int choix;
    private int idUt1;
    private int idUt2;

    public ActionInvitationAcceptOrRefuse(int idUt1, int idUt2, int choix, Invitation invitation) {

        this.idUt1 = idUt1;
        this.idUt2 = idUt2;
        this.choix = choix;

        this.invitation = invitation; }

    @Override
    public void handle(ActionEvent actionEvent) {

        if(choix == 0) {

            GestionBD.updateStatement("delete from INVITATION where idUt1=" + idUt2);

            ArrayList<Object> peer = new ArrayList<>();
            peer.add(idUt1);
            peer.add(idUt2);

            try { GestionBD.updatePreparedStatement("insert into ETREAMI values (?,?)", peer); }

            catch (SQLException e) { }

            this.invitation.majAffichageInvitation(); }

        else {

            GestionBD.updateStatement("delete from INVITATION where idUt1="+idUt2);

            this.invitation.majAffichageInvitation(); }}}
