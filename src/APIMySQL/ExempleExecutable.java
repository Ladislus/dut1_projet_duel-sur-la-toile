package APIMySQL;

public class ExempleExecutable {
    public static void main(String[] args) throws ClassNotFoundException {
        // TEST : Essai de passer en bibliothèques statiques.

        ConnexionMySQL co = new ConnexionMySQL("192.168.1.100", "serveurDeJeux", "dst", "dst");

        GestionBD.updateStatement(co,"INSERT INTO ROLE VALUES ('ADMIN')");

        Utilisateur.creerUtilisateur(co,"test","test@gmail.com","couscous","admin");

        try {
            System.out.println(Utilisateur.isMdpValide(co,"test","couscous"));
            System.out.println(Utilisateur.isMdpValide(co,"test","test"));
            System.out.println(Utilisateur.isMdpValide(co,"test2","test"));
        } catch (UtilisateurException e) {
            e.printStackTrace();
        }

    }
}
