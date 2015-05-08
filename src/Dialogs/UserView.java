package Dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import BusinessManager.BusinessManager;
import Components.CButton;
import Components.CLabel;
import Components.FlowCustomLayout;
import Security.User;
import Utilities.ImageUtilities;

public class UserView {
	
	private JDialog dialog;
	private CButton close;
	private JLabel photo, firstName, lastName;
	
	public UserView(User user){
		
		init(user);
		setComponents();
	}
	
	public void init(User user){
		
		dialog = new JDialog();
		dialog.setSize(new Dimension(250,250));
		dialog.setLocationRelativeTo(BusinessManager.frame);
		
		firstName = new CLabel(user.getFirstName());
		lastName = new CLabel(user.getLastName());
		photo = new JLabel(ImageUtilities.RescaleImage(user.getPhotoPath()));
		
		close = new CButton("Close", "close this dialog box and go back", 'C', KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), null);
	}
	
	public void setComponents(){
		
		JPanel bottom = new JPanel(new FlowCustomLayout(FlowCustomLayout.RIGHT));
		JPanel left = new JPanel(new FlowCustomLayout(FlowCustomLayout.RIGHT));
		JPanel center = new JPanel(new FlowCustomLayout(FlowCustomLayout.RIGHT));
		
		dialog.setLayout(new BorderLayout());
		
		left.add(photo);
		center.add(firstName);
		center.add(lastName);
		bottom.add(close);
		
		dialog.add(bottom, BorderLayout.SOUTH);
		dialog.add(left, BorderLayout.WEST);
		dialog.add(center, BorderLayout.CENTER);
	}

}
