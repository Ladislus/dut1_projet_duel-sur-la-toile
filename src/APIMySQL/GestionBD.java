package APIMySQL;

import com.mysql.jdbc.ResultSetMetaData;
import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GestionBD {

    private static Connection co = null;

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://localhost/serveurDeJeux", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private GestionBD(){}

    public static HashMap<String, List<Object>> selectPreparedStatement(String requete) {
        try {
            Statement st = co.createStatement();
            ResultSet rs = st.executeQuery(requete);
            ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
            int columns = md.getColumnCount();
            List<HashMap<String, List<Object>>> list = new ArrayList<>();
            while (rs.next()) {
                //On boucle sur les colonnes
                HashMap<String, List<Object>> row = new HashMap<>(columns);
                for (int i = 1; i <= columns; ++i) {
                    ArrayList<Object> liste = new ArrayList<>();
                    liste.add(rs.getObject(i));
                    row.put(md.getColumnName(i), liste);
                }
                list.add(row);
            }
            HashMap<String, List<Object>> res = new HashMap<>();
            for (HashMap<String, List<Object>> e : list){
                for(String key : e.keySet()){
                    //Si la clé n'existe pas
                    if(!res.containsKey(key))
                        res.put(key, e.get(key));
                    else
                        res.get(key).add(e.get(key).get(0));
                }
            }
            return res;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void updatePreparedStatement(String requete, List<Object> listeDonnee) throws SQLException{
        //todo : make an exception
        int nbPointDinterrogation = 0;
        for(int i =0; i<requete.length(); i++){
            if(requete.charAt(i) == '?'){
                nbPointDinterrogation += 1;
            }
        }
        PreparedStatement ps = co.prepareStatement(requete);
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

    public static void updateStatement(String requete){
        try {
            Statement s = co.createStatement();
            s.executeUpdate(requete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Blob createBlob(String url) throws IOException, SQLException {
        Blob res = co.createBlob();
        res.setBytes(1,Files.readAllBytes(Paths.get(url)));
        return res;
    }

    public static Image blobToImage(Blob blob){
        try {
            Image res = new Image(new ByteArrayInputStream(blob.getBytes(1,(int)blob.length())));
            blob.free();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Image bytesToImage(byte[] bytes){
        return new Image(new ByteArrayInputStream(bytes));
    }

    public static byte[] getBlob(String requete){
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = co.prepareStatement(requete);
            rs = ps.executeQuery();
            rs.next();
            Blob blob = rs.getBlob(Arrays.asList(requete.split(" ")).get(1));
            return blob.getBytes(1,(int)blob.length());
        } catch (SQLException e){}
        return null;
    }
}
