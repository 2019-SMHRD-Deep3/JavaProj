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
				psmt.setString(2, b.getBook_id());
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
				             "WHERE BOOK_ID = ? TITLE=?";
			    psmt = conn.prepareStatement(sql);
			    psmt.setString(1,b.getBook_id());
			    psmt.setString(2,b.getTitle());
			    rs = psmt.executeQuery();
			  
			    if(rs.next()) {   //���� �� ������ true, false�� ����
					// �ش� ID�� PW�� ���� ����� ����     //�ϴ� �����ͺ��̽��� �ִ� �÷���
			    	String title = rs.getString("title");
			    	String book_id = rs.getString("book_id");
			    	String author = rs.getString("author");
			    	String publisher = rs.getString("publisher");
			    	String loanDate = rs.getString("loanDate");
			    	String returnDate = rs.getString("returnDate");
			    	 
			    	
			        b = new Book (title,book_id,author, publisher,loanDate,r);			    	
			    	
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
		// String sql = "insert into book values(?,?,?,?,?,?,?)" ;
		String sql = "SELECT * FROM MEMBER "+ 
		             "WHERE TITLE != ? ";
	    psmt = conn.prepareStatement(sql);
	    
	    psmt.setString(1,title);
	    
	    rs = psmt.executeQuery();
	  
	    while(rs.next()) { 
			
	    	String title2 = rs.getString("title");
	    	
	    	String book_id = rs.getString("book_id");
	    	String publisher = rs.getString("publisher");
	    	String author = rs.getString("author");
	    	
	    	
	         list.add(new Book(title2,book_id,author,publisher));			    	
	    	
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
	
	
	
	
	
	
	

}
