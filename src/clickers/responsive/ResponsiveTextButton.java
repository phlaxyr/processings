package clickers.responsive;

import clickers.AbstractButton;
import processing.event.MouseEvent;
public class ResponsiveTextButton extends AbstractButton<ResponsiveTextbox> implements ISelectionable{



	public ResponsiveTextButton(ResponsiveTextbox rect) {
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
