package GUI;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.RibbonButton;

public class RibbonMenu extends JPanel{

	private static final long serialVersionUID = 7211001066395700094L;
	
	public static RibbonButton createBill;
	public static RibbonButton addCustomer;
	public static RibbonButton addWholesaler;
	public static RibbonButton searchCustomer;
	public static RibbonButton searchWholesaler;
	public static RibbonButton Help;
	
	public RibbonMenu(){
		init();
		addComponents();
	}
	
	public void init(){
		
		setSize(new Dimension(400,50));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		createBill = new RibbonButton("Create bill", "Create a new bill");
		addCustomer = new RibbonButton("Add customer", "Add a new customer");
		addWholesaler = new RibbonButton("Add wholesaler", "Add a new wholesaler");
		searchCustomer = new RibbonButton("Search customer", "search for an existing customer");
		searchWholesaler = new RibbonButton("Search wholesaler", "search for a new wholsaler");
		Help = new RibbonButton("Help", "look at some help");
		
	}
	
	public void addComponents(){
		
		add(createBill);
		add(addCustomer);
		add(addWholesaler);
		add(searchCustomer);
		add(searchWholesaler);
		add(Help);
	}
	

}
