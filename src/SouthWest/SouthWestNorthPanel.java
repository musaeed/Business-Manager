package SouthWest;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.CLabel;
import Components.FlowCustomLayout;

public class SouthWestNorthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel tableName;
	
	public SouthWestNorthPanel(){
		
		init();
		addToPane();
	}
	
	public void init(){
		
		setLayout(new FlowCustomLayout(FlowCustomLayout.LEFT));
		tableName = new CLabel("Wholesalers table");
	}
	
	public void addToPane(){
		
		add(tableName);
	}

}
