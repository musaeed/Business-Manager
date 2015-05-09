package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import BusinessManager.AppData;
import BusinessManager.BusinessManager;

public class Customer {
	
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	private String photoPath;


	public Customer(String firstName, String lastName, String address, String phoneNumber, String emailAddress, String photoPath) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.photoPath = photoPath;
		
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getAddress() {
		return address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getEmailAddress() {
		return emailAddress;
	}
	
	
	public String getPhotoPath() {
		return photoPath;
	}
	
	public static void addToDatabase(final Customer customer){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {

				Connection connection = null;
				Statement stmt = null;
				
				 try {
				      Class.forName("org.sqlite.JDBC");
				      connection = DriverManager.getConnection("jdbc:sqlite:"+AppData.DatabaseName);
				      connection.setAutoCommit(false);
				      stmt = connection.createStatement();
				      
				      String sql = "INSERT INTO Customers (CustomerID,FirstName,LastName,Address,phoneNumber, email, photoLocation) " +
				                   "VALUES (1, '"+customer.getFirstName()+"', '"+customer.getLastName()+"', '"+customer.getAddress()+"', '"+customer.getPhoneNumber()+"', '"+customer.getEmailAddress()+"','"+customer.getPhotoPath()+"');"; 
				      
				      stmt.executeUpdate(sql);
				      stmt.close();
				      connection.commit();
				      connection.close();
				    } catch ( Exception e ) {
				      
				    	JOptionPane.showMessageDialog(BusinessManager.frame, "Unable to add data to the database. Please contact the developer!", "Database error", JOptionPane.ERROR_MESSAGE);
				    	return;
				    }
				 
			}
		}).start();
	}
	
}
