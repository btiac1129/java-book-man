package Test;

import java.util.ArrayList;

public class MemVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String tel;
	private ArrayList<Book> loanRecord = new ArrayList();
	private ArrayList<Book> booksOnLoan = new ArrayList();
	
	public MemVO() {		
	}
	public MemVO(String id, String pwd, String name, String email, String tel) {
		this.id =id;
		this.pwd = pwd;
		this.name=name;
		this.email=email;
		this.tel=tel;		
	}
	public void output() {
		System.out.printf("%10s %10s %10s %20s %13s", id, pwd, name, email, tel);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

}
