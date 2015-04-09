import java.awt.EventQueue;

import Utilities.StartService;
import BusinessManager.BusinessManager;


public class MainClass {
	
	public static void main(String args[]){
		
		new StartService();
		
		EventQueue.invokeLater(new Runnable()
		  {
		       public void run()
		       {
		    	System.setProperty("awt.useSystemAAFontSettings","on");
		    	System.setProperty("swing.aatext", "true");
				new BusinessManager();
				
		       }
		  });
		
	}

}
