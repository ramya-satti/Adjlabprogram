package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartBillServlet
 */
@WebServlet("/CartBillServlet")
public class CartBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(true);
		
		int totamt = 0;
		Enumeration names = session.getAttributeNames();
		
		while(names.hasMoreElements()) {
			String name = names.nextElement().toString();
			String value = session.getAttribute(name).toString();
			totamt += Integer.parseInt(value);
		}
		
		String pencilamt = "";
		String bookamt = "";
		String laptopamt="";
		String mobileamt = "";
		if(session.getAttribute("pencilamt") != null) {
			pencilamt = session.getAttribute("pencilamt").toString();
		}
		if(session.getAttribute("bookamt") != null) {
			bookamt = session.getAttribute("bookamt").toString();
		}
		if(session.getAttribute("laptopamt") != null) {
			laptopamt = session.getAttribute("laptopamt").toString();
		}
		if(session.getAttribute("mobileamt") != null) {
			mobileamt = session.getAttribute("mobileamt").toString();
		}
		
		out.println("<table>");
		out.println("<tr><td>Pencil:</td><td>" + pencilamt + "</td></tr>");
		out.println("<tr><td>Book:</td><td>" + bookamt + "</td></tr>");
		out.println("<tr><td>Laptop:</td><td>" + laptopamt + "</td></tr>");
		out.println("<tr><td>Mobile:</td><td>" + mobileamt + "</td></tr>");
		out.println("<tr><td>Total amount:</td><td>" + totamt + "</td></tr>");
		out.println("</table>");
		session.invalidate();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
