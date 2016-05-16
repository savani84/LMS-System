package HW2;

public class Apartment {
	Integer aptno;
	String type;
	String facility;
	Integer maxppl;
	Integer rent;
	Integer deposit;
	Boolean vacant;
	
	public Apartment(Integer AptNo, String Type, String Facility, Integer Maxppl, Integer Rent, Integer Deposit, Boolean Vacant)
    {
        this.aptno = AptNo;
        this.type = Type;
        this.facility = Facility;
        this.maxppl = Maxppl;
        this.rent = Rent;
        this.deposit = Deposit;
        this.vacant = Vacant;
    }
	public Integer getAptNo()
	{
		return aptno;
	}
	public String getType()
	{
		return type;
	}
	public String getFacility()
	{
		return facility;
	}
	public Integer getMaxppl()
	{
		return maxppl;
	}
	public Integer getRent()
	{
		return rent;
	}
	public Integer getDeposit()
	{
		return deposit;
	}
	public Boolean getVacant()
	{
		return vacant;
	}
	public void setVacant(Boolean vacant)
	{
		this.vacant = vacant;
	}
}
