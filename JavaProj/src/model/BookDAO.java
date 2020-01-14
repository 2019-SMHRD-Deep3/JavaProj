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
	private Connection conn = null; // connection import�ʿ�
	private PreparedStatement psmt = null;
    private ResultSet rs = null;
	
		
		public int insert(Book b) {   
			int rows = 0;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); /// try - ���ܻ��� //catch - ����ó��
				/// surround with try/catch//java���� ����ó��-�������� ����, �����߿� �����ϴ� ����

				conn = DriverManager.getConnection(url, user, password); // ���ӽõ� , �ڵ��� ���� - ĳġ�� ����(�˾�â2��°)
				/// connection - overloading
				// String sql = "insert into member values('kkb2','����',25,1)" ;
				String sql = "insert into Book values(?,?,?,?,?,?)";
				//// ������ �Է¹޾Ƽ� �����Ű�� ��� // ��� ���� ��ü //�ϴ� psmt�� Ȱ��

				psmt = conn.prepareStatement(sql); // �������� ����

				psmt.setString(1, b.getTitle());
				psmt.setString(2, b.getIsbn());    
				psmt.setString(3, b.getAuthor());
				psmt.setString(4, b.getPublisher());
				psmt.setString(5, b.getLoanDate());
				psmt.setString(6, b.getReturnDate());
	
				
				

				rows = psmt.executeUpdate(); /// psmt �غ�� ���� cf select�ÿ��� executeQuery();
//				if(rows == 0) { //rows�� 0�� ���� ������ �ִٴ� �ǹ�
//					System.out.println("SQL���� Ȯ���ϼ���.");
//				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Ŭ���� ��ü�� �����ؼ� �޸𸮿� �÷��ִ� ����
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				/// ���� out�� ���� in�� ��������
				try {
					if (psmt != null)
						psmt.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // error���� --> ó�� ; surround with try/catch

			}

			return rows;
		}
		

		public Book selectOne(Book b) {
			
			Book book = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); /// try - ���ܻ��� //catch - ����ó��
				/// surround with try/catch//java���� ����ó��-�������� ����, �����߿� �����ϴ� ����

				conn = DriverManager.getConnection(url, user, password); // ���ӽõ� , �ڵ��� ���� - ĳġ�� ����(�˾�â2��°)
				/// connection - overloading
				// String sql = "insert into member values('kkb2','����',25,1)" ;
				String sql = "SELECT * FROM Book "+ 
				             "WHERE ISBM = ? TITLE=?";
			    psmt = conn.prepareStatement(sql);
			    psmt.setString(1,b.getIsbn());
			    psmt.setString(2,b.getTitle());
			 
			    rs = psmt.executeQuery();
			  
			    if(rs.next()) {   //���� �� ������ true, false�� ����
					// �ش� ID�� PW�� ���� ����� ����     //�ϴ� �����ͺ��̽��� �ִ� �÷���
			    	String title = rs.getString("title");
			    	String isbn = rs.getString("isbn");
			    	String author = rs.getString("author");
			    	String publisher = rs.getString("publisher");
			    	String loanDate = rs.getString("loanDate");
			    	String returnDate = rs.getString("returnDate");
			    	 
			    	
			        b = new Book (title,isbn,author, publisher);			    	
			    	
				}
				//// ������ �Է¹޾Ƽ� �����Ű�� ��� // ��� ���� ��ü //�ϴ� psmt�� Ȱ��
//				if(rows == 0) { //rows�� 0�� ���� ������ �ִٴ� �ǹ�
//					System.out.println("SQL���� Ȯ���ϼ���.");
//				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Ŭ���� ��ü�� �����ؼ� �޸𸮿� �÷��ִ� ����
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				/// ���� out�� ���� in�� ��������
				try {
					if(rs != null) rs.close();
					if (psmt != null) psmt.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if (conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // error���� --> ó�� ; surround with try/catch

			
			
		}
			return book;
		}

	public ArrayList<Book> selectALL(String title) {
		
		ArrayList<Book> list = new ArrayList<>();

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver"); /// try - ���ܻ��� //catch - ����ó��
		/// surround with try/catch//java���� ����ó��-�������� ����, �����߿� �����ϴ� ����

		conn = DriverManager.getConnection(url, user, password); // ���ӽõ� , �ڵ��� ���� - ĳġ�� ����(�˾�â2��°)
		/// connection - overloading
		// String sql = "insert into book values(?,?,?,?,?,?)" ;
		String sql = "SELECT * FROM MEMBER "+ 
		             "WHERE TITLE != ? ";
	    psmt = conn.prepareStatement(sql);
	    
	    psmt.setString(1,title);
	    
	    rs = psmt.executeQuery();
	  
	    while(rs.next()) { 
			
	    	String title2 = rs.getString("title");	
	    	String isbn = rs.getString("isbn");	    	
	    	String author = rs.getString("author");
	    	String publisher = rs.getString("publisher");
	    	
	         list.add(new Book(title2,isbn,author,publisher));			    	
	    	
		}
		//// ������ �Է¹޾Ƽ� �����Ű�� ��� // ��� ���� ��ü //�ϴ� psmt�� Ȱ��
//		if(rows == 0) { //rows�� 0�� ���� ������ �ִٴ� �ǹ�
//			System.out.println("SQL���� Ȯ���ϼ���.");
//		}

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // Ŭ���� ��ü�� �����ؼ� �޸𸮿� �÷��ִ� ����
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		/// ���� out�� ���� in�� ��������
		try {
			if(rs != null) rs.close();
			if (psmt != null) psmt.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // error���� --> ó�� ; surround with try/catch


	}return list;
		
	}
	private static void update(Book b) {  //�Ű��������� �ϳ��� ��ü(class)�� �����ϰ� ó���ϴ� ����� exam05 ����
		// JDBC Ȱ�����
		// 1. ����� �����ͺ��̽� ȸ���� jar������ ������Ʈ�� import (process ��÷)
		// 2. ������ ���� ������Ʈ ���� �ε�
		// 3. �����ͺ��̽��� ���� --> ���̵�, ��й�ȣ, �����ͺ��̽� �ּ�
		// 4. SQL �ۼ��� ���� ��ü ����
		// 5. SQL ����
		// 6. Select�� ��쿡 ��ü�κ��� ������ ����
		// 7. ��������

		String url = "jdbc:oracle:thin:@localhost:1521:xe"; /// ����Ŭ�翡�� ���س��� �������� ///localhost; ���� ����ǻ�͸� ��Ī/// 1521 //xe
		String user = "hr";
		String password = "hr";
		Connection conn = null; // connection import�ʿ�
		PreparedStatement psmt = null;

		//// 2. ������ ���� ������Ʈ ���� �ε�

		/// OracleDriver driver = new OracleDriver(); ������ ���� compile �����, ���ŷο�
		//// String name = �������Ͽ��� ����̹��� �б�(); �� ��� - ������ �޸��忡 �ִ� ���ڸ� ����, recompile�ҿ�

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); /// try - ���ܻ��� //catch - ����ó��
			/// surround with try/catch//java���� ����ó��-�������� ����, �����߿� �����ϴ� ����

			conn = DriverManager.getConnection(url, user, password); // ���ӽõ� , �ڵ��� ���� - ĳġ�� ����(�˾�â2��°)
			/// connection - overloading
			// String sql = "insert into member values('kkb2','����',25,1)" ;
			String sql = "update book set title = ?, isbn = ?, author = ?, publisher = ?, "
					      + "loanDate = ?, returnDate = ? WHERE USER_id = ?";
			// String sql = "update member set USER_AGE = ? WHERE USER_ID = ?";
			//// ������ �Է¹޾Ƽ� �����Ű�� ��� // ��� ���� ��ü //�ϴ� psmt�� Ȱ��

			psmt = conn.prepareStatement(sql); // �������� ����

			psmt.setString(1, b.getTitle());
			psmt.setString(2, b.getIsbn());
			psmt.setString(3, b.getAuthor());
			psmt.setString(4, b.getPublisher());
			psmt.setString(5, b.getLoanDate());
			psmt.setString(6, b.getReturnDate());

			int rows = psmt.executeUpdate();
			
			if (rows == 0) {
				System.out.println("SQL���� Ȯ���ϼ���.");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Ŭ���� ��ü�� �����ؼ� �޸𸮿� �÷��ִ� ����
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/// ���� out�� ���� in�� ��������
			try {
				if (psmt != null)
					psmt.close();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // error���� --> ó�� ; surround with try/catch

		}
	}

	//// 4. SQL �ۼ��� ���� ��ü ����

	//////// 2. conn �ϴ� �ڵ� ����

	//// 5. ����

	//// 7. �������� //���� ���Ḧ �����ؾ� connection��ü�� out db���� commit ������ java���� ����

	private static String getReturnDate() {
		// TODO Auto-generated method stub
		return null;
	}


	private static String getLoanDate() {
		// TODO Auto-generated method stub
		return null;
	}


	private static String getPublisher() {
		// TODO Auto-generated method stub
		return null;
	}


	private static void delete(Book b) {  //�Ű��������� �ϳ��� ��ü(class)�� �����ϰ� ó���ϴ� ����� exam05 ����
		// JDBC Ȱ�����
		// 1. ����� �����ͺ��̽� ȸ���� jar������ ������Ʈ�� import (process ��÷)
		// 2. ������ ���� ������Ʈ ���� �ε�
		// 3. �����ͺ��̽��� ���� --> ���̵�, ��й�ȣ, �����ͺ��̽� �ּ�
		// 4. SQL �ۼ��� ���� ��ü ����
		// 5. SQL ����
		// 6. Select�� ��쿡 ��ü�κ��� ������ ����
		// 7. ��������

		String url = "jdbc:oracle:thin:@localhost:1521:xe"; /// ����Ŭ�翡�� ���س��� �������� ///localhost; ���� ����ǻ�͸� ��Ī/// 1521 //xe
		String user = "hr";
		String password = "hr";
		Connection conn = null; // connection import�ʿ�
		PreparedStatement psmt = null;

		//// 2. ������ ���� ������Ʈ ���� �ε�

		/// OracleDriver driver = new OracleDriver(); ������ ���� compile �����, ���ŷο�
		//// String name = �������Ͽ��� ����̹��� �б�(); �� ��� - ������ �޸��忡 �ִ� ���ڸ� ����, recompile�ҿ�

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); /// try - ���ܻ��� //catch - ����ó��
			/// surround with try/catch//java���� ����ó��-�������� ����, �����߿� �����ϴ� ����

			conn = DriverManager.getConnection(url, user, password); // ���ӽõ� , �ڵ��� ���� - ĳġ�� ����(�˾�â2��°)
			/// connection - overloading
			// String sql = "insert into member values('kkb2','����',25,1)" ;
			String sql = "delete from  users WHERE USER_id = ?";
			// String sql = "delete from users WHERE USER_ID = ?";
			//// ������ �Է¹޾Ƽ� �����Ű�� ��� // ��� ���� ��ü //�ϴ� psmt�� Ȱ��

			psmt = conn.prepareStatement(sql); // �������� ����

			psmt.setString(1, b.getTitle());
			psmt.setString(2, b.getIsbn());
			psmt.setString(3, b.getAuthor());
			psmt.setString(4, b.getPublisher());
			psmt.setString(5, b.getLoanDate());
			psmt.setString(6, b.getReturnDate());

			int rows = psmt.executeUpdate();
			
			if (rows == 0) {
				System.out.println("SQL���� Ȯ���ϼ���.");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Ŭ���� ��ü�� �����ؼ� �޸𸮿� �÷��ִ� ����
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/// ���� out�� ���� in�� ��������
			try {
				if (psmt != null)
					psmt.close();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // error���� --> ó�� ; surround with try/catch

		}
	}

	//// 4. SQL �ۼ��� ���� ��ü ����

	//////// 2. conn �ϴ� �ڵ� ����

	//// 5. ����

	//// 7. �������� //���� ���Ḧ �����ؾ� connection��ü�� out db���� commit ������ java���� ����

}
