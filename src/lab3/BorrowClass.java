package lab3;

import java.util.Date;

public class BorrowClass {
	Integer id = 0;
	String title = "";
	String studentname = "";
	Date borrowdate = new Date();
	public BorrowClass(Integer id, String title, String studentname,
			Date borrowdate) {
		super();
		this.id = id;
		this.title = title;
		this.studentname = studentname;
		this.borrowdate = borrowdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public Date getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}
	

}
