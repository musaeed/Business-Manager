package Components;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;

public class ClickableLabel extends JLabel{

	private static final long serialVersionUID = 1L;
	
	public ClickableLabel(String text){
		super(text);
		init();
	}
	
	@SuppressWarnings("unchecked")
	public void init(){
		Font font = getFont();
		@SuppressWarnings("rawtypes")
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		setFont(font.deriveFont(attributes));
	}
	
	
}
