package APIMySQL;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;

public class Utilisateur {

    private GestionBD gestionBD;
    private static final SecureRandom RANDOM = new SecureRandom();

    public Utilisateur(GestionBD gestionBD){
        this.gestionBD = gestionBD;
    }

    private static String getSalt(){
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private String getHash(byte[] bytes){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {}
        byte[] hash = digest.digest(bytes);
        return Base64.getEncoder().encodeToString(hash);
    }

    public boolean creerUtilisateur(String pseudo, String email, String mdp, String nomRole){
        String salt = getSalt();
        ArrayList<Object> donnees = new ArrayList<>();

        try {
            Collections.addAll(donnees,pseudo,email,1,nomRole,getHash((mdp + salt).getBytes()),salt);
            gestionBD.insertRequete("INSERT INTO UTILISATEUR (pseudoUt,emailUt,activeUt,nomRole,hash,salt) VALUES (?,?,?,?,?,?)", donnees);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(salt);
        return true;
    }

    public boolean mdpValide(int idU, String mdp){
        /*try {
            String hash = gestionBD.selectRequestWithPreparedStatement("SELECT hash FROM UTILISATEUR WHERE idU="+idU).get(0).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return false;
    }
}
