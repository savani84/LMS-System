package final_controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import final_model.meeting;
import final_model.time;

/**
 * Servlet implementation class Final
 */
@WebServlet("/Final")
public class Final extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Final() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<time> timeentries = new ArrayList<time>();
		List<meeting> meetingentries = new ArrayList<meeting>();
		
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
        {
			c = Db_connect.getConnection();
			
			stmt = c.createStatement();
            rs = stmt.executeQuery( "select * from time" );
            
            while( rs.next() )
            {
            	timeentries.add(new time(rs.getString("time")));
            }
            
            rs.close();
            stmt.close();

            stmt = c.createStatement();
            rs = stmt.executeQuery( "select * from meeting" );
            
            while( rs.next() )
            {
            	meetingentries.add(new meeting(rs.getString("day"),rs.getString("time"),rs.getString("meetingnotes")));
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
		getServletContext().setAttribute( "timeentries", timeentries );
		getServletContext().setAttribute( "meetingentries", meetingentries );
		request.getRequestDispatcher("Final.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
