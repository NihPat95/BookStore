package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReviewDAO;
import vo.BookRecords;
import vo.ReviewRecords;
import vo.UserRecords;

@WebServlet("/SubmitReview")
public class SubmitReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SubmitReview() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession();
		UserRecords usere = (UserRecords)session.getAttribute("user");
		if(usere == null)
		{
			response.sendRedirect("Register.jsp");
		}
		else{
			String user = usere.getEmail();
			String comment = request.getParameter("comment");
			String ISBN = ((BookRecords) session.getAttribute("bookdetail")).getISBN();
			ReviewRecords review = new ReviewRecords();
			review.setEmail(user);
			review.setISBN(ISBN);
			review.setReview(comment);
			ReviewDAO reviewdao = new ReviewDAO(review); 
			reviewdao.addreview();
			System.out.println("Review Added Successfully");
			response.sendRedirect("ProductDetail?Id="+ISBN+"");
		}
	}
}
