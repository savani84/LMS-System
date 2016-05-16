package HW2;

import java.util.Date;

public class Rent {
	String custname = "";
	Integer aptno = 0;
	String leasename = "";
	Date leasedate = new Date();
	String doclist = "";
	Integer deposit = 0;
	Integer rent = 0;
	Integer rent_id = 0;
	
	public Rent(String custname, Integer aptno, String leasename,
			Date leasedate, String doclist, Integer deposit, Integer rent,Integer rent_id) {
		super();
		this.custname = custname;
		this.aptno = aptno;
		this.leasename = leasename;
		this.leasedate = leasedate;
		this.doclist = doclist;
		this.deposit = deposit;
		this.rent = rent;
		this.rent_id = rent_id;
	}
	public Integer getrentid() {
		return rent_id;
	}
	public void setrentid(Integer rent_id) {
		this.rent_id = rent_id;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public Integer getAptno() {
		return aptno;
	}
	public void setAptno(Integer aptno) {
		this.aptno = aptno;
	}
	public String getLeasename() {
		return leasename;
	}
	public void setLeasename(String leasename) {
		this.leasename = leasename;
	}
	public Date getLeasedate() {
		return leasedate;
	}
	public void setLeasedate(Date leasedate) {
		this.leasedate = leasedate;
	}
	public String getDoclist() {
		return doclist;
	}
	public void setDoclist(String doclist) {
		this.doclist = doclist;
	}
	public Integer getDeposit() {
		return deposit;
	}
	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}
	public Integer getRent() {
		return rent;
	}
	public void setRent(Integer rent) {
		this.rent = rent;
	}
}
