package controller;

import java.util.ArrayList;

import model.Book;
import model.BookDAO;
import model.BookStDAO;
import model.Member;
import model.MemberDAO;

public class MemberManagementService {
	// 데이터 베이스에 직접 접근: DAO
	private MemberDAO dao = new MemberDAO();
	private BookDAO bdao = new BookDAO();
	private BookStDAO bstdao = new BookStDAO();

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

	public ArrayList<Member> searchId(String id) { // 책 대출할 때 id검색

		return dao.selectId(id);
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

	public ArrayList<Book> mainLookup() { // 도서 메인 전체 보기2

		return bdao.mainALL();
	}

	public ArrayList<Book> CLookup() { // C에서 첫화면 데이터 출력용

		return bdao.selectAll();
	}

	public ArrayList<Book> findTitle(String title) { // 제목 검색

		return bdao.selectTitle(title);
	}

	public ArrayList<Book> findAuthor(String title) { // 작가 검색

		return bdao.selectAuthor(title);
	}

	public ArrayList<Book> findPublisher(String title) { // 출판사 검색

		return bdao.selectPublisher(title);
	}

	public ArrayList<Book> ccLookup() { // c클래스 도서 목록 불러오기

		return bdao.selectSome();
	}

	public Book cReturn(Book b) { // 책반납-선진
		return bdao.returnLoan(b);
	}
	
	public Book cExtension(Book b) { // 대출연장-선진
		return bdao.extensionLoan(b);
	}

	public boolean editBook(Book editBook) { // 도서 정보 수정

		if (bdao.updateBook(editBook) == 0) {
			return false;
		} else {
			return true;
		}
	}

	public ArrayList<Member> bkLookup(String id) { // C에서 id 1명 선택 - 선진
		return dao.selectOneId(id);
	}

	public ArrayList<Member> bkAllLookup() { // C에서 id 전부 선택 - 선진
		return dao.selectAllId();
	}

	public Book loanMember(Book b) { // C에서 책 빌려간 회원 찾기 - 선진
		return bdao.updateLoan(b);
	}

	public ArrayList<Book> bookLookup(String title) {

		return bdao.selectAllBook(title);
	}

	public ArrayList<Book> bookChart(String title) { // Rank5 chart 도식화
		return bstdao.rankFive(title); //
	}

//	public boolean editBook(Book selectBook) { // 회원 정보 수정
//
//		if (bdao.updateLoan(selectBook) == 0) {
//			return false;
//		} else {
//			return true;
//		}
//
//	}

	public boolean rgstBook(Book b) { // 도서 등록

		if (bdao.insertBook(b) == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean delBook(Book b) { // 도서 삭제
		if (bdao.deletebook(b) == 0) {
			return false;
		} else {
			return true;
		}
	}

}
