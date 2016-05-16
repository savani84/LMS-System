package HW2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * Servlet implementation class AddApartment
 */
@WebServlet("/AddApartment")
public class AddApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddApartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if( request.getSession().getAttribute("name") == null )
        {
			if(request.getSession().getAttribute("Role") != "admin")
			{
				response.sendRedirect( "LMSlogin" );
	            return;
			}
        }
		request.getRequestDispatcher("Hw2/AddApartment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String button_param1 = "";
		String button_param2 = "";
		if(request.getParameter("Submit") != null)
			button_param1 = request.getParameter("Submit");
		if(request.getParameter("Clear") != null)
			button_param2 = request.getParameter("Clear");
		
		if (button_param1.equals("Submit")) {
			Integer AptNo = 0;
			Integer Maxppl = 0;
			Integer Rent = 0;
			Integer Deposits = 0;
			if(request.getParameter("AptNo") != "")
				AptNo = Integer.parseInt(request.getParameter("AptNo"));
			String Type = request.getParameter("Type");
			String Facilities = request.getParameter("Facilities");
			if(request.getParameter("Maxppl") != "")
				Maxppl = Integer.parseInt(request.getParameter("Maxppl"));
			if(request.getParameter("Rent") != "")
				Rent = Integer.parseInt(request.getParameter("Rent"));
			if(request.getParameter("Deposits") != "")
				Deposits = Integer.parseInt(request.getParameter("Deposits"));
			String ErrMsg = "";
			if(AptNo == 0)
			{
				ErrMsg = "Please Enter Apartment Number...";
			}
			else if(Facilities == "")
			{
				ErrMsg = "Please Enter Facility...";
			}
			else if(Maxppl == 0)
			{
				ErrMsg = "Please Enter Maximum People...";
			}
			else if(Rent == 0)
			{
				ErrMsg = "Please Enter Rent...";
			}
			else if(Deposits == 0)
			{
				ErrMsg = "Please Enter Deposits...";
			}
			if(ErrMsg != "")
			{
				request.setAttribute("error2", ErrMsg);
				doGet(request, response);
			}
			else
			{
				Connection c = null;
				Statement stmt = null;
				try
		        {
					c = Connect_db.getConnection();
		            stmt = c.createStatement();
		            stmt.executeUpdate( "Insert into apartment(aptno,type,facility,maxppl,rent,deposit,vacant) values(" 
		            					+ AptNo + ",'" + Type + "','" + Facilities + "'," + Maxppl +"," + Rent + ","
		            					+ Deposits + ",'true')" );
		            
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
				response.sendRedirect("ViewApartment");
			}
		} else if (button_param2.equals("Clear")) {
			response.sendRedirect("AddApartment");
		}
	}
}
