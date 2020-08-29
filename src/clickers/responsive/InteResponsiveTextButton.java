package clickers.responsive;

import clickers.IIntegratedSelectionable;
import processing.event.MouseEvent;

public class InteResponsiveTextButton extends AbstractResponsiveTextbox implements IIntegratedSelectionable, ISelectionable {

	



	public InteResponsiveTextButton(int x, int y, int sizex, int sizey, String text) {
		super(x, y, sizex, sizey, text);
	}


	@Override
	public InteResponsiveTextButton getShape() {
		return this;
	}
	
	public boolean isSelected = false;

	@Override
	public void onMouseEvent(MouseEvent e, boolean isInside) {
		isSelected = isInside;
//		System.out.print("oi");
	}

	
	@Override
	public boolean isSelected() {
		return isSelected;
	}




}
