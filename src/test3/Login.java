package test3;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
public class Login{
	MemberVO bmv = new MemberVO();
	Member m = new Member();
	
		
	public Login() {
	}
	//, HashMap<String, MemberVO> mlist
	public boolean memCheck(String id, String pwd, HashMap<String, MemberVO> mlist, HashMap<String, BookVO> blist, BookVO bvo, HashMap<String, BookRequestVO> blist2,BookRequestVO rbvo) {
			
		if(mlist.containsKey(id)) {
			if((mlist.get(id)).getPwd().equals(pwd)) {
				return true;
			}else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				return false;
			}
		}
		else {
			System.out.println("존재하지 않는 아이디 입니다.");
			return false;
		}		
	}

}//end of class
