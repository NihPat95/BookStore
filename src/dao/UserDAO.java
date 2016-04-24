package dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import vo.UserRecords;
public class UserDAO {

	private String name;
	private String email;
	private String number;
	private String password;
	private UserRecords userrecords;
	public UserDAO(){}
	public UserDAO(UserRecords userrecords) {
		super();
		this.userrecords = userrecords;}
	
	public UserDAO(String name, String email, String number, String password) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
		this.password = password;

	}public boolean add() {
		// TODO Auto-generated method stub
		//method to add new user in database
		try{
			Configuration config = new Configuration().configure();
			SessionFactory sessionfactory = config.buildSessionFactory();
			Session session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			String sql ="From UserRecords Where Email='"+userrecords.getEmail()+"'";
			Query q = session.createQuery(sql);
			List<UserRecords> l = q.list();
			System.out.println(""+l.size());
		//	System.out.println("List: "+l);
			if(l.size()==0){
				session.save(userrecords);
				transaction.commit();
				session.close();
				return true;
			}
			else
				return false;
			
		}
		catch(Exception e){
			System.out.println("User Record Entry: "+e);
		}
	return false;
	}
	public int login() {
		// method for login 
		// return 0 for new user
		// return 1 for invalid password
		// return 2 for login successful
		try{
			Configuration config = new Configuration().configure();
			SessionFactory sessionfactory = config.buildSessionFactory();
			Session session = sessionfactory.openSession();
			UserRecords user = null;
			user = (UserRecords)session.get(UserRecords.class, email);
			//System.out.println(""+user.getEmail());
			if(user==null){
				System.out.println("New User");
				session.close();
				return 0;
			}
			else {
			
				if(password.equals(user.getPassword()))
				{
					System.out.println("Login");
					session.close();
					return 2;
				}
				else
				{
					System.out.println("Forgot Password");
					session.close();
					return 1;
				}
				
			}
			
			}
			
		catch(Exception e){
			System.out.println("Login Error DAO: "+e);
		}
		
		
		return 0;
	}
	
	public UserRecords getUser(String emailid){
		//method used to get user via email id 
		
		UserRecords user = null;
		try{
		Configuration config = new Configuration().configure();
		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
		user = (UserRecords)session.get(UserRecords.class, emailid);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	
}
