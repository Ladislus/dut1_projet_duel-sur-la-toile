package APIMySQL;

import java.sql.*;

class ConnexionMySQL {
	private Connection mysql;
	private boolean connecte = false;
	public ConnexionMySQL(String IP, String database, String user, String mdp) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			this.mysql = DriverManager.getConnection("jdbc:mysql://"+ IP +":3306/"+ database, user, mdp);
			this.connecte=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() throws SQLException {
		this.mysql.close();
		this.connecte=false;
	}

	public boolean isConnecte() { return this.connecte;}
	public Blob createBlob()throws SQLException{
		return this.mysql.createBlob();
	}
	public Statement createStatement() throws SQLException {
		return this.mysql.createStatement();
	}

	public PreparedStatement prepareStatement(String requete) throws SQLException{
		return this.mysql.prepareStatement(requete);
	}

}
