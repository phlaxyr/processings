package clickers;


import processing.event.MouseEvent;
import rect.Rect;
import rect.builder.FancyRect;

public class AbstractButton<T extends Rect> implements IButton, IClickable<T>{


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
	public void onClick(MouseEvent e) {
		
	}

	@Override
	public void onClickOutside(MouseEvent e) {
		
	}

	@Override
	public boolean isPressed() {
		return false;
	}


	@Override
	public void onSetup() {
		
	}
	

}
