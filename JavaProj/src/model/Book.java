package model;

import java.sql.Date;

public class Book {
	private String title; // 제목
	private long isbn; // 책번호
	private String author; // 작가
	private String publisher; // 출판사
	private Date loanDate; // 대출날짜
	private Date returnDate; // 반납날짜
	private String isOverdue; // 연체여부
	private String genre; // 장르

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public Book(String title, String author, long isbn, String publisher, String genre) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publisher = publisher;
		this.genre = genre;

	}

	public Book(String title, long isbn, String author, String publisher, Date loanDate, Date returnDate) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.loanDate = loanDate;
		this.returnDate = returnDate;
	}

	public Book(String title, String author, Date loanDate2, Date returnDate2, String isOverdue) {
		super();
		this.title = title;
		this.author = author;
		this.loanDate = loanDate2;
		this.returnDate = returnDate2;
		this.isOverdue = isOverdue;
	}

<<<<<<< HEAD
	public Book(String title, long isbn, String author,String publisher) {
=======
	public Book(String title, String author, long isbn) {
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git
		super();
		this.title = title;
		this.author = author;
<<<<<<< HEAD
		this.publisher = publisher;
=======
		this.isbn = isbn;
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git
	}

	public Book(String title) {
		this.title = title;
	}

	public Book(String title, String author, String publisher, String genre) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
	}

<<<<<<< HEAD
	public Book(String title, String author, long isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		
=======
	public Book(String title, long isbn, String author, String publisher, String genre) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git
	}

	public String getTitle() {
		return title;
	}

	public long getIsbn() {
		return isbn;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public String getIsOverdue() {
		return isOverdue;
	}

<<<<<<< HEAD
	public String getGenre() {		
		return genre;
	}

=======
	public String getGenre() {
		return genre;
	}
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git
}
