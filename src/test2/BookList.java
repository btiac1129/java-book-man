package test2;
import java.util.HashMap;

public class BookList {
	
	public BookList() {
		
	}

	public static HashMap<String, BookListVO> setBook(){
		HashMap<String, BookListVO> hm = new HashMap<String, BookListVO>();
		hm.put("문화 이야기", new BookListVO(101, "문화 이야기", "김진섭", 2002, "역사", "비치중"));
		hm.put("즐거운 한국사", new BookListVO(105, "즐거운 한국사", "최하림", 2001, "역사", "비치중"));
		hm.put("안동문학", new BookListVO(210, "안동문학", "이회", 2002, "문학", "비치중"));
		hm.put("현대문학사", new BookListVO(250, "현대문학사", "김윤식", 2005, "문학", "비치중"));
		hm.put("미지에서", new BookListVO(331, "미지에서", "문경원", 2012, "예술", "대여중"));
		hm.put("빛의 이해", new BookListVO(375, "빛의 이해", "리처드 요트", 2014, "예술", "비치중"));
		hm.put("국어사전", new BookListVO(455, "국어사전", "교학사", 2004, "언어", "대여중"));
		hm.put("영어 이력서", new BookListVO(489, "영어 이력서", "김민식", 2008, "언어", "비치중"));
		hm.put("전공수학", new BookListVO(522, "전공수학", "최석민", 2002, "과학", "비치중"));
		hm.put("인간과 과학기술", new BookListVO(590, "인간과 과학기술", "박대철", 2016, "과학", "대여중"));
		hm.put("탈형이상학", new BookListVO(652, "탈형이상학", "신승환", 2018, "철학", "비치중"));
		hm.put("우리는 신이다", new BookListVO(673, "우리는 신이다", "페테르 에르베", 1998, "철학", "비치중"));
		return hm;
	}

}
