package controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import model.Member;
import model.MemberDAO;
import view.MMJoin;

public class MemberManagementService {
	// ������ ���̽��� ���� ����: DAO
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


}
