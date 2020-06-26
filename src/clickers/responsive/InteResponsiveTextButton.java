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
	public void onClick(MouseEvent e) {
		isSelected = true;
		System.out.print("oi");
	}


	@Override
	public void onClickOutside(MouseEvent e) {
		isSelected = false;
		
	}

	
	@Override
	public boolean isSelected() {
		return isSelected;
	}




}
