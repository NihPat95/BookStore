package vo;

public class UserRecords {

	public UserRecords(){}
	public UserRecords(String name, String email, String password, String number) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.number = number;
	}
	private String name;
	private String email;
	private String password;
	private String number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
