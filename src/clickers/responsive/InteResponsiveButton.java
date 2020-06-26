package clickers.responsive;

import clickers.IIntegratedSelectionable;
import processing.event.MouseEvent;

public class InteResponsiveButton extends AbstractResponsiveRect implements IIntegratedSelectionable {
	public InteResponsiveButton(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}
	
	



	@Override
	public InteResponsiveButton getShape() {
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
