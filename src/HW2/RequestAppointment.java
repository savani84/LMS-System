package HW2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestAppointment
 */
@WebServlet("/RequestAppointment")
public class RequestAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CusName = request.getParameter("CusName");
		Integer AptNo = 0;
		if(request.getParameter("AptNo") != "")
			AptNo = Integer.parseInt(request.getParameter("AptNo"));
		Connection c = null;
		Statement stmt = null;
		try
        {
			c = Connect_db.getConnection();
            stmt = c.createStatement();
            stmt.executeUpdate( "Insert into appointment(status,cusname,aptno) values('Requested','" 
            				    + CusName + "'," + AptNo + ")");
            
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
		response.sendRedirect("LookUpApartment");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
