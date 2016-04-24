package controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import vo.UserRecords;

/**
 * Servlet implementation class VerifyOTP
 */
@WebServlet("/VerifyOTP")
public class VerifyOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyOTP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("userOTP");
		int OTP = Integer.parseInt(request.getParameter("OTP"));
		int SOTP = (int)session.getAttribute("OTP");
		if(OTP==SOTP){
			UserDAO user = new UserDAO();
			UserRecords u = user.getUser(email);
		 	 String pass = u.getPassword();
		 	try{
				String from = "nihpat95@gmail.com";
				String to = email;
				final String useremail ="NihPat95@gmail.com";
				final String password="password";
				String host = "smtp.gmail.com";
				Properties properties = System.getProperties();
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.starttls.enable","true");
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port", "587");
				javax.mail.Session mailSession = javax.mail.Session.getInstance(properties,new javax.mail.Authenticator(){
					protected PasswordAuthentication getPasswordAuthentication() {
			            return new PasswordAuthentication(useremail, password);
					}
				});
				MimeMessage message = new MimeMessage(mailSession);
				String sample="<h1>Password</h1><h2>"+pass+"</h2>";
				message.setFrom(new InternetAddress(from));
				message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
				message.setSubject("OTP Password");
				message.setContent(sample, "text/html; charset=utf-8");
				Transport.send(message);
				System.out.println("Done");
				session.setAttribute("forgotpassword","Password Sent Your Email");
				response.sendRedirect("ForgotPassword.jsp");
				
			}catch(Exception e)
			{
				System.out.println("Sending mail Error");
				e.printStackTrace();
			}
			
		}
		else{
			session.setAttribute("forgotpassword","Invlaid OTP");
			response.sendRedirect("ForgotPassword.jsp");
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
