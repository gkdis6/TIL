package day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDB {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=utf8";
		String driver = "com.mysql.cj.jdbc.Driver";
		Connection con = null; // 디비 연결 객체
		Statement stmt = null; // sql문 전송객체
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "javauser", "1234");
			
			String sql = "delete from address ";
			sql += "where addressnum = 15";
			
			stmt = con.createStatement();
			int cnt = stmt.executeUpdate(sql);
			
			System.out.println("레코드 " + cnt + "개가 삭제되었습니다.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(stmt != null) stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
	}

}
