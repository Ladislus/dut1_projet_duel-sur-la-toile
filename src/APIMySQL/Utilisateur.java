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

    public static String getUserInfo(ConnexionMySQL co, String columnInfoName, String columnName, String columnValue) throws SQLException {
        return GestionBD.selectPreparedStatement(co,"SELECT " + columnInfoName + " FROM UTILISATEUR WHERE " + columnName + "='" + columnValue + "'").get(columnInfoName).get(0).toString();
    }

    public static void setUserInfo(ConnexionMySQL co, String columnInfoName, Object columInfoValue, String columnName, String columnValue) throws SQLException {
        GestionBD.updateStatement(co,"UPDATE UTILISATEUR SET " + columnInfoName + "=" + columInfoValue + " WHERE " + columnName + "='" + columnValue + "'");
    }

    public static void creerUtilisateur(ConnexionMySQL co, String pseudo, String email, String mdp, String nomRole){
        String salt = getSalt();
        ArrayList<Object> donnees = new ArrayList<>();

        try {
            Collections.addAll(donnees,pseudo,email,1,nomRole,getHash((mdp + salt).getBytes()),salt);
            GestionBD.updatePreparedStatement(co,"INSERT INTO UTILISATEUR (pseudoUt,emailUt,activeUt,nomRole,hash,salt) VALUES (?,?,?,?,?,?)", donnees);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isMdpValide(ConnexionMySQL co, String pseudoUt, String mdp) throws UtilisateurException {
        try {
            String hash = getUserInfo(co,"hash","pseudoUt",pseudoUt);
            String salt = getUserInfo(co,"salt","pseudoUt",pseudoUt);
            return hash.equals(getHash((mdp+salt).getBytes()));
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            throw new UtilisateurException("unknownPseudo");
        }
    }
}
