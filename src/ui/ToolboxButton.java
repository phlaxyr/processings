package ui;

import clickers.AbstractButton;
import processing.event.MouseEvent;
import rect.Rect;

public class ToolboxButton<T extends Rect> extends AbstractButton<T>{
	ToolBox tb;
	public ToolboxButton(T rect, ToolBox tb) {
		super(rect);
		this.tb = tb;
	}
	
	
	@Override
	public void onClick(MouseEvent e) {
		isPressed = true;
	}
	@Override
	public void onClickOutside(MouseEvent e) {
		isPressed = false;
	}
	public boolean isPressed = false;
	@Override
	public boolean isPressed() {
		return isPressed;
	}
	
	@Override
	public void draw() {
		super.draw();
	}


}
