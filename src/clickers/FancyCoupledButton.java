package clickers;

import processing.event.MouseEvent;
import rect.builder.FancyRect;

public class FancyCoupledButton extends FancyRect implements IClickable<FancyCoupledButton>{


	public FancyCoupledButton(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
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
