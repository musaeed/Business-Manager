package GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import NorthEast.CustomerTable;
import NorthEast.NorthEastNorthPanel;
import NorthEast.NorthEastSouthPanel;
import NorthWest.NorthWestNorthPanel;
import NorthWest.NorthWestSouthPanel;
import NorthWest.RecentBillsTable;
import SouthEast.SouthEastNorthPanel;
import SouthEast.SouthEastSouthPanel;
import SouthEast.StocksTable;
import SouthWest.SouthWestNorthPanel;
import SouthWest.SouthWestSouthPanel;
import SouthWest.WholesalerTable;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JPanel northWest;
	private JPanel northEast;
	private JPanel southWest;
	private JPanel southEast;
	private JSplitPane main;
	private JSplitPane up;
	private JSplitPane down;
	
	public MainPanel(){
		init();
	}
	
	
	public void init(){
		
		setLayout(new BorderLayout());
		northWest = new JPanel();
		northEast = new JPanel();
		southEast = new JPanel();
		southWest = new JPanel();
		
		up = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, northWest, northEast);
		down = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, southWest, southEast);
		main = new JSplitPane(JSplitPane.VERTICAL_SPLIT, up, down);
		
		up.setResizeWeight(0.5);
		down.setResizeWeight(0.5);
		main.setResizeWeight(0.5);
		
		add(main, BorderLayout.CENTER);
		
		setNorthWestPanel();
		setNorthEastPanel();
		setSouthWestPanel();
		setSouthEastPanel();
	}
	
	public void setNorthWestPanel(){
		
		northWest.setLayout(new BorderLayout());
		northWest.add(new RecentBillsTable(), BorderLayout.CENTER);
		northWest.add(new NorthWestNorthPanel(), BorderLayout.NORTH);
		northWest.add(new NorthWestSouthPanel(), BorderLayout.SOUTH);
		
	}
	
	public void setNorthEastPanel(){
		
		northEast.setLayout(new BorderLayout());
		northEast.add(new CustomerTable(), BorderLayout.CENTER);
		northEast.add(new NorthEastNorthPanel(), BorderLayout.NORTH);
		northEast.add(new NorthEastSouthPanel(), BorderLayout.SOUTH);
	}
	
	public void setSouthWestPanel(){
		
		southWest.setLayout(new BorderLayout());
		southWest.add(new WholesalerTable(), BorderLayout.CENTER);
		southWest.add(new SouthWestNorthPanel(), BorderLayout.NORTH);
		southWest.add(new SouthWestSouthPanel(), BorderLayout.SOUTH);
	}
	
	public void setSouthEastPanel(){
		
		southEast.setLayout(new BorderLayout());
		southEast.add(new StocksTable(), BorderLayout.CENTER);
		southEast.add(new SouthEastNorthPanel(), BorderLayout.NORTH);
		southEast.add(new SouthEastSouthPanel(), BorderLayout.SOUTH);
	}

}
