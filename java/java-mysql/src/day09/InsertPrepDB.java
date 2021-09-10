package day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPrepDB {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=utf8";
		String driver = "com.mysql.cj.jdbc.Driver";

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, "javauser", "1234");
			
			String sql = "INSERT INTO address(name,handphone,address) ";
			sql += "VALUES(?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "나우석");
			pstmt.setString(2, "010-4233-2255");
			pstmt.setString(3, "서울시 강남");
			
			int cnt = pstmt.executeUpdate();
			
			System.out.println("레코드가 " + cnt + "개 추가되었습니다.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null) {
					pstmt.close();
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
