package SouthWest;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WholesalerTable extends JScrollPane{

	private static final long serialVersionUID = 1L;
	private JTable table;
	
	public WholesalerTable(){
		
		init();
	}
	
	public void init(){
	
		Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3"},
				{ "Row2-Column1", "Row2-Column2", "Row2-Column3"} };
		Object columnNames[] = { "Column One", "Column Two", "Column Three"};
		table = new JTable(rowData, columnNames);
		getViewport().add(table);
	}

}
