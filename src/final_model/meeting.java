package final_model;

public class meeting {
	String day;
	String time;
	String meetingnotes;
	public meeting(String day, String time, String meetingnotes) {
		super();
		this.day = day;
		this.time = time;
		this.meetingnotes = meetingnotes;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMeetingnotes() {
		return meetingnotes;
	}
	public void setMeetingnotes(String meetingnotes) {
		this.meetingnotes = meetingnotes;
	}
	
}
