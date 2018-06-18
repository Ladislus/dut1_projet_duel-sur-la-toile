package APIMySQL;

import java.sql.*;

public class ConnexionMySQL {
	public static Connection mysql;

	public ConnexionMySQL(String IP, String database, String user, String mdp) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			mysql = DriverManager.getConnection("jdbc:mysql://"+ IP +":3306/"+ database, user, mdp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Statement createStatement() throws SQLException {
		return mysql.createStatement();
	}

	public PreparedStatement prepareStatement(String requete) throws SQLException{
		return mysql.prepareStatement(requete);
	}

}
