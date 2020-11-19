package clickers;

import shape.Rect;

/**
 * Simple button. A little unconventional hierarchy
 * @author phlaxyr
 *
 */
public class SimpleButton extends AbstractButton {

	public SimpleButton(Rect rect) {
		super(rect);
	}
	public SimpleButton(int x, int y, int sizex, int sizey) {
		this(new Rect(x, y, sizex, sizey));
	}
	
	






}
