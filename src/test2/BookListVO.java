package test2;
public class BookListVO {
	private int num; //������ȣ
	private String name; //��������
	private String author; //�۰�, ������
	private int year; //����⵵
	private String genre; //�帣
	private String rental; // ������Ȳ ////�����û, �ݳ��ϸ� ��Ȳ�� ǥ�� ��ġ��, ������ ���� �߰� �����. 

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
		
		System.out.println("<���� ��ȣ> : "+num+"\n<������>   : "+name+"\n<����>    : "+author+"\n<����⵵> : "+year+"\n<�帣>    : "+genre+"\n<��ġ����> : "+rental);
		
	}

	public void output() { //������� ���
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
