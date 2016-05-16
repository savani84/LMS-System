package HW2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RentOut
 */
@WebServlet("/RentOut")
public class RentOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Hw2/RentOut.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ErrMsg = "";
		Integer AptNo = 0;
		if(request.getParameter("AptNo") != null)
			AptNo = Integer.parseInt(request.getParameter("AptNo"));
		String CutName = request.getParameter("CutName");
		String LDate = request.getParameter("LDate");
		String LName = request.getParameter("LName");
		String DocList = request.getParameter("DocList");
		Integer Rent = 0;
		if(request.getParameter("Rent") != null)
			Rent = Integer.parseInt(request.getParameter("Rent"));
		Integer Deposit = 0;
		if(request.getParameter("Deposit") != null)
			Deposit = Integer.parseInt(request.getParameter("Deposit"));
		if(LDate == ""){
			ErrMsg = "Please Enter Lease Date...";
		}
		else if(LName == ""){
			ErrMsg = "Please Enter Lease Holder Name...";
		}
		else if(DocList == ""){
			ErrMsg = "Please Enter Document List...";
		}
		else if(Rent == 0){
			ErrMsg = "Please Enter Rent...";
		}
		else if(Deposit == 0){
			ErrMsg = "Please Enter Deposit...";
		}
		else{
			ErrMsg = "";
		}
		java.util.Date NeedDate = null;
		if(ErrMsg == "")
		{
			if(LDate != "")
			{
				DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
				try {
					NeedDate = sdf.parse(LDate);
				} catch (ParseException e) {
					ErrMsg = "Write Lease Date in MM/dd/yyyy hh:mm:ss format...";
				}
			}
		}
		
		if(ErrMsg == "")
		{
			Connection c = null;
			Statement stmt = null;
			try
	        {
				c = Connect_db.getConnection();
	            stmt = c.createStatement();
	            stmt.executeUpdate( "Insert into rent(custname,aptno,leasename,leasedate,doclist,deposit,rent)" + 
	            					" values('" + CutName + "'," + AptNo + ",'" + LName 
	            					+ "','" + LDate + "','" + DocList + "'," + Deposit + "," + Rent + ")");
	            stmt.close();
	        
	            stmt = c.createStatement();
	            stmt.executeUpdate( "update apartment set vacant = 'false' where aptno = " + AptNo);
				stmt.close();
				
				stmt = c.createStatement();
				stmt.executeUpdate( "delete from appointment where status != 'Appointment Confirm' and cusname != '" 
									+ CutName + "' and aptno = " + AptNo);
				stmt.close();
				
				c.close();
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
			response.sendRedirect("ViewAppointment?AptNo=" + AptNo);
		}
		else
		{
			request.setAttribute("ErrMsg3",ErrMsg);
			request.getRequestDispatcher("Hw2/RentOut.jsp?AptNo=" + AptNo + "&CutName=" + CutName).forward(request, response);
		}
	}
}
