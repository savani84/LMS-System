package HW2;

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

/**
 * Servlet implementation class RentHistory
 */
@WebServlet("/RentHistory")
public class RentHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<RentPaid> RentPaidentries = new ArrayList<RentPaid>();
		
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
        {
			c = Connect_db.getConnection();
            stmt = c.createStatement();
            rs = stmt.executeQuery( "Select aptno,custname,rent,paid_rent,paid_month,paid_year From rent r,rent_paid p where r.rent_id = p.rent_id" );
            
            while( rs.next() )
            {
            	RentPaidentries.add(new RentPaid(rs.getString("custname"),rs.getInt("aptno"),rs.getInt("rent"),
            			rs.getInt("paid_rent"),rs.getString("paid_month"),rs.getString("paid_year")));
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
		getServletContext().setAttribute( "RentPaidentries", RentPaidentries );
		request.getRequestDispatcher("Hw2/RentHistory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
