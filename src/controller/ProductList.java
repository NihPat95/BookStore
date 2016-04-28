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

@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProductList() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			System.out.println("Generating Main Page");
			BookDAO bookdao = new BookDAO();
			BookRecords book[] = bookdao.getbooks();
			HttpSession session = request.getSession();
			session.setAttribute("books", book);
			response.sendRedirect("product_list.jsp");
			System.out.println("Redirected To Product Page");
		}
		catch(Exception e){
			System.out.println("ProductList Error:"+e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
