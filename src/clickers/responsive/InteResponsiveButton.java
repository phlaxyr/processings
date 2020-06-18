package clickers.responsive;

import clickers.IIntegratedSelectionable;
import processing.event.MouseEvent;
import rect.builder.FancyRect;

public class InteResponsiveButton extends FancyRect implements IIntegratedSelectionable, ISelectionable {
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

	@Override
	public void defaultCustomizations() {
		
		super.defaultCustomizations();
//		if(getModel().isSelected() && f2flag) {
		if(isSelected() && f2flag) {
			main.fill(select_fill);
		}
	}

}
