package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBClose {

	public static void close(PreparedStatement prst, Connection con) {
		try {
			if(prst != null) prst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement prst, Connection con, ResultSet rs) {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(prst != null) prst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
