package HW2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AcceptAppointment
 */
@WebServlet("/AcceptAppointment")
public class AcceptAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CusName = request.getParameter("CusName");
		String ScheduleDate = request.getParameter("ScheduleDate");
		Integer AptNo = 0;
		if(request.getParameter("AptNo") != "")
			AptNo = Integer.parseInt(request.getParameter("AptNo"));
		List<Appointment> AppoEntries = (List<Appointment>)getServletContext().getAttribute("AppoEntries");
		for(Appointment AppoE : AppoEntries){
			if(AppoE.getAppNo().equals(AptNo) && AppoE.getCusName().equals(CusName) && AppoE.getStatus().equals("Scheduled")){
				Connection c = null;
				Statement stmt = null;
				try
		        {
					c = Connect_db.getConnection();
		            stmt = c.createStatement();
		            stmt.executeUpdate( "Update appointment set status = 'Appointment Confirm' where cusname = '" 
		            					+ CusName + "' and aptno = " + AptNo + " and schedule = '" + ScheduleDate + "'");
		            
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
				break;
			}
		}
		getServletContext().setAttribute( "AppoEntries", AppoEntries );
		response.sendRedirect("LookUpApartment");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
