package Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class BookFunction {
	HashMap<String, BookVO> bth = new HashMap<String, BookVO>();

	public BookFunction() {
	}

	// 책 셋팅
	public HashMap<String, BookVO> setbook() {
		// 책이름, 저자, 출판사, 출판연도, 책분류번호
		bth.put("상상을 키워주는 철학 그림책", new BookVO("상상을 키워주는 철학 그림책", "베아트리스 로드리게즈", "봄나무", 2019, 100));
		bth.put("철학 높이뛰기", new BookVO("철학 높이뛰기", "외르크 베르나르디", "시금치", 2019, 100));
		bth.put("삶에 답하다", new BookVO("삶에 답하다", "김봉현 ", "넥서스", 2020, 200));
		bth.put("21세기 평화와 종교를 말한다", new BookVO("21세기 평화와 종교를 말한다", "하비 콕스", "조선뉴스프레스", 2019, 200));
		bth.put("사회논평", new BookVO("사회논평", "기 드보르", "울력", 2017, 300));

		return bth;
	}

	// 로그인 후 첫 화면
	public void bookMenu(String id) {
		Book b = new Book();
		System.out.println();
		System.out.println(id + "님 반갑습니다.\n");
		do {
			System.out.println("============== BOOK MAN ==============");
			String menu = b.menuInput("1. 책 검색하기 \n2. 책 빌리기 \n3. 로그아웃");
			if (menu.equals("1")) {
				bookSearch();
			} else if (menu.equals("3")) {
				loanBook(id);
			} else if (menu.equals("3")) {
				System.out.println("로그아웃 하였습니다. 메인화면으로 돌아갑니다.");
				System.out.println();
				b.start();
				break;
			} else {
				System.out.println("메뉴를 잘못 선택하였습니다. 다시 선택하세요.");
			}
		} while (true);

	}

	// 책 검색
	public void bookSearch() {
		Book b = new Book();
		// 책 셋팅
		setbook();

		Set set = bth.keySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println("bli Key : " + key);
		}

		String bname = b.lineInput("도서명을 입력하세요.");
		if (bth.containsKey(bname)) {
			System.out.println("책이 존재합니다.");
			System.out.printf("	책제목          저자	출판사	출판년도	분류번호\n");
			BookVO bvo = bth.get(bname);
			bvo.output();

		} else {
			System.out.println("책이 존재하지 않습니다.");

		}
	}

	// 책 빌리기
	public void loanBook(String id) {
		Book book = new Book();
		String bookName = book.lineInput("도서명을 입력하세요.");
		if (bth.containsKey(bookName)) {
			
		} else {
			System.out.println("존재하지 않는 책입니다.");
		}
	}
}
