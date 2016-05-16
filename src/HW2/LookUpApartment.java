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
 * Servlet implementation class LookUpApartment
 */
@WebServlet("/LookUpApartment")
public class LookUpApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookUpApartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Appointment> entries = new ArrayList<Appointment>();
		List<Apartment> Apartmententries = new ArrayList<Apartment>();
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
        {
			c = Connect_db.getConnection();
			
			stmt = c.createStatement();
            rs = stmt.executeQuery( "select * from apartment" );
            
            while( rs.next() )
            {
            	Apartmententries.add(new Apartment(rs.getInt("aptno"),rs.getString("type"),rs.getString("facility"),
            			rs.getInt("maxppl"),rs.getInt("rent"),rs.getInt("deposit"),rs.getBoolean("vacant")));
            }
            
            rs.close();
            stmt.close();

            stmt = c.createStatement();
            rs = stmt.executeQuery( "select * from appointment" );
            java.util.Date NeedDate = null;
            DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
            
            while( rs.next() )
            {
            	NeedDate = null;
            	if(rs.getString("schedule") != null){
            		try {
						NeedDate = sdf.parse(rs.getString("schedule"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
            	}
            	entries.add(new Appointment(NeedDate,rs.getString("status"),rs.getString("cusname"),rs.getInt("aptno")));
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
		getServletContext().setAttribute( "Appentries", Apartmententries );
		getServletContext().setAttribute( "AppoEntries", entries );
		request.getRequestDispatcher("Hw2/LookUpApartment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
