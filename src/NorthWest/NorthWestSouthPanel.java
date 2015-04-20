package NorthWest;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import Components.ClickableLabel;
import Components.FlowCustomLayout;

public class NorthWestSouthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private ClickableLabel viewTable;
	
	public NorthWestSouthPanel(){
		
		init();
		addToPanel();
		addActions();
	}
	
	public void init(){
		
		setLayout(new FlowCustomLayout(FlowLayout.LEFT));
		viewTable = new ClickableLabel("View table", "view the complete recent bills table");
	}
	
	public void addToPanel(){
		
		add(viewTable);
	}
	
	public void addActions(){
		viewTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1){
					//TODO open table here
				}
			}
			
		});
	}

}
