package MainMenu;

import javax.swing.JMenuBar;

public class frameMenu extends JMenuBar{

	private static final long serialVersionUID = 1L;
	
	public frameMenu(){
		
		init();
		
	}
	
	public void init(){
		
		add(new Actions("Actions",'A'));
		add(new Tools("Tools", 'T'));
		add(new BackUpMenu("Backup", 'B'));
		add(new Help("Help",'H'));
	}

}
