package APIMySQL;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.*;

public class Utilisateur {

    private static final SecureRandom RANDOM = new SecureRandom();

    private Utilisateur(){}

    private static String getSalt(){
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private static String getHash(byte[] bytes){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {}
        byte[] hash = digest.digest(bytes);
        return Base64.getEncoder().encodeToString(hash);
    }

    public static String getUserInfo(ConnexionMySQL co, String colonne, String pseudoUt) throws SQLException {
        return GestionBD.selectPreparedStatement(co,"SELECT " + colonne + " FROM UTILISATEUR WHERE pseudoUt='"+pseudoUt+"'").get(colonne).get(0).toString();
    }

    public static boolean creerUtilisateur(ConnexionMySQL co, String pseudo, String email, String mdp, String nomRole){
        String salt = getSalt();
        ArrayList<Object> donnees = new ArrayList<>();

        try {
            Collections.addAll(donnees,pseudo,email,1,nomRole,getHash((mdp + salt).getBytes()),salt);
            GestionBD.updatePreparedStatement(co,"INSERT INTO UTILISATEUR (pseudoUt,emailUt,activeUt,nomRole,hash,salt) VALUES (?,?,?,?,?,?)", donnees);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean isMdpValide(ConnexionMySQL co, String pseudoUt, String mdp) throws UtilisateurException {
        try {
            String hash = getUserInfo(co,"hash",pseudoUt);
            String salt = getUserInfo(co,"salt",pseudoUt);
            return hash.equals(getHash((mdp+salt).getBytes()));
        } catch (SQLException | NullPointerException e) {
            throw new UtilisateurException("unknownPseudo");
        }
    }
}
