package dao;

import vo.ReviewRecords;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	 ReviewRecords reviewrecord = new ReviewRecords();
	 reviewrecord.setEmail("nihpat95@gmail.com");
	 reviewrecord.setISBN("73833359235");
	 reviewrecord.setReview("Blah Blah Blah");
		
	 ReviewDAO reviewdao = new ReviewDAO(reviewrecord);
	 reviewdao.addreview();
	 System.out.println("Added Successfully");
	 
		
	
	}
	

}
