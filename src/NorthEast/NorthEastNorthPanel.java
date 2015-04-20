package NorthEast;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.CLabel;
import Components.FlowCustomLayout;

public class NorthEastNorthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel tableName;
	
	public NorthEastNorthPanel(){
		
		init();
		addToPanel();
	}
	
	public void init(){
		setLayout(new FlowCustomLayout(FlowCustomLayout.LEFT));
		tableName = new CLabel("Customers Table");
	}
	
	public void addToPanel(){
		add(tableName);
	}
	
}
