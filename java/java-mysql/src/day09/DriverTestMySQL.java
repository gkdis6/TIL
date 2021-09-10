package day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTestMySQL {
	public static void main(String args[]) {
		Connection con = null;
		try {
			// JDBC드라이버를 로딩합니다.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 서버를 설정합니다.
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/javadb?useUnicode=true&characterEncoding=utf8", "javauser", "1234");
			System.out.println("데이터 베이스 접속이 성공했습니다.");
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex);
		} finally {
			try {
				// 데이터베이스 접속을 닫습니다.
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
			}
		}
	}
}