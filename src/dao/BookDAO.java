package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import vo.BookRecords;
public class BookDAO {

	private BookRecords bookrecord=null;

	public BookDAO(){}
	
	public BookDAO(BookRecords bookrecord) {
		super();
		this.bookrecord = bookrecord;
	}
	
	public void TestMethod(){
		try{
			Configuration config = new Configuration().configure();
			SessionFactory sessionfactory = config.buildSessionFactory();
			Session session = sessionfactory.openSession();
			String hql = "FROM BookRecords";
			Query query = session.createQuery(hql);
			List<BookRecords> results = query.list();
			System.out.println("Size "+results.size());
			
			for(int i=0; i<results.size(); i++)
			{
				bookrecord = (BookRecords) results.get(i);
				System.out.print("Book Name:"+bookrecord.getTitle());
				System.out.print(" Publisher:"+bookrecord.getPublisher());
				System.out.print(" Author:"+bookrecord.getAuthor());
				System.out.print(" Price:"+bookrecord.getPrice());
				System.out.print(" Page:"+bookrecord.getPages());
				System.out.print(" Genre:"+bookrecord.getGenre());
				System.out.print(" Type:"+bookrecord.getType());
				System.out.print(" ISBN:"+bookrecord.getISBN());
				System.out.print(" Date:"+bookrecord.getDate());
				System.out.print(" Synopsis:"+bookrecord.getSynopsis());
			}
			session.close();
			
		}
		
		catch(Exception e){
			
		}
		
	}

	public BookRecords[] getbooks() {
		BookRecords bookrecords[] = null;
		try{
		Configuration config = new Configuration().configure();
		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
		String hql = "FROM BookRecords";
		Query query = session.createQuery(hql);
		List<BookRecords> results = query.list();
		bookrecords = new BookRecords[results.size()];
		for(int i=0; i<results.size(); i++)
		{
			bookrecords[i] = results.get(i);
		}
		}
		catch(Exception e){
			System.out.println("Error In Getting Books");
		}
		
		return bookrecords;
	}
	public BookRecords[] gettopbooks() {
		int max = 3;
		BookRecords bookrecords[] = null;
		try{
		Configuration config = new Configuration().configure();
		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
		String hql = "FROM BookRecords";
		Query query = session.createQuery(hql);
		query.setMaxResults(3);
		List<BookRecords> results = query.list();
		bookrecords = new BookRecords[results.size()];
		System.out.println("Size: "+results.size());
		for(int i=0; i<max; i++)
		{
			bookrecords[i] = results.get(i);
		}
		}
		catch(Exception e){
			System.out.println("Error In Getting Books");
		}
		
		return bookrecords;
	}
	
	public BookRecords getsingleBook(String isbn){
		BookRecords book = null;
		try{
			Configuration congif = new Configuration().configure();
			SessionFactory sf = congif.buildSessionFactory();
			Session s = sf.openSession();
			book = (BookRecords)s.get(BookRecords.class, isbn);
			if(book!=null)
			{
				System.out.println("Title: "+book.getTitle());
				s.close();
				return book;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public BookRecords[] getsearchresult(String bookname) {
		BookRecords bookrecords[] = null;
		try{
		Configuration config = new Configuration().configure();
		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
		String hql = "FROM BookRecords Where Title='"+bookname+"'";
		Query query = session.createQuery(hql);
		List<BookRecords> results = query.list();
		bookrecords = new BookRecords[results.size()];
		for(int i=0; i<results.size(); i++)
		{
			bookrecords[i] = results.get(i);
		}
		}
		catch(Exception e){
			System.out.println("Error In Search Books");
		}
		return bookrecords;
		
	}

	public BookRecords[] getgenrebooks(String[] genres) {
		// TODO Auto-generated method stub
		//query string
		BookRecords bookrecords[];
		String s = "(";
		for(int i=0; i<genres.length; i++){
		
			if(genres[i]!=null && i!=genres.length-1)
			s = s + "'" + genres[i] + "'" + ",";
			else if(genres[i]!=null && i==genres.length-1)
			s = s + "'" + genres[i] + "'";	
			
		}
		s = s + ")";
		System.out.println(s);
		try{
			
			Configuration config = new Configuration().configure();
			SessionFactory sessionfactory = config.buildSessionFactory();
			Session session = sessionfactory.openSession();
			String hql = "FROM BookRecords Where Genre In"+s;
			Query query = session.createQuery(hql);
			List<BookRecords> results = query.list();
			bookrecords = new BookRecords[results.size()];
			System.out.println(results.size());
			for(int i=0; i<results.size(); i++)
			{
				bookrecords[i] = results.get(i);
			}	
			return bookrecords;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	public BookRecords[] getgenrebooks(String genres) {

		// TODO Auto-generated method stub
				//query string
				BookRecords bookrecords[];
				try{
					
					Configuration config = new Configuration().configure();
					SessionFactory sessionfactory = config.buildSessionFactory();
					Session session = sessionfactory.openSession();
					String hql = "FROM BookRecords Where Genre='"+genres+"'";
					Query query = session.createQuery(hql);
					List<BookRecords> results = query.list();
					bookrecords = new BookRecords[results.size()];
					System.out.println(results.size());
					for(int i=0; i<results.size(); i++)
					{
						bookrecords[i] = results.get(i);
					}	
					return bookrecords;
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				return null;

	}

	public BookRecords[] getrmdbooks(String isbn, String genre) {
		// TODO Auto-generated method stub
		BookRecords bookrecords[];
		try{
			
			Configuration config = new Configuration().configure();
			SessionFactory sessionfactory = config.buildSessionFactory();
			Session session = sessionfactory.openSession();
			String hql = "FROM BookRecords where Genre = '"+genre+"'And ISBN!='"+isbn+"'";
			System.out.println(hql);
			Query query = session.createQuery(hql);
			List<BookRecords> results = query.list();
			bookrecords = new BookRecords[results.size()];
			System.out.println(results.size());
			for(int i=0; i<results.size(); i++)
			{
				bookrecords[i] = results.get(i);
			}	
			return bookrecords;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
		
		
		
		
	}	
}
