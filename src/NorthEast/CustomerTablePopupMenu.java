package NorthEast;

import javax.swing.JPopupMenu;

import Components.CMenuItem;

public class CustomerTablePopupMenu extends JPopupMenu{
	
	private static final long serialVersionUID = 5001555052196347233L;
	private CMenuItem viewTable;
	
	public CustomerTablePopupMenu(){
		
		init();
		addActions();
		addToMenu();
		
	}
	
	public void init(){
		
		viewTable = new CMenuItem("View table", "view the complete table", 'V', null);
		
	}
	
	public void addActions(){
		
	}
	
	public void addToMenu(){
		add(viewTable);
	}

}
