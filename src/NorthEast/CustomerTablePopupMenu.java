package NorthEast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPopupMenu;

import Utilities.Icons;
import Components.CMenuItem;

public class CustomerTablePopupMenu extends JPopupMenu{
	
	private static final long serialVersionUID = 5001555052196347233L;
	private CMenuItem viewTable, addCustomer, searchTable, selectAll, clearSelection;
	
	public CustomerTablePopupMenu(){
		
		init();
		addActions();
		addToMenu();
		
	}
	
	public void init(){
		
		viewTable = new CMenuItem("View table", "view the complete table", 'V', null);
		viewTable.setIcon(Icons.getIcon("small/view-table.png"));
		addCustomer = new CMenuItem("Add customer", "add a new customer", 'A', null);
		addCustomer.setIcon(Icons.getIcon("small/add-icon.png"));
		searchTable = new CMenuItem("Search table", "search the table for a customer", 'S', null);
		searchTable.setIcon(Icons.getIcon("small/search.png"));
		selectAll = new CMenuItem("Select all", "select all the customers in the table", 'E', null);
		selectAll.setIcon(Icons.getIcon("small/selectall.png"));
		clearSelection = new CMenuItem("Clear selection", "clear the selection in the table", 'C', null);
		clearSelection.setIcon(Icons.getIcon("small/clear-selection.png"));
	}
	
	public void addActions(){
		
		viewTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewTableDialog().show();
			}
		});
		
		addCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCustomerDialog().show();				
			}
		});
		
		searchTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				new ViewTableDialog().show();
			}
		});
		
		selectAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerTable.table.selectAll();
				
			}
		});
		
		clearSelection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerTable.table.clearSelection();
			}
		});
	}
	
	public void addToMenu(){
		add(viewTable);
		addSeparator();
		add(addCustomer);
		add(searchTable);
		addSeparator();
		add(selectAll);
		add(clearSelection);
	}

}
