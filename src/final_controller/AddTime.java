package final_controller;

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
 * Servlet implementation class AddTime
 */
@WebServlet("/AddTime")
public class AddTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("AddTime.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ErrMsg = "";
		String time = request.getParameter("time");
		if(time == ""){
			ErrMsg = "Please Enter Time Slot...";
		}
		
		if(ErrMsg == "")
		{
			Connection c = null;
			Statement stmt = null;
			try
	        {
				c = Db_connect.getConnection();
	            stmt = c.createStatement();
	            stmt.executeUpdate( "Insert into time(time) values('" + time + "')");
	            
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
			response.sendRedirect("Final");
		}
		else
		{
			request.setAttribute("ErrMsg1",ErrMsg);
			request.getRequestDispatcher("AddTime.jsp").forward(request, response);
		}
		
	}

}
