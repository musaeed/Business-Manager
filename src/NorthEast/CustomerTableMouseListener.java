package NorthEast;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

public class CustomerTableMouseListener extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1){
			
			if(e.getClickCount() > 1){
				JTable table = (JTable) e.getSource();
				int row = table.getSelectedRow();
				
				new ShowCustomerDialog().show();
			}
			
		}
	}
	
	

}
