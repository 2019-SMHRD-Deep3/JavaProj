package model;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

			String sql = "insert into Book values(?,?,?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, b.getTitle());
			psmt.setString(2, b.getIsbn());
			psmt.setString(3, b.getAuthor());
			psmt.setString(4, b.getPublisher());
			psmt.setString(5, b.getLoanDate());
			psmt.setString(6, b.getReturnDate());

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

	public Book selectOne(Book b) {

		Book book = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);

			String sql = "SELECT * FROM Book " + "WHERE ISBM = ? TITLE=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b.getIsbn());
			psmt.setString(2, b.getTitle());

			rs = psmt.executeQuery();

			if (rs.next()) {

				String title = rs.getString("title");
				String isbn = rs.getString("isbn");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String loanDate = rs.getString("loanDate");
				String returnDate = rs.getString("returnDate");

				b = new Book(title, isbn, author, publisher);

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
		return book;
	}

	public ArrayList<Book> selectALL(String title) {

		ArrayList<Book> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);

			String sql = "SELECT * FROM MEMBER " + "WHERE TITLE != ? ";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, title);

			rs = psmt.executeQuery();

			while (rs.next()) {

				String title2 = rs.getString("title");
				String isbn = rs.getString("isbn");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");

				list.add(new Book(title2, isbn, author, publisher));

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
			String sql = "SELECT * FROM BOOK ";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				String title2 = rs.getString("book_title");
				String author = rs.getString("book_author");
				String loanDate = rs.getString("book_loan");
				String returnDate = rs.getString("book_return");
				String isOverdue = rs.getString("book_isOverdue");

				list.add(new Book(title2, author, loanDate, returnDate, isOverdue));
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

	private static void update(Book b) {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);

			String sql = "update book set title = ?, isbn = ?, author = ?, publisher = ?, "
					+ "loanDate = ?, returnDate = ? WHERE USER_id = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, b.getTitle());
			psmt.setString(2, b.getIsbn());
			psmt.setString(3, b.getAuthor());
			psmt.setString(4, b.getPublisher());
			psmt.setString(5, b.getLoanDate());
			psmt.setString(6, b.getReturnDate());

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

	private static String getReturnDate() {

		return null;
	}

	private static String getLoanDate() {

		return null;
	}

	private static String getPublisher() {

		return null;
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

			String sql = "delete from  users WHERE USER_id = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, b.getTitle());
			psmt.setString(2, b.getIsbn());
			psmt.setString(3, b.getAuthor());
			psmt.setString(4, b.getPublisher());
			psmt.setString(5, b.getLoanDate());
			psmt.setString(6, b.getReturnDate());

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

}
