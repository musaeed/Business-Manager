package Security;

public class User {
	
	private String firstName;
	private String lastName;
	private String photoPath;
	
	public User(String firstName, String lastName, String photoPath){
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.photoPath = photoPath;
		
	}

	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getPhotoPath() {
		return photoPath;
	}

}
