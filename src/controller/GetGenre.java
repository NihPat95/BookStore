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
 * Servlet implementation class GetGenre
 */
@WebServlet("/GetGenre")
public class GetGenre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetGenre() {
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
			String genres = request.getParameter("genrebox");
			
			BookDAO bookdao = new BookDAO();
			BookRecords books[] = bookdao.getgenrebooks(genres);
			HttpSession Session  = request.getSession();
			Session.setAttribute("books", books);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
			
				response.sendRedirect("product_list.jsp");
				
			}
			
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try{
		String[] genres = request.getParameterValues("genrebox");
		
		for( String s : genres){
			System.out.println(s);
		}
		
		
		BookDAO bookdao = new BookDAO();
		BookRecords books[] = bookdao.getgenrebooks(genres);
		HttpSession Session  = request.getSession();
		Session.setAttribute("books", books);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		
			response.sendRedirect("product_list.jsp");
			
		}
		
		
		
		
		
	}

}
