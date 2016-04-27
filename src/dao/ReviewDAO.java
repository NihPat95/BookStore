package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.BookRecords;
import vo.ReviewRecords;

public class ReviewDAO {
	private ReviewRecords reviewrecords;
	public ReviewDAO(ReviewRecords reviewrecords) {
		super();
		this.reviewrecords = reviewrecords;
	}
	public void addreview(){
	try{
		Configuration configure = new Configuration().configure();
		SessionFactory sessionfactory  = configure.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(reviewrecords);
		System.out.println("Records Saved");
		transaction.commit();
		session.close();
	}
	catch(Exception e){
		System.out.println("Inside Review add: ");
		e.printStackTrace();
		
	}
}
	public ReviewRecords[] getReviews() {
		ReviewRecords r[] = null;
		try{
		Configuration config = new Configuration().configure();
		SessionFactory sessionfactory = config.buildSessionFactory();
		Session session = sessionfactory.openSession();
		String hql = "FROM ReviewRecords Where ISBN='"+reviewrecords.getISBN()+"'";
		Query query = session.createQuery(hql);
		List<ReviewRecords> results = query.list();
		r = new ReviewRecords[results.size()];
		for(int i=0; i<results.size(); i++)
		{
			r[i] = results.get(i);
		}
		}
		catch(Exception e){
			System.out.println("Error In Getting Reviews");
			e.printStackTrace();
		}
		
		return r;
	
	}
	
	
	
	
}
