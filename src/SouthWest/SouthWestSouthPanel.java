package SouthWest;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.ClickableLabel;
import Components.FlowCustomLayout;

public class SouthWestSouthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel viewTable;
	private JLabel searchTable;
	private JLabel addWholesaler;
	
	public SouthWestSouthPanel(){
		init();
		addToPanel();
	}
	
	public void init(){
		
		setLayout(new FlowCustomLayout(FlowCustomLayout.LEFT));
		viewTable = new ClickableLabel("View table", "View the complete wholesalers table");
		searchTable = new ClickableLabel("Search table", "search the wholesalers table");
		addWholesaler = new ClickableLabel("Add Wholesaler", "add a new wholesaler");
	}
	
	public void addToPanel(){
		add(viewTable);
		add(searchTable);
		add(addWholesaler);
	}
	
	public void addActions(){
		
		viewTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1){
					
					//TODO open the table here
					
				}
			}
			
		});
		
		searchTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1){
					
					//TODO open the table here
					
				}
			}
			
		});
		
		addWholesaler.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1){
					
					//TODO open the table here
					
				}
			}
			
		});
	}

}
