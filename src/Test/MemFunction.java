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
		mth.put("admin", new MemVO("admin", "1234", "������", "admin@naver.com", "010-1111-1111"));
		mth.put("aaaa", new MemVO("aaaa", "1111", "ȫ�浿", "sadfsadf@naver.com", "010-1234-1324"));
		mth.put("bbbb", new MemVO("bbbb", "2222", "������", "bbbbbb@naver.com", "010-2222-2222"));
		mth.put("cccc", new MemVO("cccc", "3333", "�̼���", "cccddc@naver.com", "010-3333-3333"));
		mth.put("dddd", new MemVO("dddd", "4444", "�������", "dddddd@naver.com", "010-4545-5555"));

		return mth;
	}
	//�α���
	public boolean memCheck(String id, String pwd) {
		if(mth.containsKey(id)) {
			if((mth.get(id)).getPwd().equals(pwd)) {
				return true;
			}else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				return false;
			}
		}
		else {
			System.out.println("�������� �ʴ� ���̵� �Դϴ�.");
			return false;
		}	
	}

	// ȸ������
	public void memAdd() {
		Book b = new Book();
		// ���̵�, ��й�ȣ, �̸�, �̸���, ����ó
		do {
			String id = b.conInput("���̵� �Է��ϼ���");
			if (mth.containsKey(id)) {
				System.out.println("�ߺ��� ���̵� �Դϴ�. �ٽ� �Է����ּ���.");
			} else {
				String pwd = b.conInput("��й�ȣ��  �Է��ϼ���"); 
				String pwd2 = b.conInput("��й�ȣ�� �ѹ� �� �Է��ϼ���");
				if (!(pwd.equals(pwd2))) {
					System.out.println("��й�ȣ�� �ٸ��ϴ�.");
				} else {
					String name = b.conInput("�̸���  �Է��ϼ���");
					String email = b.conInput("�̸�����  �Է��ϼ���");
					if (emailCheck(email)) {
						String tel = b.conInput("��ȭ��ȣ��  �Է��ϼ���");

						MemVO mvo = new MemVO(id, pwd, name, email, tel);
						mth.put(id, mvo);
						System.out.println(name + "�� ������ �Ϸ�Ǿ����ϴ�.");
						break;
					} else {
						System.out.println("�߸��� �����Դϴ�. ó������ �ٽ� �Է��ϼ���.");
					}//�̸��� Ȯ�� else
				} // ���Ȯ�� else
			}
		} while (true);
	}// memAdd
		
	// �̸��� Ȯ��
	public boolean emailCheck(String email) {
		int atMark = email.indexOf("@");// @��ġ�� index�� ���ϰ� ���� ���� -1�� ������.
		int point = email.indexOf(".");// .��ġ ���ϱ�

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
