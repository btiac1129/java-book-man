package test2;
import java.util.HashMap;

public class MemberList {

	public MemberList() {
	}
	public static HashMap<String, MemberVO> setMemberList() {  
		HashMap<String, MemberVO> mm = new HashMap<String, MemberVO>();
		//���̵� ��й�ȣ �̸� �ּ� ����ó �̸���
		mm.put("jang", new MemberVO(1,"jang", "1111", "�念��", "����� ������", "010-1111-1111", "jang@naver.com"));  
		mm.put("hong", new MemberVO(2,"hong", "2222", "ȫ�浿", "����� ��������", "010-2222-2222", "hong@naver.com"));
		mm.put("lee", new MemberVO(3,"lee", "3333", "�̼���", "����� ���ı�", "010-3333-3333", "lee@naver.com"));
		mm.put("kang", new MemberVO(4,"kang", "4444", "������", "����� ������", "010-4444-4444", "kang@naver.com"));
		mm.put("lee2", new MemberVO(5,"lee2", "5555", "�̼���", "����� ������", "010-5555-5555", "lee2@naver.com"));

		
		return mm;	
		
		

		
	}
	

	

	
	
	
}
