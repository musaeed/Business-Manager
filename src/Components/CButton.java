package Components;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class CButton extends JButton{

	private static final long serialVersionUID = -3578309610785152111L;
	
	public CButton(String text, String toolTip, final char Mnemonic, final KeyStroke stroke, final String iconPath){
		init(text, toolTip, Mnemonic, stroke, iconPath);
	}
	
	public void init(String text, String toolTip, final char Mnemonic, final KeyStroke stroke, final String iconPath){
		
		setText(text);
		setToolTipText(toolTip);
		setMnemonic(Mnemonic);
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(stroke, 1);
		getActionMap().put(1, new AbstractAction() {
			
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent e) {
				
				doClick();
				
			}
		});
	}
	

}
