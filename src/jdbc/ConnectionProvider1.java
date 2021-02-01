package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider1 {
	private static String url;
	private static String user;
	private static String password;
	
	static void setUrl(String url) {
		ConnectionProvider1.url = url;
	}
	static void setUser(String user) {
		ConnectionProvider1.user = user;
	}
	static void setPassword(String password) {
		ConnectionProvider1.password = password;
	}
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
