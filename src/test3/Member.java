package test3;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class Member {
	Scanner scan = new Scanner(System.in);

	HashMap<String, MemberVO> mlist = new HashMap<String, MemberVO>();

	// 비번 정규식 - 숫자 최소 1자이상, 영문소문자 최소1자 이상, 특수문자 포함, 최소5~최대15자 허용
	String pwdExp = "^(?=.*[0-9])(?=.*[a-z])(?=.*\\W).{5,15}$";
	// 연락처 정규식
	String telExp = "^010(\\d{4})(\\d{4})$";

	public Member() {
	}

	public String conInput(String msg) {
		System.out.print(msg + "= ");
		return scan.next();
	}

	// 회원 셋팅
	public static HashMap<String, MemberVO> setEmp() {
		HashMap<String, MemberVO> mlist = new HashMap<String, MemberVO>();
		// 아이디, 비밀번호, 이름, 이메일, 연락처, 대여중인 책, 예약한 책
		mlist.put("admin", new MemberVO("admin", "1234qwer!", "관리자", "admin@naver.com", "010-1111-1111"));
		mlist.put("aaa", new MemberVO("aaa", "1111!q", "홍길동", "aaaa@naver.com", "010-1234-1263"));
		mlist.put("bbb", new MemberVO("bbb", "2222!q", "강감찬", "bbbb@naver.com", "010-2222-2222"));
		mlist.put("ccc", new MemberVO("ccc", "3333!q", "이순신", "cccc@naver.com", "010-3333-3333"));
		mlist.put("ddd", new MemberVO("ddd", "4444!q", "세종대왕", "dddd@naver.com", "010-4545-5555"));

		return mlist;

	}

	// 회원 목록 출력//
	public void memList(HashMap<String, MemberVO> mlist) {
		Collection<MemberVO> mValueList = mlist.values();
		Iterator<MemberVO> mi = mValueList.iterator();
		System.out.println("아이디\t비밀번호\t이름\t이메일\t연락처");
		System.out.println("-------------------------------------------------------------------");
		while (mi.hasNext()) {
			mi.next().print();
		}
	}

	// 회원 등록 ,
	public HashMap<String, MemberVO> memAdd(HashMap<String, MemberVO> mlist, MemberVO mv) {

		// 아이디, 비밀번호, 이름, 이메일, 연락처

		a: do {

			String id = conInput("아이디를 입력하세요");
			if (mlist.containsKey(id)) {
				System.out.println("중복된 아이디 입니다.");
				break a;
			} else {
				mv.setId(id);
			}

			do {
				String pwd = conInput("비밀번호를  입력하세요(숫자, 영문자, 특수문자 포함. 5~15자리로 입력)");
				if (!(pwd.matches(pwdExp))) {
					System.out.println("비밀번호 조건과 맞지 않습니다. 조건에 맞춰 입력해주세요.");
				} else {
					String pwd2 = conInput("비밀번호 확인을 위해 다시 입력해주세요.");
					if (pwd.equals(pwd2)) {
						mv.setPwd(pwd);
						break;
					} else {
						System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");

					}
				}
			} while (true);

			String name = conInput("이름을  입력하세요");
			mv.setName(name);

			do {
				String email = conInput("이메일을  입력하세요");
				if (emailCheck(email)) {
					mv.setEmail(email);
					break;
				} else {
					System.out.println("이메일 형식이 아닙니다. 다시 입력해주세요.");
				}
			} while (true);
			do {
				String tel = conInput("연락처를  입력하세요(숫자만 입력)\n");
				if (tel.matches(telExp)) {
					mv.setTel(tel);
					break;
				} else {
					System.out.println("연락처 형식이 아닙니다. 다시 입력해주세요.");
				}
			} while (true);

			mlist.put(id, mv);
			memList(mlist);//출력
			System.out.println(name + "님 가입이 완료되었습니다.\n");
			System.out.println();
			
			break;
		} while (true);
		return mlist;
	}

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

	// 회원 수정
	public void memEdit(HashMap<String, MemberVO> mlist, String id) {

		MemberVO vo = mlist.get(id);

		vo.print();

		// 아이디, 비밀번호, 이름, 이메일, 연락처
		String subMenu = conInput("수정할 항목을 선택하세요.(1: 비밀번호, 2: 이름, 3: 이메일, 4: 연락처)");
		do {
			String data = conInput("수정할 데이터 입력");
			if (subMenu.equals("1")) {
				if (!(data.matches(pwdExp))) {
					System.out.println("비밀번호 조건과 맞지 않습니다. 조건에 맞춰 입력해주세요.");
				} else {
					vo.setPwd(data);
					break;
				}
			} else if (subMenu.equals("2")) {
				vo.setName(data);
				break;
			} else if (subMenu.equals("3")) {

				if (emailCheck(data)) {
					vo.setEmail(data);
					break;
				} else {
					System.out.println("이메일 형식이 아닙니다. 다시 입력해주세요.");
				}

			} else if (subMenu.equals("4")) {

				if (data.matches(telExp)) {
					vo.setTel(data);
					break;
				} else {
					System.out.println("연락처 형식이 아닙니다. 다시 입력해주세요.");
				}

			} else {
				System.out.println("수정할 항목을 잘못 선택 하였습니다.");
			}
		} while (true);

	}// end of memEdit

	// 회원 삭제
	public void memDelete(HashMap<String, MemberVO> mlist) {
		String key = new Library().conInput("삭제할 아이디 입력");
		mlist.remove(key);

	}

}
