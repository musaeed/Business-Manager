package Utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageUtilities {

	public static ImageIcon RescaleImage(String path){
		
		if(path == null){
			
			//JOptionPane.showMessageDialog(arg0, arg1);
		}

		BufferedImage myPicture = null;

		try {
			myPicture = ImageIO.read(new File(path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return new ImageIcon(myPicture);
	}

}
