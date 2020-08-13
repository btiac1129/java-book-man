package Test;
import java.util.HashMap;
import java.util.Hashtable;

public class MemFunction {
	HashMap<String, MemVO> mth = new HashMap<String, MemVO>();
	
	public MemFunction() {
	}

	//
	public HashMap<String, MemVO> setMem() {
		//HashMap<String, MemVO> mth = new HashMap<String, MemVO>();
		mth.put("admin", new MemVO("admin", "1234", "관리자", "admin@naver.com", "010-1111-1111"));
		mth.put("aaaa", new MemVO("aaaa", "1111", "홍길동", "sadfsadf@naver.com", "010-1234-1324"));
		mth.put("bbbb", new MemVO("bbbb", "2222", "강감찬", "bbbbbb@naver.com", "010-2222-2222"));
		mth.put("cccc", new MemVO("cccc", "3333", "이순신", "cccddc@naver.com", "010-3333-3333"));
		mth.put("dddd", new MemVO("dddd", "4444", "세종대왕", "dddddd@naver.com", "010-4545-5555"));

		return mth;
	}
	//로그인
	public boolean memCheck(String id, String pwd) {
		if(mth.containsKey(id)) {
			if((mth.get(id)).getPwd().equals(pwd)) {
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

	// 회원가입
	public void memAdd() {
		Book b = new Book();
		// 아이디, 비밀번호, 이름, 이메일, 연락처
		do {
			String id = b.conInput("아이디를 입력하세요");
			if (mth.containsKey(id)) {
				System.out.println("중복된 아이디 입니다. 다시 입력해주세요.");
			} else {
				String pwd = b.conInput("비밀번호를  입력하세요"); 
				String pwd2 = b.conInput("비밀번호를 한번 더 입력하세요");
				if (!(pwd.equals(pwd2))) {
					System.out.println("비밀번호가 다릅니다.");
				} else {
					String name = b.conInput("이름을  입력하세요");
					String email = b.conInput("이메일을  입력하세요");
					if (emailCheck(email)) {
						String tel = b.conInput("전화번호를  입력하세요");

						MemVO mvo = new MemVO(id, pwd, name, email, tel);
						mth.put(id, mvo);
						System.out.println(name + "님 가입이 완료되었습니다.");
						break;
					} else {
						System.out.println("잘못된 형식입니다. 처음부터 다시 입력하세요.");
					}//이메일 확인 else
				} // 비번확인 else
			}
		} while (true);
	}// memAdd
		
	// 이메일 확인
	public boolean emailCheck(String email) {
		int atMark = email.indexOf("@");// @위치의 index를 구하고 없을 경우는 -1이 구해짐.
		int point = email.indexOf(".");// .위치 구하기

		if (atMark < 4 || point < 6 || point < atMark || point - atMark < 2 || atMarkCount(email, '@') != 1
				|| atMarkCount(email, '.') > 2) {
			return false;
		} else {
			return true;
		}
	}

	public int atMarkCount(String email, char str) {
		int cnt = 0;
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == str) {
				cnt++;
			}
		}
		return cnt;
	}
}
