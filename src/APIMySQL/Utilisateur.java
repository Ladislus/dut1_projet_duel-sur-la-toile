package APIMySQL;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Utilisateur {

    private GestionBD gestionBD;
    private static final SecureRandom RANDOM = new SecureRandom();

    public Utilisateur(GestionBD gestionBD){
        this.gestionBD = gestionBD;
    }

    private static byte[] getSalt(){
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return salt;
    }

    private String getHash(byte[] bytes){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {}
        byte[] hash = digest.digest(bytes);
        return Base64.getEncoder().encodeToString(hash);
    }

    public boolean creerUtilisateur(String nom, String email, String mdp, String nomRole){
        byte[] mdpBytes = mdp.getBytes(StandardCharsets.UTF_8);

        ByteArrayOutputStream mdpSalted = new ByteArrayOutputStream();

        try {
            mdpSalted.write(mdpBytes);
            mdpSalted.write(getSalt());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(getHash(mdpSalted.toByteArray()));
        return true;
    }
}
