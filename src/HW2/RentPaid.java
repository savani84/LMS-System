package HW2;

public class RentPaid {
	String custname = "";
	Integer aptno = 0;
	Integer rent = 0;
	Integer paidrent = 0;
	String month = "";
	String year = "";
	
	public RentPaid(String custname, Integer aptno, Integer rent,
			Integer paidrent, String month, String year) {
		super();
		this.custname = custname;
		this.aptno = aptno;
		this.rent = rent;
		this.paidrent = paidrent;
		this.month = month;
		this.year = year;
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
	public Integer getRent() {
		return rent;
	}
	public void setRent(Integer rent) {
		this.rent = rent;
	}
	public Integer getPaidrent() {
		return paidrent;
	}
	public void setPaidrent(Integer paidrent) {
		this.paidrent = paidrent;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
