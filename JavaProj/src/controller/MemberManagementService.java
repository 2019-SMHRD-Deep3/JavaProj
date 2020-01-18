package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Book;
import model.BookDAO;

import model.Member;
import model.MemberDAO;

public class MemberManagementService {
	// ������ ���̽��� ���� ����: DAO
	private MemberDAO dao = new MemberDAO();
	private BookDAO bdao = new BookDAO();

	public boolean memberJoin(Member m) { // ȸ������
		int row = dao.insert(m);
		if (row == 0) {
			return false;
		} else {
			return true;
		}
	}

	public Member memberLogin(Member m) { // �α���
		Member loginUser = dao.selectOne(m);
		return loginUser;
	}

	public ArrayList<Member> memberLookup(String id) { // ȸ�� ���� Ȯ��

		return dao.selectAll(id);
	}

	public ArrayList<Member> findName(String name) { // ȸ�� �̸� �˻�

		return dao.selectName(name);
	}

	public ArrayList<Member> findAddress(String address) { // ȸ�� �ּ� �˻�

		return dao.selectAddress(address);
	}

	public ArrayList<Member> findPhone(String phone) { // ȸ�� ��ȭ��ȣ �˻�

		return dao.selectPhone(phone);
	}

	public ArrayList<Member> findId(String id) { // ȸ�� �̸� �˻�(���� ������ ���̵�Ŭ��)

		return dao.selectName(id);
	}

	public boolean editMember(Member editUser) { // ȸ�� ���� ����

		if (dao.updateMember(editUser) == 0) {

			return false;
		} else {
			return true;
		}

	}

	public boolean delMember(Member deleteUser) { // ȸ�� ����
		if (dao.deleteMember(deleteUser) == 0) {
			return false;
		} else {
			return true;
		}
	}

	public ArrayList<Book> bookLookup(String title) { // ���嵵�����

		return bdao.selectAllBook(title);
	}

	public ArrayList<Book> mainLookup() {

		return bdao.selectMain();
	}

	public ArrayList<Book> CLookup() {

		return bdao.selectAll();
	}

	public ArrayList<Book> findTitle(String title) { // ���� �˻�

		return bdao.selectTitle(title);
	}

	public ArrayList<Book> findAuthor(String title) { // �۰� �˻�

		return bdao.selectAuthor(title);
	}

	public ArrayList<Book> findPublisher(String title) { // �˻�

		return bdao.selectPublisher(title);
	}

	public ArrayList<Book> ccLookup() { // c���̺� ���� ��� �ҷ�����

		return bdao.selectSome();
	}

	public boolean editBook(Book editBook) { // ���� ���� ����

		if (bdao.updateBook(editBook) == 0) {

			return false;
		} else {
			return true;
		}
	}
}