package test2;

public class Login {
	
	
	private String userid = "12"; //관리자 아이디
	private String userpwd = "12"; //관리자 비밀번호
	//MemverVO에서 key를 아이디로해서 비번을 호출하고 맞는지 확인
	//이 문장 사용 안할거같은데
	
	private String adminid = "admin"; //관리자 아이디
	private String adminpwd = "1234"; //관리자 비밀번호	
	
		
	public Login() {
		
	}
	//회원 가입
	public void join(String userid, String userpwd) {
		this.userid=userid;
		this.userpwd=userpwd;
				
	}
	//MemberVO에서 값을 넘겨받아 아이디에 입력
	public void useridpwd(String userid, String userpwd) {
		this.userid=userid;
		this.userpwd=userpwd;
	}
	
	
	//일반회원 로그인 체크
	public boolean memberCheck(String userid, String userpwd) {
		if(this.userid.equals(userid) && this.userpwd.equals(userpwd)) {
			//회원 가입 후 위에 userid와 userpwd가 수정되도록?
			//회원가입 여러번하면 어떻게?
			//멤버VO에 회원가입한사람 목록 추가하고 아이디로 검색해서 비번이 맞다면 로그인되게?
			//위에 private 유저 아이디 패스워드 부분 말고 memberVO에서 불러서?
			//키로 id를 호출하고 출력된값이 입력된값과 같으면 로그인되게. 수정해야할듯
			return true;
		}else {
			return false;
		}
		
	}

	
	//관리자 로그인 체크
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


//회원 가입 하면 로그인에 아이디 패스워드 들어가게하기,

//MemberVO필요?


//관리자 아이디 생성하기.(기본)

