package model;

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

	public int insert(Book b) {
		int rows = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			String sql = "insert into Book values(?,?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, b.getTitle());
			psmt.setLong(2, b.getIsbn());
			psmt.setString(3, b.getAuthor());
			psmt.setString(4, b.getPublisher());
			psmt.setString(5, b.getGenre());

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

	
	public ArrayList<Book> selectAllBook(String login_id) { // 소장도서목록

		ArrayList<Book> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT b.b_title, b.b_author, b.b_isbn, p.p_publisher, g.g_genre" + 
					" FROM book b, publisher p, genre g" + 
					" WHERE b.b_isbn = p.b_isbn AND g.b_isbn = b.b_isbn";
			conn = DriverManager.getConnection(url, user, password);

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				String title = rs.getString("B_TITLE");
				String author = rs.getString("B_AUTHOR");
				long isbn = rs.getLong("B_ISBN");
				String publisher = rs.getString("p_PUBLISHER");
				String genre = rs.getString("G_genre");
				System.out.println(title);
				System.out.println(author);

				Book b = new Book(title, author, isbn, publisher, genre);
				list.add(b);
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
				long isbn = rs.getLong("b_isbn");
				String author = rs.getString("b_author");
				Book b = new Book(title, author, isbn);
				list.add(b);
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

	public int updateBook(Book selectBook) { // 도서 수정
		int rows = 0;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);

			String sql = "update  book as b, publisher as p, genre as g set b.b_title = ?, b.b_isbn = ?, b.b_author = ?, p.p_publisher = ?, g.g_genre = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, selectBook.getTitle());
			psmt.setLong(2, selectBook.getIsbn());
			psmt.setString(3, selectBook.getAuthor());
			psmt.setString(4, selectBook.getPublisher());
			psmt.setString(5, selectBook.getGenre());
			System.out.println(selectBook.getTitle());
			System.out.println(selectBook.getIsbn());
			System.out.println(selectBook.getAuthor());
			System.out.println(selectBook.getPublisher());
			System.out.println(selectBook.getGenre());
			
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

	public int updateLoan(Book selectBook) {
		int rows = 0;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		Connection conn = null;
		PreparedStatement psmt = null;

		try { // try ~ catch 예외처리

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE LOAN SET l.l_loanDate = ?, l.l_returnDate = ?,"
					+ "l.l_isOverdue = ?, l.l_count = ? WHERE b.b_isbn = ? AND b.b_isbn = l.b_isbn";
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

			psmt.setLong(5, selectBook.getIsbn());
			rows = psmt.executeUpdate();

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
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	public ArrayList<Book> selectTitle(String title) { // 제목 검색

		ArrayList<Book> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT b.b_title, b.b_author, b.b_isbn, p.p_publisher, g.g_genre" + 
					" FROM book b, publisher p, genre g" + 
					" WHERE b.b_isbn = g.b_isbn AND b.b_isbn = p.b_isbn AND b.b_title like '%' || ? || '%' ";
			conn = DriverManager.getConnection(url, user, password);

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			
			rs = psmt.executeQuery();

			while (rs.next()) {

				String title1 = rs.getString("B_TITLE");
				String author = rs.getString("B_AUTHOR");
				long isbn = rs.getLong("B_ISBN");
				String publisher = rs.getString("p_PUBLISHER");
				String genre = rs.getString("G_genre");				

				Book b = new Book(title1, author, isbn, publisher, genre);
				list.add(b);
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
	
	public ArrayList<Book> selectAuthor(String title) { // 작가 검색

		ArrayList<Book> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT b.b_title, b.b_author, b.b_isbn, p.p_publisher, g.g_genre" + 
					" FROM book b, publisher p, genre g" + 
					" WHERE b.b_isbn = g.b_isbn AND b.b_isbn = p.b_isbn AND b.b_author like '%' || ? || '%' ";
			conn = DriverManager.getConnection(url, user, password);

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			rs = psmt.executeQuery();

			while (rs.next()) {

				String title1 = rs.getString("B_TITLE");
				String author = rs.getString("B_AUTHOR");
				long isbn = rs.getLong("B_ISBN");
				String publisher = rs.getString("p_PUBLISHER");
				String genre = rs.getString("G_genre");				

				Book b = new Book(title1, author, isbn, publisher, genre);
				list.add(b);
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
	public ArrayList<Book> selectPublisher(String title) { // 출판사 검색

		ArrayList<Book> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT b.b_title, b.b_author, b.b_isbn, p.p_publisher, g.g_genre" + 
					" FROM book b, publisher p, genre g" + 
					" WHERE b.b_isbn = g.b_isbn AND b.b_isbn = p.b_isbn AND p.p_publisher like '%' || ? || '%' ";
			conn = DriverManager.getConnection(url, user, password);

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			System.out.println(title+" ");
			rs = psmt.executeQuery();

			while (rs.next()) {

				String title1 = rs.getString("B_TITLE");
				String author = rs.getString("B_AUTHOR");
				long isbn = rs.getLong("B_ISBN");
				String publisher = rs.getString("p_PUBLISHER");
				String genre = rs.getString("G_genre");
				System.out.println(title1);
				System.out.println(author);
				System.out.println(publisher);
				Book b = new Book(title1, author, isbn, publisher, genre);
				list.add(b);
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
}
