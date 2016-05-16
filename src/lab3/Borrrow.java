package lab3;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Borrrow
 */
@WebServlet("/Borrrow")
public class Borrrow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Borrrow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer myID =Integer.parseInt(request.getParameter("myID"));
		String myBookTitle = request.getParameter("myBookTitle");
		request.setAttribute("myID",myID);
		request.setAttribute("myBookTitle",myBookTitle);
		request.getRequestDispatcher("Borrow.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Student =request.getParameter("Student");
		String Title =request.getParameter("Title");
		Integer ID =Integer.parseInt(request.getParameter("LibID"));
		String ErrMsg = "";
		if(Student == "")
		{
			ErrMsg = "Please Enter Student Name...";
		}
		List<BorrowClass> entries = null;
		if(getServletContext().getAttribute("borrowentries") != null)
		{
			 entries = (List<BorrowClass>)getServletContext().getAttribute("borrowentries");
		}
		else
		{
			 entries = new ArrayList<BorrowClass>();
		}
		
		
		if(ErrMsg == "")
		{
			List<Library> entries2 = (List<Library>)getServletContext().getAttribute("entries");
			if(entries2 != null)
			{
				for(Library entry: entries2)
				{
					if(entry.getLibid() == ID)
					{
						entry.setPages(entry.getPages() - 1);
						break;
					}
				}	
			}
			String now = new Date().toString();
			java.util.Date DateNow = new Date();
			DateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
			try {
				DateNow = sdf.parse(now);
			} catch (ParseException e) {
			}
			entries.add(new BorrowClass(ID,Title,Student,DateNow));
			getServletContext().setAttribute( "borrowentries", entries );
			response.sendRedirect("ViewLibrary");
		}
		else
		{
			request.setAttribute("htmlentries",entries);
			request.setAttribute("ErrMsg2",ErrMsg);
			request.getRequestDispatcher("Borrow.jsp").forward(request, response);
		}
	}

}
