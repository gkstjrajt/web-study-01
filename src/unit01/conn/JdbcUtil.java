package unit01.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	public static Connection getConnection() {
		Connection con = null;
		String proptiesPath = "db.properties";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl?useSSL=false";
			String user = "erd_study";
			String password = "rootroot";

			con = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return con;
	}
}