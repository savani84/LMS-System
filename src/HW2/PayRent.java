package HW2;

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
 * Servlet implementation class PayRent
 */
@WebServlet("/PayRent")
public class PayRent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayRent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Hw2/PayRent.jsp").forward(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer mycnt = Integer.parseInt(request.getParameter("mycnt"));
		String ErrMsg = "";
		String Btn = "";
		String RentID = "";
		Integer RentIDvalue = 0;
		String PaidRent = "";
		Integer PaidRentvalue = 0;
		String PaidMonth = "";
		String PaidYear = "";
		int i = 1;
		while(i <= mycnt)
		{
			Btn = "sub"  + i;
			if(request.getParameter(Btn) != null){
				RentID = "id" + i;
				if(request.getParameter(RentID) != "")
					RentIDvalue = Integer.parseInt(request.getParameter(RentID));
				PaidRent = "paid" + i;
				if(request.getParameter(PaidRent) != "")
					PaidRentvalue = Integer.parseInt(request.getParameter(PaidRent));
				PaidMonth = "month" + i;
				PaidMonth = request.getParameter(PaidMonth);
				PaidYear = "year" + i;
				PaidYear = request.getParameter(PaidYear);
				if(PaidRentvalue == 0){
					ErrMsg = "Please Enter Paid Rent...";
				}else if(PaidMonth == "SELECT MONTH"){
					ErrMsg = "Please Select Paid Month...";
				}else if(PaidMonth == "SELECT YEAR"){
					ErrMsg = "Please Select Paid Year...";
				}
				if(ErrMsg == ""){
					Connection c = null;
					Statement stmt = null;
					try
			        {
						c = Connect_db.getConnection();
			            stmt = c.createStatement();
			            stmt.executeUpdate("INSERT INTO rent_paid(rent_id,paid_rent,paid_month,paid_year) VALUES (" + RentIDvalue + "," + PaidRentvalue + ",'" + PaidMonth + "','" + PaidYear + "')");
			            
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
					response.sendRedirect("RentHistory");
				}else{
					request.setAttribute("ErrMsg4",ErrMsg);
					request.getRequestDispatcher("Hw2/PayRent.jsp").forward(request, response);
				}
			}
			i=i+1;
		}
	}

}
