package trickery;

import clickers.IClickable;
import processing.event.MouseEvent;
import shape.Rect;

public class CoupledButton extends Rect implements IClickable{

	public CoupledButton(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}

	@Override
	public void onMouseEvent(MouseEvent e, boolean isInside) {
		
	}

	@Override
	public CoupledButton getShape() {
		return this;
	}

}
