package clickers;

import processing.event.MouseEvent;
import rect.FancyRect;
import rect.Rect;

public class Button<T extends Rect> implements IClickable<T>{

	public T rect;
	
	public Button(T rect) {
		this.rect = rect;
	}

	@Override
	public T getShape() {
		return rect;
	}

	@Override
	public void onMouse(MouseEvent e) {
		
	}
	public static Button<FancyRect> make(int x, int y, int sizex, int sizey) {
		return new Button<FancyRect>(new FancyRect(x, y, sizex, sizey));
	}
	public T rect() {
		return getShape();
	}

	@Override
	public void onMouseOutside(MouseEvent e) {		
	}

}
