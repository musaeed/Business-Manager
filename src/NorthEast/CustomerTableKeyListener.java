package NorthEast;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTable;

public class CustomerTableKeyListener extends KeyAdapter{

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER){
			
			
			JTable table = (JTable) e.getSource();
			int row = table.getSelectedRow();
			new ShowCustomerDialog().show();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER){
			e.consume();
		}
	}
	
	
	

}
