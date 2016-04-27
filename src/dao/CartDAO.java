package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.BookRecords;
import vo.CartRecord;
import vo.UserRecords;

public class CartDAO {
	private int ID;
	private String Email=null;
	private String ISBN=null;
	private CartRecord cart=null;
	
	public CartDAO(){}
	public CartDAO(String email) {
		super();
		Email = email;
	}
	public CartDAO(CartRecord cart) {
		super();
		this.cart = cart;
	}
	public void add(){
		try{
			Configuration configure = new Configuration().configure();
			SessionFactory sessionfactory = configure.buildSessionFactory();
			Session session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();
			session.save(cart);
			System.out.println("Saved Cart");
			t.commit();
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public CartRecord[] getCarts(UserRecords user) {
		Configuration configure = null;
		SessionFactory sessionfactory = null;
		Session session = null;
		Transaction t = null;
		try{
			configure = new Configuration().configure();
			sessionfactory = configure.buildSessionFactory();
			session = sessionfactory.openSession();
			t = session.beginTransaction();
			String hql = "FROM CartRecord Where User='"+user.getEmail()+"'";
			Query query = session.createQuery(hql);
			List<CartRecord> results = query.list();
			CartRecord cart[] =  new CartRecord[results.size()];
			for(int i=0; i<results.size(); i++)
			{
				cart[i]=(CartRecord)results.get(i);
			}
			
			return cart;
			//System.out.println("Size of cart"+results.size());
			
		}
		catch(Exception e){
			System.out.println("Inside CartDAO->getCarts");
			e.printStackTrace();
		}
		
		return null;
	}
	public int getcartno(String email){
		Configuration configure = null;
		SessionFactory sessionfactory = null;
		Session session = null;
		Transaction t = null;
		try{
			configure = new Configuration().configure();
			sessionfactory = configure.buildSessionFactory();
			session = sessionfactory.openSession();
			t = session.beginTransaction();
			String hql = "FROM CartRecord Where User='"+email+"'";
			Query query = session.createQuery(hql);
			List<CartRecord> results = query.list();
			
			return results.size();
			//System.out.println("Size of cart"+results.size());
			
		}
		catch(Exception e){
			System.out.println("Inside CartDAO->getCarts");
			e.printStackTrace();
		}
		
		return 0;
		
		
	}
	
	public void delete(int key) {
		// TODO Auto-generated method stub
		
		Configuration configure = null;
		SessionFactory sessionfactory = null;
		Session session = null;
		Transaction t = null;
		try{
			configure = new Configuration().configure();
			sessionfactory = configure.buildSessionFactory();
			session = sessionfactory.openSession();
			t = session.beginTransaction();
			String hql = "DELETE FROM CartRecord " + "WHERE ID = "+key;
			Query query = session.createQuery(hql);
			int result = query.executeUpdate();
			System.out.println("Deleted Rows: "+result);
			t.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
