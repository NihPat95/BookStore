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
 * Servlet implementation class DisplayCart
 */
@WebServlet("/DisplayCart")
public class DisplayCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try{
			
			//retrieve cart records based on user email 
			HttpSession session = request.getSession();
			UserRecords user =(UserRecords) session.getAttribute("user");
			CartDAO cartdao = new CartDAO();
			CartRecord carts[] = cartdao.getCarts(user);
			session.setAttribute("cartlist",carts);
			response.sendRedirect("Cart.jsp");
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
