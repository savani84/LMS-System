package lab5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW2.Connect_db;
import lab3.Library;

/**
 * Servlet implementation class ViewLibraryDB
 */
@WebServlet("/ViewLibraryDB")
public class ViewLibraryDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewLibraryDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
        {
			c = Connect_db.getConnection();

            stmt = c.createStatement();
            rs = stmt.executeQuery( "select * from books" );
            List<Library> entries = new ArrayList<Library>();
            
            while( rs.next() )
            {
            	entries.add(new Library(rs.getInt("Id"),rs.getString("title"),rs.getString("author"),rs.getInt("copies")));
            }
            getServletContext().setAttribute( "entries", entries );
            request.setAttribute("htmlentries",entries);
            request.getRequestDispatcher("ViewLib.jsp").forward(request, response);
            
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
