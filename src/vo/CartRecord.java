package vo;

public class CartRecord {

	private int ID;
	private BookRecords Books;
	private UserRecords User;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public BookRecords getBooks() {
		return Books;
	}
	public void setBooks(BookRecords books) {
		Books = books;
	}
	public UserRecords getUser() {
		return User;
	}
	public void setUser(UserRecords user) {
		this.User = user;
	}
}
