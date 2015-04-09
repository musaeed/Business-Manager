package Utilities;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Themes {
	
	public static void setTheme(){
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			System.err.println("Unable to set the system theme...");
			e.printStackTrace();
		}
	}

}
