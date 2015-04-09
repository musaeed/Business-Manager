package MainMenu;

import javax.swing.JMenu;

public class Actions extends JMenu{

	private static final long serialVersionUID = 1L;
	
	public Actions(String name, final char Mnemonic){
		
		super(name);		
		init(Mnemonic);
	}
	
	public void init(final char Mnemonic){
		setMnemonic(Mnemonic);
	}

}
