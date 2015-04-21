package SouthWest;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.CLabel;
import Components.FlowCustomLayout;
import Components.RibbonButton;
import Utilities.Icons;

public class SouthWestNorthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel tableName;
	private RibbonButton exportAsExcel;
	private RibbonButton exportAsPdf;
	private RibbonButton exportAsText;
	
	public SouthWestNorthPanel(){
		
		init();
		addToPane();
	}
	
	public void init(){
		
		setLayout(new BorderLayout());
		tableName = new CLabel("Wholesalers table");
		
		exportAsExcel = new RibbonButton("", "export the table as an excel sheet");
		exportAsExcel.setIcon(Icons.getIcon("small/Excel-icon.png"));
		exportAsExcel.setPreferredSize(new Dimension(17,17));
		
		exportAsPdf = new RibbonButton("", "export the table as a pdf document");
		exportAsPdf.setIcon(Icons.getIcon("small/pdf-icon.png"));
		exportAsPdf.setPreferredSize(new Dimension(17,17));
		
		exportAsText = new RibbonButton("", "export the table as simple text file");
		exportAsText.setIcon(Icons.getIcon("small/text-icon.png"));
		exportAsText.setPreferredSize(new Dimension(17,17));
	}
	
	public void addToPane(){
		
		JPanel left = new JPanel(new FlowCustomLayout(FlowCustomLayout.LEFT));
		JPanel right = new JPanel(new FlowCustomLayout(FlowCustomLayout.RIGHT));
		
		left.add(tableName);
		
		right.add(exportAsExcel);
		right.add(exportAsPdf);
		right.add(exportAsText);
		
		
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
	}

}
