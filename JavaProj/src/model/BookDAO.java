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
	private Connection conn = null; // connection import필요
	private PreparedStatement psmt = null;
    private ResultSet rs = null;
	
		
		public int insert(Book b) {
			int rows = 0;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); /// try - 예외색출 //catch - 예외처리
				/// surround with try/catch//java에서 예외처리-문법외의 에러, 실행중에 발행하는 에러

				conn = DriverManager.getConnection(url, user, password); // 접속시도 , 코딩후 에러 - 캐치블럭 설정(팝업창2번째)
				/// connection - overloading
				// String sql = "insert into member values('kkb2','김김김',25,1)" ;
				String sql = "insert into Book values(?,?,?,?,?,?)";
				//// 정보를 입력받아서 실행시키는 방법 // 상기 문장 대체 //하단 psmt문 활용

				psmt = conn.prepareStatement(sql); // 지역변수 생성

				psmt.setString(1, b.getTitle());
				psmt.setString(2, b.getBook_id());
				psmt.setString(3, b.getAuthor());
				psmt.setString(4, b.getPublisher());
				psmt.setString(5, b.getLoanDate());
				psmt.setString(6, b.getReturnDate());
				
				

				rows = psmt.executeUpdate(); /// psmt 준비시 실행 cf select시에는 executeQuery();
//				if(rows == 0) { //rows가 0인 경우는 문제가 있다는 의미
//					System.out.println("SQL문을 확인하세요.");
//				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 클래스 객체를 생성해서 메모리에 올려주는 역할
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				/// 접속 out은 접속 in의 역순으로
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
				} // error에러 --> 처리 ; surround with try/catch

			}

			return rows;
		}

		public Book selectOne(Book b) {
			
			Book book = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); /// try - 예외색출 //catch - 예외처리
				/// surround with try/catch//java에서 예외처리-문법외의 에러, 실행중에 발행하는 에러

				conn = DriverManager.getConnection(url, user, password); // 접속시도 , 코딩후 에러 - 캐치블럭 설정(팝업창2번째)
				/// connection - overloading
				// String sql = "insert into member values('kkb2','김김김',25,1)" ;
				String sql = "SELECT * FROM Book "+ 
				             "WHERE BOOK_ID = ? TITLE=?";
			    psmt = conn.prepareStatement(sql);
			    psmt.setString(1,b.getBook_id());
			    psmt.setString(2,b.getTitle());
			    rs = psmt.executeQuery();
			  
			    if(rs.next()) {   //다음 줄 유무를 true, false로 전달
					// 해당 ID와 PW를 가진 사람이 존재     //하단 데이터베이스에 있는 컬럼명
			    	String title = rs.getString("title");
			    	String book_id = rs.getString("book_id");
			    	String author = rs.getString("author");
			    	String publisher = rs.getString("publisher");
			    	String loanDate = rs.getString("loanDate");
			    	String returnDate = rs.getString("returnDate");
			    	 
			    	
			        b = new Book (title,book_id,author, publisher,loanDate,r);			    	
			    	
				}
				//// 정보를 입력받아서 실행시키는 방법 // 상기 문장 대체 //하단 psmt문 활용
//				if(rows == 0) { //rows가 0인 경우는 문제가 있다는 의미
//					System.out.println("SQL문을 확인하세요.");
//				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 클래스 객체를 생성해서 메모리에 올려주는 역할
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				/// 접속 out은 접속 in의 역순으로
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
				} // error에러 --> 처리 ; surround with try/catch

			
			
		}
			return book;
		}

	public ArrayList<Book> selectALL(String title) {
		
		ArrayList<Book> list = new ArrayList<>();

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver"); /// try - 예외색출 //catch - 예외처리
		/// surround with try/catch//java에서 예외처리-문법외의 에러, 실행중에 발행하는 에러

		conn = DriverManager.getConnection(url, user, password); // 접속시도 , 코딩후 에러 - 캐치블럭 설정(팝업창2번째)
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
		//// 정보를 입력받아서 실행시키는 방법 // 상기 문장 대체 //하단 psmt문 활용
//		if(rows == 0) { //rows가 0인 경우는 문제가 있다는 의미
//			System.out.println("SQL문을 확인하세요.");
//		}

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // 클래스 객체를 생성해서 메모리에 올려주는 역할
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		/// 접속 out은 접속 in의 역순으로
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
		} // error에러 --> 처리 ; surround with try/catch


	}return list;
		
	}
	
	
	
	
	
	
	

}
