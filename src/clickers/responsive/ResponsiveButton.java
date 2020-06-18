package clickers.responsive;

import clickers.AbstractButton;
import processing.event.MouseEvent;
public class ResponsiveButton<T extends ResponsiveRect> extends AbstractButton<T> implements ISelectionable{



	public ResponsiveButton(T rect) {
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
