package test3;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BookRequestVO {
	private String rbookName;
	private String rwriter;
	private String rpublisher;
	private int rpublishYear;
	private int rbookNum;
	
	public BookRequestVO() {}

	//책 제목, 저자, 출판사, 출판년도, 분류번호
	public BookRequestVO(String rbookName, String rwriter, String rpublisher, int rpublishYear, int rbookNum) {
		this.rbookName=rbookName;
		this.rwriter=rwriter;
		this.rpublisher=rpublisher;
		this.rpublishYear=rpublishYear;
		this.rbookNum=rbookNum;
	}
	
	public void output() {
		System.out.printf("%-30s %-10s %-10s %-7d %-3d\n", rbookName, rwriter, rpublisher, rpublishYear, rbookNum);
	}

	public String getRbookName() {
		return rbookName;
	}

	public void setRbookName(String rbookName) {
		this.rbookName = rbookName;
	}

	public String getRwriter() {
		return rwriter;
	}

	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}

	public String getRpublisher() {
		return rpublisher;
	}

	public void setRpublisher(String rpublisher) {
		this.rpublisher = rpublisher;
	}

	public int getRpublishYear() {
		return rpublishYear;
	}

	public void setRpublishYear(int rpublishYear) {
		this.rpublishYear = rpublishYear;
	}

	public int getRbookNum() {
		return rbookNum;
	}

	public void setRbookNum(int rbookNum) {
		this.rbookNum = rbookNum;
	}
	
	
	
	
	

}
