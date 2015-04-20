package NorthEast;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.ClickableLabel;
import Components.FlowCustomLayout;

public class NorthEastSouthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel viewTable;
	
	public NorthEastSouthPanel(){
		
		init();
		addToPanel();
		addActions();
	}
	
	public void init(){
		
		setLayout(new FlowCustomLayout(FlowCustomLayout.LEFT));
		viewTable = new ClickableLabel("View table", "view the complete customers table");
		
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
