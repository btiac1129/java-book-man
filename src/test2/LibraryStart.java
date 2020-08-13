package test2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Calendar;


public class LibraryStart {
	Scanner scan = new Scanner(System.in);
	HashMap<String, BookListVO> list = new HashMap<String, BookListVO>();
	HashMap<String, MemberVO> list2 = new HashMap<String, MemberVO>();
	TreeMap<String, String> list3 = new TreeMap<String, String>(); //시간별로 대여현황 갱신
	TreeMap<String, String> list4 = new TreeMap<String, String>(); //개인대여현황
	List<MemberVO> data2 = new  ArrayList<MemberVO>(); //중복검사
	List<BookListVO> data4 = new  ArrayList<BookListVO>();	//도서 전체 대출현황 
	List<BookListVO> data5 = new  ArrayList<BookListVO>();  //도서목록 호출
	
	Calendar now = Calendar.getInstance();	
	
	Login login = new Login();
	int membernum = 6; //현재 회원 수
	String userid;
	String userpwd;
	int cnt = 5; //회원가입할때 1추가 회원삭제할때 -1
	int bookcnt = 12; //책 추가할때 1추가 삭제할때 -1
	int mybook = 0; //내가 대여한 도서 수
	int ex = 0; //회원탈퇴시 첫화면으로	
	String loginid; //로그인시 여기에 현재 접속한 아이디 저장
	String treenum; //대여 시간 저장
	int treenum2 = 1;  //treemap key값 중복 방지를 위해 번호부여 
	String treenum3; // 반납 예정 시간
	

	
	public LibraryStart() {
		int loginCnt = 0; //로그인 횟수
		list = BookList.setBook(); //도서목록 확인 초기화.. 위치이동?
		list2 = MemberList.setMemberList();
		
		do {//비회원 둘러보기
			System.out.println("----------------------------------------------");
			String menu = conInput("1.도서목록   2.도서검색   3.로그인   4.회원가입   5.종료");
			if(menu.equals("1")) { //1. 도서목록 호출
				bookList(); 
			}else if(menu.equals("2")) { //2. 도서검색
				bookListSearch();
			}else if(menu.equals("3")) { //3. 로그인
				int out=3;
				a: //초기화면
				do {
					memberlogin();  //회원 정보를 이용해 로그인
					String userpwd = conInput("패스워드 입력");
					if(login.memberCheck(userid, userpwd)) {
						list4.clear();
						System.out.println("---------------------------------------------------------------------------------------");
						System.out.println(" ------------------------------------로그인 되었습니다.------------------------------------ ");						
						do { //일반회원
							System.out.println("---------------------------------------------------------------------------------------");
							String menu2 = conInput("1.도서목록   2.도서검색   3.도서대출신청   4.도서반납   5.대출현황   6.개인정보수정   7.로그아웃   8.회원탈퇴   9.종료");
							if(menu2.equals("1")) { //1. 도서목록 호출
								bookList(); 
							}else if(menu2.equals("2")) { //2. 도서검색
								bookListSearch();
							}else if(menu2.equals("3")) { //3. 대출신청
								String rent = conInput("대여할 도서명");
								
								//목록 받아서 대출중으로 바꾸고, 대출현황에 추가.
								if(cc(rent)==true) {
									bookrent(rent);	
								}
															
							}else if(menu2.equals("4")) { //도서 반납
								String rent = conInput("반납할 도서명");
								
								if(dd(rent)==true) {
									bookreturn(rent);	
								}else {
									System.out.println("대여하지 않았거나 없는 도서입니다.");
								}
							}else if(menu2.equals("5")) { //대출 현황
								for(String i : list4.keySet()){ //저장된 key값 확인
								    System.out.println("["+list4.get(i)+"]까지 반납할 도서 " + "<"+i+">");
								}

							}else if(menu2.equals("6")) { //맴버에서 key로 개인정보수정
								memberEdit();
							}else if(menu2.equals("7")) { //로그아웃. 제일 처음으로 돌아가면 된다.
								break a;
							}else if(menu2.equals("8")) { //맴버에서 key로 값삭제
							    if(list4.size()>=1){
							        System.out.println("대여중인 도서가 있어 회원탈퇴를 진행할 수 없습니다.");
							    }else {
									memberDelete();
									if(ex==1) {
										cnt--;
										break a;
									}
								}
							}else if(menu2.equals("9")) { //
								System.out.println("프로그램을 종료합니다.");
								System.exit(0);
							}else {
								System.out.println("잘못 입력하셨습니다.");
							}							
							
						}while(true); //일반회원 로그인 끝
					}else if(login.adminCheck(userid, userpwd)){//관리자 로그인
						System.out.println("------------------------------------------------------------------------------");
						System.out.println(" -------------------------------관리자로 로그인 했습니다.---------------------------- ");
						System.out.println("------------------------------------------------------------------------------");
							do {   
								System.out.println("------------------------------------------------------------------------------");
								String menu3 = conInput("1.도서목록   2.도서검색   3.도서추가   4.도서삭제   5.도서관 대출현황   6.회원목록   7.회원삭제   8.로그아웃   9.종료");			
								if(menu3.equals("1")) { //1. 도서목록 호출
									bookList(); 
								}else if(menu3.equals("2")) { //2. 도서검색
									bookListSearch();
								}else if(menu3.equals("3")) { //3. 도서추가
									bookListInsert();
								}else if(menu3.equals("4")) {
									bookDelete(); 
								}else if(menu3.equals("5")) { //4. 도서관 대출현황
									for(String i : list3.keySet()) {
										System.out.println(i+list3.get(i));
									}
								}else if(menu3.equals("6")) { //5. 회원목록
									memberList2();
								}else if(menu3.equals("7")) { //6. 회원삭제
									memberDelete2();

								}else if(menu3.equals("8")) { //7. 로그아웃
									break a;
								}else if(menu3.equals("9")) { //8. 종료
									System.out.println("프로그램을 종료합니다.");
									System.exit(0);
								}else {
									System.out.println("잘못 입력하셨습니다.");
								}
									
							}while(true);//관리자 로그인 끝
					}
					loginCnt++;
					out--;
					System.out.println("아이디나 비밀번호를 잘못 입력하셨습니다."+"남은 로그인 횟수는 "+out+"회 입니다.");
					if(loginCnt>=3) { //아이디 비밀번호 3회 잘못 입력시 프로그램 종료 
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
					}
				}while(true);
			}else if(menu.equals("4")) {
				memberInsert(); //회원 가입
				
			}else if(menu.equals("5")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
			

		}while(true);// 비회원 둘러보기 끝
	}
	//회원 정보를 이용해 로그인.
	//아이디를 입력받으면 입력받은 아이디를 회원정보와 대조해 값이 있는지 찾고 있으면 회원정보에 있는 아이디와 패스워드를 로그인 클래스에 등록
	//관리자 아이디 입력받으면 관리자 로그인 창으로 넘어감.
	public void memberlogin() {  //일반회원로그인, 관리자로그인
		String id = conInput("아이디를 입력하세요");
		do {

			if(id.equals("admin")){
				userid = "admin";
				break;
			}
			MemberVO vo = list2.get(id);		
			if(vo!=null) {
				login.setUserid(id);
				String pass = vo.getPass();
				login.setUserpwd(pass);
				userid = id;
				loginid = id;
				break;
			}else {
				break;
			} 
			
		}while(true);
	}

	
	//회원 가입
	public void memberInsert() {
		c:
		do {
//			int exit = 1;
			int num = membernum;
			//num, id, pass, name, address, tel, email);
			String id = conInput("아이디 입력(알파벳과 숫자 가능, 최대 10자리)");  //10자리 확인
			if(id.length()>10) {
				System.out.println("아이디가 10자리를 초과했습니다.");
				break c; 
			}else{
				int[] a = new int[id.length()];
				
				for(int i = 0; i < id.length(); i++) {
					a[i] = (int)id.charAt(i);
					if(65<=a[i] && 90>=a[i] || 97<=a[i] && 122>=a[i] || 48<=a[i] && 57>=a[i]) {
								continue;
					}else{
						System.out.println("잘못된 형식의 아이디입니다.");
						break c;
					}
				}
//				
			}
			MemberVO vo = list2.get(id);
			if(vo!=null) {
				System.out.println("이미 동일한 아이디가 있습니다.");
				break;
			}else {
				String pass = conInput("패스워드 입력(최대 10자리)");  //10자리 넘어가면 에러표시
				if(pass.length()>10) {
					System.out.println("패스워드가 10자리를 초과했습니다.");
					break c; 
				}
				String name = conInput("이름 입력");
				String address = conInput("주소 입력(동까지만)");
				String tel;
				
				do {
					int xa = 1;
					int xb = 1;
					tel = conInput("전화번호 입력"); //중복 확인 해보기

					
					if(bb(tel)==false) {
						System.out.println("이미 동일한 전화번호가 있습니다.");
						
					}else if(bb(tel)==true) {
						int[] b = new int[tel.length()];
						
						for(int i = 0; i < tel.length(); i++) {
							b[i] = (int)tel.charAt(i);
							if(45<=b[i] && 57>=b[i]) {
								if(b[i]==46||b[i]==47) {
									xa++;
									break;
								}else if(b[i]==45) {
									xb++;
								}
							}else{
								xa++;
								break;
							}
						}
						if(xb!=3){
							xa++;
						}
						
						if(xa>=2) {
							System.out.println("잘못된 형식의 전화번호입니다.");
							continue;	
						}else {
							break;
						}
					}
				}while(true);
				
				String email;
				do {
					 email = conInput("Email 입력"); //중복 확인 해보기
					 EmailCheck check = new EmailCheck();
					 if(check.emailCheckStart(email)==false) {
						System.out.println("잘못된 형식의 이메일 주소 입니다.");
					 }else if (bb(email)==false) {
						System.out.println("이미 동일한 Email이 있습니다.");
						
					}else if(bb(email)==true) {
						break;
					}
				}while(true);
				MemberVO vo3 = new MemberVO(num, id, pass, name, address, tel, email);
				list2.put(id, vo3);
				data2.clear();
				data2.addAll(list2.values()); 
				membernum++;
				cnt++;
				memberList2();				
				break;
			}
		}while(true);
	}
	

	
	//회원정보 수정
	public void memberEdit() {
		MemberVO vo = list2.get(loginid);
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("  |회원 번호|     |아이디|     |패스워드|   |이름|        |주소|       |연락처|               |Email|");
		System.out.println("-----------------------------------------------------------------------------------------------");
		vo.output();
		if(vo!=null) {
			String submenu = conInput("수정할 항목을 선택하세요.(1:이름, 2:연락처, 3:주소, 4:Email)");
			
			String data = conInput("수정할 내용을 입력하세요");
			if(submenu.equals("1")){
				vo.setName(data);
			}else if(submenu.equals("2")){
				do {
					if(bb(data)==false) {
						System.out.println("이미 동일한 전화번호가 있습니다.");
						break;
					}else if(bb(data)==true) {
						vo.setTel(data);
						break;
					}
				}while(true);
			}else if(submenu.equals("3")){
				vo.setAddress(data);
			}else if(submenu.equals("4")){
				do {
					 EmailCheck check = new EmailCheck();
					 if(check.emailCheckStart(data)==false) {
						System.out.println("잘못된 형식의 이메일 주소 입니다.");
						break;
					 }else if (bb(data)==false) {
						System.out.println("이미 동일한 Email이 있습니다.");
						break;
					}else if(bb(data)==true) {
						vo.setEmail(data);
						break;
					}
				}while(true);
			}else {
				System.out.println("수정할 항목을 잘못 선택하였습니다.");
			}
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("  |회원 번호|     |아이디|     |패스워드|   |이름|        |주소|       |연락처|               |Email|");
			System.out.println("-----------------------------------------------------------------------------------------------");
			vo.output();
		}
	}
	
	//회원 탈퇴
	public void memberDelete() {
		do {
			ex = 0;
			String qna = conInput("회원탈퇴를 진행하시겠습니까?(1:예, 2:아니오)");			
			if(qna.equals("1")) {
				System.out.println("이용해주셔서 감사합니다.");
				list2.remove(loginid);
				ex++;
				break;
			}else if(qna.equals("2")) {
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}while(true);
	}
	
	
	//회원 삭제
	public void memberDelete2() {
		String key = conInput("삭제할 회원 아이디"); 
		MemberVO vo = list2.get(key); 
		if(vo!=null) {		
			do {
				ex = 0;
				String num0 = conInput(key+"회원을"+" 정말 삭제합니까?(1:예, 2:아니오)");
				if(num0.equals("1")) {
					list2.remove(key); 
					ex++;
					break;
				}else if(num0.equals("2")) {
					break;
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}while(true);
		}else {
			System.out.println(key+"는 없는 회원입니다.");
		}
	}
	//도서 삭제
	public void bookDelete() {
		String key = conInput("삭제할 도서명"); 
		BookListVO vo = list.get(key); 
		if(vo!=null) {		
			do {
				ex = 0;
				String num0 = conInput(key+"도서를"+" 정말 삭제합니까?(1:예, 2:아니오)");
				if(num0.equals("1")) {
					list.remove(key); 
					break;
				}else if(num0.equals("2")) {
					break;
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}while(true);
		}else {
			System.out.println(key+"는 없는 도서입니다.");
		}
	}
	
	//도서추가
	public void bookListInsert() {
		do {
			String name = conInput("도서명 입력");  
			BookListVO vo = list.get(name);
			if(vo!=null) {
				System.out.println("이미 동일한 도서가 있습니다.");
				break;
			}else {
				String num2 = conInput("도서 번호 입력");
				int num=0;
				try {
					num = Integer.parseInt(num2);
				}catch(NumberFormatException e) {
					System.out.println("숫자만 입력해야 합니다.");
					break;
				}
				String author = conInput("저자 입력");  
				String year2 = conInput("년도 입력(숫자만)");
				int year=0;
				try {
					year = Integer.parseInt(year2);
				}catch(NumberFormatException d) {
					System.out.println("숫자만 입력해야 합니다.");
					break;
				}
				String genre = conInput("장르 입력");
				String rental;
				do {
					String rental2 = conInput("비치여부(1:비치중, 2:대여중)");
					if(rental2.equals("1")) {
						rental = "비치중";
						break;
					}else if(rental2.equals("2")) {
						rental = "대여중";
						break;
					}else {
						System.out.println("다시 입력하세요.");
					}
				}while(true);		
				BookListVO vo3 = new BookListVO(num, name, author, year, genre, rental);
				list.put(name, vo3);
				bookcnt++;
				bookList();				
				break;
			}
		}while(true);
	}

	
	//도서 대출하기
	public void bookrent(String msg) {
		do {
			BookListVO vo = list.get(msg);
			if(vo!=null) {
				String rent = conInput("도서를 대여하시겠습니까?(1:예, 2:아니오)");
					if(rent.equals("1")) {
						
						vo.setRental("대여중");
						calndar();
						lastDay();
						data4.add(list.get(msg));
						list4.put(msg, treenum3);
						
						BookListVO vo4 = data4.get(mybook);
						list3.put("대여번호 : "+treenum2+"번  ["+treenum+"]", " "+loginid +"님이 "+"<"+msg+">"+"도서를 대여하셨습니다."+"반납 예정 시간은["+treenum3+"]입니다.");
						treenum2++;
						System.out.println("------------------------------------------------");
						System.out.println("대여기간은 2일입니다.");
						System.out.println(treenum3+"까지 반납해 주세요."); 
						System.out.println("------------------------------------------------");
						System.out.println("------------------- 대여 도서 정보 -------------------");
						vo4.print(); 
						System.out.println("------------------------------------------------");
						mybook++;
						break;
					}else if(rent.equals("2")) {
						break;
					}else {
						System.out.println("잘못 입력하셨습니다.");
					}
			}else {
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}while(true);
	}
	
	//도서 반납하기
	public void bookreturn(String msg) {
		do {
			BookListVO vo = list.get(msg);
			if(vo!=null) {
				String rent = conInput("반납하시겠습니까?(1:예, 2:아니오)");
					if(rent.equals("1")) {
						vo.setRental("비치중");
						data4.remove(list.get(msg));
						list4.remove(msg);
						mybook--;
						break;
					}else if(rent.equals("2")) {
						break;
					}
			}
		}while(true);
	}
	
	
	
	//중복검사 //전화번호, 이메일
	public boolean bb(String msg) {
		data2.addAll(list2.values()); 
		for(int i=0; i<cnt; i++) {
				if(msg.equals(data2.get(i).getTel())) {
					return false;
				}else if(msg.equals(data2.get(i).getEmail())) {
					return false;
				}
		}
		return true;		
	}
	
	//중복검사 //도서 대여할때 
	public boolean cc(String msg) {
		List<BookListVO> data3 = new  ArrayList<BookListVO>();   //중복검사
		data3.addAll(list.values()); //데이터 list에 집어넣기
		for(int i=0; i<bookcnt; i++) {
				if(msg.equals(data3.get(i).getName())) {
					if("대여중".equals(data3.get(i).getRental())) {
						System.out.println("대여중인 도서입니다.");
						return false;
					}
				}
		}
		return true;
	}	
	
	//중복검사 도서 반납할떄
	public boolean dd(String msg) {
		for(int i=0; i<mybook; i++) {
				if(msg.equals(data4.get(i).getName())) {
					if("대여중".equals(data4.get(i).getRental())) {
						System.out.println("대여중인 도서입니다.");
						return true;
					}
					System.out.println("그 책은 대여하지 않았습니다.");
					
				}
		}
		return false;
	}		


	//도서 검색 
	public void bookListSearch() {
		do {
			String book = conInput("도서명을 입력하세요. (1: 나가기) ");
			BookListVO vo = list.get(book);
			if(vo!=null) {
				System.out.println("-----------------------");
				vo.print();
				break;
			}else if(book.equals("1")){
				break;
			}
			System.out.println("잘못 입력하셨습니다.");
		}while(true);
	}


	//입력 출력
	public String conInput(String msg) {
		System.out.print(msg + "=");
		return scan.nextLine();
	}
	
	
	public void memberList2() {
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("  |회원 번호|     |아이디|     |패스워드|   |이름|        |주소|       |연락처|               |Email|");
		System.out.println("-----------------------------------------------------------------------------------------------");
		List<MemberVO> lst = new ArrayList<MemberVO>();
		lst.addAll(list2.values()); 
		Collections.sort(lst, new CompareNumAsc2());
		for(MemberVO vo : lst) {
			vo.output();
		}
	}
	
	
	/////////////// 책 정렬 호출관련
	public void bookList() { //정렬
		String bookmenu = conInput("어떻게 정렬할까요?(1:도서번호, 2:장르별, 3:발행년도 최근순)");
		if(bookmenu.equals("1")) { //도서번호순 
			System.out.println("---------------------------------------------------------------------");
			System.out.println("|도서 번호|          도서명                  |    저자        |발행 년도|  장르    |  비치여부    |");	
			System.out.println("---------------------------------------------------------------------");
			List<BookListVO> lst = new ArrayList<BookListVO>();
			lst.addAll(list.values()); 
			Collections.sort(lst, new CompareNumAsc());
			for(BookListVO vo : lst) {
				vo.output();
			}			
		}else if(bookmenu.equals("2")) {//장르별인데 선택하는거 또 나오고 장르만 뽑아서 정렬할 수 있게.
			//1번은 장르별, 2번 누르면 장르선택
			String genreqna = conInput("1:장르 가나다순, 2:장르 선택 정렬");
			if(genreqna.equals("1")) {
				System.out.println("---------------------------------------------------------------------");
				System.out.println("|도서 번호|          도서명                  |    저자        |발행 년도|  장르    |  비치여부    |");	
				System.out.println("---------------------------------------------------------------------");
				List<BookListVO> lst = new ArrayList<BookListVO>();
				lst.addAll(list.values()); 
				Collections.sort(lst, new CompareGenreQna());
				for(BookListVO vo : lst) {
					vo.output();
				}
			}else if(genreqna.equals("2")){
				String genreqna2 = conInput("장르 선택(1:역사, 2:문학, 3:예술, 4:언어, 5:과학, 6:철학)");
				if(genreqna2.equals("1")) {
					genrelist("역사");
				}else if(genreqna2.equals("2")) {
					genrelist("문학");
				}else if(genreqna2.equals("3")) {
					genrelist("예술");
				}else if(genreqna2.equals("4")) {
					genrelist("언어");
				}else if(genreqna2.equals("5")) {
					genrelist("과학");
				}else if(genreqna2.equals("6")) {
					genrelist("철학");
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
				
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
		}else if(bookmenu.equals("3")) {
			System.out.println("---------------------------------------------------------------------");			
			System.out.println("|도서 번호|          도서명                  |    저자        |발행 년도|  장르    |  비치여부    |");
			System.out.println("---------------------------------------------------------------------");
			List<BookListVO> lst = new ArrayList<BookListVO>();
			lst.addAll(list.values()); 
			Collections.sort(lst, new CompareYearAsc());
			for(BookListVO vo : lst) {
				vo.output();
			}		
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	
	class CompareNumAsc implements Comparator<BookListVO>{ //도서번호순 오름차순
		public int compare(BookListVO v1, BookListVO v2) { 
			return (v1.getNum()  <  v2.getNum())? -1 : (v1.getNum() > v2.getNum())? 1 : 0;   
		} 
	}	
	
	class CompareNumAsc2 implements Comparator<MemberVO>{ //회원번호순 오름차순
		public int compare(MemberVO v1, MemberVO v2) { 
			return (v1.getNum()  <  v2.getNum())? -1 : (v1.getNum() > v2.getNum())? 1 : 0;   
		} 
	}		
	
	class CompareYearAsc implements Comparator<BookListVO>{ //년도 내림차순
		public int compare(BookListVO v1, BookListVO v2) {
			return (v1.getYear()  <  v2.getYear())? 1 : (v1.getYear() > v2.getYear())? -1 : 0;
		}
	}

	class CompareGenreQna implements Comparator<BookListVO>{
		public int compare(BookListVO v1, BookListVO v2) {
			return v1.getGenre().compareTo(v2.getGenre()); 
		}
	}	
	
	public void genrelist(String msg) {
		List<BookListVO> data3 = new  ArrayList<BookListVO>();   //중복검사
		data3.addAll(list.values()); //데이터 list에 집어넣기
		for(int i=0; i<bookcnt; i++) {
			BookListVO vo4 = data3.get(i);
				if(msg.equals(data3.get(i).getGenre())) {
						vo4.output(); //출력
				}
		}
	}
	
	////////////////////////// 시간 출력
	public void calndar(){  
	
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1; 
		int day = now.get(Calendar.DAY_OF_MONTH);
		int week = now.get(Calendar.DAY_OF_WEEK);
		int hour = now.get(Calendar.HOUR); 
		int minute = now.get(Calendar.MINUTE);
		int amPm = now.get(Calendar.AM);

		String monthStr = "";
		if(month<10){
			monthStr = "0"+month;
		}else{
			monthStr = month+""; 
		}

		
		String weekStr = "";
		switch(week){
			case 1: weekStr = "일";break;
			case 2: weekStr = "월";break;
			case 3: weekStr = "화";break;
			case 4: weekStr = "수";break;
			case 5: weekStr = "목";break;
			case 6: weekStr = "금";break;
			case 7: weekStr = "토";break;
			}

		String amStr="";
		if(amPm==0){
			amStr = "오전";
		}else{
			amStr = "오후";
		}

		treenum = year+"년 "+monthStr+"월 "+day+"일 "+weekStr+"요일 "+amStr+hour+"시"+minute+"분";

	}
	public void lastDay() {//반납일
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		now.add(Calendar.DATE,2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = sdf.format(now.getTime());
		
		treenum3 = today;
	}


	public static void main(String[] args) {
		new LibraryStart();

		
	}


}
