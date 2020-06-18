package clickers.responsive;

import clickers.AbstractButton;
import processing.event.MouseEvent;
public class ResponsiveTextButton<T extends ResponsiveTextbox> extends AbstractButton<T> implements ISelectionable{



	public ResponsiveTextButton(T rect) {
		super(rect); 
	}
	{
		rect.linkSelectionable(this);
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
