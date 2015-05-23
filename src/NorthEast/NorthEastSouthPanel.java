package NorthEast;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Utilities.Icons;
import Components.ClickableLabel;
import Components.FlowCustomLayout;

public class NorthEastSouthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel viewTable;
	private JLabel searchTable;
	private JLabel addCustomer;
	
	public NorthEastSouthPanel(){
		
		init();
		addToPanel();
		addActions();
	}
	
	public void init(){
		
		setLayout(new FlowCustomLayout(FlowCustomLayout.LEFT));
		viewTable = new ClickableLabel("View table", "view the complete customers table");
		viewTable.setIcon(Icons.getIcon("small/view-table.png"));
		searchTable = new ClickableLabel("Search table", "search the entries of the customer table");
		searchTable.setIcon(Icons.getIcon("small/search.png"));
		addCustomer = new ClickableLabel("Add Customer", "add a new customer to the table");
		addCustomer.setIcon(Icons.getIcon("small/add-icon.png"));
	}
	
	public void addToPanel(){
		add(viewTable);
		add(searchTable);
		add(addCustomer);
	}
	
	public void addActions(){
		viewTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1){
					
					new ViewTableDialog().show();
				}
			}
			
		});
		
		addCustomer.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1){
					
					new AddCustomerDialog().show();
				}
			}
			
		});
	}
}
