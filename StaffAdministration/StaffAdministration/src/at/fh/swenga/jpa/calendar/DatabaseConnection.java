package at.fh.swenga.jpa.calendar;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static java.sql.Connection getConnection() {
		java.sql.Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Local
//			String url = "jdbc:mysql://localhost:3306/staffadministration";
//			String user = "root";
//			String password = "Pa$$w0rd";
			
			//online
			String url = "jdbc:mysql://sigadev.com/d01de52e";
			String user = "d01de52e";
			String password = "V9RG2EHDHbXf9bqG";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return conn;
	}

}