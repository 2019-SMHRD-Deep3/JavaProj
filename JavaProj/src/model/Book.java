package model;

import java.sql.Date;

public class Book {
	private String title; // ����
	private int isbn; // å��ȣ
	private String author; // �۰�
	private String publisher; // ���ǻ�
	private Date loanDate; // ���⳯¥
	private Date returnDate; // �ݳ���¥
	private String isOverdue; // ��ü����
	private String Genre; // �帣

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public Book(String title, int isbn, String author, String publisher) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		
	}

	public Book(String title, int isbn, String author, String publisher, Date loanDate,
			Date returnDate) {
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

	public Book(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public int getIsbn() {
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

}
