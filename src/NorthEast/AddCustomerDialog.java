package NorthEast;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import BusinessManager.BusinessManager;
import Components.CButton;
import Components.CLabel;
import Components.FlowCustomLayout;

public class AddCustomerDialog {
	
	private JDialog dialog;
	private CLabel lFirstName, lLastName, lAddress, lEmail, lPhoneNumber;
	private JTextField tFirstName, tLastName, tAddress, tEmail, tPhoneNumber;
	private CButton add, cancel;
	
	public AddCustomerDialog(){
		
		init();
		build();
	}
	
	public void init(){
		
		dialog = new JDialog();
		dialog.setTitle("Add customer");
		dialog.setSize(new Dimension(500,300));
		dialog.setLocationRelativeTo(BusinessManager.frame);
		dialog.setModal(true);
		
		lFirstName = new CLabel("First name:");
		lLastName = new CLabel("Last name:");
		lEmail = new CLabel("Email:");
		lPhoneNumber = new CLabel("Phone number");
		lAddress = new CLabel("Address:");
		
		tFirstName = new JTextField();
		tLastName = new JTextField();
		tAddress = new JTextField();
		tEmail = new JTextField();
		tPhoneNumber = new JTextField();
		
		add = new CButton("Add", "add the new customer to the database", 'A', null, null);
		cancel = new CButton("Cancel", "cancel and go back", 'C', KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), null);
	}
	
	public void show(){
		
		dialog.setVisible(true);
	}
	
	public void build(){
		
		dialog.setLayout(new BorderLayout());
		dialog.add(getButtonPanel(), BorderLayout.SOUTH);
	}
	
	public JPanel getButtonPanel(){
		
		JPanel panel = new JPanel(new FlowCustomLayout(FlowCustomLayout.RIGHT));
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				dialog.dispose();
				
			}
		});
		
		panel.add(add);
		panel.add(cancel);
		
		return panel;
	}

}
