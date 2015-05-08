package Database;

public class Customer {
	
	private String firstName;
	private String lastName;
	private String location;
	private String phoneNumber;
	private String emailAddress;
	
	
	public Customer(String firstName, String lastName, String location, String phoneNumber, String emailAddress) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getLocation() {
		return location;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getEmailAddress() {
		return emailAddress;
	}
	
	
	
}
