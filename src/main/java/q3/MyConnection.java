package q3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	static Connection conn;
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/mydb2"; // mydb2 is the name of the database
		try {
			conn = DriverManager.getConnection(url, "root", "mango%^TANGO47");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
