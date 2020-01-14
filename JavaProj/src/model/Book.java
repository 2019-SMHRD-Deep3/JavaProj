package model;

public class Book {
	private String title;  // ����
	private String isbn; // å��ȣ
	private String author; // �۰�
	private String publisher; // ���ǻ�
	private String loanDate; // ���⳯¥
	private String returnDate; // �ݳ���¥
	
	public Book(String title, String isbn, String author, String publisher) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
	}

	public Book(String title, String isbn, String author, String publisher, String loanDate,
			String returnDate) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.loanDate = loanDate;
		this.returnDate = returnDate;
	}

	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public String getReturnDate() {
		return returnDate;
	}
	
	
	
	
}
