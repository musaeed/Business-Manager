package NorthEast;

import javax.swing.table.DefaultTableModel;

import Database.Customer;

public class CustomerTableModel extends DefaultTableModel{

	private static final long serialVersionUID = 3458567892385671628L;
	private static CustomerTableModel instance = null;
	
	public static CustomerTableModel getInstance(){
		if(instance == null){
			instance = new CustomerTableModel();
		}
		
		return instance;
	}
	
	private CustomerTableModel(){
		
		init();
		
	}
	
	public void init(){
		
		addColumns();
	}
	
	public void addColumns(){
		
		addColumn("First name");
		addColumn("Last name");
		addColumn("Email");
		addColumn("Number");
		addColumn("Location");
	}
	
	public void addToTable(Customer customer){
		
		Object data [] = {customer.getFirstName(), customer.getLastName(), customer.getEmailAddress(), customer.getPhoneNumber(),customer.getAddress()};
		addRow(data);
	}

}
