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
				psmt.setString(2, b.getIsbn());    
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
				             "WHERE ISBM = ? TITLE=?";
			    psmt = conn.prepareStatement(sql);
			    psmt.setString(1,b.getIsbn());
			    psmt.setString(2,b.getTitle());
			 
			    rs = psmt.executeQuery();
			  
			    if(rs.next()) {   //다음 줄 유무를 true, false로 전달
					// 해당 ID와 PW를 가진 사람이 존재     //하단 데이터베이스에 있는 컬럼명
			    	String title = rs.getString("title");
			    	String isbn = rs.getString("isbn");
			    	String author = rs.getString("author");
			    	String publisher = rs.getString("publisher");
			    	String loanDate = rs.getString("loanDate");
			    	String returnDate = rs.getString("returnDate");
			    	 
			    	
			        b = new Book (title,isbn,author, publisher);			    	
			    	
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
	private static void update(Book b) {  //매개변수들을 하나의 객체(class)로 간주하고 처리하는 방법은 exam05 참조
		// JDBC 활용순서
		// 1. 사용할 데이터베이스 회사의 jar파일을 프로젝트에 import (process 별첨)
		// 2. 접속을 위한 프로젝트 파일 로딩
		// 3. 데이터베이스에 접속 --> 아이디, 비밀번호, 데이터베이스 주소
		// 4. SQL 작성을 돕는 객체 생성
		// 5. SQL 실행
		// 6. Select의 경우에 객체로부터 데이터 추출
		// 7. 접속종료

		String url = "jdbc:oracle:thin:@localhost:1521:xe"; /// 오라클사에서 정해놓은 버전정보 ///localhost; 현재 내컴퓨터를 지칭/// 1521 //xe
		String user = "hr";
		String password = "hr";
		Connection conn = null; // connection import필요
		PreparedStatement psmt = null;

		//// 2. 접속을 위한 프로젝트 파일 로딩

		/// OracleDriver driver = new OracleDriver(); 수정시 직접 compile 수행요, 번거로움
		//// String name = 설정파일에서 드라이버명 읽기(); 이 경우 - 수정시 메모장에 있는 글자만 변경, recompile불요

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); /// try - 예외색출 //catch - 예외처리
			/// surround with try/catch//java에서 예외처리-문법외의 에러, 실행중에 발행하는 에러

			conn = DriverManager.getConnection(url, user, password); // 접속시도 , 코딩후 에러 - 캐치블럭 설정(팝업창2번째)
			/// connection - overloading
			// String sql = "insert into member values('kkb2','김김김',25,1)" ;
			String sql = "update book set title = ?, isbn = ?, author = ?, publisher = ?, "
					      + "loanDate = ?, returnDate = ? WHERE USER_id = ?";
			// String sql = "update member set USER_AGE = ? WHERE USER_ID = ?";
			//// 정보를 입력받아서 실행시키는 방법 // 상기 문장 대체 //하단 psmt문 활용

			psmt = conn.prepareStatement(sql); // 지역변수 생성

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
	}

	//// 4. SQL 작성을 돕는 객체 생성

	//////// 2. conn 하단 코딩 참조

	//// 5. 실행

	//// 7. 접속종료 //접속 종료를 수행해야 connection객체도 out db에서 commit 수행후 java에서 실행

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


	private static void delete(Book b) {  //매개변수들을 하나의 객체(class)로 간주하고 처리하는 방법은 exam05 참조
		// JDBC 활용순서
		// 1. 사용할 데이터베이스 회사의 jar파일을 프로젝트에 import (process 별첨)
		// 2. 접속을 위한 프로젝트 파일 로딩
		// 3. 데이터베이스에 접속 --> 아이디, 비밀번호, 데이터베이스 주소
		// 4. SQL 작성을 돕는 객체 생성
		// 5. SQL 실행
		// 6. Select의 경우에 객체로부터 데이터 추출
		// 7. 접속종료

		String url = "jdbc:oracle:thin:@localhost:1521:xe"; /// 오라클사에서 정해놓은 버전정보 ///localhost; 현재 내컴퓨터를 지칭/// 1521 //xe
		String user = "hr";
		String password = "hr";
		Connection conn = null; // connection import필요
		PreparedStatement psmt = null;

		//// 2. 접속을 위한 프로젝트 파일 로딩

		/// OracleDriver driver = new OracleDriver(); 수정시 직접 compile 수행요, 번거로움
		//// String name = 설정파일에서 드라이버명 읽기(); 이 경우 - 수정시 메모장에 있는 글자만 변경, recompile불요

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); /// try - 예외색출 //catch - 예외처리
			/// surround with try/catch//java에서 예외처리-문법외의 에러, 실행중에 발행하는 에러

			conn = DriverManager.getConnection(url, user, password); // 접속시도 , 코딩후 에러 - 캐치블럭 설정(팝업창2번째)
			/// connection - overloading
			// String sql = "insert into member values('kkb2','김김김',25,1)" ;
			String sql = "delete from  users WHERE USER_id = ?";
			// String sql = "delete from users WHERE USER_ID = ?";
			//// 정보를 입력받아서 실행시키는 방법 // 상기 문장 대체 //하단 psmt문 활용

			psmt = conn.prepareStatement(sql); // 지역변수 생성

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
	}

	//// 4. SQL 작성을 돕는 객체 생성

	//////// 2. conn 하단 코딩 참조

	//// 5. 실행

	//// 7. 접속종료 //접속 종료를 수행해야 connection객체도 out db에서 commit 수행후 java에서 실행

}
