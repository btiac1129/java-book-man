package Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class BookFunction {
	HashMap<String, BookVO> bth = new HashMap<String, BookVO>();

	public BookFunction() {
	}

	// å ����
	public HashMap<String, BookVO> setbook() {
		// å�̸�, ����, ���ǻ�, ���ǿ���, å�з���ȣ
		bth.put("����� Ű���ִ� ö�� �׸�å", new BookVO("����� Ű���ִ� ö�� �׸�å", "����Ʈ���� �ε帮����", "������", 2019, 100));
		bth.put("ö�� ���̶ٱ�", new BookVO("ö�� ���̶ٱ�", "�ܸ�ũ ����������", "�ñ�ġ", 2019, 100));
		bth.put("� ���ϴ�", new BookVO("� ���ϴ�", "����� ", "�ؼ���", 2020, 200));
		bth.put("21���� ��ȭ�� ������ ���Ѵ�", new BookVO("21���� ��ȭ�� ������ ���Ѵ�", "�Ϻ� �۽�", "��������������", 2019, 200));
		bth.put("��ȸ����", new BookVO("��ȸ����", "�� �庸��", "���", 2017, 300));

		return bth;
	}

	// �α��� �� ù ȭ��
	public void bookMenu(String id) {
		Book b = new Book();
		System.out.println();
		System.out.println(id + "�� �ݰ����ϴ�.\n");
		do {
			System.out.println("============== BOOK MAN ==============");
			String menu = b.menuInput("1. å �˻��ϱ� \n2. å ������ \n3. �α׾ƿ�");
			if (menu.equals("1")) {
				bookSearch();
			} else if (menu.equals("3")) {
				loanBook(id);
			} else if (menu.equals("3")) {
				System.out.println("�α׾ƿ� �Ͽ����ϴ�. ����ȭ������ ���ư��ϴ�.");
				System.out.println();
				b.start();
				break;
			} else {
				System.out.println("�޴��� �߸� �����Ͽ����ϴ�. �ٽ� �����ϼ���.");
			}
		} while (true);

	}

	// å �˻�
	public void bookSearch() {
		Book b = new Book();
		// å ����
		setbook();

		Set set = bth.keySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println("bli Key : " + key);
		}

		String bname = b.lineInput("�������� �Է��ϼ���.");
		if (bth.containsKey(bname)) {
			System.out.println("å�� �����մϴ�.");
			System.out.printf("	å����          ����	���ǻ�	���ǳ⵵	�з���ȣ\n");
			BookVO bvo = bth.get(bname);
			bvo.output();

		} else {
			System.out.println("å�� �������� �ʽ��ϴ�.");

		}
	}

	// å ������
	public void loanBook(String id) {
		Book book = new Book();
		String bookName = book.lineInput("�������� �Է��ϼ���.");
		if (bth.containsKey(bookName)) {
			
		} else {
			System.out.println("�������� �ʴ� å�Դϴ�.");
		}
	}
}
