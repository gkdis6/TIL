package day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllPrepDB {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=utf8";
		String driver = "com.mysql.cj.jdbc.Driver";

		Connection con = null;
		PreparedStatement prst = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "javauser", "1234");

			String sql = "select addressnum, name, handphone, address ";
			sql += "from address order by ? asc";

			prst = con.prepareStatement(sql);
			prst.setString(1, "name");

			rs = prst.executeQuery();

			while (rs.next()) {
				int addressnum = rs.getInt("addressnum");
				String name = rs.getString("name"); // or rs.getStrng(2); 순서값.
				String phone = rs.getString(3);
				String address = rs.getString("address");

				System.out.println("번호 : " + addressnum);
				System.out.println("이름 : " + name);
				System.out.println("전화번호 : " + phone);
				System.out.println("주소 : " + address);
				System.out.println("=========================");
			}

		} catch (ClassNotFoundException | SQLException e) {
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
				if (prst != null)
					prst.close();
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
