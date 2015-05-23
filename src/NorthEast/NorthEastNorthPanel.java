package NorthEast;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.CLabel;
import Components.FlowCustomLayout;
import Components.RibbonButton;
import Utilities.Icons;

public class NorthEastNorthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel tableName;
	private RibbonButton exportAsExcel;
	private RibbonButton exportAsPdf;
	private RibbonButton exportAsText;
	private RibbonButton refresh;
	
	public NorthEastNorthPanel(){
		
		init();
		addToPanel();
		addActions();
	}
	
	public void init(){
		setLayout(new BorderLayout());
		tableName = new CLabel("Customers Table");
		
		exportAsExcel = new RibbonButton("", "export the table as an excel sheet");
		exportAsExcel.setIcon(Icons.getIcon("small/Excel-icon.png"));
		exportAsExcel.setPreferredSize(new Dimension(17,17));
		
		exportAsPdf = new RibbonButton("", "export the table as a pdf document");
		exportAsPdf.setIcon(Icons.getIcon("small/pdf-icon.png"));
		exportAsPdf.setPreferredSize(new Dimension(17,17));
		
		exportAsText = new RibbonButton("", "export the table as simple text file");
		exportAsText.setIcon(Icons.getIcon("small/text-icon.png"));
		exportAsText.setPreferredSize(new Dimension(17,17));
		
		refresh = new RibbonButton("", "refresh the table");
		refresh.setIcon(Icons.getIcon("small/refresh.png"));
		refresh.setPreferredSize(new Dimension(17,17));
	}
	
	public void addToPanel(){
		JPanel left = new JPanel(new FlowCustomLayout(FlowCustomLayout.LEFT));
		JPanel right = new JPanel(new FlowCustomLayout(FlowCustomLayout.RIGHT));
		
		left.add(tableName);
		left.add(refresh);
		
		right.add(exportAsExcel);
		right.add(exportAsPdf);
		right.add(exportAsText);
		
		
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
	}
	
	public void addActions(){
		
		exportAsExcel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("Export table as an excel file");
				fc.showSaveDialog(null);
			}
		});
		
		exportAsPdf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("Export table as a pdf file");
				fc.showSaveDialog(null);
				
			}
		});
		
		exportAsText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("Export table as a text file");
				fc.showSaveDialog(null);
				
			}
		});
		
		refresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CustomerTableModel dm = CustomerTableModel.getInstance();
				
				int rowCount = dm.getRowCount();
				//Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
				    dm.removeRow(i);
				}
				
				new CustomerTableLoader();
				
			}
		});
	}
	
}
