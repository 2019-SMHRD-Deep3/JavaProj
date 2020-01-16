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

			String sql = "insert into Book values(?,?,?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, b.getTitle());
			psmt.setLong(2, b.getIsbn());
			psmt.setString(3, b.getAuthor());
			psmt.setString(4, b.getPublisher());
			psmt.setDate(5, b.getLoanDate());
			psmt.setDate(6, b.getReturnDate());

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

			String sql = "SELECT * FROM BOOK " + "WHERE b_ISBN = ? b_TITLE=?";
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, b.getIsbn());
			psmt.setString(2, b.getTitle());

			rs = psmt.executeQuery();

			if (rs.next()) {

				String title = rs.getString("b_title");
				int isbn = rs.getInt("b_isbn");
				String author = rs.getString("b_author");
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

			conn = DriverManager.getConnection(url, user, password); // 접속시도 , 코딩후 에러 - 캐치블럭 설정(팝업창2번째)
			/// connection - overloading
			// String sql = "insert into book values(?,?,?,?,?,?)" ;
			String sql = "SELECT * FROM BOOK ";
			conn = DriverManager.getConnection(url, user, password);

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				String title2 = rs.getString("title");
				int isbn = rs.getInt("isbn");
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
				list.add(new Book(title, isbn, author));
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
					+ "loanDate = ?, returnDate = ? ";

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

}
