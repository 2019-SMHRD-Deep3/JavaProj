package controller;


import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import model.Member;
import model.MemberDAO;

public class MemberManagementService {
	// 데이터 베이스에 직접 접근: DAO
	private MemberDAO dao = new MemberDAO();

	public boolean memberJoin(Member m) {
		int row = dao.insert(m);
		if (row == 0) {
			return false;
		} else {
			return true;
		}
	}

	public Member memberLogin(Member m) {
		Member loginUser = dao.selectOne(m);
		return loginUser;
	}
	
    public ArrayList<Member> memberLookup(String id) {
		
		return dao.selectAll(id);
	}


}
