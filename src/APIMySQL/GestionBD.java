package APIMySQL;

import com.mysql.jdbc.ResultSetMetaData;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestionBD {

    private String url;
    private String nomBase;
    private String username;
    private String password;
    ConnexionMySQL connexionMySQL;

    /*
     * Constructeur qui se connecte a la base de donnée
     *
     */
    public GestionBD(String url, String nomBase, String username, String password) throws ClassNotFoundException {
        this.url = url;
        this.nomBase = nomBase;
        this.username = username;
        this.password = password;
        connexionMySQL = new ConnexionMySQL();
    }

    /*
    Initialise la connexion a la base de donnée
    Retourne vraie si elle c'est connectée, sinon faux
     */
    public boolean init(){
        try{
            this.connexionMySQL.connecter(this.url, this.nomBase, this.username, this.password);
        } catch (SQLException e) {
            System.out.println("Est casser -->");
        }
        return this.connexionMySQL.isConnecte();
    }

    public HashMap<String, List<Object>> selectRequestWithPreparedStatement(String requete) throws SQLException {
        Statement st=connexionMySQL.createStatement();
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

    public boolean insertRequete(String requete, List<Object> listeDonnee) throws SQLException {
        //todo : make an exception
        if(!requete.contains("?")){
            return true;
        }
        int nbPointDinterrogation = 0;
        for(int i =0; i<requete.length(); i++){
            if(requete.charAt(i) == '?'){
                nbPointDinterrogation += 1;
            }
        }
        //
        PreparedStatement ps = this.connexionMySQL.prepareStatement(requete);
        for(int i =0; i<nbPointDinterrogation; i++){
            ps.setObject(i+1, listeDonnee.get(i).toString());
        }
        int nb=ps.executeUpdate();
        if(nb ==0){
            return false;
        }
        return true;
    }
}
