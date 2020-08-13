package test2;
public class MemberVO {
	private int num;
	private String id; //ȸ�� ���̵�
	private String pass; //ȸ�� �н�����
	private String name; //ȸ�� �̸�
	private String address; //ȸ�� �ּ�
	private String tel; //ȸ�� ����ó
	private String email; //ȸ�� �̸���
	
	
	public MemberVO() {
	}

	public MemberVO(int num, String id, String pass, String name, String address, String tel, String email) {
		this.num=num;
		this.id=id;
		this.pass=pass;
		this.name=name;
		this.address=address;
		this.tel=tel;
		this.email=email;
	}
	
	
	
	
	
	
	public void output() {//���
		System.out.printf("%6d %12s %12s %6s %20s %15s %20s\n", num, id, pass, name, address, tel, email);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
