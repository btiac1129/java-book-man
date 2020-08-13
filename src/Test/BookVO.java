package Test;

public class BookVO {
	//private String isbn;
	
	private String bookName;
	private String writer;
	private String publisher;
	private int publishYear;
	private int bookNum;

	public BookVO() {
	
	}
	public BookVO(String bookName, String writer, String publisher, int publishYear, int bookNum) {
		this.bookName=bookName;
		this.writer=writer;
		this.publisher=publisher;
		this.publishYear=publishYear;
		this.bookNum=bookNum;
	}
	
	public void output() {
		System.out.printf("%20s %10s %10s %4d %3d\n", bookName, writer, publisher, publishYear, bookNum);
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	
	

}
