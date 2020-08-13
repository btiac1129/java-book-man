package Test;
import java.util.HashMap;
import java.util.Scanner;

public class Book {
	MemFunction mf = new MemFunction();
	BookFunction bf= new BookFunction();
	Scanner scan = new Scanner(System.in);
	
	HashMap<String, MemVO> mth = new HashMap<String, MemVO>();
	public Book() {
	}
	public String menuInput(String msg) {
		System.out.print(msg + "\n\n메뉴 선택 : ");
		return scan.next();
	}
	public String conInput(String msg) {
		System.out.print(msg + " : ");
		return scan.next();
	}
	public String lineInput(String msg) {
		System.out.print(msg + " : ");
		return scan.nextLine();
	}
	
	public void start() {
		int loginCnt = 0;
		// 멤버 셋팅
		mth=mf.setMem();
		//mf.setMem();
		System.out.println("====== 도서관리 시스템에 오신 것을 환영합니다 ======");
		a:
		do {
			System.out.println("================ MENU ================");
			String choice = menuInput("1. 로그인 \n2. 회원가입\n3. 프로그램 종료");
			if (choice.equals("1")) {// 로그인
				String id = conInput("아이디");
				String pwd = conInput("비밀번호");
				if (mf.memCheck(id, pwd)) {// 로그인 성공
					bf.bookMenu(id);// 메뉴화면
					break;
				} else {// 로그인 실패
					loginCnt++;
					if (loginCnt >= 3) {// 3번까지 로그인 시도
						System.out.println("프로그램이 종료되었습니다.");
						break a;
					}
				}

			} else if (choice.equals("2")) {// 회원가입	
				mf.memAdd();

			}else if (choice.equals("3")) {// 회원가입	
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			} else {
				System.out.println("번호를 잘못 눌렀습니다. 다시 선택해 주세요.");
			}
			
		}while(true);
		
	}//end of start()	
}
