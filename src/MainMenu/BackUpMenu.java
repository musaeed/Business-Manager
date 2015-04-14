package MainMenu;

import javax.swing.JMenu;

import Components.CMenuItem;

public class BackUpMenu extends JMenu{

	private static final long serialVersionUID = 1L;
	public static CMenuItem backupDatabase;
	public static CMenuItem restoreBackup;
	
	public BackUpMenu(String name, final char Mnemonic){
		super(name);
		init(Mnemonic);
		addComponents();
	}
	
	public void init(final char Mnemonic){
		setMnemonic(Mnemonic);
		backupDatabase = new CMenuItem("Backup database", "back up your complete database", 'B', null);
		restoreBackup = new CMenuItem("Restore backup", "restore your backed up database", 'R', null);
	}
	
	public void addComponents(){
		add(backupDatabase);
		add(restoreBackup);
	}

}
