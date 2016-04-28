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

@WebServlet("/Search")

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Search() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String bookname = request.getParameter("search");
		try{
			BookDAO bookdao = new BookDAO();
			BookRecords bookrecords[] = bookdao.getsearchresult(bookname);
			if(bookrecords.length==0){
				response.sendRedirect("NoRecordsFound.jsp");
			}
			else{
				HttpSession session = request.getSession();
				session.setAttribute("searchresult", bookrecords);
				response.sendRedirect("SearchResult.jsp");
			}
		}
		catch(Exception e){
		}
	}
}
