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
											+"Address varchar(255),"
											+"phoneNumber varchar(255),"
											+"email varchar(255),"
											+"photoLocation varchar(255)"
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
		
	}
	
	public static boolean databaseExists(){

		File f = new File(AppData.DatabaseName);
		return f.exists() && !f.isDirectory();
	}

}
