package lab7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GradeCalculator
 */
@WebServlet("/GradeCalculator")
public class GradeCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeCalculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("GradeCalculator.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer Hw0 = 0;
		if(request.getParameter("Hw0") != "")
			Hw0 = Integer.parseInt(request.getParameter("Hw0"));
		Integer Hw1 = 0;
		if(request.getParameter("Hw1") != "")
			Hw1 = Integer.parseInt(request.getParameter("Hw1"));
		Integer Hw2 = 0;
		if(request.getParameter("Hw2") != "")
			Hw2 = Integer.parseInt(request.getParameter("Hw2"));
		Integer Hw3 = 0;
		if(request.getParameter("Hw3") != "")
			Hw3 = Integer.parseInt(request.getParameter("Hw3"));
		Integer Hw4 = 0;
		if(request.getParameter("Hw4") != "")
			Hw4 = Integer.parseInt(request.getParameter("Hw4"));
		Integer lab1 = 0;
		if(request.getParameter("lab1") != "")
			lab1 = Integer.parseInt(request.getParameter("lab1"));
		Integer lab2 = 0;
		if(request.getParameter("lab2") != "")
			lab2 = Integer.parseInt(request.getParameter("lab2"));
		Integer lab3 = 0;
		if(request.getParameter("lab3") != "")
			lab3 = Integer.parseInt(request.getParameter("lab3"));
		Integer lab4 = 0;
		if(request.getParameter("lab4") != "")
			lab4 = Integer.parseInt(request.getParameter("lab4"));
		Integer lab5 = 0;
		if(request.getParameter("lab5") != "")
			lab5 = Integer.parseInt(request.getParameter("lab5"));
		Integer lab6 = 0;
		if(request.getParameter("lab6") != "")
			lab6 = Integer.parseInt(request.getParameter("lab6"));
		Integer Totlab = 0;
		if(request.getParameter("Totlab") != "")
			Totlab = Integer.parseInt(request.getParameter("Totlab"));
		Integer TotHw = 0;
		if(request.getParameter("TotHw") != "")
			TotHw = Integer.parseInt(request.getParameter("TotHw"));
		Integer MidTm = 0;
		if(request.getParameter("MidTm") != "")
			MidTm = Integer.parseInt(request.getParameter("MidTm"));
		Integer TotMidTm = 0;
		if(request.getParameter("TotMidTm") != "")
			TotMidTm = Integer.parseInt(request.getParameter("TotMidTm"));
		Integer finalexam = 0;
		if(request.getParameter("final") != "")
			finalexam = Integer.parseInt(request.getParameter("final"));
		Integer Totfinal = 0;
		if(request.getParameter("Totfinal") != "")
			Totfinal = Integer.parseInt(request.getParameter("Totfinal"));
		Integer Attendance = 0;
		if(request.getParameter("Attendance") != "")
			Attendance = Integer.parseInt(request.getParameter("Attendance"));
		double TotalGrad = 0.00;
		String Grad = "";
		String ErrMsg = "";
		double HwGrad = 0;
		Integer userTotHw = Hw0 + Hw1 + Hw2 + Hw3 + Hw4;
		HwGrad = userTotHw * 35;
		HwGrad =  HwGrad / TotHw;
		double LabGrad = 0;
		Integer userTotlab = lab1 + lab2 + lab3 + lab4 + lab5 + lab6;
		LabGrad = userTotlab * 20;
		LabGrad = LabGrad / Totlab;
		double MidGrad = 0;
		MidGrad = ((MidTm * 20) / TotMidTm);
		double FinalGrad = 0;
		FinalGrad = ((finalexam * 20 ) / Totfinal);
		TotalGrad = HwGrad + LabGrad + MidGrad + FinalGrad + Attendance;
		if(TotalGrad <= 100 && TotalGrad >= 90)
			Grad = "A";
		else if(TotalGrad < 90 && TotalGrad >= 80)
			Grad = "B";
		else if(TotalGrad < 80 && TotalGrad >= 60)
			Grad = "C";
		else if(TotalGrad < 60 && TotalGrad >= 40)
			Grad = "B";
		else if(TotalGrad < 40)
			Grad = "F";
		request.setAttribute("Grad",Grad);
		request.getRequestDispatcher("GradeCalculator.jsp").forward(request, response);
	}

}
