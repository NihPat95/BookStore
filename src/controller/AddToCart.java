package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import dao.CartDAO;
import vo.BookRecords;
import vo.CartRecord;
import vo.UserRecords;

/**
/ * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
		HttpSession session = request.getSession();
		UserRecords user = (UserRecords)session.getAttribute("user");
		//Check for if user logged in 
		if(user==null)
		{
			response.sendRedirect("Register.jsp");
		}
		//if user logged user in
		String isbn=request.getParameter("id");
		String page=request.getParameter("flag");
		System.out.println(""+isbn);
		try{
			CartRecord cart = new CartRecord();
			cart.setUser(user);
			BookRecords book = null;
			BookDAO bookdao = new BookDAO();
			book = bookdao.getsingleBook(isbn);
			cart.setBooks(book);
			CartDAO cartdao = new CartDAO(cart);
			cartdao.add();
			int n = (int)session.getAttribute("cartno");
			n++;
			session.setAttribute("cartno", n);
			System.out.println("after add cart");
			if(page.equals("index"))
			response.sendRedirect("index.jsp");
			else if(page.equals("searchresult"))
			response.sendRedirect("index.jsp");
			else
			response.sendRedirect("product_list.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
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
