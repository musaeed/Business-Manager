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
	private ClickableLabel createBill;
	private ClickableLabel searchTable;
	
	public NorthWestSouthPanel(){
		
		init();
		addToPanel();
		addActions();
	}
	
	public void init(){
		
		setLayout(new FlowCustomLayout(FlowLayout.LEFT));
		viewTable = new ClickableLabel("View table", "view the complete recent bills table");
		createBill = new ClickableLabel("Create bill", "create a new bill");
		searchTable = new ClickableLabel("Search table", "search for entries in the bill table");
	}
	
	public void addToPanel(){
		
		add(viewTable);
		add(searchTable);
		add(createBill);
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
		
		createBill.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getButton() == MouseEvent.BUTTON1){
					//TODO
				}
			}
			
		});
		
		searchTable.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getButton() == MouseEvent.BUTTON1){
					//TODO
				}
			}
		});
	}

}
