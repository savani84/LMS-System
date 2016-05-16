package HW2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterResident
 */
@WebServlet("/RegisterResident")
public class RegisterResident extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterResident() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Register Resident</title></head><body>" );
        out.println( "<form action=\"RegisterResident\" method=\"POST\">" );
        out.println( "<table align=\"center\" valign=\"middle\" border=\"1\">" );
        out.println("<tr><td align=\"center\" colspan=\"3\"><h3>Leasing Management System</h3></td></tr>");
        out.println("<tr><td align=\"center\" colspan=\"3\">Sign Up</td></tr>");
        out.println( "<tr><td>User Name</td><td><input type=\"text\" name=\"UserNm\" value=\"\"></td></tr>" );
        out.println( "<tr><td>Email ID</td><td><input type=\"text\" name=\"EmailID\" value=\"\"></td></tr>" );
        out.println( "<tr><td>Password</td><td><input type=\"Password\" name=\"Pass\" value=\"\"></td></tr>" );
        out.println( "<tr><td>Con. Password</td><td><input type=\"Password\" name=\"ConPass\" value=\"\"></td></tr>" );
        out.println( "<tr><td>Contact #</td><td><input type=\"text\" name=\"Contact\" value=\"\"></td></tr>" );
        out.println( "<tr><td># People</td><td><input type=\"text\" name=\"People\" value=\"\"></td></tr>" );
        out.println( "<tr><td>Occupation</td><td><input type=\"radio\" name=\"Occupation\" value=\"Student\" checked>Student</input><br/>" );
        out.println( "<input type=\"radio\" name=\"Occupation\" value=\"Family\">Family</input><br/>" );
        out.println( "<input type=\"radio\" name=\"Occupation\" value=\"Business\">Business</input></td></tr>" );
        out.println( "<tr><td>Type</td><td><input type=\"radio\" name=\"Type\" value=\"1BD,1Bath\" checked>1BHK</input><br/>" );
        out.println( "<input type=\"radio\" name=\"Type\" value=\"2BD,1Bath\">2BHK - 1 Bath</input><br/>" );
        out.println( "<input type=\"radio\" name=\"Type\" value=\"2BD,2Bath\">2BHK - 2 Bath</input></td></tr>" );
        out.println( "<tr><td>Preferences</td><td><textarea name=\"Preferences\" value=\"\"></textarea></td></tr>" );
        out.println( "<tr><td>Need From Date</td><td><input type=\"text\" name=\"NeedDate\" value=\"\"></td></tr>" );
        out.println( "<tr><td colspan=\"3\" align=\"center\"><input type=submit value=\"Register\"></td></tr>" );
        if (request.getAttribute("error1") != null)
			out.println("<tr><td colspan=\"3\">" + request.getAttribute("error1") + "</td></tr>");
        out.println( "</table></form>" );
        out.println( "</body></html>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ErrMsg = "";
		String UserNm = request.getParameter("UserNm");
		String EmailID = request.getParameter("EmailID");
		String Pass = request.getParameter("Pass");
		String ConPass = request.getParameter("ConPass");
		String Contact = request.getParameter("Contact");
		Integer People = 0;
		if(request.getParameter("People") != "")
			People = Integer.parseInt(request.getParameter("People"));
		String Occupation = request.getParameter("Occupation");
		String Type = request.getParameter("Type");
		String Preferences = request.getParameter("Preferences");
		String SampleDate = request.getParameter("NeedDate");
		if(UserNm == "")
		{
			ErrMsg = "Please Enter User Name...";
		}
		else if(EmailID == "")
		{
			ErrMsg = "Please Enter Email ID...";
		}
		else if(Pass == "")
		{
			ErrMsg = "Please Enter Password...";
		}
		else if(ConPass == "")
		{
			ErrMsg = "Please Enter Confirm Password...";
		}
		else if(!Pass.equals(ConPass))
		{
			ErrMsg = "Password and Confirm Password should be same...";
		}
		else if(Contact == "")
		{
			ErrMsg = "Please Enter Contact Number...";
		}
		else if(People == 0)
		{
			ErrMsg = "Please Enter No of People...";
		}
		else if(Preferences == "")
		{
			ErrMsg = "Please Enter Preferences...";
		}
		else if(SampleDate == "")
		{
			ErrMsg = "Please Enter Need Date...";
		}
		else
		{
			ErrMsg = "";
		}
		
		java.util.Date NeedDate = null;
		if(ErrMsg == "")
		{
			if(SampleDate != "")
			{
				DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
				try {
					NeedDate = sdf.parse(SampleDate);
				} catch (ParseException e) {
					ErrMsg = "Write Need Date in MM/dd/yyyy hh:mm:ss format...";
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
	            stmt.executeUpdate( "Insert into customer(usernm,role,emailid,userpassword,contact,pplno,"
	            					+ "occupation,type,preference,needdate) values('" + UserNm 
	            					+ "','Resident','" + EmailID + "','" + Pass + "','" + Contact 
	            					+ "'," + People + ",'" + Occupation + "','" + Type + "','" + Preferences 
	            					+ "','" + SampleDate + "')");
	            
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
			response.sendRedirect("LMSlogin");
		}
		else
		{
			request.setAttribute("error1", ErrMsg);
			doGet(request, response);
		}
	}
}
