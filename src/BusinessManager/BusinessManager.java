package BusinessManager;

import javax.swing.JFrame;

import Component_listeners.frameListener;
import MainMenu.frameMenu;
import Utilities.Themes;

public class BusinessManager {
	
	public static JFrame frame;
	
	public BusinessManager(){
		init();
	}
	
	public void init(){
		Themes.setTheme();
		initMainFrame();
		addListeners();
		addComponents();
	}
	
	public void initMainFrame(){
		
		frame = new JFrame();
		frame.setTitle(AppData.AppName);
		frame.setVisible(true);
		frame.setSize(1024, 780);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public void addListeners(){
		
		frame.addWindowListener(new frameListener());
	}
	
	public void addComponents(){
		frame.setJMenuBar(new frameMenu());
	}

}
