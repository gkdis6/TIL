package day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDB {
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=utf8";
		Connection con = null;
		Statement stmt = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.err.print(e.toString());
		}
		try {
			con = DriverManager.getConnection(url, "javauser", "1234");
			stmt = con.createStatement();

			String sql = "INSERT INTO address(name,handphone,address) ";
			sql = sql + "VALUES('개발자7', '777-777-7777', '한국')";

			// INSERT 쿼리를 먼저 실행한 후 추가된 레코드수를 리턴합니다.
			int ret = stmt.executeUpdate(sql);
			System.out.println("레코드 " + ret + "개가 추가되었습니다.");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
			}
		}
	}
}