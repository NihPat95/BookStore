package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAO;
import dao.UserDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get email from jsp page
		String email=request.getParameter("email");
		//get password from jsp page
		String password=request.getParameter("password");
		String name = null;
		String number = null;
		PrintWriter pw = response.getWriter();
		HttpSession sess = request.getSession();
		try{
			
			UserDAO user = new UserDAO(name,email,number,password);
			int i = user.login();
			switch(i){
			case 0:
				//If user is a new user
				sess.setAttribute("login","No Records Found");
				response.sendRedirect("Register.jsp");
				   
			break;
			case 1:
					//If user record is found but password invalid
				 	sess.setAttribute("login","Invalid Password");
				 	response.sendRedirect("Register.jsp");
				  
			break;
			case 2:
					//Login successfully
				   sess.setAttribute("cartno",new CartDAO().getcartno(email));
				   sess.setAttribute("login", "Login Successfully");
				   sess.setAttribute("user",user.getUser(email));
				   response.sendRedirect("index.jsp");
		    break;
			}
			
		}
		catch(Exception e){
			System.out.println("Login Error:"+e);
		}
				
	}

}
