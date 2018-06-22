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

    /**
     Controlleur permettant l'acceptation ou le refus d'une demande d'ami grâce à un
     couple d'ID utilisateur
     @param idUt1 : Le premier ID
     @param idUt2 : Le second ID
     @param choix : Le choix réalisé (0 = oui, 1 = non)
     @param invitation : La page d'invitation à propager
    */
    ActionInvitationAcceptOrRefuse(int idUt1, int idUt2, int choix, Invitation invitation) {

        this.idUt1 = idUt1;
        this.idUt2 = idUt2;
        this.choix = choix;

        this.invitation = invitation; }

    /**
     Action d'acceptation ou de refus d'une invitation
     @param actionEvent : L'actionEvent contenant l'action
    */
    @Override
    public void handle(ActionEvent actionEvent) {

        //Acceptation
        if(choix == 0) {

            GestionBD.updateStatement("delete from INVITATION where idUt1=" + idUt2);

            ArrayList<Object> peer = new ArrayList<>();
            peer.add(idUt1);
            peer.add(idUt2);

            //Ajout du couple d'ami
            try { GestionBD.updatePreparedStatement("insert into ETREAMI values (?,?)", peer); }

            catch (SQLException e) {}

            this.invitation.majAffichageInvitation(); }

        //Refus
        else {

            GestionBD.updateStatement("delete from INVITATION where idUt1="+idUt2);

            this.invitation.majAffichageInvitation(); }}}
