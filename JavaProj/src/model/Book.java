package model;

public class Book {
	private String title;  // 제목
	private String book_id; // 책번호
	private String author; // 작가
	private String publisher; // 출판사
	private String loanDate; // 대출날짜
	private String returnDate; // 반납날짜
	
	public Book(String title, String book_id, String author, String publisher) {
		super();
		this.title = title;
		this.book_id = book_id;
		this.author = author;
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public String getBook_id() {
		return book_id;
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
