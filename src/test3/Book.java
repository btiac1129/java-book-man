package test3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.Hashtable;

public class Book {
	Scanner scan = new Scanner(System.in);

//	//key,value 함께 출력
//	Set set = bm.entrySet();//key는 중복을 허용하지 않으니 set타입으로 반환
//	Iterator it = set.iterator();//value는 중복을 허용하니 collection 타입으로 반환
	// 출판년도 정규식 - 1900년대 2000년대
	String pyExp = "^([1|2]\\d{3})$";
	// 분류번호 정규식
	String bnExp = "^(\\d{3})$";

	public Book() {

	}

	public String conInput(String msg) {
		System.out.print(msg + "= ");
		return scan.nextLine();
	}

	// 책 셋팅
	public HashMap<String, BookVO> setbook() {

		HashMap<String, BookVO> bhm = new HashMap<String, BookVO>();
		// 책이름, 저자, 출판사, 출판연도, 책분류번호
		bhm.put("안네의 일기", new BookVO("안네의 일기", "안네프랑크", "보물상자", 2011, 800));
		bhm.put("철학 높이뛰기", new BookVO("철학 높이뛰기", "외르크 베르나르디", "시금치", 2019, 100));
		bhm.put("삶에 답하다", new BookVO("삶에 답하다", "김봉현 ", "넥서스", 2020, 200));
		bhm.put("이것이 자바다", new BookVO("이것이 자바다", "신용권", "한빛미디어", 2015, 500));
		bhm.put("사회논평", new BookVO("사회논평", "기 드보르", "울력", 2017, 300));
		bhm.put("군산", new BookVO("군산", "배지영", "21세기북스", 2020, 900));
		bhm.put("동물기계", new BookVO("동물기계", "루스 해리슨", "에이도스", 2020, 500));
		bhm.put("지킬박사와 하이드", new BookVO("지킬박사와 하이드","로버트","아로파",2018,800));
		return bhm;
	}
	
	// 책 셋팅
		public HashMap<String, BookRequestVO> setbookr() {

			HashMap<String, BookRequestVO> bhm2 = new HashMap<String, BookRequestVO>();
			// 책이름, 저자, 출판사, 출판연도, 책분류번호
			bhm2.put("율리시스무어1", new BookRequestVO("율리시스무어1", "피에르도메니코 바칼라리오", "웅진", 2006, 800));
			bhm2.put("율리시스무어2", new BookRequestVO("율리시스무어2", "피에르도메니코 바칼라리오", "웅진", 2006, 800));
			bhm2.put("율리시스무어3", new BookRequestVO("율리시스무어3", "피에르도메니코 바칼라리오", "웅진", 2006, 800));
			
			return bhm2;
		}

	// 책 검색
	public void bookSearch(HashMap<String, BookVO> bhm) {

//			Set set = bth.keySet();
//			Iterator iterator = set.iterator();
//			while (iterator.hasNext()) {
//				String key = (String) iterator.next();
//				System.out.println("bth Key : " + key);
//			}

		String bname = conInput("도서명을 입력하세요");
		BookVO bvo = bhm.get(bname);
		if (bvo != null) {
			System.out.println("출력 순서 : 책제목, 저자, 출판사,  출판년도,  분류번호");
			System.out.println("-------------------------------------------------------");
			bvo.output();

		} else {
			System.out.println("책이 존재하지 않습니다.");

		}
	}

	

	// 책 목록
	public void bookList(HashMap<String, BookVO> bhm, String id) {
		Collection<BookVO> valueList = bhm.values();
		Iterator<BookVO> ii = valueList.iterator();
		
		System.out.println("출력 순서 : 책제목, 저자, 출판사,  출판년도,  분류번호");
		System.out.println("-------------------------------------------------------");
		while (ii.hasNext()) {
				ii.next().output();
			
		}
	}

	// 요청한 책 목록
	public void bookList2(HashMap<String, BookRequestVO> bhm2) {
		Collection<BookRequestVO> valueList = bhm2.values();
		Iterator<BookRequestVO> ii = valueList.iterator();
		while (ii.hasNext()) {
			ii.next().output();
		}
	}

	// 책 등록
	public void bookInsert(HashMap<String, BookVO> bhm, BookVO bvo) {
		// 책 제목, 저자, 출판사, 출판년도, 분류번호
		do {
			String bookName = conInput("책 제목을 입력하세요");
			bvo.setBookName(bookName);
			String writer = conInput("저자를 입력하세요");
			bvo.setWriter(writer);
			String publisher = conInput("출판사를 입력하세요");
			bvo.setPublisher(publisher);

			do {
				String publishYear = conInput("출판년도를 입력하세요");
				if (publishYear.matches(pyExp)) {
					bvo.setPublishYear(Integer.parseInt(publishYear));
					break;
				} else {
					System.out.println("출판년도를 올바르게 입력하세요.");
				}
			} while (true);

			do {
				String bookNum = conInput("분류번호를 입력하세요.");
				if (bookNum.matches(bnExp)) {
					bvo.setBookNum(Integer.parseInt(bookNum));
					break;
				}

				else {
					System.out.println("분류번호를 올바르게 입력해주세요.");
				}
			} while (true);

			bhm.put(bookName, bvo);
			System.out.println(bookName + "책이 등록되었습니다.\n");

			break;
		} while (true);

	}

	// 책 수정
	public void bookEdit(HashMap<String, BookVO> bhm) {

		String bname = conInput("수정할 책제목");
		BookVO vo = bhm.get(bname);
		if (vo != null) {
			vo.output();
			String subMenu = conInput("수정할 항목을 선택하세요.(1: 책 제목, 2: 저자, 3: 출판사, 4: 출판년도, 5: 분류번호 )");
			do {
				String data = conInput("수정할 데이터 입력");
				if (subMenu.equals("1")) {
					vo.setBookName(data);
				} else if (subMenu.equals("2")) {
					vo.setWriter(data);
				} else if (subMenu.equals("3")) {
					vo.setPublisher(data);
				} else if (subMenu.equals("4")) {
					if (data.matches(pyExp)) {
						vo.setPublishYear(Integer.parseInt(data));
					} else {
						System.out.println("출판년도를 올바르게 입력해주세요");
					}
				} else if (subMenu.equals("5")) {
					if (data.matches(bnExp)) {
						vo.setBookNum(Integer.parseInt(data));
					} else {
						System.out.println("분류번호를 올바르게 입력해주세요");
					}
				} else {
					System.out.println("수정할 항목을 잘못 선택 하였습니다");
				}
			} while (true);
		} else {
			System.out.println(bname + "없는 책입니다.");
		}

	}

	// 책 삭제
	public void bookDelete(HashMap<String, BookVO> bhm) {
		String key = conInput("삭제할 책을 입력하세요");
		bhm.remove(key);

	}
	

	// 책 요청목록
	public void requestedBook(HashMap<String, BookRequestVO> bhm2, BookRequestVO bvo) {
		// 책 제목, 저자, 출판사, 출판년도, 분류번호
		do {
			String bookName = conInput("책 제목을 입력하세요");
			bvo.setRbookName(bookName);
			String writer = conInput("저자를 입력하세요");
			bvo.setRwriter(writer);
			String publisher = conInput("출판사를 입력하세요");
			bvo.setRpublisher(publisher);

			do {
				String publishYear = conInput("출판년도를 입력하세요");
				if (publishYear.matches(pyExp)) {
					bvo.setRpublishYear(Integer.parseInt(publishYear));
					break;
				} else {
					System.out.println("출판년도를 올바르게 입력하세요.");
				}
			} while (true);

			do {
				String bookNum = conInput("분류번호를 입력하세요.");
				bvo.setRbookNum(Integer.parseInt(bookNum));
				if (bookNum.matches(bnExp)) {

					bvo.setRbookNum(Integer.parseInt(bookNum));
					break;
				}

				else {
					System.out.println("분류번호를 올바르게 입력해주세요.");
				}
			} while (true);

			bhm2.put(bookName, bvo);
			System.out.println(bookName + "책이 요청되었습니다.\n");
			System.out.println("출력 순서 : 책제목, 저자, 출판사,  출판년도,  분류번호");
			bookList2(bhm2);

			break;
		} while (true);

	}

	public static void main(String[] args) {
		new Book();
	}

}
