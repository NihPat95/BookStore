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

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Generating Main Page");
		try{
			BookDAO bookdao = new BookDAO();
			BookRecords book[] = bookdao.gettopbooks();
			
			//book collection of top book records
			HttpSession session = request.getSession();
			//genre based book collection
			session.setAttribute("genbooks", null);
			//set user login session 
			session.setAttribute("reviews", null);
			session.setAttribute("cartno", null);
			session.setAttribute("user", null);
			//set user login session 
			session.setAttribute("forgotpassword", null);
			//set user login session 
			session.setAttribute("OTP", null);
			//set search as null initially session
			session.setAttribute("searchresult", null);
			//set initial register as null
			session.setAttribute("register",null);
			//set initial login as null
			session.setAttribute("login",null);
			//set books as the top book records 
			session.setAttribute("booklist", book);
			//Generate main page
			response.sendRedirect("index.jsp");
			System.out.println("Redirected To Main Page");
		}
		catch(Exception e)
		{
			System.out.println("Index Error: ");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	
	}

}
