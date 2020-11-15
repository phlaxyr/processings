package clickers.responsive;

import clickers.AbstractButton;
import processing.event.MouseEvent;
public class ResponsiveButton/*<T extends ResponsiveRect>*/ extends AbstractButton implements ISelectionable {



	public ResponsiveButton(ResponsiveRect rect) {
		super(rect);
	}
	@Override
		public ResponsiveRect getShape() {
			return (ResponsiveRect) super.getShape();
		}
	
	{
		getShape().acknowledgeContainer(this);
	}

	
	public boolean isSelected = false;

	@Override
	public void onMouseEvent(MouseEvent e, boolean isClick, boolean isInside) {
//		isSelected = true;
		if(isClick && isInside) {
			isSelected = !isSelected;
		}
	}



	@Override
	public boolean isSelected() {
		return isSelected;
	}

	
	
	
	
}
