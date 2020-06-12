package clickers;

import rect.TextBox;

public class TextButton extends AbstractButton<TextBox>{

	
	public TextButton(TextBox rect) {
		super(rect);
	}
	public TextButton(int x, int y, int sizex, int sizey, String text) {
		super(new TextBox(x, y, sizex, sizey, text));
	}

}
