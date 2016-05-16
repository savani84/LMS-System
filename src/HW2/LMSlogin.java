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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LMSlogin
 */
@WebServlet("/LMSlogin")
public class LMSlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LMSlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Hw2/LMSlogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Customer> entries = new ArrayList<Customer>();
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
        {
			c = Connect_db.getConnection();

            stmt = c.createStatement();
            rs = stmt.executeQuery( "select * from customer" );
            java.util.Date NeedDate = null;
            DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
            
            while( rs.next() )
            {
            	NeedDate = null;
            	if(rs.getString("needdate") != null){
            		try {
						NeedDate = sdf.parse(rs.getString("needdate"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
            	}
            	entries.add(new Customer(rs.getString("role"),rs.getString("usernm"),rs.getString("emailid"),
            							 rs.getString("userpassword"),rs.getString("contact"),rs.getInt("pplno"),
            							 rs.getString("occupation"),rs.getString("type"),rs.getString("preference"),NeedDate));
            }
            
            c.close();
            rs.close();
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
			if(rs != null){
				try {
					rs.close();
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
		getServletContext().setAttribute( "entries", entries );
		String button_param1 = "";
		String button_param2 = "";
		if(request.getParameter("Login") != null)
			button_param1 = request.getParameter("Login");
		if(request.getParameter("Clear") != null)
			button_param2 = request.getParameter("Clear");
		if (button_param1.equals("Login")) {
			String EmailID = request.getParameter("EmailID");
			String Pass = request.getParameter("Pass");
			String ErrMsg = "";
			if(EmailID == "")
			{
				ErrMsg = "Please Enter Email ID...";
			}
			else if(Pass == "")
			{
				ErrMsg = "Please Enter Password...";
			}
			if(ErrMsg != "")
			{
				request.setAttribute("error", ErrMsg);
				doGet(request, response);
			}
			else
			{
				Boolean successfullLogin = false;
				String UserNm = "";
				String Role = "";
				HttpSession session = request.getSession();
				
				for(Customer entry : entries )
				{
					if(entry.getEmailID().equals(EmailID) && entry.getPassword().equals(Pass))
					{
						successfullLogin = true;
						UserNm = entry.getUserNm();
						Role = entry.getrole();
					}
				}
				if(successfullLogin == true)
				{
					session.setAttribute("name", UserNm);
					session.setAttribute("Role", Role);
					if(Role.equals("admin")){
						response.sendRedirect("ManagerHome");
					}
					else{
						response.sendRedirect("LookUpApartment");
					}
				}
				else
				{
					request.setAttribute("error", "Invalid Username and/or Password");
					doGet(request, response);
				}
			}
		} else if (button_param2.equals("Clear")) {
			response.sendRedirect("LMSlogin");
		}
		
	}
}
