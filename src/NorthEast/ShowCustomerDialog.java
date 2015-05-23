package NorthEast;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import BusinessManager.BusinessManager;
import Components.CButton;
import Components.FlowCustomLayout;

public class ShowCustomerDialog {

	private JDialog dialog;
	private CButton close;
	
	public ShowCustomerDialog() {
		
		init();
		addToDialog();
		
	}
	
	public void init(){
		
		dialog = new JDialog();
		dialog.setTitle("Customer");
		dialog.setSize(new Dimension(500,300));
		dialog.setLocationRelativeTo(BusinessManager.frame);
		dialog.setModal(true);
		
		close = new CButton("Close", "close the dialog and go back", 'C', KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), null);
	}
	
	public void addToDialog(){
		
		dialog.setLayout(new BorderLayout());
		dialog.add(getButtonPanel(), BorderLayout.SOUTH);
		
	}
	
	public JPanel getButtonPanel(){
		
		JPanel panel = new JPanel(new FlowCustomLayout(FlowCustomLayout.RIGHT));
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dialog.dispose();
				
			}
		});
		
		panel.add(close);
		
		return panel;
	}
	
	public void show(){
		dialog.setVisible(true);
	}
	
	
}
