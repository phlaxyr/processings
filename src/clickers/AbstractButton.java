package clickers;


import processing.event.MouseEvent;
import shape.FancyRect;
import shape.Rect;

public class AbstractButton implements IClickable {

	public Rect rect;
	
	public AbstractButton(Rect rect) {
		this.rect = rect;
	}


	@Override
	public Rect getShape() {
		return rect;
	}

	public static AbstractButton make(int x, int y, int sizex, int sizey) {
		return new AbstractButton(new FancyRect(x, y, sizex, sizey));
	}
	public Rect rect() {
		return rect;
	}



	@Override
	public void onMouseEvent(MouseEvent e, boolean isClick, boolean isInside) {
		
	}


	@Override
	public void onSetup() {
		
	}


	@Override
	public void draw() {
		this.getShape().draw();
	}
	

}
