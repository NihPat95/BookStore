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

@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProductDetail() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
