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
	public void onMouseEvent(MouseEvent e, boolean isInside) {
//		isSelected = true;
		if(isInside) {
			isSelected = !isSelected;
		}
	}



	@Override
	public boolean isSelected() {
		return isSelected;
	}

	
	
	
	
}
