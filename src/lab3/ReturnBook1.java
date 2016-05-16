package lab3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReturnBook1
 */
@WebServlet("/ReturnBook1")
public class ReturnBook1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBook1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer myID =Integer.parseInt(request.getParameter("myID"));
		List<Library> entries = (List<Library>)getServletContext().getAttribute("entries");
		if(entries != null)
		{
			for(Library entry: entries)
			{
				if(entry.getLibid() == myID)
				{
					entry.setPages(entry.getPages() + 1);
					break;
				}
			}	
		}
		List<BorrowClass> borrowentries = (List<BorrowClass>)getServletContext().getAttribute("borrowentries");
		if(borrowentries != null)
		{
			for(BorrowClass borrowentry: borrowentries)
			{
				if(borrowentry.getId() == myID)
				{
					borrowentries.remove(borrowentry);					
					break;
				}
			}	
		}
		response.sendRedirect("ViewLibrary");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
