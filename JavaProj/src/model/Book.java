package model;

public class Book {
	private String title;  // ����
	private String book_id; // å��ȣ
	private String author; // �۰�
	private String publisher; // ���ǻ�
	private String loanDate; // ���⳯¥
	private String returnDate; // �ݳ���¥
	
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
