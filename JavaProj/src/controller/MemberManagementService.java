package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Book;
import model.BookDAO;

import model.Member;
import model.MemberDAO;

public class MemberManagementService {
	// 데이터 베이스에 직접 접근: DAO
	private MemberDAO dao = new MemberDAO();
	private BookDAO bdao = new BookDAO();

	public boolean memberJoin(Member m) { // 회원가입
		int row = dao.insert(m);
		if (row == 0) {
			return false;
		} else {
			return true;
		}
	}

	public Member memberLogin(Member m) { // 로그인
		Member loginUser = dao.selectOne(m);
		return loginUser;
	}

	public ArrayList<Member> memberLookup(String id) { // 회원 정보 확인

		return dao.selectAll(id);
	}

	public ArrayList<Member> findName(String name) { // 회원 이름 검색

		return dao.selectName(name);
	}

	public ArrayList<Member> findAddress(String address) { // 회원 주소 검색

		return dao.selectAddress(address);
	}

	public ArrayList<Member> findPhone(String phone) { // 회원 전화번호 검색

		return dao.selectPhone(phone);
	}

	public ArrayList<Member> findId(String id) { // 회원 이름 검색(정보 수정시 아이디클릭)

		return dao.selectName(id);
	}

	public boolean editMember(Member editUser) { // 회원 정보 수정

		if (dao.updateMember(editUser) == 0) {

			return false;
		} else {
			return true;
		}

	}

	public boolean delMember(Member deleteUser) { // 회원 삭제
		if (dao.deleteMember(deleteUser) == 0) {
			return false;
		} else {
			return true;
		}
	}

	public ArrayList<Book> bookLookup(String title) { // 소장도서목록

		return bdao.selectAllBook(title);
	}

	public ArrayList<Book> mainLookup() {

		return bdao.selectMain();
	}

	public ArrayList<Book> CLookup() {

		return bdao.selectAll();
	}

	public ArrayList<Book> findTitle(String title) { // 제목 검색

		return bdao.selectTitle(title);
	}

	public ArrayList<Book> findAuthor(String title) { // 작가 검색

		return bdao.selectAuthor(title);
	}

	public ArrayList<Book> findPublisher(String title) { // 검색

		return bdao.selectPublisher(title);
	}

	public ArrayList<Book> ccLookup() { // c테이블 도서 목록 불러오기

		return bdao.selectSome();
	}

	public boolean editBook(Book editBook) { // 도서 정보 수정

		if (bdao.updateBook(editBook) == 0) {

			return false;
		} else {
			return true;
		}
	}
}