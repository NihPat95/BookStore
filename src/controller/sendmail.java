package controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sendmail
 */
@WebServlet("/sendmail")
public class sendmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendmail() {
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
			
			String from = "nihpat95@gmail.com";
			String to = "nihpat95@gmail.com";
			final String user ="NihPat95@gmail.com";
			final String password="@rockyduel#1995*";
			String host = "smtp.gmail.com";
			Properties properties = System.getProperties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable","true");
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port", "587");
			
			Session mailSession = Session.getInstance(properties,new javax.mail.Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication(user, password);
				}
			});
			
			MimeMessage message = new MimeMessage(mailSession);
			String sample="<h1>H1</h1><h2>H2</h2>";
			message.setFrom(new InternetAddress(from));
			message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			message.setSubject("This is subject line");
			message.setContent(sample, "text/html; charset=utf-8");
			Transport.send(message);
			System.out.println("Done");
			
		}catch(Exception e)
		{
			System.out.println("Sending mail Error");
			e.printStackTrace();
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
