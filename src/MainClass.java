import java.awt.EventQueue;

import BusinessManager.BusinessManager;
import Database.DatabaseCreator;
import Utilities.StartService;
import Utilities.TableLoader;


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
				
				if(!DatabaseCreator.databaseExists()){
					
					DatabaseCreator.createDatabase();
				}
				
				new TableLoader().load();
				
		       }
		  });
		
	}

}
