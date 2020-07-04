package clickers;

import rect.IDrawnShape;
import rect.IShapeProvider;
import trickery.ISetupable;

public interface IClickable<V extends IDrawnShape> extends IMouseHandler, IShapeProvider<V>, ISetupable {

//	public void setElement(V v);
	
	
	
}
