package test2;
import java.util.HashMap;

public class BookList {
	
	public BookList() {
		
	}

	public static HashMap<String, BookListVO> setBook(){
		HashMap<String, BookListVO> hm = new HashMap<String, BookListVO>();
		hm.put("��ȭ �̾߱�", new BookListVO(101, "��ȭ �̾߱�", "������", 2002, "����", "��ġ��"));
		hm.put("��ſ� �ѱ���", new BookListVO(105, "��ſ� �ѱ���", "���ϸ�", 2001, "����", "��ġ��"));
		hm.put("�ȵ�����", new BookListVO(210, "�ȵ�����", "��ȸ", 2002, "����", "��ġ��"));
		hm.put("���빮�л�", new BookListVO(250, "���빮�л�", "������", 2005, "����", "��ġ��"));
		hm.put("��������", new BookListVO(331, "��������", "�����", 2012, "����", "�뿩��"));
		hm.put("���� ����", new BookListVO(375, "���� ����", "��ó�� ��Ʈ", 2014, "����", "��ġ��"));
		hm.put("�������", new BookListVO(455, "�������", "���л�", 2004, "���", "�뿩��"));
		hm.put("���� �̷¼�", new BookListVO(489, "���� �̷¼�", "��ν�", 2008, "���", "��ġ��"));
		hm.put("��������", new BookListVO(522, "��������", "�ּ���", 2002, "����", "��ġ��"));
		hm.put("�ΰ��� ���б��", new BookListVO(590, "�ΰ��� ���б��", "�ڴ�ö", 2016, "����", "�뿩��"));
		hm.put("Ż���̻���", new BookListVO(652, "Ż���̻���", "�Ž�ȯ", 2018, "ö��", "��ġ��"));
		hm.put("�츮�� ���̴�", new BookListVO(673, "�츮�� ���̴�", "���׸� ������", 1998, "ö��", "��ġ��"));
		return hm;
	}

}
