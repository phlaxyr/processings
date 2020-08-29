package trickery;

import clickers.IClickable;
import processing.event.MouseEvent;
import shape.FancyRect;

public class FancyCoupledButton extends FancyRect implements IClickable<FancyCoupledButton>{


	public FancyCoupledButton(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}
	
	
	public FancyCoupledButton(int x, int y, int sizex, int sizey, String text) {
		super(x, y, sizex, sizey, text);
	}


	@Override
	public void onMouseEvent(MouseEvent e, boolean isInside) {
		
	}

	@Override
	public FancyCoupledButton getShape() {
		return this;
	}
	
}
