package co.uk.kjsoftware.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		
		String hostName = "localhost";
		String dbName = "itassetmgrdb";
		String user = "root";
		String password = "";
		
		return getMySQLConnection(hostName, dbName, user, password);
	}
	
	public static Connection getMySQLConnection(String hostName, String dbName, String user, String password) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		
		Connection conn =DriverManager.getConnection(connectionURL, user, password);
		
		return conn;
	}

}
