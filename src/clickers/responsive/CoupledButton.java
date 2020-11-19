package clickers.responsive;

import clickers.responsive.trickery.ICoupledSelectionable;
import processing.event.MouseEvent;

public class CoupledButton extends AbstractResponsiveRect implements ICoupledSelectionable {
	public CoupledButton(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}
	public CoupledButton(int x, int y, int sizex, int sizey, String text) {
		super(x, y, sizex, sizey, text);
	}





	@Override
	public CoupledButton getShape() {
		return this;
	}
	
	public boolean isSelected = false;

	@Override
	public void onMouseEvent(MouseEvent e, boolean isClick, boolean isInside) {
		if(isClick) {
			isSelected = isInside;
		}
	}

	
	@Override
	public boolean isSelected() {
		return isSelected;
	}





}
