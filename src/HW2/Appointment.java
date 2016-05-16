package HW2;

import java.util.Date;

public class Appointment {
	Date schedule = new Date();
	String status = "";
	String cusname = "";
	Integer appno = 0;
	
	public Appointment(Date schedule, String status, String cusName,Integer appNo) {
		super();
		this.schedule = schedule;
		this.status = status;
		this.cusname = cusName;
		this.appno = appNo;
	}
	public Date getSchedule() {
		return schedule;
	}
	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCusName() {
		return cusname;
	}
	public void setCusName(String cusName) {
		this.cusname = cusName;
	}
	public Integer getAppNo() {
		return appno;
	}
	public void setAppNo(Integer appNo) {
		this.appno = appNo;
	}
}
