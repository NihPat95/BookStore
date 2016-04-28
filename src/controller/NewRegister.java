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

@WebServlet("/NewRegister")
public class NewRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NewRegister() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String password = request.getParameter("password");
		try{
			UserRecords rs = new UserRecords(name,email,password,number);
			UserDAO userdao = new UserDAO(rs);
			HttpSession session = request.getSession();
			if(!userdao.add())
			{
				session.setAttribute("register", "User Already Exists");
				response.sendRedirect("Register.jsp");
			}
			else
			{
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
