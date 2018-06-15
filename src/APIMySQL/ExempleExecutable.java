package APIMySQL;

public class ExempleExecutable {
    public static void main(String[] args) throws ClassNotFoundException {
        // TEST : Essai de passer en bibliothèques statiques.

        ConnexionMySQL co = new ConnexionMySQL("192.168.1.100", "serveurDeJeux", "dst", "dst");

<<<<<<< HEAD
class ExempleExecutable {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        GestionBD gestionBD = new GestionBD("192.168.1.100", "serveurDeJeux", "dst", "dst");
        System.out.println(gestionBD.init());
        //Exemple pour ajouter des données
        //ArrayList<Object> donnee = new ArrayList<>();
        //donnee.add("ADMIN");
        //donnee.add("USER");
        //gestionBD.insertRequete("insert into ROLE values (?)", donnee);
        HashMap<String, List<Object>> res = gestionBD.selectRequestWithPreparedStatement("Select * from ROLE;");
        //retourne {nomRole=[ADMIN, USER]}
        System.out.println(res);
=======
        GestionBD.updateStatement(co,"INSERT INTO ROLE VALUES ('ADMIN')");

        Utilisateur.creerUtilisateur(co,"test","test@gmail.com","couscous","admin");

        try {
            System.out.println(Utilisateur.isMdpValide(co,"test","couscous"));
            System.out.println(Utilisateur.isMdpValide(co,"test","test"));
            System.out.println(Utilisateur.isMdpValide(co,"test2","test"));
        } catch (UtilisateurException e) {
            e.printStackTrace();
        }
>>>>>>> 9ea1129d9fef9e602bd64fec7f0ba6ea05d50ed3

    }
}
