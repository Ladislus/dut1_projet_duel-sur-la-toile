package module_joueur;

import APIMySQL.GestionBD;
import APIMySQL.Utilisateur;

import javafx.event.ActionEvent;
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

    /** Constructeur du controlleur prenant en paramètre un couple de pseudo et une inviation
     @param pseudo1 : premier pseudo sous forme de String
     @param pseudo2 : second pseudo sous forme de String
     @param invitation : l'invitation
    */
    ActionAjoutAmis(String pseudo1, String pseudo2, Invitation invitation) {

        this.pseudo1 = pseudo1;
        this.pseudo2 = pseudo2;

        this.invitation = invitation; }

    /**
     handler de l'ajout
     Test la base de données et agit en conséquences
    */
    @Override
    public void handle(ActionEvent actionEvent) {

        ArrayList<Object> peerFriend = new ArrayList<>();
        peerFriend.add(Utilisateur.getIdByPseudo(pseudo1));
        peerFriend.add(Utilisateur.getIdByPseudo(pseudo2));

        ArrayList<Object> res = (ArrayList<Object>) GestionBD.selectPreparedStatement("select idUt2 from INVITATION where idUt1 = " + Utilisateur.getIdByPseudo(pseudo1)).get("idUt2");
        ArrayList<Object> res2 = (ArrayList<Object>) GestionBD.selectPreparedStatement("select idUt1 from INVITATION where idUt2 = " + Utilisateur.getIdByPseudo(pseudo2)).get("idUt1");

        if (res == null && res2 != null) {

            if(!res2.contains(Utilisateur.getIdByPseudo(pseudo1))) { insertJoueur(peerFriend); }}

        else if (res != null && res2 == null) {

            if (!res.contains(Utilisateur.getIdByPseudo(pseudo2))) { insertJoueur(peerFriend); }}

        else if (res == null && res2 == null) { insertJoueur(peerFriend); }

        //Les deux personnes sont déjà ami ou invité
        else { failed(); }}

    /**
     Fonction permettant l'insertion du couple d'ID dans la table ETREAMI
     @param peerFriend : Un ArrayList<Object> contenant un couple d'ID
    */
    private void insertJoueur(ArrayList<Object> peerFriend) {

        try { GestionBD.updatePreparedStatement("insert into INVITATION values (null, CURRENT_TIMESTAMP, 'N', ?,?);", peerFriend); }
        catch (SQLException e) { e.printStackTrace(); }

        KeyEvent ke = new KeyEvent(KeyEvent.KEY_RELEASED, "", "", KeyCode.UNDEFINED, false, false, false, false);

        invitation.getTfSearch().clear();
        invitation.getTfSearch().fireEvent(ke);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText("Demande d'ami envoyé à " + pseudo2);
        alert.show();

        invitation.majAffichageInvitation(); }

    /**
     Alerte à afficher si l'ajout d'ami échoue
    */
    private void failed() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERREUR");
        alert.setHeaderText("Vous avez déjà invité cet ami");
        alert.show(); }}
