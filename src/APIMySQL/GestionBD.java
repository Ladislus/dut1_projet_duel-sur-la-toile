package APIMySQL;

import com.mysql.jdbc.ResultSetMetaData;
import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestionBD {

    private static Connection co = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://localhost/serveurDeJeux", "root", ""); }
        catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); }}

    /**
     * Classe statique (Bibliothèque) permettant la gestion bas niveau de l'API MySQL
     */
    private GestionBD(){}

    /**
     * Retourne la connection courante
     * @return connexion
     */
    public static Connection getCo() {
        return co;
    }

    /**
     * Permet de passer une requête SQL en entrée
     * puis de retourner le résultat sous une forme
     * pratique pour l'intégration de l'API sur les différents modules
     * @param requete
     * @return HashMap<String, List<Object>>
     */
    public static HashMap<String, List<Object>> selectPreparedStatement(String requete) {
        try {
            //Creation des objets necessaire a la connexion a la bd
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(requete);
            ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
            int columns = md.getColumnCount();
            List<HashMap<String, List<Object>>> list = new ArrayList<>();
            //On boucle sur les colonnes
            while (rs.next()) {
                HashMap<String, List<Object>> row = new HashMap<>(columns);
                //Pour chaque colonne, ajoutée le dictionnaire {nomCol=valeur} dans la liste
                for (int i = 1; i <= columns; ++i) {
                    ArrayList<Object> liste = new ArrayList<>();
                    liste.add(rs.getObject(i));
                    row.put(md.getColumnName(i), liste);
                }
                list.add(row);
            }
            HashMap<String, List<Object>> res = new HashMap<>();
            //Reformattage de la liste des HashMap pour avoir qu'une seule hashmap : {nomCol=[valeur1, valeur2], nomCol2=[]..etc}
            for (HashMap<String, List<Object>> e : list){
                for(String key : e.keySet()){
                    if(!res.containsKey(key))
                        res.put(key, e.get(key));
                    else
                        res.get(key).add(e.get(key).get(0));
                }
            }
            //retourne le resultat
            return res;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Permet de faire une requête SQL UPDATE avec
     * des données rajoutées dans l'ordre dans une liste
     * @param requete
     * @param listeDonnee
     * @throws SQLException
     */
    public static void updatePreparedStatement(String requete, List<Object> listeDonnee) throws SQLException{
        //On compte le nombre de point d'interogation
        int nbPointDinterrogation = 0;
        for(int i =0; i<requete.length(); i++){
            if(requete.charAt(i) == '?'){
                nbPointDinterrogation += 1;
            }
        }
        //On prepare les object necessaire
        PreparedStatement ps = co.prepareStatement(requete);
        //Puis on entre les données dans la bd
        for(int i =0; i<nbPointDinterrogation; i++){
            Object o = listeDonnee.get(i);
            if (o.getClass().getName().equals("com.mysql.jdbc.Blob")){
                ps.setBlob(i+1,(Blob)o);
            }
            else if (o.getClass().getName().equals("java.sql.Timestamp")){
                ps.setTimestamp(i+1,(Timestamp) o);
            }
            else ps.setObject(i+1, o.toString());
        }
        ps.executeUpdate();
    }

    /**
     * Permet de faire des requêtes de type update en brut
     * @param requete
     */
    public static void updateStatement(String requete){
        try {
            Statement s = co.createStatement();
            s.executeUpdate(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de créer un Blob à partir d'un chemin relatif ou absolu
     * @param url
     * @return Blob
     * @throws IOException
     * @throws SQLException
     */
    public static Blob createBlob(String url) throws IOException, SQLException {
        Blob res = co.createBlob();
        res.setBytes(1,Files.readAllBytes(Paths.get(url)));
        return res;
    }

    /**
     * Permet de créer un blob à partir d'un tableau d'octets
     * @param bytes
     * @return Blob
     * @throws SQLException
     */
    public static Blob createBlob(byte[] bytes) throws SQLException {
        Blob res = co.createBlob();
        res.setBytes(1,bytes);
        return res;
    }

    /**
     * Permet de convertir un Blob en Image JavaFX
     * @param blob
     * @return Image
     */
    public static Image blobToImage(Blob blob) {
        try {
            Image res = new Image(new ByteArrayInputStream(blob.getBytes(1,(int)blob.length())));
            blob.free();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; }

    /**
     * Permet de convertir un tableau d'octets en Image JavaFX
     * @param bytes
     * @return Image
     */
    public static Image bytesToImage(byte[] bytes){
        return new Image(new ByteArrayInputStream(bytes));
    }}
