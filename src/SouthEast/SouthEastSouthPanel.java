package SouthEast;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.ClickableLabel;
import Components.FlowCustomLayout;

public class SouthEastSouthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel viewTable;
	
	public SouthEastSouthPanel(){
		
		init();
		addToPanel();
		addActions();
	}
	
	public void init(){
		setLayout(new FlowCustomLayout(FlowCustomLayout.LEFT));
		viewTable = new ClickableLabel("View table", "view the complete stocks table");
	}
	
	public void addToPanel(){
		add(viewTable);
	}
	
	public void addActions(){
		
		viewTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO open the table here
			}
			
		});
	}
	
}
