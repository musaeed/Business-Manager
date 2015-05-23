package NorthEast;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpringLayout;

import BusinessManager.BusinessManager;
import Components.CButton;
import Components.FlowCustomLayout;
import Utilities.Icons;
import Utilities.SpringUtilities;

public class ViewTableDialog {
	
	private JDialog dialog;
	private CButton close;
	private JTable table;
	private JLabel searchLabel;
	private JTextField searchTextField;
	private CButton addCustomer;
	
	public ViewTableDialog(){
		
		init();
		build();
	}
	
	public void init(){
		
		dialog = new JDialog();
		dialog.setTitle("Customers table");
		dialog.setSize(new Dimension(800,600));
		dialog.setModal(true);
		dialog.setLocationRelativeTo(BusinessManager.frame);
		
		table = new JTable(CustomerTableModel.getInstance());
		table.setComponentPopupMenu(new CustomerTablePopupMenu());
		
		close = new CButton("Close", "close the dialog and go back", 'C', KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), null);
		
		searchLabel = new JLabel(Icons.getIcon("small/search.png"));
		searchLabel.setText("Search:");
		searchLabel.setToolTipText("search for a customer");
		searchTextField = new JTextField();
	}
	
	public void build(){
		
		dialog.setLayout(new BorderLayout());
		dialog.add(getButtonPanel(), BorderLayout.SOUTH);
		dialog.add(getTablePane(), BorderLayout.CENTER);
		dialog.add(getNorthPanel(), BorderLayout.NORTH);
	}
	
	public JPanel getNorthPanel(){
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel temp = new JPanel(new SpringLayout());
		
		temp.add(searchLabel);
		temp.add(searchTextField);
		
		SpringUtilities.makeCompactGrid(temp, 1, 2, 6, 6, 6, 6);
		
		panel.add(temp, BorderLayout.SOUTH);
		panel.add(new NorthEastNorthPanel(), BorderLayout.NORTH);
		
		
		return panel;
	}
	
	public JScrollPane getTablePane(){
		
		JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.setComponentPopupMenu(new CustomerTablePopupMenu());
		
		return pane;
	}
	
	public JPanel getButtonPanel(){
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel left = new JPanel(new FlowCustomLayout(FlowCustomLayout.LEFT));
		JPanel right = new JPanel(new FlowCustomLayout(FlowCustomLayout.RIGHT));
		
		addCustomer = new CButton("Add customer", "add a new customer", 'A', KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK), null);
		addCustomer.setIcon(Icons.getIcon("small/add-icon.png"));
		
		addCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCustomerDialog().show();
			}
		});
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				dialog.dispose();
				
			}
		});
		
		right.add(close);
		left.add(addCustomer);
		
		panel.add(right, BorderLayout.EAST);
		panel.add(left, BorderLayout.WEST);
		
		return panel;
	}
	
	
	public void show(){
		
		dialog.setVisible(true);
	}

}
