package clickers;


import processing.event.MouseEvent;
import shape.FancyRect;
import shape.Rect;

public class AbstractButton<T extends Rect> implements IClickable<T>{

	public T rect;
	
	public AbstractButton(T rect) {
		this.rect = rect;
	}


	@Override
	public T getShape() {
		return rect;
	}

	public static AbstractButton<FancyRect> make(int x, int y, int sizex, int sizey) {
		return new AbstractButton<FancyRect>(new FancyRect(x, y, sizex, sizey));
	}
	public T rect() {
		return getShape();
	}



	@Override
	public void onMouseEvent(MouseEvent e, boolean isInside) {
		
	}


	@Override
	public void onSetup() {
		
	}
	

}
