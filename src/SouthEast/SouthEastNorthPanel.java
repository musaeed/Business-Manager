package SouthEast;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.CLabel;
import Components.FlowCustomLayout;

public class SouthEastNorthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel tableName;
	
	public SouthEastNorthPanel(){
		
		init();
		addToPanel();
	}
	
	public void init(){
		setLayout(new FlowCustomLayout(FlowCustomLayout.LEFT));
		tableName = new CLabel("Stocks");
	}
	
	public void addToPanel(){
		add(tableName);
	}
	
}
