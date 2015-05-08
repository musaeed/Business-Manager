package NorthEast;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import BusinessManager.BusinessManager;
import Components.CButton;
import Components.FlowCustomLayout;

public class ViewTableDialog {
	
	private JDialog dialog;
	private CButton close;
	private JTable table;
	
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
		
		close = new CButton("Close", "close the dialog and go back", 'C', KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), null);
	}
	
	public void build(){
		
		dialog.setLayout(new BorderLayout());
		dialog.add(getButtonPanel(), BorderLayout.SOUTH);
		dialog.add(getTablePane(), BorderLayout.CENTER);
	}
	
	public JScrollPane getTablePane(){
		
		JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		return pane;
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
