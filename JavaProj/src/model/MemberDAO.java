package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
   private String url = "jdbc:oracle:thin:@localhost:1521:xe";
   private String user = "hr";
   private String password = "hr";
   private Connection conn = null;
   private PreparedStatement psmt = null;
   private ResultSet rs = null;

   public int insert(Member m) { // �����ϱ�
      int rows = 0;
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(url, user, password);
         String sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?, ?)";
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, m.getId());
         psmt.setString(2, m.getPw());
         psmt.setString(3, m.getName());
         psmt.setString(4, m.getSocialNumber());
         psmt.setString(5, m.getAddress());
         psmt.setString(6, m.getPhone());
         rows = psmt.executeUpdate();
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
            if (conn != null)
               conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return rows;
   }

   public Member selectOne(Member m) { // �α����ϱ�
      Member loginUser = null;

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(url, user, password);
         String sql = "SELECT * FROM member WHERE m_id = ? AND m_pw = ?";
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, m.getId());
         psmt.setString(2, m.getPw());
         rs = psmt.executeQuery();

         if (rs.next()) {
            String id = rs.getString("M_ID");
            String pw = rs.getString("M_PW");
            String name = rs.getString("M_NAME");
            String socialNumber = rs.getString("M_SOCIALNUMBER");
            String address = rs.getString("M_ADDRESS");
            String phone = rs.getString("M_PHONE");

            loginUser = new Member(id, pw, name, socialNumber, address, phone);
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
            if (conn != null)
               conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return loginUser;
   }
   
   public  int updateMember(Member selectUser) {  // ȸ�� ����
	   int rows = 0;
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "hr";
      String password = "hr";
      Connection conn = null;
      PreparedStatement psmt = null;
      
      try { // try ~ catch ����ó��
          Class.forName("oracle.jdbc.driver.OracleDriver");
          conn = DriverManager.getConnection(url, user, password);
          String sql = "UPDATE member SET m_name = ?, m_pw = ?, m_address = ?, m_phone = ? WHERE m_name = ?";
          psmt = conn.prepareStatement(sql);         
          psmt.setString(1, selectUser.getName());
          psmt.setString(2, selectUser.getPw());         
          psmt.setString(3, selectUser.getAddress());
          psmt.setString(4, selectUser.getPhone());
          psmt.setString(5, selectUser.getName());
          System.out.println(selectUser.getName());
          System.out.println(selectUser.getPw());
          System.out.println(selectUser.getAddress());
          System.out.println(selectUser.getPhone());
          System.out.println(selectUser.getName());
          
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


   
    public static int deleteMember(Member deleteUser) { //ȸ�� ����
    	 int rows = 0;
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         String user = "hr";
         String password = "hr";
         Connection conn = null;
         PreparedStatement psmt = null;

         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password); // �굵 try catch�� ����. connection�� �������̽�
            String sql = "DELETE FROM member WHERE m_id = ? AND m_pw =?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, deleteUser.getId());            
            psmt.setString(2, deleteUser.getPw());            
            System.out.println(deleteUser.getId());            

            rows = psmt.executeUpdate(); // ����. �� ���忡 ������� rows�� ���ϵȴ�. �� ���̴ϱ� 1 / ����Ʈ�� 3���� �����Ǹ� 3
            if (rows == 0) {
               System.out.println("SQL���� Ȯ���ϼ���.");
            }
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         } catch (SQLException e) { // id,���,url���� Ʋ���� ��
            e.printStackTrace();
         } finally {
            // ���� ���߿� �� �ͺ��� �ݴ´�.
            try {
               if (psmt != null) // ��ü�� ������������ �ݾƾ��Ѵ�.
                  psmt.close();

               if (conn != null)
                  conn.close();

            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         return rows;
         
    }
    
    public ArrayList<Member> selectAll(String login_id) { 
         ArrayList<Member> list = new ArrayList<>();

         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM member WHERE m_id != ?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, login_id);
            rs = psmt.executeQuery();

            while (rs.next()) {
               String id = rs.getString("M_ID");
               String name = rs.getString("M_NAME");
               String socialNumber = rs.getString("M_SOCIALNUMBER");
               String address = rs.getString("M_ADDRESS");
               String phone = rs.getString("M_PHONE");
               String pw = rs.getString("M_PW");                  

               list.add(new Member(id, name, socialNumber,address,phone,pw));
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
               if (conn != null)
                  conn.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         return list;
      }
    
    public static ArrayList<Member> selectName(String login_id) { //�̸� �˻� ��� 
         ArrayList<Member> list = new ArrayList<>();
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         String user = "hr";
         String password = "hr";
         Connection conn = null;
         PreparedStatement psmt = null;
         ResultSet rs = null; // �������̽�(ResultSet)

         try { // ���� ���� ��Ƴ� �� �ִ� ���� ó��
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * FROM member WHERE m_name like '%' || ? || '%' ";
            psmt = conn.prepareStatement(sql);   
            psmt.setString(1, login_id);
            rs = psmt.executeQuery();
            // ���� �о�帱���� �ִ��� ����� ��(��� Ŀ���� �������鼭 �д� ����)

            while (rs.next()) {
               String id = rs.getString("M_ID");
               String name = rs.getString("M_NAME");
               String socialNumber = rs.getString("M_SOCIALNUMBER");
               String address = rs.getString("M_ADDRESS");
               String phone = rs.getString("M_PHONE");
               String pw = rs.getString("M_PW");

               Member m = new Member(id, name, socialNumber, address, phone, pw);
               list.add(m);               
            }
            
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         } catch (SQLException e) { // id,���,url���� Ʋ���� ��
            e.printStackTrace();
         } finally {
            try {
               if (psmt != null) // ��ü�� ������������ �ݾƾ��Ѵ�.
                  psmt.close();

               if (conn != null)
                  conn.close();

            } catch (SQLException e) {
               e.printStackTrace();
            }
         }

         return list;
      }
    
    public static ArrayList<Member> selectAddress(String login_id) { //�ּ� �˻� ��� 
         ArrayList<Member> list = new ArrayList<>();
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         String user = "hr";
         String password = "hr";
         Connection conn = null;
         PreparedStatement psmt = null;
         ResultSet rs = null; // �������̽�(ResultSet)

         try { // ���� ���� ��Ƴ� �� �ִ� ���� ó��
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * FROM member WHERE m_address like '%' || ? || '%' ";
            psmt = conn.prepareStatement(sql);   
            psmt.setString(1, login_id);
            rs = psmt.executeQuery();
            // ���� �о�帱���� �ִ��� ����� ��(��� Ŀ���� �������鼭 �д� ����)

            while (rs.next()) {
               String id = rs.getString("M_ID");
               String name = rs.getString("M_NAME");
               String socialNumber = rs.getString("M_SOCIALNUMBER");
               String address = rs.getString("M_ADDRESS");
               String phone = rs.getString("M_PHONE");
               String pw = rs.getString("M_PW");

               Member m = new Member(id, name, socialNumber, address, phone, pw);
               list.add(m);               
            }
            
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         } catch (SQLException e) { // id,���,url���� Ʋ���� ��
            e.printStackTrace();
         } finally {
            try {
               if (psmt != null) // ��ü�� ������������ �ݾƾ��Ѵ�.
                  psmt.close();

               if (conn != null)
                  conn.close();

            } catch (SQLException e) {
               e.printStackTrace();
            }
         }

         return list;
      }
    
    public static ArrayList<Member> selectPhone(String login_id) { //��ȭ��ȣ �˻� ��� 
         System.out.println(login_id);
       ArrayList<Member> list = new ArrayList<>();
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         String user = "hr";
         String password = "hr";
         Connection conn = null;
         PreparedStatement psmt = null;
         ResultSet rs = null; // �������̽�(ResultSet)

         try { // ���� ���� ��Ƴ� �� �ִ� ���� ó��
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * FROM member WHERE m_phone like '%' || ? || '%' ";
            psmt = conn.prepareStatement(sql);   
            psmt.setString(1, login_id);
            rs = psmt.executeQuery();
            // ���� �о�帱���� �ִ��� ����� ��(��� Ŀ���� �������鼭 �д� ����)

            while (rs.next()) {
               String id = rs.getString("M_ID");
               String name = rs.getString("M_NAME");
               String socialNumber = rs.getString("M_SOCIALNUMBER");
               String address = rs.getString("M_ADDRESS");
               String phone = rs.getString("M_PHONE");
               String pw = rs.getString("M_PW");

               Member m = new Member(id, name, socialNumber, address, phone, pw);
               list.add(m);               
            }
            
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         } catch (SQLException e) { // id,���,url���� Ʋ���� ��
            e.printStackTrace();
         } finally {
            try {
               if (psmt != null) // ��ü�� ������������ �ݾƾ��Ѵ�.
                  psmt.close();

               if (conn != null)
                  conn.close();

            } catch (SQLException e) {
               e.printStackTrace();
            }
         }

         return list;
      }







}