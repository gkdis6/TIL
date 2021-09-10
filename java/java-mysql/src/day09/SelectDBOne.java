package day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDBOne {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=utf8";
		String driver = "com.mysql.cj.jdbc.Driver";
		Connection con = null; // 디비 연결 객체
		Statement stmt = null; // sql문 전송객체
		ResultSet rs = null; // select문을 전송한 후 실행된 결과값을 받는 자바클래스

		
		try {
			// 1. 드라이버 메모리 올림(객체 생성 -> new : 정확한 타입이 있어야함) 정확한 타입 말고 메모리에 올리고 싶다면
			// Class.forName으로 올려야함
			Class.forName(driver); // mysql만 예외적으로 이게 없어도 자동으로 만들어주긴 함
			
			// 2. 연결객체 생성
			con = DriverManager.getConnection(url, "javauser", "1234");
			
			// 3. 서버에 전송할 sql 작성
			String sql = "select addressnum, name, handphone, address ";
			sql += "from address where addressnum = 11";

			// 4. 전송객체 생성 후 sql문 전송
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 5. 전송 후 받은 결과값 확인
			if(rs.next()) {
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
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
