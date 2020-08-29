package clickers;

import shape.Rect;
import shape.Textbox;

public class TextButton extends AbstractButton {

	
	public TextButton(Textbox rect) {
		super(rect);
	}
	@Override
	public Rect rect() {
		return (Textbox) super.rect();
	}
	public TextButton(int x, int y, int sizex, int sizey, String text) {
		super(new Textbox(x, y, sizex, sizey, text));
	}

}
