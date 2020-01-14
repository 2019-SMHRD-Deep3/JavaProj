package model;

public class Book {
	private String title;  // 제목
	private String isbn; // 책번호
	private String author; // 작가
	private String publisher; // 출판사
	private String loanDate; // 대출날짜
	private String returnDate; // 반납날짜
	
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
