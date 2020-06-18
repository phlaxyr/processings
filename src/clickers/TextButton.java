package clickers;

import rect.Textbox;

public class TextButton extends AbstractButton<Textbox>{

	
	public TextButton(Textbox rect) {
		super(rect);
	}
	public TextButton(int x, int y, int sizex, int sizey, String text) {
		super(new Textbox(x, y, sizex, sizey, text));
	}

}
