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

			String sql = "insert into Book values(?,?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, b.getTitle());
			psmt.setLong(2, b.getIsbn());
			psmt.setString(3, b.getAuthor());
			psmt.setString(4, b.getPublisher());
<<<<<<< HEAD
			psmt.setString(5, b.getGenre());
=======
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git

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

<<<<<<< HEAD
	
	public ArrayList<Book> selectAllBook(String login_id) { // ���嵵�����

=======
	public Book selectOne(Book b) {

		Book book = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);

			String sql = "SELECT * FROM BOOK WHERE b_ISBN = ? b_TITLE = ? b_author";
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, b.getIsbn());
			psmt.setString(2, b.getTitle());

			rs = psmt.executeQuery();

			if (rs.next()) {

				String title = rs.getString("b_title");
				long isbn = rs.getInt("b_isbn");
				String author = rs.getString("b_author");
				String publisher = rs.getString("publisher");

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

	public ArrayList<Book> mainALL() { // ���� ���� ��ü ����1
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git
		ArrayList<Book> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
<<<<<<< HEAD
			String sql = "SELECT b.b_title, b.b_author, b.b_isbn, p.p_publisher, g.g_genre" + 
					" FROM book b, publisher p, genre g" + 
					" WHERE b.b_isbn = p.b_isbn AND g.b_isbn = b.b_isbn";
			conn = DriverManager.getConnection(url, user, password);

=======
			String sql = "SELECT b.b_title, b.b_author, b.b_isbn, p.p_publisher, g.g_genre FROM book b, publisher p, genre g WHERE b.b_isbn = p.b_isbn AND g.b_isbn = b.b_isbn";
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

<<<<<<< HEAD
				String title = rs.getString("B_TITLE");
				String author = rs.getString("B_AUTHOR");
				long isbn = rs.getLong("B_ISBN");
				String publisher = rs.getString("p_PUBLISHER");
				String genre = rs.getString("G_genre");
				System.out.println(title);
				System.out.println(author);
=======
				String title = rs.getString("b_title");
				long isbn = rs.getLong("b_isbn");
				String author = rs.getString("b_author");
				String publisher = rs.getString("p_publisher");
				String genre = rs.getString("g_genre");
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git

<<<<<<< HEAD
				Book b = new Book(title, author, isbn, publisher, genre);
				list.add(b);
=======
				list.add(new Book(title, isbn, author, publisher, genre));

>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git
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
				String author = rs.getString("b_author");
<<<<<<< HEAD
				Book b = new Book(title, author, isbn);
				list.add(b);
=======
				long isbn = rs.getLong("b_isbn");
				list.add(new Book(title, author, isbn));
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git
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

	public int updateBook(Book selectBook) { // ���� ����
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
				System.out.println("SQL���� Ȯ���ϼ���.");
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
			String sql = "SELECT * FROM BOOK "; // where �������� rank ����ʿ�?
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

		try { // try ~ catch ����ó��

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO loan"
					+ " SELECT ?, ?, ?, ?, ?, ? FROM member m, loan l, book b WHERE m.m_id = l.m_id "
					+ " AND b.b_isbn = l.b_isbn";
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

			File file = new File("C:\\MemberId.txt");
			FileReader file_reader = new FileReader(file);
			int cur = 0;
			while ((cur = file_reader.read()) != -1) {
				psmt.setLong(5, (char) cur);
			}
			File file2 = new File("C:\\BookIsbn.txt");
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

	public ArrayList<Book> selectTitle(String title) { // ���� �˻�

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
	
	public ArrayList<Book> selectAuthor(String title) { // �۰� �˻�

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
	public ArrayList<Book> selectPublisher(String title) { // ���ǻ� �˻�

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
