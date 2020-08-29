package clickers;

import processing.event.MouseEvent;
import shape.IShape;
import shape.IShapeProvider;
import trickery.ISetupable;

public interface IClickable extends IShapeProvider<IShape>, ISetupable {

//	public void setElement(V v);
	void onMouseEvent(MouseEvent e, boolean isInside);
	// void onClickOutside(MouseEvent e);
	
	

	
	
}
