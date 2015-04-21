package Components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;

import GUI.BottomMenu;

public class ClickableLabel extends JLabel{

	private static final long serialVersionUID = 1L;
	
	public ClickableLabel(String text, String tooltip){
		super(text);
		setToolTipText(tooltip);
		init();
		addListener(tooltip);
	}
	
	@SuppressWarnings("unchecked")
	public void init(){
		Font font = getFont();
		@SuppressWarnings("rawtypes")
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		setFont(font.deriveFont(attributes));
	}
	
	public void addListener(final String text){
		
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(Color.BLUE);
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				BottomMenu.bottomLabel.setText(text);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setForeground(Color.BLACK);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				BottomMenu.bottomLabel.setText("Ready");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setForeground(Color.RED);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				setForeground(Color.BLUE);
			}
			
		});
	}
	
	
}
