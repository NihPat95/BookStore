package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.BookDAO;
import vo.BookRecords;

@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Index() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Generating Main Page");
		try{
			BookDAO bookdao = new BookDAO();
			BookRecords book[] = bookdao.gettopbooks();
			HttpSession session = request.getSession();
			session.setAttribute("genbooks", null);
			session.setAttribute("reviews", null);
			session.setAttribute("cartno", null);
			session.setAttribute("user", null);
			session.setAttribute("forgotpassword", null);
			session.setAttribute("OTP", null);
			session.setAttribute("searchresult", null);
			session.setAttribute("register",null);
			session.setAttribute("login",null);
			session.setAttribute("booklist", book);
			response.sendRedirect("index.jsp");
			System.out.println("Redirected To Main Page");
		}
		catch(Exception e)
		{
			System.out.println("Index Error: ");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
