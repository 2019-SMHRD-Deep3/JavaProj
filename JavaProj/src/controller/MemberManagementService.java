package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Book;
import model.BookDAO;
import model.Member;
import model.MemberDAO;
import view.MMJoin;

public class MemberManagementService {
	// ������ ���̽��� ���� ����: DAO
	private MemberDAO dao = new MemberDAO();
	private BookDAO bdao = new BookDAO();

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
	

	public ArrayList<Book> bookLookup() {

		return bdao.selectSome();
	}


}
