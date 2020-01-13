package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String password = "hr";
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	public int insert(Member m) {
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
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}
	
	public Member selectOne(Member m) {
		Member loginUser = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM member WHERE member_id = ? AND member_pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, m.getId());
			psmt.setString(2, m.getPw());
			rs = psmt.executeQuery();

			if (rs.next()) {
				// 해당 ID와 PW를 가진 사람이 존재
				String id = rs.getString("MEMBER_ID");
				String pw = rs.getString("MEMBER_PW");
				String name = rs.getString("MEMBER_NAME");
				String socialNumber = rs.getString("MEMBER_SOCIALNUMBER");
				String address = rs.getString("MEMBER_ADDRESS");
				String phone = rs.getString("MEMBER_PHONE");

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
	
}
