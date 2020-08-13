package test2;
import java.util.HashMap;

public class MemberList {

	public MemberList() {
	}
	public static HashMap<String, MemberVO> setMemberList() {  
		HashMap<String, MemberVO> mm = new HashMap<String, MemberVO>();
		//아이디 비밀번호 이름 주소 연락처 이메일
		mm.put("jang", new MemberVO(1,"jang", "1111", "장영실", "서울시 강서구", "010-1111-1111", "jang@naver.com"));  
		mm.put("hong", new MemberVO(2,"hong", "2222", "홍길동", "서울시 영등포구", "010-2222-2222", "hong@naver.com"));
		mm.put("lee", new MemberVO(3,"lee", "3333", "이순신", "서울시 송파구", "010-3333-3333", "lee@naver.com"));
		mm.put("kang", new MemberVO(4,"kang", "4444", "강감찬", "서울시 마포구", "010-4444-4444", "kang@naver.com"));
		mm.put("lee2", new MemberVO(5,"lee2", "5555", "이성계", "서울시 강남구", "010-5555-5555", "lee2@naver.com"));

		
		return mm;	
		
		

		
	}
	

	

	
	
	
}
