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
	TreeMap<String, String> list3 = new TreeMap<String, String>(); //�ð����� �뿩��Ȳ ����
	TreeMap<String, String> list4 = new TreeMap<String, String>(); //���δ뿩��Ȳ
	List<MemberVO> data2 = new  ArrayList<MemberVO>(); //�ߺ��˻�
	List<BookListVO> data4 = new  ArrayList<BookListVO>();	//���� ��ü ������Ȳ 
	List<BookListVO> data5 = new  ArrayList<BookListVO>();  //������� ȣ��
	
	Calendar now = Calendar.getInstance();	
	
	Login login = new Login();
	int membernum = 6; //���� ȸ�� ��
	String userid;
	String userpwd;
	int cnt = 5; //ȸ�������Ҷ� 1�߰� ȸ�������Ҷ� -1
	int bookcnt = 12; //å �߰��Ҷ� 1�߰� �����Ҷ� -1
	int mybook = 0; //���� �뿩�� ���� ��
	int ex = 0; //ȸ��Ż��� ùȭ������	
	String loginid; //�α��ν� ���⿡ ���� ������ ���̵� ����
	String treenum; //�뿩 �ð� ����
	int treenum2 = 1;  //treemap key�� �ߺ� ������ ���� ��ȣ�ο� 
	String treenum3; // �ݳ� ���� �ð�
	

	
	public LibraryStart() {
		int loginCnt = 0; //�α��� Ƚ��
		list = BookList.setBook(); //������� Ȯ�� �ʱ�ȭ.. ��ġ�̵�?
		list2 = MemberList.setMemberList();
		
		do {//��ȸ�� �ѷ�����
			System.out.println("----------------------------------------------");
			String menu = conInput("1.�������   2.�����˻�   3.�α���   4.ȸ������   5.����");
			if(menu.equals("1")) { //1. ������� ȣ��
				bookList(); 
			}else if(menu.equals("2")) { //2. �����˻�
				bookListSearch();
			}else if(menu.equals("3")) { //3. �α���
				int out=3;
				a: //�ʱ�ȭ��
				do {
					memberlogin();  //ȸ�� ������ �̿��� �α���
					String userpwd = conInput("�н����� �Է�");
					if(login.memberCheck(userid, userpwd)) {
						list4.clear();
						System.out.println("---------------------------------------------------------------------------------------");
						System.out.println(" ------------------------------------�α��� �Ǿ����ϴ�.------------------------------------ ");						
						do { //�Ϲ�ȸ��
							System.out.println("---------------------------------------------------------------------------------------");
							String menu2 = conInput("1.�������   2.�����˻�   3.���������û   4.�����ݳ�   5.������Ȳ   6.������������   7.�α׾ƿ�   8.ȸ��Ż��   9.����");
							if(menu2.equals("1")) { //1. ������� ȣ��
								bookList(); 
							}else if(menu2.equals("2")) { //2. �����˻�
								bookListSearch();
							}else if(menu2.equals("3")) { //3. �����û
								String rent = conInput("�뿩�� ������");
								
								//��� �޾Ƽ� ���������� �ٲٰ�, ������Ȳ�� �߰�.
								if(cc(rent)==true) {
									bookrent(rent);	
								}
															
							}else if(menu2.equals("4")) { //���� �ݳ�
								String rent = conInput("�ݳ��� ������");
								
								if(dd(rent)==true) {
									bookreturn(rent);	
								}else {
									System.out.println("�뿩���� �ʾҰų� ���� �����Դϴ�.");
								}
							}else if(menu2.equals("5")) { //���� ��Ȳ
								for(String i : list4.keySet()){ //����� key�� Ȯ��
								    System.out.println("["+list4.get(i)+"]���� �ݳ��� ���� " + "<"+i+">");
								}

							}else if(menu2.equals("6")) { //�ɹ����� key�� ������������
								memberEdit();
							}else if(menu2.equals("7")) { //�α׾ƿ�. ���� ó������ ���ư��� �ȴ�.
								break a;
							}else if(menu2.equals("8")) { //�ɹ����� key�� ������
							    if(list4.size()>=1){
							        System.out.println("�뿩���� ������ �־� ȸ��Ż�� ������ �� �����ϴ�.");
							    }else {
									memberDelete();
									if(ex==1) {
										cnt--;
										break a;
									}
								}
							}else if(menu2.equals("9")) { //
								System.out.println("���α׷��� �����մϴ�.");
								System.exit(0);
							}else {
								System.out.println("�߸� �Է��ϼ̽��ϴ�.");
							}							
							
						}while(true); //�Ϲ�ȸ�� �α��� ��
					}else if(login.adminCheck(userid, userpwd)){//������ �α���
						System.out.println("------------------------------------------------------------------------------");
						System.out.println(" -------------------------------�����ڷ� �α��� �߽��ϴ�.---------------------------- ");
						System.out.println("------------------------------------------------------------------------------");
							do {   
								System.out.println("------------------------------------------------------------------------------");
								String menu3 = conInput("1.�������   2.�����˻�   3.�����߰�   4.��������   5.������ ������Ȳ   6.ȸ�����   7.ȸ������   8.�α׾ƿ�   9.����");			
								if(menu3.equals("1")) { //1. ������� ȣ��
									bookList(); 
								}else if(menu3.equals("2")) { //2. �����˻�
									bookListSearch();
								}else if(menu3.equals("3")) { //3. �����߰�
									bookListInsert();
								}else if(menu3.equals("4")) {
									bookDelete(); 
								}else if(menu3.equals("5")) { //4. ������ ������Ȳ
									for(String i : list3.keySet()) {
										System.out.println(i+list3.get(i));
									}
								}else if(menu3.equals("6")) { //5. ȸ�����
									memberList2();
								}else if(menu3.equals("7")) { //6. ȸ������
									memberDelete2();

								}else if(menu3.equals("8")) { //7. �α׾ƿ�
									break a;
								}else if(menu3.equals("9")) { //8. ����
									System.out.println("���α׷��� �����մϴ�.");
									System.exit(0);
								}else {
									System.out.println("�߸� �Է��ϼ̽��ϴ�.");
								}
									
							}while(true);//������ �α��� ��
					}
					loginCnt++;
					out--;
					System.out.println("���̵� ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�."+"���� �α��� Ƚ���� "+out+"ȸ �Դϴ�.");
					if(loginCnt>=3) { //���̵� ��й�ȣ 3ȸ �߸� �Է½� ���α׷� ���� 
						System.out.println("���α׷��� �����մϴ�.");
						System.exit(0);
					}
				}while(true);
			}else if(menu.equals("4")) {
				memberInsert(); //ȸ�� ����
				
			}else if(menu.equals("5")) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			

		}while(true);// ��ȸ�� �ѷ����� ��
	}
	//ȸ�� ������ �̿��� �α���.
	//���̵� �Է¹����� �Է¹��� ���̵� ȸ�������� ������ ���� �ִ��� ã�� ������ ȸ�������� �ִ� ���̵�� �н����带 �α��� Ŭ������ ���
	//������ ���̵� �Է¹����� ������ �α��� â���� �Ѿ.
	public void memberlogin() {  //�Ϲ�ȸ���α���, �����ڷα���
		String id = conInput("���̵� �Է��ϼ���");
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

	
	//ȸ�� ����
	public void memberInsert() {
		c:
		do {
//			int exit = 1;
			int num = membernum;
			//num, id, pass, name, address, tel, email);
			String id = conInput("���̵� �Է�(���ĺ��� ���� ����, �ִ� 10�ڸ�)");  //10�ڸ� Ȯ��
			if(id.length()>10) {
				System.out.println("���̵� 10�ڸ��� �ʰ��߽��ϴ�.");
				break c; 
			}else{
				int[] a = new int[id.length()];
				
				for(int i = 0; i < id.length(); i++) {
					a[i] = (int)id.charAt(i);
					if(65<=a[i] && 90>=a[i] || 97<=a[i] && 122>=a[i] || 48<=a[i] && 57>=a[i]) {
								continue;
					}else{
						System.out.println("�߸��� ������ ���̵��Դϴ�.");
						break c;
					}
				}
//				
			}
			MemberVO vo = list2.get(id);
			if(vo!=null) {
				System.out.println("�̹� ������ ���̵� �ֽ��ϴ�.");
				break;
			}else {
				String pass = conInput("�н����� �Է�(�ִ� 10�ڸ�)");  //10�ڸ� �Ѿ�� ����ǥ��
				if(pass.length()>10) {
					System.out.println("�н����尡 10�ڸ��� �ʰ��߽��ϴ�.");
					break c; 
				}
				String name = conInput("�̸� �Է�");
				String address = conInput("�ּ� �Է�(��������)");
				String tel;
				
				do {
					int xa = 1;
					int xb = 1;
					tel = conInput("��ȭ��ȣ �Է�"); //�ߺ� Ȯ�� �غ���

					
					if(bb(tel)==false) {
						System.out.println("�̹� ������ ��ȭ��ȣ�� �ֽ��ϴ�.");
						
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
							System.out.println("�߸��� ������ ��ȭ��ȣ�Դϴ�.");
							continue;	
						}else {
							break;
						}
					}
				}while(true);
				
				String email;
				do {
					 email = conInput("Email �Է�"); //�ߺ� Ȯ�� �غ���
					 EmailCheck check = new EmailCheck();
					 if(check.emailCheckStart(email)==false) {
						System.out.println("�߸��� ������ �̸��� �ּ� �Դϴ�.");
					 }else if (bb(email)==false) {
						System.out.println("�̹� ������ Email�� �ֽ��ϴ�.");
						
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
	

	
	//ȸ������ ����
	public void memberEdit() {
		MemberVO vo = list2.get(loginid);
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("  |ȸ�� ��ȣ|     |���̵�|     |�н�����|   |�̸�|        |�ּ�|       |����ó|               |Email|");
		System.out.println("-----------------------------------------------------------------------------------------------");
		vo.output();
		if(vo!=null) {
			String submenu = conInput("������ �׸��� �����ϼ���.(1:�̸�, 2:����ó, 3:�ּ�, 4:Email)");
			
			String data = conInput("������ ������ �Է��ϼ���");
			if(submenu.equals("1")){
				vo.setName(data);
			}else if(submenu.equals("2")){
				do {
					if(bb(data)==false) {
						System.out.println("�̹� ������ ��ȭ��ȣ�� �ֽ��ϴ�.");
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
						System.out.println("�߸��� ������ �̸��� �ּ� �Դϴ�.");
						break;
					 }else if (bb(data)==false) {
						System.out.println("�̹� ������ Email�� �ֽ��ϴ�.");
						break;
					}else if(bb(data)==true) {
						vo.setEmail(data);
						break;
					}
				}while(true);
			}else {
				System.out.println("������ �׸��� �߸� �����Ͽ����ϴ�.");
			}
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("  |ȸ�� ��ȣ|     |���̵�|     |�н�����|   |�̸�|        |�ּ�|       |����ó|               |Email|");
			System.out.println("-----------------------------------------------------------------------------------------------");
			vo.output();
		}
	}
	
	//ȸ�� Ż��
	public void memberDelete() {
		do {
			ex = 0;
			String qna = conInput("ȸ��Ż�� �����Ͻðڽ��ϱ�?(1:��, 2:�ƴϿ�)");			
			if(qna.equals("1")) {
				System.out.println("�̿����ּż� �����մϴ�.");
				list2.remove(loginid);
				ex++;
				break;
			}else if(qna.equals("2")) {
				break;
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}while(true);
	}
	
	
	//ȸ�� ����
	public void memberDelete2() {
		String key = conInput("������ ȸ�� ���̵�"); 
		MemberVO vo = list2.get(key); 
		if(vo!=null) {		
			do {
				ex = 0;
				String num0 = conInput(key+"ȸ����"+" ���� �����մϱ�?(1:��, 2:�ƴϿ�)");
				if(num0.equals("1")) {
					list2.remove(key); 
					ex++;
					break;
				}else if(num0.equals("2")) {
					break;
				}else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			}while(true);
		}else {
			System.out.println(key+"�� ���� ȸ���Դϴ�.");
		}
	}
	//���� ����
	public void bookDelete() {
		String key = conInput("������ ������"); 
		BookListVO vo = list.get(key); 
		if(vo!=null) {		
			do {
				ex = 0;
				String num0 = conInput(key+"������"+" ���� �����մϱ�?(1:��, 2:�ƴϿ�)");
				if(num0.equals("1")) {
					list.remove(key); 
					break;
				}else if(num0.equals("2")) {
					break;
				}else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			}while(true);
		}else {
			System.out.println(key+"�� ���� �����Դϴ�.");
		}
	}
	
	//�����߰�
	public void bookListInsert() {
		do {
			String name = conInput("������ �Է�");  
			BookListVO vo = list.get(name);
			if(vo!=null) {
				System.out.println("�̹� ������ ������ �ֽ��ϴ�.");
				break;
			}else {
				String num2 = conInput("���� ��ȣ �Է�");
				int num=0;
				try {
					num = Integer.parseInt(num2);
				}catch(NumberFormatException e) {
					System.out.println("���ڸ� �Է��ؾ� �մϴ�.");
					break;
				}
				String author = conInput("���� �Է�");  
				String year2 = conInput("�⵵ �Է�(���ڸ�)");
				int year=0;
				try {
					year = Integer.parseInt(year2);
				}catch(NumberFormatException d) {
					System.out.println("���ڸ� �Է��ؾ� �մϴ�.");
					break;
				}
				String genre = conInput("�帣 �Է�");
				String rental;
				do {
					String rental2 = conInput("��ġ����(1:��ġ��, 2:�뿩��)");
					if(rental2.equals("1")) {
						rental = "��ġ��";
						break;
					}else if(rental2.equals("2")) {
						rental = "�뿩��";
						break;
					}else {
						System.out.println("�ٽ� �Է��ϼ���.");
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

	
	//���� �����ϱ�
	public void bookrent(String msg) {
		do {
			BookListVO vo = list.get(msg);
			if(vo!=null) {
				String rent = conInput("������ �뿩�Ͻðڽ��ϱ�?(1:��, 2:�ƴϿ�)");
					if(rent.equals("1")) {
						
						vo.setRental("�뿩��");
						calndar();
						lastDay();
						data4.add(list.get(msg));
						list4.put(msg, treenum3);
						
						BookListVO vo4 = data4.get(mybook);
						list3.put("�뿩��ȣ : "+treenum2+"��  ["+treenum+"]", " "+loginid +"���� "+"<"+msg+">"+"������ �뿩�ϼ̽��ϴ�."+"�ݳ� ���� �ð���["+treenum3+"]�Դϴ�.");
						treenum2++;
						System.out.println("------------------------------------------------");
						System.out.println("�뿩�Ⱓ�� 2���Դϴ�.");
						System.out.println(treenum3+"���� �ݳ��� �ּ���."); 
						System.out.println("------------------------------------------------");
						System.out.println("------------------- �뿩 ���� ���� -------------------");
						vo4.print(); 
						System.out.println("------------------------------------------------");
						mybook++;
						break;
					}else if(rent.equals("2")) {
						break;
					}else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					}
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}while(true);
	}
	
	//���� �ݳ��ϱ�
	public void bookreturn(String msg) {
		do {
			BookListVO vo = list.get(msg);
			if(vo!=null) {
				String rent = conInput("�ݳ��Ͻðڽ��ϱ�?(1:��, 2:�ƴϿ�)");
					if(rent.equals("1")) {
						vo.setRental("��ġ��");
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
	
	
	
	//�ߺ��˻� //��ȭ��ȣ, �̸���
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
	
	//�ߺ��˻� //���� �뿩�Ҷ� 
	public boolean cc(String msg) {
		List<BookListVO> data3 = new  ArrayList<BookListVO>();   //�ߺ��˻�
		data3.addAll(list.values()); //������ list�� ����ֱ�
		for(int i=0; i<bookcnt; i++) {
				if(msg.equals(data3.get(i).getName())) {
					if("�뿩��".equals(data3.get(i).getRental())) {
						System.out.println("�뿩���� �����Դϴ�.");
						return false;
					}
				}
		}
		return true;
	}	
	
	//�ߺ��˻� ���� �ݳ��ҋ�
	public boolean dd(String msg) {
		for(int i=0; i<mybook; i++) {
				if(msg.equals(data4.get(i).getName())) {
					if("�뿩��".equals(data4.get(i).getRental())) {
						System.out.println("�뿩���� �����Դϴ�.");
						return true;
					}
					System.out.println("�� å�� �뿩���� �ʾҽ��ϴ�.");
					
				}
		}
		return false;
	}		


	//���� �˻� 
	public void bookListSearch() {
		do {
			String book = conInput("�������� �Է��ϼ���. (1: ������) ");
			BookListVO vo = list.get(book);
			if(vo!=null) {
				System.out.println("-----------------------");
				vo.print();
				break;
			}else if(book.equals("1")){
				break;
			}
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}while(true);
	}


	//�Է� ���
	public String conInput(String msg) {
		System.out.print(msg + "=");
		return scan.nextLine();
	}
	
	
	public void memberList2() {
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("  |ȸ�� ��ȣ|     |���̵�|     |�н�����|   |�̸�|        |�ּ�|       |����ó|               |Email|");
		System.out.println("-----------------------------------------------------------------------------------------------");
		List<MemberVO> lst = new ArrayList<MemberVO>();
		lst.addAll(list2.values()); 
		Collections.sort(lst, new CompareNumAsc2());
		for(MemberVO vo : lst) {
			vo.output();
		}
	}
	
	
	/////////////// å ���� ȣ�����
	public void bookList() { //����
		String bookmenu = conInput("��� �����ұ��?(1:������ȣ, 2:�帣��, 3:����⵵ �ֱټ�)");
		if(bookmenu.equals("1")) { //������ȣ�� 
			System.out.println("---------------------------------------------------------------------");
			System.out.println("|���� ��ȣ|          ������                  |    ����        |���� �⵵|  �帣    |  ��ġ����    |");	
			System.out.println("---------------------------------------------------------------------");
			List<BookListVO> lst = new ArrayList<BookListVO>();
			lst.addAll(list.values()); 
			Collections.sort(lst, new CompareNumAsc());
			for(BookListVO vo : lst) {
				vo.output();
			}			
		}else if(bookmenu.equals("2")) {//�帣���ε� �����ϴ°� �� ������ �帣�� �̾Ƽ� ������ �� �ְ�.
			//1���� �帣��, 2�� ������ �帣����
			String genreqna = conInput("1:�帣 �����ټ�, 2:�帣 ���� ����");
			if(genreqna.equals("1")) {
				System.out.println("---------------------------------------------------------------------");
				System.out.println("|���� ��ȣ|          ������                  |    ����        |���� �⵵|  �帣    |  ��ġ����    |");	
				System.out.println("---------------------------------------------------------------------");
				List<BookListVO> lst = new ArrayList<BookListVO>();
				lst.addAll(list.values()); 
				Collections.sort(lst, new CompareGenreQna());
				for(BookListVO vo : lst) {
					vo.output();
				}
			}else if(genreqna.equals("2")){
				String genreqna2 = conInput("�帣 ����(1:����, 2:����, 3:����, 4:���, 5:����, 6:ö��)");
				if(genreqna2.equals("1")) {
					genrelist("����");
				}else if(genreqna2.equals("2")) {
					genrelist("����");
				}else if(genreqna2.equals("3")) {
					genrelist("����");
				}else if(genreqna2.equals("4")) {
					genrelist("���");
				}else if(genreqna2.equals("5")) {
					genrelist("����");
				}else if(genreqna2.equals("6")) {
					genrelist("ö��");
				}else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
				
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			
		}else if(bookmenu.equals("3")) {
			System.out.println("---------------------------------------------------------------------");			
			System.out.println("|���� ��ȣ|          ������                  |    ����        |���� �⵵|  �帣    |  ��ġ����    |");
			System.out.println("---------------------------------------------------------------------");
			List<BookListVO> lst = new ArrayList<BookListVO>();
			lst.addAll(list.values()); 
			Collections.sort(lst, new CompareYearAsc());
			for(BookListVO vo : lst) {
				vo.output();
			}		
		}else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
	
	
	class CompareNumAsc implements Comparator<BookListVO>{ //������ȣ�� ��������
		public int compare(BookListVO v1, BookListVO v2) { 
			return (v1.getNum()  <  v2.getNum())? -1 : (v1.getNum() > v2.getNum())? 1 : 0;   
		} 
	}	
	
	class CompareNumAsc2 implements Comparator<MemberVO>{ //ȸ����ȣ�� ��������
		public int compare(MemberVO v1, MemberVO v2) { 
			return (v1.getNum()  <  v2.getNum())? -1 : (v1.getNum() > v2.getNum())? 1 : 0;   
		} 
	}		
	
	class CompareYearAsc implements Comparator<BookListVO>{ //�⵵ ��������
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
		List<BookListVO> data3 = new  ArrayList<BookListVO>();   //�ߺ��˻�
		data3.addAll(list.values()); //������ list�� ����ֱ�
		for(int i=0; i<bookcnt; i++) {
			BookListVO vo4 = data3.get(i);
				if(msg.equals(data3.get(i).getGenre())) {
						vo4.output(); //���
				}
		}
	}
	
	////////////////////////// �ð� ���
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
			case 1: weekStr = "��";break;
			case 2: weekStr = "��";break;
			case 3: weekStr = "ȭ";break;
			case 4: weekStr = "��";break;
			case 5: weekStr = "��";break;
			case 6: weekStr = "��";break;
			case 7: weekStr = "��";break;
			}

		String amStr="";
		if(amPm==0){
			amStr = "����";
		}else{
			amStr = "����";
		}

		treenum = year+"�� "+monthStr+"�� "+day+"�� "+weekStr+"���� "+amStr+hour+"��"+minute+"��";

	}
	public void lastDay() {//�ݳ���
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
