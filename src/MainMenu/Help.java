package MainMenu;

import javax.swing.JMenu;

public class Help extends JMenu{

	private static final long serialVersionUID = 1L;
	
	public Help(String name, final char Mnemonic){
		super(name);
		init(Mnemonic);
	}
	
	public void init(final char Mnemonic){
		setMnemonic(Mnemonic);
	}

}
