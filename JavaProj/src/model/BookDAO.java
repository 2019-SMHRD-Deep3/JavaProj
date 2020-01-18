package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class BookDAO {

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String password = "hr";
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	Member m;
	Book b;

	public int insert(Book b) {
		int rows = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			String sql = "insert into Book values(?,?,?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, b.getTitle());
			psmt.setLong(2, b.getIsbn());
			psmt.setString(3, b.getAuthor());
			psmt.setString(4, b.getPublisher());

			rows = psmt.executeUpdate();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				if (psmt != null)
					psmt.close();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return rows;
	}

//	public Book selectOne(Book b) {
//
//		Book book = null;
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//
//			conn = DriverManager.getConnection(url, user, password);
//
//			String sql = "SELECT * FROM BOOK WHERE b_ISBN = ? b_TITLE = ? b_author";
//			psmt = conn.prepareStatement(sql);
//			psmt.setLong(1, b.getIsbn());
//			psmt.setString(2, b.getTitle());
//
//			rs = psmt.executeQuery();
//
//			if (rs.next()) {
//
//				String title = rs.getString("b_title");
//				long isbn = rs.getInt("b_isbn");
//				String author = rs.getString("b_author");
//				String publisher = rs.getString("publisher");
//
//				b = new Book(title, isbn, author, publisher);
//
//			}
//
//		} catch (ClassNotFoundException e) {
//
//			e.printStackTrace();
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		} finally {
//
//			try {
//				if (rs != null)
//					rs.close();
//				if (psmt != null)
//					psmt.close();
//
//			} catch (SQLException e1) {
//
//				e1.printStackTrace();
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//
//		}
//		return book;
//	}

//	public ArrayList<Book> mainALL() { // 도서 메인 전체 보기1
//		ArrayList<Book> list = new ArrayList<>();
//
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(url, user, password);
//			String sql = "SELECT b.b_title, b.b_author, b.b_isbn, p.p_publisher, g.g_genre FROM book b, publisher p, genre g WHERE b.b_isbn = p.b_isbn AND g.b_isbn = b.b_isbn";
//			psmt = conn.prepareStatement(sql);
//			rs = psmt.executeQuery();
//
//			while (rs.next()) {
//
//				String title = rs.getString("b_title");
//				long isbn = rs.getLong("b_isbn");
//				String author = rs.getString("b_author");
//				String publisher = rs.getString("p_publisher");
//				String genre = rs.getString("g_genre");
//
//				list.add(new Book(title, isbn, author, publisher, genre));
//
//			}
//
//		} catch (ClassNotFoundException e) {
//
//			e.printStackTrace();
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		} finally {
//
//			try {
//				if (rs != null)
//					rs.close();
//				if (psmt != null)
//					psmt.close();
//
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//
//		}
//		return list;
//
//	}

	public ArrayList<Book> selectSome() {

		ArrayList<Book> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT b.b_title, b.b_author, l.l_loandate, l.l_returndate, l.l_isOverdue"
					+ " FROM BOOK b, LOAN l" + " WHERE b.b_isbn = l.b_isbn";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String title = rs.getString("b_title");
				String author = rs.getString("b_author");
				Date loanDate = rs.getDate("l_loandate");
				Date returnDate = rs.getDate("l_returndate");
				String isOverdue = rs.getString("l_isOverdue");
				list.add(new Book(title, author, loanDate, returnDate, isOverdue));
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list;
	}

	public ArrayList<Book> selectAll() {

		ArrayList<Book> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM BOOK";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String title = rs.getString("b_title");
				String author = rs.getString("b_author");
				long isbn = rs.getLong("b_isbn");
				list.add(new Book(title, author, isbn));
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list;
	}

//	private static void update(Book b) {
//
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "hr";
//		String password = "hr";
//		Connection conn = null;
//		PreparedStatement psmt = null;
//
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//
//			conn = DriverManager.getConnection(url, user, password);
//
//			String sql = "update book set title = ?, isbn = ?, author = ?, publisher = ?, "
//					+ "loanDate = ?, returnDate = ? ";
//
//			psmt = conn.prepareStatement(sql);
//
//			psmt.setString(1, b.getTitle());
//			psmt.setLong(2, b.getIsbn());
//			psmt.setString(3, b.getAuthor());
//			psmt.setString(4, b.getPublisher());
//			psmt.setDate(5, b.getLoanDate());
//			psmt.setDate(6, b.getReturnDate());
//
//			int rows = psmt.executeUpdate();
//
//			if (rows == 0) {
//				System.out.println("SQL문을 확인하세요.");
//			}
//
//		} catch (ClassNotFoundException e) {
//
//			e.printStackTrace();
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		} finally {
//
//			try {
//				if (psmt != null)
//					psmt.close();
//
//			} catch (SQLException e1) {
//
//				e1.printStackTrace();
//			}
//			try {
//				if (conn != null)
//					conn.close();
//
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//
//		}
//	}

	private static void delete(Book b) {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);

			String sql = "delete from BOOK WHERE B_ISBN = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, b.getTitle());
			psmt.setLong(2, b.getIsbn());
			psmt.setString(3, b.getAuthor());
			psmt.setString(4, b.getPublisher());
			psmt.setDate(5, b.getLoanDate());
			psmt.setDate(6, b.getReturnDate());

			int rows = psmt.executeUpdate();

			if (rows == 0) {
				System.out.println("SQL문을 확인하세요.");
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public ArrayList<Book> selectMain() {

		ArrayList<Book> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM BOOK "; // where 조건으로 rank 계산필요?
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				String title = rs.getString("book_title");
				String author = rs.getString("book_author");
				String publisher = rs.getString("book_publisher");
				String genre = rs.getString("book_genre");

				list.add(new Book(title, author, publisher, genre));
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return list;

	}

	public Book updateLoan(Book selectBook) {
		int rows = 0;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		Connection conn = null;
		PreparedStatement psmt = null;

		try { // try ~ catch 예외처리

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO loan" + " values (?, ?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);

			Calendar cal = Calendar.getInstance();
			java.util.Date date = cal.getTime();
			String dateString = new SimpleDateFormat("yy/MM/dd").format(date);
			psmt.setString(1, dateString);

			cal.add(Calendar.DATE, 14);
			date = cal.getTime();
			String dateString2 = new SimpleDateFormat("yy/MM/dd").format(date);
			psmt.setString(2, dateString2);

			psmt.setString(3, "y");
			psmt.setInt(4, 1);

			File file = new File("D:\\MemberId.txt");
			FileReader file_reader = new FileReader(file);
			int cur = 0;
			while ((cur = file_reader.read()) != -1) {
				psmt.setLong(5, (char) cur);
			}
			File file2 = new File("D:\\BookIsbn.txt");
			FileReader file_reader2 = new FileReader(file2);
			int cur2 = 0;
			while ((cur2 = file_reader2.read()) != -1) {
				psmt.setLong(6, (char) cur2);
			}

			file_reader.close();
			rows = psmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return b;
	}

}
