package test2;

public class Login {
	
	
	private String userid = "12"; //������ ���̵�
	private String userpwd = "12"; //������ ��й�ȣ
	//MemverVO���� key�� ���̵���ؼ� ����� ȣ���ϰ� �´��� Ȯ��
	//�� ���� ��� ���ҰŰ�����
	
	private String adminid = "admin"; //������ ���̵�
	private String adminpwd = "1234"; //������ ��й�ȣ	
	
		
	public Login() {
		
	}
	//ȸ�� ����
	public void join(String userid, String userpwd) {
		this.userid=userid;
		this.userpwd=userpwd;
				
	}
	//MemberVO���� ���� �Ѱܹ޾� ���̵� �Է�
	public void useridpwd(String userid, String userpwd) {
		this.userid=userid;
		this.userpwd=userpwd;
	}
	
	
	//�Ϲ�ȸ�� �α��� üũ
	public boolean memberCheck(String userid, String userpwd) {
		if(this.userid.equals(userid) && this.userpwd.equals(userpwd)) {
			//ȸ�� ���� �� ���� userid�� userpwd�� �����ǵ���?
			//ȸ������ �������ϸ� ���?
			//���VO�� ȸ�������ѻ�� ��� �߰��ϰ� ���̵�� �˻��ؼ� ����� �´ٸ� �α��εǰ�?
			//���� private ���� ���̵� �н����� �κ� ���� memberVO���� �ҷ���?
			//Ű�� id�� ȣ���ϰ� ��µȰ��� �ԷµȰ��� ������ �α��εǰ�. �����ؾ��ҵ�
			return true;
		}else {
			return false;
		}
		
	}

	
	//������ �α��� üũ
	public boolean adminCheck(String adminid, String adminpwd) {
		if(this.adminid.equals(adminid) && this.adminpwd.equals(adminpwd)) {
			return true;
		}else {
			return false;
		}
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

}


//ȸ�� ���� �ϸ� �α��ο� ���̵� �н����� �����ϱ�,

//MemberVO�ʿ�?


//������ ���̵� �����ϱ�.(�⺻)

