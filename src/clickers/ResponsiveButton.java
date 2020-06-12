package clickers;

import processing.event.MouseEvent;
import rect.FancyRect;
public class ResponsiveButton extends FancyRect implements IClickable<ResponsiveButton>{


	
	public ResponsiveButton(int x, int y, int sizex, int sizey) {
		super(x, y, sizex, sizey);
	}
	

	@Override
	public ResponsiveButton getShape() {
		return this;
	}

	
	public boolean isSelected = false;

	@Override
	public void onClick(MouseEvent e) {
		isSelected = true;
	}


	@Override
	public void onClickOutside(MouseEvent e) {
		isSelected = false;
		
	}
	

	boolean f2flag = false;
	int select_fill;
	public ResponsiveButton setSelectedColor(int fill) { 
		f2flag = true;
		this.select_fill = fill;
		return this;
	}
	@Override
	protected void defaultCustomizations() {
		
		super.defaultCustomizations();
		if(isSelected && f2flag) {
			main.fill(select_fill);
		}
	}
	
	
	
	
}
