package clickers;

import rect.Rect;

/**
 * Simple button. A little unconventional hierarchy
 * @author phlaxyr
 *
 */
public class SimpleButton extends AbstractButton<Rect>{

	public SimpleButton(Rect rect) {
		super(rect);
	}
	public SimpleButton(int x, int y, int sizex, int sizey) {
		this(new Rect(x, y, sizex, sizey));
	}
	
	






}
