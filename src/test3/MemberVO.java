package test3;
public class MemberVO {
	//아이디, 비밀번호, 이름, 이메일, 연락처
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String tel;
//	private String borrowB;
//	private String reserveB;
	
	public MemberVO() {
		
	}

	public MemberVO(String id, String pwd) {
		this.id=id;
		this.pwd=pwd;
	}
	public MemberVO(String id, String pwd, String name, String email, String tel) {
		this(id, pwd);
		this.name=name;
		this.email=email;
		this.tel=tel;
	}
	
	public void print() {
		System.out.println(id+"\t "+pwd+"\t "+name+"\t "+email+"\t "+tel+"\t ");
	}
	//getter, setter
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
