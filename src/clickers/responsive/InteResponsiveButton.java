package clickers.responsive;

import clickers.IIntegratedSelectionable;
import processing.event.MouseEvent;

public class InteResponsiveButton extends AbstractResponsiveRect implements IIntegratedSelectionable {
	public InteResponsiveButton(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}
	public InteResponsiveButton(int x, int y, int sizex, int sizey, String text) {
		super(x, y, sizex, sizey, text);
	}





	@Override
	public InteResponsiveButton getShape() {
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
