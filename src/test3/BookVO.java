package test3;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BookVO {
	private String bookName;
	private String writer;
	private String publisher;
	private int publishYear;
	private int bookNum;
	//private String introduce;
	//private int borrowNum;
	
	//private String borrowID;
	//private String[] reserveID;
	
/*
	private int borrow;
	private int returnDay;// 반납예정일
	private int reserve;

	
	*/
	
	
	public BookVO() {}

	//책 제목, 저자, 출판사, 출판년도, 분류번호
	public BookVO(String bookName, String writer, String publisher, int publishYear, int bookNum) {
		this.bookName=bookName;
		this.writer=writer;
		this.publisher=publisher;
		this.publishYear=publishYear;
		this.bookNum=bookNum;
	}
	
	

	
	public void output() {
		
		System.out.printf("%-20s %-10s %-10s %-5d %-5d \n", bookName, writer, publisher, publishYear, bookNum);
		
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
