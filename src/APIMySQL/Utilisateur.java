package APIMySQL;

import java.security.SecureRandom;

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

    public boolean creerUtilisateur(String nom, String email, String mdp, String nomRole){
        System.out.println(bytesToHex(getSalt()));
        return true;
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
