package book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utility.DBClose;
import utility.Open;

public class BookTest {

	public static void main(String[] args) {
		BookDTO dto = new BookDTO(21424, "Java Basic", "김하나", "Jaen.kr", 15000, "Java 기본 문법");
		BookDTO dto2 = new BookDTO(33455, "JDBC Pro", "김철수", "Jaen.kr", 23000);
		BookDTO dto3 = new BookDTO(55355, "Servlet/JSP", "박자바", "Jaen.kr", 41000, "Model2 기반");
		BookDTO dto4 = new BookDTO(35332, "Android App", "홍길동", "Jaen.kr", 25000, "Lightweight Framework");
		BookDTO dto5 = new BookDTO(35355, "OOAD 분석, 설계", "소나무", "Jaen.kr", 30000);
		
		createTable();
		
		insertStudent(dto);
		insertStudent(dto2);
		insertStudent(dto3);
		insertStudent(dto4);
		insertStudent(dto5);
		
		printAllBooks();
	}
	
	public static void createTable() {
		Connection con = Open.getConnection();
		Statement stmt = null;
		StringBuffer sql = new StringBuffer();
		
		try {
			stmt = con.createStatement();
			
			sql.append("CREATE TABLE if not exists books ("
					+ "isbn int primary key, "
					+ "title varchar(50) not null, "
					+ "author varchar(250) not null, "
					+ "publisher varchar(50) not null, "
					+ "price int not null, "
					+ "info varchar(200), "
					+ "publish_date varchar(10));");
			
			stmt.execute(sql.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(stmt, con);
		}
	}

	public static void insertStudent(BookDTO book) {
		Connection con = Open.getConnection();
		PreparedStatement prst = null;
		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO books (isbn, title, author, publisher, price, info) ");
		sql.append("values(?,?,?,?,?,?);");
		try {
			prst = con.prepareStatement(sql.toString());
			prst.setInt(1, book.getIsbn());
			prst.setString(2, book.getTitle());
			prst.setString(3, book.getAuthor());
			prst.setString(4, book.getPublisher());
			prst.setInt(5, book.getPrice());
			prst.setString(6, book.getInfo());

			prst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBClose.close(prst, con);
		}
	}

	public static void printAllBooks() {
		List<BookDTO> list = list();

		p("*********************** 도서 목록 ***********************");
		for (int i = 0; i < list.size(); i++) {
			BookDTO book = list.get(i);
			p(book.toString());
		}
	}

	public static List<BookDTO> list() {
		List<BookDTO> list = new ArrayList<>();
		Connection con = Open.getConnection();
		Statement stmt = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;

		sql.append("select * ");
		sql.append("from books");
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql.toString());
			while (rs.next()) {
				BookDTO book = new BookDTO();
				book.setIsbn(rs.getInt("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setInfo(rs.getString("info"));

				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(stmt, con, rs);
		}

		return list;
	}
	private static void p(String s) {
		System.out.println(s);
	}
}
