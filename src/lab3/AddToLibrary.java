package lab3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * Servlet implementation class AddToLibrary
 */
@WebServlet("/AddToLibrary")
public class AddToLibrary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToLibrary() {
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
		// TODO Auto-generated method stub
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
			
		}
		else
		{
			request.setAttribute("htmlentries",entries);
			request.setAttribute("ErrMsg",ErrMsg);
			request.getRequestDispatcher("AddToLib.jsp").forward(request, response);
		}
	}

}
