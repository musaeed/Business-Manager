package Database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import BusinessManager.AppData;
import BusinessManager.BusinessManager;

public class DatabaseCreator {

	private static String createCustomers = "CREATE TABLE Customers("
											+"CustomerID int,"
											+"FirstName varchar(255),"
											+"LastName varchar(255),"
											+"Location varchar(255),"
											+"phoneNumber varchar(255),"
											+"email varchar(255)"
											+");";

	public static void createDatabase(){
		
		Connection connection = null;
		Statement stmt = null;

		try {
			
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + AppData.DatabaseName);
			System.out.println("Database opened successfully...");

			stmt = connection.createStatement();
			stmt.executeUpdate(createCustomers);
			stmt.close();
			connection.close();
		} 
		catch(Exception e) {
			JOptionPane.showMessageDialog(BusinessManager.frame, "Error", "Unable to create a database!", JOptionPane.ERROR_MESSAGE);
		}
		
		//////////////////////////////////////////////////////
		Connection c = null;
		
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:"+AppData.DatabaseName);
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "INSERT INTO Customers (CustomerID,FirstName,LastName,Location,phoneNumber, email) " +
	                   "VALUES (1, 'Muhammad Omer', 'Saeed', 'Bonn', '+4915213530903', 'muhammad.omar555@gmail.com');"; 
	      stmt.executeUpdate(sql);
	      sql = "INSERT INTO Customers (CustomerID,FirstName,LastName,Location,phoneNumber, email) " +
                  "VALUES (1, 'Muhammad Hamza', 'Saeed', 'Rawalpindi', '+923335172246', 'hamza17@gmail.com');";
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    //////////////////////////////////////////
	}
	
	public static boolean databaseExists(){

		File f = new File(AppData.DatabaseName);
		return f.exists() && !f.isDirectory();
	}

}
