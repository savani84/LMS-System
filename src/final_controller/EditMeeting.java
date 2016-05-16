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
 * Servlet implementation class EditMeeting
 */
@WebServlet("/EditMeeting")
public class EditMeeting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMeeting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("EditMeeting.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String day = request.getParameter("day");
		String time = request.getParameter("time");
		String notes = request.getParameter("notes");
		Connection c = null;
		Statement stmt = null;
		try
        {
			c = Db_connect.getConnection();
            stmt = c.createStatement();
            if(request.getParameter("Save") != null){
            	stmt.executeUpdate("update meeting set meetingnotes = '" + notes + "' where day ='" + day + "' and time = '" + time + "'");
    		}else if(request.getParameter("Delete") != null){
    			stmt.executeUpdate("delete from meeting where day ='" + day + "' and time = '" + time + "'");
    		}
            
            
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

}
