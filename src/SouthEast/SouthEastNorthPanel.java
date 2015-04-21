package SouthEast;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Utilities.Icons;
import Components.CLabel;
import Components.FlowCustomLayout;
import Components.RibbonButton;

public class SouthEastNorthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel tableName;
	private RibbonButton exportAsExcel;
	private RibbonButton exportAsPdf;
	private RibbonButton exportAsText;
	
	public SouthEastNorthPanel(){
		
		init();
		addToPanel();
	}
	
	public void init(){
		setLayout(new BorderLayout());
		tableName = new CLabel("Stocks");
		
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
	
	public void addToPanel(){
		
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
