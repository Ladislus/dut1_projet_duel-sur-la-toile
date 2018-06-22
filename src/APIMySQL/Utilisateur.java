package APIMySQL;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.*;

/**
 * Classe permettant de gérer tout ce qui a un lien avec les
 * utilisateurs de la BD ( Mots de passe, profil, informations)
 */
public class Utilisateur {

    private static final SecureRandom RANDOM = new SecureRandom();

    private Utilisateur(){}

    /**
     * Genère un sel (salt), sous forme de chaîne aléatoire en Base64
     * @return String
     */
    private static String getSalt(){
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    /**
     * Genère le hash d'un tableau d'octets, ici, de la chaîne
     * de caractères composée d'un mot de passe et d'un sel
     * @return String
     */
    private static String getHash(byte[] bytes){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {}
        byte[] hash = digest.digest(bytes);
        return Base64.getEncoder().encodeToString(hash);
    }

    /**
     * Permet de récupérer les informations d'un utilisateur
     * à partir d'une autre information et de la valeur de celle-ci
     * @param columnInfoName
     * @param columnName
     * @param columnValue
     * @return String
     */
    public static String getUserInfo(String columnInfoName, String columnName, String columnValue){
        return GestionBD.selectPreparedStatement("SELECT " + columnInfoName + " FROM UTILISATEUR WHERE " + columnName + "='" + columnValue + "'").get(columnInfoName).get(0).toString();
    }

    /**
     * Permet de mettre à jour les informations d'un utilisateur
     * @param columnInfoName
     * @param columInfoValue
     * @param columnName
     * @param columnValue
     */
    public static void setUserInfo(String columnInfoName, Object columInfoValue, String columnName, String columnValue){
        GestionBD.updateStatement("UPDATE UTILISATEUR SET " + columnInfoName + "='" + columInfoValue + "' WHERE " + columnName + "='" + columnValue + "'");
    }

    /**
     * Permet de créer un utilisateur sans image
     * @param pseudo
     * @param email
     * @param sexe
     * @param prenom
     * @param nom
     * @param mdp
     * @param nomRole
     * @throws APIMySQLException
     */
    public static void creerUtilisateur(String pseudo, String email, String sexe, String prenom, String nom, String mdp, String nomRole) throws APIMySQLException {
        String salt = getSalt();
        ArrayList<Object> donnees = new ArrayList<>();

        try {
            Collections.addAll(donnees,pseudo,email,sexe,prenom,nom,1,nomRole,getHash((mdp + salt).getBytes()),salt);
            GestionBD.updatePreparedStatement("INSERT INTO UTILISATEUR (pseudoUt,emailUt,sexe,prenom,nom,activeUt,nomRole,hash,salt) VALUES (?,?,?,?,?,?,?,?,?)", donnees);
        } catch (SQLException e) {
            throw new APIMySQLException("pseudoTaken");
        }
    }

    /**
     * Permet de créer un utilisateur complet
     * @param pseudo
     * @param email
     * @param sexe
     * @param prenom
     * @param nom
     * @param active
     * @param mdp
     * @param nomRole
     * @param image
     * @throws APIMySQLException
     */
    public static void creerUtilisateur(String pseudo, String email, String sexe, String prenom, String nom, int active, String mdp, String nomRole, Blob image) throws APIMySQLException {
        String salt = getSalt();
        ArrayList<Object> donnees = new ArrayList<>();

        try {
            Collections.addAll(donnees,pseudo,email,sexe,prenom,nom,active,nomRole,getHash((mdp + salt).getBytes()),salt,image);
            GestionBD.updatePreparedStatement("INSERT INTO UTILISATEUR (pseudoUt,emailUt,sexe,prenom,nom,activeUt,nomRole,hash,salt,image) VALUES (?,?,?,?,?,?,?,?,?,?)", donnees);
        } catch (SQLException e) {
            throw new APIMySQLException("pseudoTaken");
        }
    }

    /**
     Permet de savoir si le mot de passe d'un utilisateur est valide ou pas
     @param pseudoUt : Une String contenant le pseudo entré
     @param mdp : Une String contenant le mot de passe entré
     @return : Un booléen
     @throws APIMySQLException : Le compte n'est pas dans la BD
    */
    public static boolean isMdpValide(String pseudoUt, String mdp) throws APIMySQLException {
        try {
            String hash = getUserInfo("hash","pseudoUt",pseudoUt);
            String salt = getUserInfo("salt","pseudoUt",pseudoUt);
            return getHash((mdp+salt).getBytes()).equals(hash);
        } catch (NullPointerException e) {
            throw new APIMySQLException("unknownPseudo");
        }
    }

    /**
     * Permet de savoir si l'utilisateur est activé
     * @param pseudoUt
     * @return Boolean
     */
    public static boolean isActivated(String pseudoUt){
        return getUserInfo("activeUt", "pseudoUt", pseudoUt).equals("true");
    }

    /**
     * Permet de désactiver un utilisateur
     * @param pseudo
     */
    public static void deactivateUser(String pseudo){
        setUserInfo("activeUt", 0, "pseudoUt", pseudo);
    }

    /**
     * Permet de supprimer un utilisateur
     * @param pseudo
     * @throws SQLException
     */
    public static void deleteUser(String pseudo) throws SQLException {
        ArrayList<String> pseudoList = new ArrayList<>();
        pseudoList.add(pseudo);
        ArrayList<Object> idListFromPseudo = new ArrayList<>();
        for(String name : pseudoList){
            idListFromPseudo.add(getIdByPseudo(name));
        }
        GestionBD.updatePreparedStatement("delete from UTILISATEUR where idUt=?", idListFromPseudo);
    }

    /**
     * Permet d'obtenir l'id d'un utilisateur à l'aide de son pseudo
     * @param pseudoUt
     * @return int
     */
    public static int getIdByPseudo(String pseudoUt){
        return Integer.parseInt(getUserInfo("idUt", "pseudoUt", pseudoUt));
    }

    /**
     * Permet d'obtenir le pseudo d'un utilisateur en ayant son id
     * @param id
     * @return String
     */
    public static String getPseudoById(Integer id){
        return getUserInfo("pseudoUt", "idUt", id.toString());
    }

    /**
     * Permet d'avoir la liste d'amis associés à un utilisateur
     * @param pseudo
     * @return ArrayList<String>
     */
    public static ArrayList<String> getListeDamis(String pseudo){
        ArrayList<String> listePseudo = new ArrayList<>();
        List<Object> listeId1 = GestionBD.selectPreparedStatement("SELECT idUt2 FROM ETREAMI WHERE idUt1 = "+getIdByPseudo(pseudo)).get("idUt2");
        List<Object> listeId2 = GestionBD.selectPreparedStatement("SELECT idUt1 FROM ETREAMI WHERE idUt2 = "+getIdByPseudo(pseudo)).get("idUt1");
        try{
            //listeId1.retainAll(listeId2);
            ArrayList<Object> listeUnion = new ArrayList<>();
            if(listeId1 != null){
                listeUnion.addAll(listeId1);
            }
            if (listeId2 != null){
                listeUnion.addAll(listeId2);
            }
            for(Object elem : listeUnion){
                if(!Utilisateur.getPseudoById(Integer.valueOf(elem.toString())).equals(pseudo)){
                    listePseudo.add(String.valueOf(getPseudoById((Integer) elem)));
                }
            }
        }
        catch (NullPointerException e){
            return null;
        }

        return listePseudo;
    }

    /**
     * Permet de mettre à jour l'image d'un utilisateur
     * @param pseudo
     * @param image
     */
    public static void updateImage(String pseudo, byte[] image){
        try {
            PreparedStatement s = GestionBD.getCo().prepareStatement("UPDATE UTILISATEUR SET image=? WHERE pseudoUt='"+pseudo+"'");
            s.setBlob(1,GestionBD.createBlob(image));
            s.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * permet de mettre à jour un utilisateur
     * @param pseudo
     * @param email
     * @param motDePasse
     * @param ancientMotDePasse
     * @param image
     */
    public static void updateUtilisateur(String pseudo, String email, String motDePasse, String ancientMotDePasse, byte[] image){
        int id = getIdByPseudo(ancientMotDePasse);
        String salt = getSalt();

        setUserInfo("pseudoUt", pseudo, "idUt", String.valueOf(id)); //eror
        setUserInfo("emailUt", email, "idUt", String.valueOf(id));
        //setUserInfo("image", blob, "idUt", String.valueOf(id));
        updateImage(pseudo,image);

        if(!(motDePasse.length() == 0)){
            setUserInfo("hash", getHash((motDePasse + salt).getBytes()), "idUt", String.valueOf(id));
            setUserInfo("salt", salt, "idUt", String.valueOf(id));
        }
    }

    /**
     * Permet d'obtenir l'adresse mail d'un utilisateur via son pseudo
     * @param pseudoUt
     * @return String
     */
    public static String getEmailByPseudo(String pseudoUt){
        return getUserInfo("emailUt", "pseudoUt", pseudoUt);
    }


}
