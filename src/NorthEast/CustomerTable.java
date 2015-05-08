package NorthEast;


import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustomerTable extends JScrollPane{

	private static final long serialVersionUID = 1L;
	public static JTable table;

	public CustomerTable(){
		init();
	}

	public void init(){
		
		table = new JTable();
		table.setModel(CustomerTableModel.getInstance());
		setComponentPopupMenu(new CustomerTablePopupMenu());
		getViewport().add(table);
	}

}

