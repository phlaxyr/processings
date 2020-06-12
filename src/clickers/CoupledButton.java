package clickers;

import processing.event.MouseEvent;
import rect.Rect;

public class CoupledButton extends Rect implements IClickable<CoupledButton>{

	public CoupledButton(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}

	@Override
	public void onClick(MouseEvent e) {
		
	}

	@Override
	public void onClickOutside(MouseEvent e) {
		
	}

	@Override
	public CoupledButton getShape() {
		return this;
	}

}
