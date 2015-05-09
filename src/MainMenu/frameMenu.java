package MainMenu;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import Components.RibbonButton;
import Utilities.Icons;

public class frameMenu extends JMenuBar{

	private static final long serialVersionUID = 1L;
	private RibbonButton user;
	
	public frameMenu(){
		
		init();
		
	}
	
	public void init(){
		
		add(new Actions("Actions",'A'));
		add(new Tools("Tools", 'T'));
		add(new BackUpMenu("Backup", 'B'));
		add(new Help("Help",'H'));
		
		add(Box.createGlue());
		user = new RibbonButton("", "Click to see details about current user");
		user.setIcon(Icons.getIcon("small/user.png"));
		user.setPreferredSize(new Dimension(17,17));
		JLabel name = new JLabel("Welcome, Muhammad Omer ");
		name.setForeground(Color.RED);
		add(name);
		add(user);
	}

}
