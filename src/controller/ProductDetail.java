package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import dao.ReviewDAO;
import vo.BookRecords;
import vo.ReviewRecords;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//get book id from jsp page

		String isbn = request.getParameter("Id");
		try{
			BookDAO bookdao = new BookDAO();
			BookRecords book = bookdao.getsingleBook(isbn);
			BookRecords rmdbooks[] = bookdao.getrmdbooks(book.getISBN(),book.getGenre());
			
			ReviewRecords review = new ReviewRecords();
			review.setEmail("");
			review.setISBN(isbn);
			review.setReview("");
			ReviewRecords reviews[] = new ReviewDAO(review).getReviews();
			HttpSession session = request.getSession();
			session.setAttribute("reviews", reviews);
			session.setAttribute("bookdetail", book);
			session.setAttribute("rmdbooks",rmdbooks);
			response.sendRedirect("Product_Detail.jsp");
			
		}catch(Exception e){
			
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
