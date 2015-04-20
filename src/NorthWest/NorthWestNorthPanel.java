package NorthWest;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.CLabel;
import Components.FlowCustomLayout;

public class NorthWestNorthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel tableName;
	
	public NorthWestNorthPanel(){
		
		init();
		addToPanel();
	}
	
	public void init(){
		
		setLayout(new FlowCustomLayout(FlowCustomLayout.LEFT));
		tableName = new CLabel("Recent Bills");
	}
	
	public void addToPanel(){
		add(tableName);
	}
	

}
