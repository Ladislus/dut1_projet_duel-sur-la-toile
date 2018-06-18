package APIMySQL;

import com.mysql.jdbc.ResultSetMetaData;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestionBD {

    private static Connection co = null;

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
<<<<<<< HEAD
            co = DriverManager.getConnection("jdbc:mysql://192.168.1.100:3306/serveurDeJeux", "dst", "dst");
=======
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/serveurDeJeux", "root", "marlou06");
>>>>>>> b61aaa676a3db4b47480dea81d52c2ad3a035bea
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private GestionBD(){}

    public static HashMap<String, List<Object>> selectPreparedStatement(String requete) throws SQLException {
        Statement st=co.createStatement();
        ResultSet rs=st.executeQuery(requete);
        ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
        int columns = md.getColumnCount();
        List<HashMap<String,List<Object>>> list = new ArrayList<>();

        while (rs.next()) {
            //On boucle sur les collonne
            HashMap<String,List<Object>> row = new HashMap<>(columns);
            for(int i=1; i<=columns; ++i) {
                ArrayList<Object> liste = new ArrayList<>();
                liste.add(rs.getObject(i));
                row.put(md.getColumnName(i), liste);
            }
            //System.out.println(row);
            list.add(row);
        }

        HashMap<String, List<Object>> res = new HashMap<>();
        for (HashMap<String, List<Object>> e : list){
            for(String key : e.keySet()){
                //Si la cle n'existe pas
                if(!res.containsKey(key)){
                    res.put(key, e.get(key));
                }
                else{
                    res.get(key).add(e.get(key).get(0));
                }
            }
            //Faire la nouvelle liste, list<hasmap(row)>
        }
        return res;
    }

    public static void updatePreparedStatement(String requete, List<Object> listeDonnee) throws SQLException {
        //todo : make an exception
        int nbPointDinterrogation = 0;
        for(int i =0; i<requete.length(); i++){
            if(requete.charAt(i) == '?'){
                nbPointDinterrogation += 1;
            }
        }
        //
        PreparedStatement ps = co.prepareStatement(requete);
        for(int i =0; i<nbPointDinterrogation; i++){
            ps.setObject(i+1, listeDonnee.get(i).toString());
        }
        ps.executeUpdate();
    }

    public static void updateStatement(String requete) throws SQLException{
        Statement s = co.createStatement();
        s.executeUpdate(requete);
    }

    public Blob createBlob() throws SQLException {
        return co.createBlob();
    }
}
