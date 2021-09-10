package day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectPrepDB {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=utf8";
		String driver = "com.mysql.cj.jdbc.Driver";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "javauser", "1234");

			String sql = "select addressnum, name, handphone, address ";
			sql += "from address where addressnum = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 11); // 1번째 ?에 11이 들어감. setString도 가능.

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int addressnum = rs.getInt("addressnum");
				String name = rs.getString("name"); // or rs.getStrng(2); 순서값.
				String phone = rs.getString(3);
				String address = rs.getString("address");

				System.out.println("번호 : " + addressnum);
				System.out.println("이름 : " + name);
				System.out.println("전화번호 : " + phone);
				System.out.println("주소 : " + address);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
