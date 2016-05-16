package HW2;

import java.util.Date;

public class Customer {
	String role;
	String usernm;
	String emailid;
	String password;
	String contact;
	Integer pplno;
	String occupation;
	String type;
	String preference;
	Date needdate = new Date();
	
	public Customer(String role, String UserNm, String EmailID, String Password, String Contact, Integer pplNo, String Occupation, String Type, String Preference, Date NeedDate)
    {
        this.role = role;
        this.usernm = UserNm;
        this.emailid = EmailID;
        this.password = Password;
        this.contact = Contact;
        this.pplno = pplNo;
        this.occupation = Occupation;
        this.type = Type;
        this.preference = Preference;
        this.needdate = NeedDate;
    }
	
	public String getrole()
	{
		return role;
	}
	public String getUserNm()
	{
		return usernm;
	}public String getEmailID()
	{
		return emailid;
	}
	public String getPassword()
	{
		return password;
	}
	public String getContact()
	{
		return contact;
	}
	public Integer getpplNo()
	{
		return pplno;
	}
	public String getOccupation()
	{
		return occupation;
	}
	public String getType()
	{
		return type;
	}
	public String getPreference()
	{
		return preference;
	}
	public Date getNeedDate()
	{
		return needdate;
	}
}
