package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Open {
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName(Constant.DRIVER);
			
			con = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static Connection getORACLEConnection() {
		try {
			Class.forName(Constant.ORACLEDRIVER);
			
			con = DriverManager.getConnection(Constant.ORACLEURL, Constant.ORACLEUSER, Constant.ORACLEPASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
