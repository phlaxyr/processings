package clickers.responsive;

import clickers.AbstractButton;

import processing.event.MouseEvent;
public class ResponsiveButton/*<T extends ResponsiveRect>*/ extends AbstractButton<ResponsiveRect> implements ISelectionable {



	public ResponsiveButton(ResponsiveRect rect) {
		super(rect);
	}

	{
		rect.acknowledgeContainer(this);
	}

	
	public boolean isSelected = false;

	@Override
	public void onClick(MouseEvent e) {
//		isSelected = true;
		isSelected = !isSelected;
	}


	@Override
	public void onClickOutside(MouseEvent e) {
//		isSelected = false;
		
	}


	@Override
	public boolean isSelected() {
		return isSelected;
	}

	
	
	
	
}
