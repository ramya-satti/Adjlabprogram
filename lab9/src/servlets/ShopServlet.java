package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String pencilcost = request.getParameter("pencilcost");
		String bookcost = request.getParameter("bookcost");
		String laptopcost = request.getParameter("laptopcost");
		String mobilecost = request.getParameter("mobilecost");
		
		String pencil = request.getParameter("pencil");
		String book = request.getParameter("book");
		String laptop = request.getParameter("laptop");
		String mobile = request.getParameter("mobile");
		
		int pencilamt = 0, bookamt = 0, laptopamt = 0, mobileamt = 0;
		
		HttpSession session = request.getSession(true);
		
		if(pencil != null && !pencil.equals("")) {
			pencilamt = Integer.parseInt(pencilcost) * Integer.parseInt(pencil);
			if(session.getAttribute("pencilamt") != null) {
				pencilamt = pencilamt + Integer.parseInt(session.getAttribute("pencilamt").toString());
			}
			
			session.setAttribute("pencilamt", pencilamt+"");
		}
		if(book != null && !book.equals("")) {
			bookamt = Integer.parseInt(bookcost) * Integer.parseInt(book);
			if(session.getAttribute("bookamt") != null) {
				bookamt = bookamt + Integer.parseInt(session.getAttribute("bookamt").toString());
			}
			session.setAttribute("bookamt", bookamt+"");
		}
		if(laptop != null && !laptop.equals("")) {
			laptopamt = Integer.parseInt(laptopcost) * Integer.parseInt(laptop);
			if(session.getAttribute("laptopamt") != null) {
				laptopamt = laptopamt + Integer.parseInt(session.getAttribute("laptopamt").toString());
			}
			session.setAttribute("laptopamt", laptopamt+"");
		}
		if(mobile != null && !mobile.equals("")) {
			mobileamt = Integer.parseInt(mobilecost) * Integer.parseInt(mobile);
			if(session.getAttribute("mobileamt") != null) {
				mobileamt = mobileamt + Integer.parseInt(session.getAttribute("mobileamt").toString());
			}
			session.setAttribute("mobileamt", mobileamt+"");
		}	
		
		response.sendRedirect("./additem.html");
		
	}

}
