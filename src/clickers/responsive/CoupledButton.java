package clickers.responsive;

import clickers.IIntegratedSelectionable;
import processing.event.MouseEvent;

public class CoupledButton extends AbstractResponsiveRect implements IIntegratedSelectionable {
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
	public void onMouseEvent(MouseEvent e, boolean isInside) {
		isSelected = isInside;
		System.out.print("oi");
	}

	
	@Override
	public boolean isSelected() {
		return isSelected;
	}





}
