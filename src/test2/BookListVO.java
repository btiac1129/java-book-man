package test2;
public class BookListVO {
	private int num; //도서번호
	private String name; //도서제목
	private String author; //작가, 지은이
	private int year; //발행년도
	private String genre; //장르
	private String rental; // 대출현황 ////대출신청, 반납하면 현황에 표시 비치중, 대출중 으로 뜨게 만들기. 

	public BookListVO() {
	}
	
	public BookListVO(int num, String name, String author, int year, String genre, String rental) {
		this.num=num;
		this.name=name;
		this.author=author;
		this.year=year;
		this.genre=genre;
		this.rental=rental;
	} 
	public void print() {
		
		System.out.println("<도서 번호> : "+num+"\n<도서명>   : "+name+"\n<저자>    : "+author+"\n<발행년도> : "+year+"\n<장르>    : "+genre+"\n<비치여부> : "+rental);
		
	}

	public void output() { //도서목록 출력
		System.out.printf("| %4d | %20s | %8s | %4d | %5s | %5s |\n", num, name, author, year, genre, rental);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRental() {
		return rental;
	}

	public void setRental(String rental) {
		this.rental = rental;
	}
	
}
