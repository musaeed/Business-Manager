package NorthEast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import BusinessManager.AppData;
import BusinessManager.BusinessManager;
import Database.Customer;

public class CustomerTableLoader {

	public CustomerTableLoader(){

		new Thread(new Runnable() {

			@Override
			public void run() {

				load();

			}
		}).start();

	}

	public void load(){

		Connection connection = null;
		Statement stmt = null;

		try{

			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + AppData.DatabaseName);
			connection.setAutoCommit(false);
			System.out.println("Database opened successfully...");
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM Customers;" );

			while ( rs.next() ) {
				
				String firstName = rs.getString("FirstName");
				String LastName = rs.getString("LastName");
				String Location = rs.getString("Address");
				String email = rs.getString("email");
				String pNumber = rs.getString("phoneNumber");
				String photoPath = rs.getString("photoLocation");
				
				CustomerTableModel.getInstance().addToTable(new Customer(firstName, LastName, Location, pNumber, email, photoPath));
			}

			rs.close();
			stmt.close();
			connection.close();
			
		} catch(Exception e){
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(BusinessManager.frame, "Unable to read the database!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

}
