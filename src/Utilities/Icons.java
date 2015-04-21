package Utilities;

import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Icons {
	
	public static Icon getIcon(String path){
		return new ImageIcon(Toolkit.getDefaultToolkit().getImage(Icons.class.getClassLoader().getResource(path)));
	}

}
