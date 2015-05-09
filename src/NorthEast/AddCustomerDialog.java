package NorthEast;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import BusinessManager.BusinessManager;
import Components.CButton;
import Components.CLabel;
import Components.FlowCustomLayout;
import Database.Customer;
import Utilities.Icons;
import Utilities.SpringUtilities;

public class AddCustomerDialog {
	
	private JDialog dialog;
	private CLabel lFirstName, lLastName, lAddress, lEmail, lPhoneNumber;
	private JTextField tFirstName, tLastName, tAddress, tEmail, tPhoneNumber;
	private CButton add, cancel;
	private JLabel photo;
	private String photoPath;
	
	public AddCustomerDialog(){
		
		init();
		build();
	}
	
	public void init(){
		
		dialog = new JDialog();
		dialog.setTitle("Add customer");
		dialog.setSize(new Dimension(500,350));
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
		
		photo = new JLabel();
		
		photoPath = "No-photo";
		
		add = new CButton("Add", "add the new customer to the database", 'A', KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), null);
		cancel = new CButton("Cancel", "cancel and go back", 'C', KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), null);
	}
	
	public void show(){
		
		dialog.setVisible(true);
	}
	
	public void build(){
		
		dialog.setLayout(new BorderLayout());
		dialog.add(getButtonPanel(), BorderLayout.SOUTH);
		dialog.add(getNorthPanel(), BorderLayout.NORTH);
		dialog.add(getCenterPanel(), BorderLayout.CENTER);
	}
	
	public JPanel getButtonPanel(){
		
		JPanel panel = new JPanel(new FlowCustomLayout(FlowCustomLayout.RIGHT));
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				dialog.dispose();
				
			}
		});
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tEmail.getText() != null || tEmail.getText() != ""){
					if(!tEmail.getText().contains("@")){
						JOptionPane.showMessageDialog(dialog, "Please enter a valid email address!", "Invalid email address", JOptionPane.ERROR_MESSAGE);
						lEmail.setForeground(Color.RED);
						return;
					}
				}
				
				Customer customer = new Customer(tFirstName.getText(), tLastName.getText(), tAddress.getText(), tPhoneNumber.getText(), tEmail.getText(), photoPath);
				Customer.addToDatabase(customer);
				CustomerTableModel.getInstance().addToTable(customer);
				
				dialog.dispose();
				
			}
		});
		
		
		panel.add(add);
		panel.add(cancel);
		
		return panel;
	}
	
	public JPanel getCenterPanel(){
		
		JPanel panel = new JPanel(new SpringLayout());
		
		panel.add(lFirstName);
		panel.add(tFirstName);
		panel.add(lLastName);
		panel.add(tLastName);
		panel.add(lEmail);
		panel.add(tEmail);
		panel.add(lPhoneNumber);
		panel.add(tPhoneNumber);
		panel.add(lAddress);
		panel.add(tAddress);
		
		panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6, 6, 6);
		
		return panel;
	}
	
	public JPanel getNorthPanel(){
		
		JPanel panel = new JPanel(new FlowLayout());
		
		photo.setIcon(Icons.getIcon("medium/photo.png"));
		photo.setToolTipText("Select a profile photo for the customer");
		photo.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getButton() == MouseEvent.BUTTON1){
					
					JFileChooser fc = new JFileChooser();
					fc.setDialogTitle("Browse customer photo");
					fc.setFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
					fc.showOpenDialog(dialog);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				photo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				photo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
			
		});
		panel.add(photo, BorderLayout.CENTER);
		
		return panel;
	}

}
