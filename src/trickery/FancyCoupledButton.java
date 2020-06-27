package trickery;

import clickers.IClickable;
import processing.event.MouseEvent;
import rect.FancyRect;

public class FancyCoupledButton extends FancyRect implements IClickable<FancyCoupledButton>{


	public FancyCoupledButton(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}
	
	
	public FancyCoupledButton(int x, int y, int sizex, int sizey, String text) {
		super(x, y, sizex, sizey, text);
	}


	@Override
	public void onClick(MouseEvent e) {
		
	}

	@Override
	public void onClickOutside(MouseEvent e) {
		
	}

	@Override
	public FancyCoupledButton getShape() {
		return this;
	}
	
}
