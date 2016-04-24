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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String bookname = request.getParameter("search");
		// get book name via jsp page
		try{
			//search based on name
			BookDAO bookdao = new BookDAO();
			BookRecords bookrecords[] = bookdao.getsearchresult(bookname);
			if(bookrecords.length==0){
				//for no records found
				response.sendRedirect("NoRecordsFound.jsp");
			}
			else{
				//for some records
				HttpSession session = request.getSession();
				session.setAttribute("searchresult", bookrecords);
				response.sendRedirect("SearchResult.jsp");
			}
			
		}
		catch(Exception e){
			
		}
		
	}

}
