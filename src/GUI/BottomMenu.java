package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import BusinessManager.AppData;
import Components.CLabel;
import Components.CProgressBar;

public class BottomMenu extends JPanel{


	private static final long serialVersionUID = 1L;
	public static JLabel bottomLabel;
	
	public BottomMenu(){
		init();
		addComponents();
	}
	
	public void init(){
		setSize(new Dimension(50, 400));
		bottomLabel = new CLabel(AppData.AppName);
		setLayout(new BorderLayout());
	}
	
	public void addComponents(){
		add(bottomLabel, BorderLayout.WEST);
		add(CProgressBar.getInstance(), BorderLayout.EAST);
	}

}
