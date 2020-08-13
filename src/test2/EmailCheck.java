package test2;
import java.util.Scanner;

public class EmailCheck {
	Scanner scan = new Scanner(System.in);
	
	public EmailCheck() {
	}
	
	public boolean emailCheckStart(String msg) {
		do {
			String email = msg;

			if(emailCheck(email)){
				//정상 이메일
				return true;
			}else {
				return false;
			}
		}while(true);
	}
	
	public boolean emailCheck(String email) {
		int atMark = email.indexOf("@");
		int point = email.indexOf(".");
		if(atMark<3 || point<6 || point<atMark || point-atMark<2 || atMarkCount(email,'@')!=1 || atMarkCount(email, '.')>2) { 
			return false;  
		}else {
			return true; 
		}
	}	
	public int atMarkCount(String email, char str) {
		int cnt=0;
		for(int i=0; i<email.length(); i++) {
			if(email.charAt(i)=='@') {
				cnt++;
			}
		}
		return cnt;
	}	

}
