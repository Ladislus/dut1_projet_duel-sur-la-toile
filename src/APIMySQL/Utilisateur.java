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

    public static String getUserInfo(ConnexionMySQL co, String columnInfoName, String columnName, String columnValue){
        try {
            return GestionBD.selectPreparedStatement(co,"SELECT " + columnInfoName + " FROM UTILISATEUR WHERE " + columnName + "='" + columnValue + "'").get(columnInfoName).get(0).toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void setUserInfo(ConnexionMySQL co, String columnInfoName, Object columInfoValue, String columnName, String columnValue){
        try {
            GestionBD.updateStatement(co,"UPDATE UTILISATEUR SET " + columnInfoName + "=" + columInfoValue + " WHERE " + columnName + "='" + columnValue + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void creerUtilisateur(ConnexionMySQL co, String pseudo, String email, String sexe, String mdp, String nomRole) throws UtilisateurException {
        String salt = getSalt();
        ArrayList<Object> donnees = new ArrayList<>();

        try {
            Collections.addAll(donnees,pseudo,email,sexe,1,nomRole,getHash((mdp + salt).getBytes()),salt);
            GestionBD.updatePreparedStatement(co,"INSERT INTO UTILISATEUR (pseudoUt,emailUt,sexe,activeUt,nomRole,hash,salt) VALUES (?,?,?,?,?,?,?)", donnees);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UtilisateurException("pseudoTaken");
        }
    }

    public static boolean isMdpValide(ConnexionMySQL co, String pseudoUt, String mdp) throws UtilisateurException {
        try {
            String hash = getUserInfo(co,"hash","pseudoUt",pseudoUt);
            String salt = getUserInfo(co,"salt","pseudoUt",pseudoUt);
            return getHash((mdp+salt).getBytes()).equals(hash);
        } catch (NullPointerException e) {
          e.printStackTrace();
            throw new UtilisateurException("unknownPseudo");
        }
    }

    public static boolean isActivated(ConnexionMySQL co, String pseudoUt){
        return getUserInfo(co, "activeUt", "pseudoUt", pseudoUt).equals("true");
    }

    public static void deactivateUser(ConnexionMySQL co, String pseudo){
        setUserInfo(co, "activeUt", 0, "pseudoUt", pseudo);
    }

    public static int getIdByPseudo(ConnexionMySQL co, String pseudoUt){
        return Integer.parseInt(getUserInfo(co, "idUt", "pseudoUt", pseudoUt));
    }

    public static String getPseudoById(ConnexionMySQL co, Integer id){
        return getUserInfo(co, "pseudoUt", "idUt", id.toString());
    }

    public static ArrayList<String> getListeDamis(ConnexionMySQL co, String pseudo){
        try {
            ArrayList<String> listePseudo = new ArrayList<>();
            List<Object> listeId = GestionBD.selectPreparedStatement(co,"SELECT idUt1 FROM ETREAMI WHERE idUt = "+getIdByPseudo(co, pseudo)).get("idUt1");
            for(Object elem : listeId){
                listePseudo.add(String.valueOf(getPseudoById(co, (Integer) elem)));
            }
            return listePseudo;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        catch (NullPointerException e){
            return null;
        }
    }

    public static String getEmailByPseudo(ConnexionMySQL co, String pseudoUt){
        return getUserInfo(co, "emailUt", "pseudoUt", pseudoUt);
    }
}
