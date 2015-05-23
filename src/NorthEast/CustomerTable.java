package NorthEast;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CustomerTable extends JScrollPane{

	private static final long serialVersionUID = 1L;
	public static JTable table;

	public CustomerTable(){
		init();
	}

	public void init(){
		
		table = new JTable(){

			private static final long serialVersionUID = 7824527675515170281L;

			@Override
			public Component prepareRenderer(TableCellRenderer renderer,int row, int column) {
				
				Component component = super.prepareRenderer(renderer, row, column);
				
				
				if(isCellSelected(row, column)){
					component.setBackground(new Color(221, 72, 20));
					component.setForeground(Color.WHITE);
				}
				else if(row % 2 == 0){
					
					component.setBackground(Color.gray.brighter());
					component.setForeground(Color.BLACK);
				}
				else
				{
					component.setBackground(Color.WHITE);
					component.setForeground(Color.BLACK);
				}
				
				
				
				return component;
			}

			@Override
			public int getRowHeight() {

				return 20;
			}
			
			@Override
			public Class<? extends Object> getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
			
		};
		
		table.setModel(CustomerTableModel.getInstance());
		setComponentPopupMenu(new CustomerTablePopupMenu());
		table.setComponentPopupMenu(new CustomerTablePopupMenu());
		table.addMouseListener(new CustomerTableMouseListener());
		table.addKeyListener(new CustomerTableKeyListener());
		getViewport().add(table);
	}

}

