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
		System.out.print(msg + "\n\n�޴� ���� : ");
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
		// ��� ����
		mth=mf.setMem();
		//mf.setMem();
		System.out.println("====== �������� �ý��ۿ� ���� ���� ȯ���մϴ� ======");
		a:
		do {
			System.out.println("================ MENU ================");
			String choice = menuInput("1. �α��� \n2. ȸ������\n3. ���α׷� ����");
			if (choice.equals("1")) {// �α���
				String id = conInput("���̵�");
				String pwd = conInput("��й�ȣ");
				if (mf.memCheck(id, pwd)) {// �α��� ����
					bf.bookMenu(id);// �޴�ȭ��
					break;
				} else {// �α��� ����
					loginCnt++;
					if (loginCnt >= 3) {// 3������ �α��� �õ�
						System.out.println("���α׷��� ����Ǿ����ϴ�.");
						break a;
					}
				}

			} else if (choice.equals("2")) {// ȸ������	
				mf.memAdd();

			}else if (choice.equals("3")) {// ȸ������	
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);

			} else {
				System.out.println("��ȣ�� �߸� �������ϴ�. �ٽ� ������ �ּ���.");
			}
			
		}while(true);
		
	}//end of start()	
}
