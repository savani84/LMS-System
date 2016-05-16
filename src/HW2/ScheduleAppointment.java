package HW2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ScheduleAppointment
 */
@WebServlet("/ScheduleAppointment")
public class ScheduleAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Appointment> AppoEntries = (List<Appointment>)getServletContext().getAttribute("AppoEntries");
		Integer AptNo = Integer.parseInt(request.getParameter("AptNo"));
		Integer mycnt = Integer.parseInt(request.getParameter("mycnt"));
		String Btn = "";
		String SDate = "";
		String UName = "";
		String ScheduleDate = "";
		String UserName = "";
		String ErrMsg = "";
		java.util.Date NeedDate = null;
		int i = 1;
		while(i <= mycnt)
		{
			Btn = "sub"  + i;
			if(request.getParameter(Btn) != null){
				SDate = "txt" + i;
				UName = "usr" + i;
				ScheduleDate = request.getParameter(SDate);
				UserName = request.getParameter(UName);
				if(ScheduleDate == ""){
					ErrMsg = "Please Enter Date...";
				}
				if(ErrMsg == "")
				{
					if(ScheduleDate != "")
					{
						DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
						try {
							NeedDate = sdf.parse(ScheduleDate);
						} catch (ParseException e) {
							ErrMsg = "Write Date in MM/dd/yyyy hh:mm:ss format...";
						}
					}
				}
				if(ErrMsg == ""){
					for(Appointment AppoE : AppoEntries){
						if(AppoE.getAppNo().equals(AptNo) && AppoE.getCusName().equals(UserName)){
							if(AppoE.getStatus().equals("Denied")){
								Connection c = null;
								Statement stmt = null;
								try
						        {
									c = Connect_db.getConnection();
						            stmt = c.createStatement();
						            stmt.executeUpdate( "Insert into appointment(schedule,status,cusname,aptno) values('" 
						            				   + ScheduleDate + "','Scheduled','" + UserName + "'," + AptNo + ")");
						            
						            c.close();
						            stmt.close();
						        }
						        catch (SQLException e) {
						        	throw new ServletException( e );
								}
								finally{
									if(c != null){
										try {
											c.close();
										} catch (SQLException e) {
											throw new ServletException( e );
										}
									}
									if(stmt != null){
										try {
											stmt.close();
										} catch (SQLException e) {
											throw new ServletException( e );
										}
									}
								}
							}else{
								Connection c = null;
								Statement stmt = null;
								try
						        {
									c = Connect_db.getConnection();
						            stmt = c.createStatement();
						            stmt.executeUpdate( "Update appointment set status = 'Scheduled',schedule = '" 
						            					+ ScheduleDate +"' where cusname = '" + UserName + "' and aptno = " + AptNo);
						            
						            c.close();
						            stmt.close();
						        }
						        catch (SQLException e) {
						        	throw new ServletException( e );
								}
								finally{
									if(c != null){
										try {
											c.close();
										} catch (SQLException e) {
											throw new ServletException( e );
										}
									}
									if(stmt != null){
										try {
											stmt.close();
										} catch (SQLException e) {
											throw new ServletException( e );
										}
									}
								}
							}
							break;
						}
					}
					response.sendRedirect("ViewAppointment?AptNo=" + AptNo);
				}
				else{
					request.setAttribute("ErrMsg2",ErrMsg);
					request.getRequestDispatcher("Hw2/ViewAppointment.jsp?AptNo=" + AptNo).forward(request, response);
				}
				break;
			}
			i = i + 1;
		}
	}
}