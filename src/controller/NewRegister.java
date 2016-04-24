package controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import vo.UserRecords;

/**
 * Servlet implementation class NewResigter
 */
@WebServlet("/NewRegister")
public class NewRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String password = request.getParameter("password");
		PrintWriter pw = response.getWriter();
		try{
			
			UserRecords rs = new UserRecords(name,email,password,number);
			UserDAO userdao = new UserDAO(rs);
			HttpSession session = request.getSession();
			//check for existing user
			if(!userdao.add())
			{
				session.setAttribute("register", "User Already Exists");
				response.sendRedirect("Register.jsp");
			}
			else
			{
				//For new user add in database
				session.setAttribute("register", "Register Successful");
				response.sendRedirect("Register.jsp");
			}
		}
		catch(Exception e)
		{
			System.out.println("Controller NewRegister Error: "+e);
		}
		
		
	}

}
