package clickers;

import processing.event.MouseEvent;
import rect.IDrawnShape;
import rect.IShapeProvider;
import trickery.ISetupable;

public interface IClickable<V extends IDrawnShape> extends IShapeProvider<V>, ISetupable {

//	public void setElement(V v);
	void onMouseEvent(MouseEvent e, boolean isInside);
	// void onClickOutside(MouseEvent e);
	
	

	
	
}
