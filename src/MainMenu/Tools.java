package MainMenu;

import javax.swing.JMenu;

public class Tools extends JMenu{

	private static final long serialVersionUID = 1L;
	
	public Tools(String name, final char Mnemonic){
		super(name);
		init(Mnemonic);
	}
	
	public void init(final char Mnemonic){
		setMnemonic(Mnemonic);
	}
	

}
