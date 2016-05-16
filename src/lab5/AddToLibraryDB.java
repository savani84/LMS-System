package lab5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HW2.Connect_db;
import lab3.Library;

/**
 * Servlet implementation class AddToLibraryDB
 */
@WebServlet("/AddToLibraryDB")
public class AddToLibraryDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToLibraryDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Library> entries = (List<Library>)getServletContext().getAttribute("entries");
		request.setAttribute("htmlentries",entries);
		request.getRequestDispatcher("AddToLib.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Library> entries = (List<Library>)getServletContext().getAttribute("entries");
		Integer LibID = Integer.parseInt(request.getParameter("LibID"));
		String Title = request.getParameter("Title");
		String Author =request.getParameter("Author");
		Integer Copies = 0;
		if(request.getParameter("Copies") != "")
			Copies = Integer.parseInt(request.getParameter("Copies"));
		String ErrMsg = "";
		if(Title == "")
		{
			ErrMsg = "Please Enter Title...";
		}
		else if(Author == "")
		{
			ErrMsg = "Please Enter Author Name...";
		}
		else if(Copies == 0)
		{
			ErrMsg = "Please Enter Copies of this book...";
		}
		else
		{
			ErrMsg = "";
		}
		
		if(ErrMsg == "")
		{
			Connection c = null;
			Statement stmt = null;
			
			try
	        {
	            c = Connect_db.getConnection();
	            stmt = c.createStatement();
	            stmt.executeUpdate( "Insert into books(Id,title,author,copies) values(" + LibID + ",'"
	            					+ Title + "','" + Author + "'," + Copies +")" );
	            
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
			response.sendRedirect("ViewLibraryDB");
		}
		else
		{
			request.setAttribute("htmlentries",entries);
			request.setAttribute("ErrMsg",ErrMsg);
			request.getRequestDispatcher("AddToLib.jsp").forward(request, response);
		}
	}

}
